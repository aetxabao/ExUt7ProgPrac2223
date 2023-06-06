package com.masanz.pos.io;

import com.masanz.pos.enums.EOrdenTicket;

import static com.masanz.pos.modelo.AppConsts.*;

public class Salida {

    public static void mostrarMenu() {
        int n = 5 + PUNTO_DE_VENTA.length() + 3 + TU_NOMBRE.length() + 5;
        StringBuilder sb = new StringBuilder();
        sb.append("=".repeat(n)).append("\n");
        sb.append("=    " + PUNTO_DE_VENTA + "   " + TU_NOMBRE + "    =").append("\n");
        sb.append("=".repeat(n)).append("\n");
        sb.append(MENU_1_NUEVA_COMPRA).append("\n");
        sb.append(MENU_2_LISTAR_PRODUCTOS).append("\n");
        sb.append(MENU_3_DEFINIR_ORDEN).append("\n");
        sb.append("-".repeat(n)).append("\n");
        sb.append(MENU_0_TERMINAR).append("\n");
        sb.append("=".repeat(n)).append("\n");
        System.out.print(sb);
    }

    public static void mostrarOrden() {
        int n = 5 + PUNTO_DE_VENTA.length() + 3 + TU_NOMBRE.length() + 5;
        System.out.println("-".repeat(n));
        for (int i = 0; i < EOrdenTicket.opciones(); i++) {
            System.out.println(i + ". " + EOrdenTicket.txtFromNumero(i));
        }
    }

    public static void mostrar(String txt) {
        System.out.println(txt);
    }

    public static void imprimir(String ticket) {
        System.out.println(ticket);
    }

    public static void mostrarProductos(String[][] productos) {
        int n = 0;
        for (int w : NUM_CAMPOS_PRODUCTOS) {
            n += Math.abs(w) + 3;
        }
        n += 2;
        System.out.println("-".repeat(n));
        mostrar(TXT_CAMPOS_PRODUCTOS, NUM_CAMPOS_PRODUCTOS);
        System.out.println("-".repeat(n));
        mostrar(productos, NUM_CAMPOS_PRODUCTOS);
        System.out.println("-".repeat(n));
    }


    private static void mostrar(String[][] valores, int[] colWidths) {
        for (int i = 0; i < valores.length; i++) {
            mostrar(valores[i], colWidths);
        }
    }

    private static void mostrar(String[] valores, int[] colWidths) {
        for (int j = 0; j < valores.length; j++) {
            System.out.printf(" | %" + colWidths[j] + "s", valores[j]);
        }
        System.out.println(" |");
    }

    public static void mostrarEstadisticas(String resumen) {
        int n = 5 + PUNTO_DE_VENTA.length() + 3 + TU_NOMBRE.length() + 5;
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(n)).append("\n");
        sb.append(resumen);
        sb.append("*".repeat(n)).append("\n");
        System.out.print(sb);
    }
}