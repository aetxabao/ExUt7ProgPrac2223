package com.masanz.pos.modelo;

import com.masanz.pos.Main;

import java.net.URL;

public final class AppConsts {

    //region Tienda
    public static final String TU_NOMBRE = "TU_NOMBRE";
    public static final String PUNTO_DE_VENTA = "Punto   de   venta";
    public static final int NUM_FACTURA = 1000000000;
    //endregion

    //region Menu
    public static final String MENU_1_NUEVA_COMPRA = "1. Nueva compra";
    public static final String MENU_2_LISTAR_PRODUCTOS = "2. Listar productos";
    public static final String MENU_3_DEFINIR_ORDEN = "3. Definir orden ticket";
    public static final String MENU_0_TERMINAR = "0. Terminar";
    //endregion

    //region Maestros
    public static final String FICHERO_PRODUCTOS = "productos9.txt";
    public static final String FICHERO_DESCUENTOS = "descuentos6.txt";
    //endregion

    //region Salida
    public static final String TXT_OPCION = "Opción";
    public static final String TXT_CONTINUAR = "Continuar";
    public static final String TXT_COMPRA_ANULADA = "Compra anulada";
    public static final String[] TXT_CAMPOS_PRODUCTOS = {"ID.", "NOMBRE", "PRECIO", "DESCUENTO"};
    public static final int[] NUM_CAMPOS_PRODUCTOS = {5, -30, 10, -20};
    public static final String TXT_NUMERO_SOCIO = "Num. socio";
    //endregion

    //region Compra
    public static final String[] TXT_CAMPOS_TICKET = {"No.", "PRODUCTO", "EUR/UN", "TOT_EUR"};
    public static final int[] NUM_CAMPOS_TICKET = {4, -25, 8, 8};
    public static final String TXT_SOCIO = "SOCIO";
    public static final String TXT_TOTAL = "TOTAL";
    public static final String TXT_TOTAL_DESCUENTOS = "TOTAL DESCUENTOS";
    public static final String TXT_TOTAL_A_PAGAR = "TOTAL A PAGAR";
    //endregion


    //region GeneradorDescuentos
    public static final String DTO = "DTO";
    public static final String SOCIO = "SOCIO";
    public static final String NXM = "NXM";
    public static final String PRC = "PRC";
    public static final String CAD = "CAD";
    public static final String SEG = "SEG";
    //endregion

    //region EstadisticasDescuentos
    public static final String TXT_NUM_COMPRAS_TOTALES = "Numero de compras totales";
    public static final String TXT_NUM_COMPRAS_SOCIOS = "Numero de compras socios";
    public static final String TXT_DTOS_CADUCIDAD = "Descuentos por caducidad";
    public static final String TXT_DTOS_NXM = "Descuentos promociones NxM";
    public static final String TXT_DTOS_PORCENTAJE = "Descuentos porcentajes";
    public static final String TXT_DTOS_SEGUNDO = "Descuentos segunda unidad";
    public static final String TXT_DTOS_SOCIOS = "Descuentos a socios";
    //endregion

    //region Entrada
    public static final String NO_VALIDO = "NO VALIDO";
    //endregion

    //region GeneradorComparadorProductos
    public static final String TXT_ORDEN_PRECIO_ASC = "Por precio ascendente";
    public static final String TXT_ORDEN_PRECIO_DES = "Por precio descendente";
    public static final String TXT_ORDEN_NOMBRE = "Por nombre";
    //endregion

    //region Logs
    public static final URL LOG4J_PROPERTIES = Main.class.getResource("log4j.properties");
    public static final String SYSTEM_PROPERTY = "userApp.userName";
    public static final String MAIN = "Main_";
    public static final String DEMO = "Demo_";
    //endregion

}