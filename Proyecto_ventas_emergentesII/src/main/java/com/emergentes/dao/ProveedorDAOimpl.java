package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO {

    @Override
    public void insert(Proveedor proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO proveedores (nombre,direccion,telefono) values (?,?,?)");

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE proveedores SET nombre=?,direccion=?,telefono=? where id=?");

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getId());
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM proveedores where id=?");

            ps.setInt(1, id);
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public Proveedor getById(int id) throws Exception {
        Proveedor pro = new Proveedor();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores where id= ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));

            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
       List<Proveedor> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs = ps.executeQuery();
         while  (rs.next()) {
             Proveedor p = new Proveedor();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
               lista.add(p);
            }
         rs.close();
         ps.close();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return lista;
    }

}
