
package com.emergentes.modelo;

import java.sql.Date;

public class Venta {
    private int id;
    private Date fecha;
    private int cliente;
    private float monto_final;
    private float descuento;

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public float getMonto_final() {
        return monto_final;
    }

    public void setMonto_final(float monto_final) {
        this.monto_final = monto_final;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", monto_final=" + monto_final + ", descuento=" + descuento + '}';
    }
   
    
    
}
