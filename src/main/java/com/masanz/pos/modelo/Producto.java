package com.masanz.pos.modelo;


//TODO: Producto debe implementar las interfaces Comparable y Cloneable
public class Producto implements Comparable<Producto> {
    private int id;
    private String nombre;
    private double precio;
    private String descuento = "";

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(int id, String nombre, double precio, String descuento) {
        this(id, nombre, precio);
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String[] toStringArray() {
        return new String[] { String.valueOf(id), nombre, String.format("%.2f", precio), descuento };
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.id, o.id);
    }

}
