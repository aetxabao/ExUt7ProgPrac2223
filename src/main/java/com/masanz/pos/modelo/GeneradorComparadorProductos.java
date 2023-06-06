package com.masanz.pos.modelo;

import com.masanz.pos.enums.EOrdenTicket;

import java.util.Comparator;

import static com.masanz.pos.enums.EOrdenTicket.*;

public class GeneradorComparadorProductos {

    private static EOrdenTicket orden = ORDEN_NOMBRE;

    public static Comparator<Producto> getComparador() {
        switch (orden){
            case ORDEN_PRECIO_DES:
                return null;
            case ORDEN_PRECIO_ASC:
                return null;
            case ORDEN_NOMBRE:
                return null;
        }
        return null;
    }

    public static EOrdenTicket getOrden() {
        return orden;
    }

    public static void setOrden(EOrdenTicket orden) {
        GeneradorComparadorProductos.orden = orden;
    }

}
