
package com.emergentes.modelo;


public class Producto {
     private int id;
    private String nombre;
    private float precio;
    private int stock;
    private int monto_total;
    private int precio_actual;
    private int nombre_categoria;

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getPrecio_actual() {
        return precio_actual;
    }

    public void setPrecio_actual(int precio_actual) {
        this.precio_actual = precio_actual;
    }

    public int getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(int nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", monto_total=" + monto_total + ", precio_actual=" + precio_actual + ", nombre_categoria=" + nombre_categoria + '}';
    }
    
    
    
}
