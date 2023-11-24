package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement ps = this.conn.prepareStatement("UPDATE categorias SET nombre_categoria=?,descripcion=? where id=?");

            ps.setString(1, categoria.getNombre_categoria());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categorias");
            ResultSet rs = ps.executeQuery();
         while  (rs.next()) {
             Categoria p = new Categoria();
                p.setId(rs.getInt("id"));
                p.setNombre_categoria(rs.getString("nombre_categoria"));
                p.setDescripcion(rs.getString("descripcion"));
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
