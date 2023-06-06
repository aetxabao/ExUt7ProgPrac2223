package com.masanz.pos.enums;
public enum EMenu {

    SALIR(0),
    NUEVA_COMPRA(1), LISTAR_PRODUCTOS(2), DEFINIR_ORDEN(3);

    private int numero;

    EMenu(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static EMenu fromNumero(int numero) {
        return switch (numero) {
            case 0 -> SALIR;
            case 1 -> NUEVA_COMPRA;
            case 2 -> LISTAR_PRODUCTOS;
            case 3 -> DEFINIR_ORDEN;
            default -> null;
        };
    }

}
