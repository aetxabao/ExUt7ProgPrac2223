package com.masanz.pos.modelo;

import com.masanz.pos.descuentos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.masanz.pos.modelo.AppConsts.*;

public class GeneradorDescuentos {

    private static boolean esSocio = false;

    public static void setEsSocio(boolean b) {
        esSocio = b;
    }

    public static List<ADescuento> getDescuentos(Map<Producto, Integer> productosCantidades){
        ADescuento dto;
        boolean esSoloParaSocios;
        Producto producto;
        int cantidad;
        String s, tipo;
        int n, m, i;
        List<ADescuento> list = new ArrayList<>();
        for (Map.Entry<Producto, Integer> entry : productosCantidades.entrySet()) {
            producto = entry.getKey();
            cantidad = entry.getValue();
            s = producto.getDescuento();
            if (!s.startsWith(DTO)){
                continue;
            }
            s = s.substring(DTO.length()+1);
            if (s.startsWith(SOCIO)) {
                esSoloParaSocios = true;
                s = s.substring(SOCIO.length()+1);
            }else {
                esSoloParaSocios = false;
            }
            tipo = s.substring(0,3);
            s = s.substring(4);
            switch (tipo) {
                case NXM:
                    i = s.indexOf("_");
                    n = Integer.valueOf(s.substring(0,i));
                    m = Integer.valueOf(s.substring(i+1));
                    dto = new DescuentoNxM(esSoloParaSocios, producto, cantidad, n, m);
                    list.add(dto);
                    break;
                case PRC:
                    n = Integer.valueOf(s);
                    dto = new DescuentoPorcentaje(esSoloParaSocios, producto, cantidad, n);
                    list.add(dto);
                    break;
                case CAD:
                    //TODO: getDescuentos DescuentoCaducidad
                    break;
                case SEG:
                    //TODO: getDescuentos DescuentoSegundo
                    break;
            }
        }
        return list;
    }

    public static double getTotalSinDescuentos(Map<Producto, Integer> productosCantidades) {
        double total = 0;
        Producto producto;
        int cantidad;
        for (Map.Entry<Producto, Integer> entry : productosCantidades.entrySet()) {
            producto = entry.getKey();
            cantidad = entry.getValue();
            total += cantidad * producto.getPrecio();
        }
        return total;
    }

    public static List<ADescuento> filtroDescuentos(boolean esSocio, List<ADescuento> descuentos){
        List<ADescuento> list = new ArrayList<>();
        for (ADescuento dto : descuentos) {
            if (dto.isSoloParaSocios()==esSocio) {
                list.add(dto);
            }
        }
        return list;
    }

    public static double getTotalDescuentos(List<ADescuento> descuentos) {
        double total = 0;
        for (ADescuento dto : descuentos) {
            total += Math.round(dto.getValorDescuento()*100);
        }
        return total/100;
    }

}
