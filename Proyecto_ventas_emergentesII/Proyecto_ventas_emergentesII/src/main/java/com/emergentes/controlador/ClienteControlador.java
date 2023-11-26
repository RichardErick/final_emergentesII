package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cliente cli = new Cliente();
            int id;
            ClienteDAO dao = new ClienteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("clientes", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");
                    break;
                case "view":
                    // Obtener los registros
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    System.out.println("View Action - Total de clientes: " + lista.size());

                    // Verificar los datos antes de enviarlos a la página JSP
                    for (Cliente cliente : lista) {
                        System.out.println("Cliente ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
                    }

                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                    break;
                default:
                    System.out.println("Default Action");
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String rut = request.getParameter("rut");
        String telefonos = request.getParameter("telefonos");

        Cliente cli = new Cliente();
        cli.setId(id);
        cli.setNombre(nombre);
        cli.setDireccion(direccion);
        cli.setRut(rut);
        cli.setTelefonos(telefonos);
            ClienteDAO dao = new ClienteDAOimpl();

        if (id == 0) {
            try {
                //NUEVO REGISTRO
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar" +ex.getMessage());
            }

        } else {
            try {
                //EDICION DE REGISTRO
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar " +ex.getMessage());
            }
        }
          response.sendRedirect("ClienteControlador");
    }

}
