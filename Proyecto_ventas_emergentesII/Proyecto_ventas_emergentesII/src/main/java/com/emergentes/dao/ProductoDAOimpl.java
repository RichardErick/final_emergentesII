package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO productos (nombre,precio,stock,monto_total,precio_actual,nombre_categoria) values (?,?,?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getMonto_total());
            ps.setInt(5, producto.getPrecio_actual());
            ps.setInt(6, producto.getNombre_categoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos SET nombre=?,precio=?,stock=?,monto_total=?,precio_actual=?,nombre_categoria=? where id=?");
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setFloat(4, producto.getMonto_total());
            ps.setInt(5, producto.getPrecio_actual());
            ps.setInt(6, producto.getNombre_categoria());
            ps.executeUpdate();
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM productos where id=?");

            ps.setInt(1, id);
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto pro = new Producto();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos where id= ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setMonto_total(rs.getInt("monto_total"));
            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {
List<Producto> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
         while  (rs.next()) {
             Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getFloat("precio"));
                p.setStock(rs.getInt("stock"));
                p.setMonto_total(rs.getInt("monto_total"));
                p.setPrecio_actual(rs.getInt("precio_actual"));
                p.setNombre_categoria(rs.getInt("nombre_categoria"));
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
