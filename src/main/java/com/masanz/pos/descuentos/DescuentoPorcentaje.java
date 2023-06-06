package com.masanz.pos.descuentos;

import com.masanz.pos.modelo.Producto;

public class DescuentoPorcentaje extends ADescuento{

    int porcentaje;

    public DescuentoPorcentaje(boolean esSoloParaSocios, Producto producto, int cantidad, int porcentaje) {
        super(esSoloParaSocios, producto, cantidad);
        this.porcentaje = porcentaje;
    }

    @Override
    public double getValorDescuento() {
        return getImporteCantidadProducto() * porcentaje / 100;
    }
}
