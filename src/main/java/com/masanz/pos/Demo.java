package com.masanz.pos;

import com.masanz.pos.enums.EOrdenTicket;
import com.masanz.pos.modelo.Tienda;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static com.masanz.pos.modelo.AppConsts.*;

public class Demo {

    private static Logger log = Logger.getLogger(Demo.class);
    public static void main(String[] args) {
        System.setProperty(SYSTEM_PROPERTY, DEMO + TU_NOMBRE);
        PropertyConfigurator.configure(LOG4J_PROPERTIES);
        log.info(">".repeat(40));

        Tienda tienda = new Tienda(TU_NOMBRE);
        compra1(tienda);
        tienda.setOrden(EOrdenTicket.ORDEN_PRECIO_DES);
        compra2(tienda);
        tienda.setOrden(EOrdenTicket.ORDEN_PRECIO_ASC);
        compra3(tienda);
        tienda.estadisticas();

    }

    public static void compra1(Tienda tienda){
        tienda.iniCompra();
        int[] ids = {1,2,3,4,5,6,7,8};
        for (int i = 0; i < 4; i++) {
            for (int id : ids) {
                tienda.compra(id);
            }
        }
        tienda.setNumSocio(123456);
        tienda.finCompra();
    }

    public static void compra2(Tienda tienda){
        tienda.iniCompra();
        int[] ids = {1,1,1,4,3,3};
        for (int i = 0; i < 4; i++) {
            for (int id : ids) {
                tienda.compra(id);
            }
        }
        tienda.setNumSocio(223344);
        tienda.finCompra();
    }

    public static void compra3(Tienda tienda){
        tienda.iniCompra();
        int[] ids = {1,1,1,4,3,3};
        for (int i = 0; i < 4; i++) {
            for (int id : ids) {
                tienda.compra(id);
            }
        }
        tienda.setNumSocio(0);
        tienda.finCompra();
    }

}
