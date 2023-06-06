package com.masanz.pos.descuentos;

import com.masanz.pos.modelo.Producto;

public class DescuentoCaducidad extends ADescuento{

    int porcentajePrimero;
    int porcentajeResto;

    public DescuentoCaducidad(boolean esSoloParaSocios, Producto producto, int cantidad, int porcentajePrimero, int porcentajeResto) {
        super(esSoloParaSocios, producto, cantidad);
        this.porcentajePrimero = porcentajePrimero;
        this.porcentajeResto = porcentajeResto;
    }

    @Override
    public double getValorDescuento() {
        double dto = producto.getPrecio() * porcentajePrimero / 100;
        dto += (cantidad-1) * producto.getPrecio() * porcentajeResto / 100;
        return dto;
    }

}
