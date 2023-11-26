package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO {

    @Override
    public void insert(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO categorias (nombre_categoria,descricpcion) values (?,?)");
            ps.setString(1, categoria.getNombre_categoria());
            ps.setString(2, categoria.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE categorias SET nombre_categoria=?,descripcion=? where id= ?");
            ps.setString(1, categoria.getNombre_categoria());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM categorias where id=?");

            ps.setInt(1, id);
            
            // Agrega la siguiente línea para ejecutar la eliminación
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Categoria getById(int id) throws Exception {
Categoria cat= new Categoria ();
 try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categorias where id= ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setNombre_categoria(rs.getString("nombre_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
               

            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
 return cat;
    }

    @Override
    public List<Categoria> getAll() throws Exception {
    List<Categoria> lista = null;
        try {
            this.conectar();
            String sql = "SELECT *from categorias";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria cli = new Categoria();
                cli.setId(rs.getInt("id"));
                cli.setNombre_categoria(rs.getString("nombre_categoria"));
                cli.setDescripcion(rs.getString("descripcion"));
               
                lista.add(cli);
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
