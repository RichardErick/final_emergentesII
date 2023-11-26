package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.modelo.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ERICK
 */
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Categoria cat = new Categoria();
            int id;
            CategoriaDAO dao = new CategoriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("categorias", cat);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cat = dao.getById(id);
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("CategoriaControlador");
                    break;
                case "view":
                    // Obtener los registros
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    System.out.println("View Action - Total de clientes: " + lista.size());

                    // Verificar los datos antes de enviarlos a la página JSP
                    for (Categoria categoria : lista) {
                        System.out.println("Categoria ID: " + categoria.getId() + ", Nombre categoria: " + categoria.getNombre_categoria());
                    }

                    request.getRequestDispatcher("categorias.jsp").forward(request, response);
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
       try {
        // Obtener el parámetro "id" del formulario
        String idParam = request.getParameter("id");

        // Validar si el parámetro "id" no es nulo ni está vacío
        if (idParam != null && !idParam.isEmpty()) {
            // Convertir el parámetro "id" a entero
            int id = Integer.parseInt(idParam);

            // Resto del código...
            String nombre_categoria = request.getParameter("nombre_categoria");
            String descripcion = request.getParameter("descripcion");

            Categoria cat = new Categoria();
            cat.setId(id);
            cat.setNombre_categoria(nombre_categoria);
            cat.setDescripcion(descripcion);

            CategoriaDAO dao = new CategoriaDAOimpl();

            if (id == 0) {
                try {
                    //NUEVO REGISTRO
                    dao.insert(cat);
                } catch (Exception ex) {
                    System.out.println("Error al insertar" + ex.getMessage());
                }
            } else {
                try {
                    //EDICION DE REGISTRO
                    dao.update(cat);
                } catch (Exception ex) {
                    System.out.println("Error al editar " + ex.getMessage());
                }
            }

            // Redireccionar después de la operación
            response.sendRedirect("CategoriaControlador");
        } else {
            // Manejar el caso donde el parámetro "id" está vacío
            System.out.println("El parámetro 'id' está vacío.");
            // Puedes agregar código adicional para manejar este caso, como mostrar un mensaje de error
            response.sendRedirect("error.jsp");  // Redirigir a una página de error
        }
    } catch (NumberFormatException e) {
        // Manejar la excepción si hay un error al convertir el parámetro "id" a entero
        System.out.println("Error al convertir el parámetro 'id' a entero: " + e.getMessage());
        // Puedes agregar aquí el código para manejar el error, como mostrar un mensaje al usuario
        response.sendRedirect("error.jsp");  // Redirigir a una página de error
    }
    }
}
