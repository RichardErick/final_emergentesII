package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ventas (fecha,cliente,monto_final,descuento) values (?,?,?,?)");

            ps.setDate(1, venta.getFecha());
            ps.setInt(2, venta.getCliente());
            ps.setFloat(3, venta.getMonto_final());
            ps.setFloat(4, venta.getDescuento());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ventas SET fecha=?,cliente=?,monto_final=?,descuento=? where id=?");

            ps.setDate(1, venta.getFecha());
            ps.setInt(2, venta.getCliente());
            ps.setFloat(3, venta.getMonto_final());
            ps.setFloat(4, venta.getDescuento());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ventas where id=?");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public Venta getById(int id) throws Exception {
Venta ven= new Venta ();
 try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ventas where id= ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ven.setId(rs.getInt("id"));
                ven.setFecha(rs.getDate("fecha"));
                ven.setCliente(rs.getInt("cliente"));
               ven.setMonto_final(rs.getFloat("monto_final"));
               ven.setDescuento(rs.getFloat("descuento"));

            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
 return ven;  
    }

    @Override
    public List<Venta> getAll() throws Exception {
List<Venta> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ventas");
            ResultSet rs = ps.executeQuery();
         while  (rs.next()) {
             Venta p = new Venta();
                p.setId(rs.getInt("id"));
                p.setFecha(rs.getDate("fecha"));
                p.setCliente(rs.getInt("cliente"));
               p.setMonto_final(rs.getFloat("monto_final"));
               p.setDescuento(rs.getFloat("descuento"));
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
