package org.espina.models;

import java.util.Date;

public class Proveedores {

    private int id_proveedor;
    private String nombre;
    private Date fecha_alta;
    private int id_cliente;

    public Proveedores(int id_proveedor, String nombre, Date fecha_alta, int id_cliente) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.fecha_alta = fecha_alta;
        this.id_cliente = id_cliente;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
