package com.masanz.pos;

import com.masanz.pos.modelo.Tienda;

import static com.masanz.pos.modelo.AppConsts.*;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        System.setProperty(SYSTEM_PROPERTY, MAIN + TU_NOMBRE);
        PropertyConfigurator.configure(LOG4J_PROPERTIES);
        log.info(".".repeat(40));
        Tienda tienda = new Tienda(TU_NOMBRE);
        tienda.run();
    }

}