package com.masanz.pos.descuentos;

import com.masanz.pos.modelo.Producto;

public class DescuentoSegundo extends ADescuento{

    int porcentaje;

    public DescuentoSegundo(boolean esSoloParaSocios, Producto producto, int cantidad, int porcentaje) {
        super(esSoloParaSocios, producto, cantidad);
        this.porcentaje = porcentaje;
    }

    @Override
    public double getValorDescuento() {
        int n = cantidad / 2;
        return n * producto.getPrecio() * porcentaje / 100;
    }

}
