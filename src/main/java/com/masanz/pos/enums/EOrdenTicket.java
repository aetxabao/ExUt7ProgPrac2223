package com.masanz.pos.enums;

import static com.masanz.pos.modelo.AppConsts.*;

public enum EOrdenTicket {

    ORDEN_NOMBRE(0),
    ORDEN_PRECIO_DES(1), ORDEN_PRECIO_ASC(2);

    private int numero;

    EOrdenTicket(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static EOrdenTicket fromNumero(int numero) {
        return EOrdenTicket.values()[numero];
    }

    public static String txtFromNumero(int numero) {
        return switch (numero) {
            case 0 -> TXT_ORDEN_NOMBRE;
            case 1 -> TXT_ORDEN_PRECIO_DES;
            case 2 -> TXT_ORDEN_PRECIO_ASC;
            default -> null;
        };
    }

    public static int opciones() {
        return EOrdenTicket.values().length;
    }

}
