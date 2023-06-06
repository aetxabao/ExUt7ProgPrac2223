package com.masanz.pos.descuentos;

import com.masanz.pos.modelo.Producto;

public abstract class ADescuento {
    boolean soloParaSocios;
    Producto producto;
    int cantidad;

    public ADescuento(boolean esSoloParaSocios, Producto producto, int cantidad) {
        this.soloParaSocios = esSoloParaSocios;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public abstract double getValorDescuento();

    protected double getImporteCantidadProducto(){
        return cantidad * producto.getPrecio() ;
    }

    @Override
    public String toString() {
        return String.format("%30s %4.2d", producto, getValorDescuento());
    }

    public boolean isSoloParaSocios() {
        return soloParaSocios;
    }

    public void setSoloParaSocios(boolean soloParaSocios) {
        this.soloParaSocios = soloParaSocios;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
