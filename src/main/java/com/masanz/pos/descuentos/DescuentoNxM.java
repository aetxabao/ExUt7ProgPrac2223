package com.masanz.pos.descuentos;

import com.masanz.pos.modelo.Producto;

public class DescuentoNxM extends ADescuento{
    int n;
    int m;

    public DescuentoNxM(boolean esSoloParaSocios, Producto producto, int cantidad, int n, int m) {
        super(esSoloParaSocios, producto, cantidad);
        this.n = n;
        this.m = m;
    }

    @Override
    public double getValorDescuento() {
        int x = cantidad / n;
        int y = cantidad % n;
        double pagas = x * m * producto.getPrecio() + y * producto.getPrecio();
        return getImporteCantidadProducto() - pagas;
    }

}
