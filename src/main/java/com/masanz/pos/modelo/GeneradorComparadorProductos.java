package com.masanz.pos.modelo;

import com.masanz.pos.enums.EOrdenTicket;

import java.util.Comparator;

import static com.masanz.pos.enums.EOrdenTicket.*;

public class GeneradorComparadorProductos {

    private static EOrdenTicket orden = ORDEN_NOMBRE;

    public static Comparator<Producto> getComparador() {
        switch (orden){
            case ORDEN_PRECIO_DES:
                return new Comparator<Producto>() {
                    @Override
                    public int compare(Producto o1, Producto o2) {
                        return (int) ((o2.getPrecio() - o1.getPrecio())*100);
                    }
                };
            case ORDEN_PRECIO_ASC:
                return new Comparator<Producto>() {
                    @Override
                    public int compare(Producto o1, Producto o2) {
                        return (int) ((o1.getPrecio() - o2.getPrecio())*100);
                    }
                };
            case ORDEN_NOMBRE:
                return new Comparator<Producto>() {
                    @Override
                    public int compare(Producto o1, Producto o2) {
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                };
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
