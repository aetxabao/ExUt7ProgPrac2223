package com.masanz.pos.modelo;

import com.masanz.pos.descuentos.*;

import java.util.List;

import static com.masanz.pos.modelo.AppConsts.*;

public class EstadisticasDescuentos {

    public static String getResumen(List<Compra> listaCompras){
        int numComprasTotales = 0;
        int numComprasSocios = 0;
        int numDescuentosCaducidad = 0;
        int numDescuentosNxM = 0;
        int numDescuentosPorcentaje = 0;
        int numDescuentosSegundo = 0;
        int numDescuentosSocios = 0;
        StringBuilder sb = new StringBuilder();
        for (Compra compra : listaCompras) {
            if (compra.numSocio!=0){
                numComprasSocios++;
            }
            List<ADescuento> dtos = GeneradorDescuentos.getDescuentos(compra.productosCantidades);
            for (ADescuento dto : dtos) {
                if (dto instanceof DescuentoCaducidad) {
                    numDescuentosCaducidad++;
                }else if (dto instanceof DescuentoNxM) {
                    numDescuentosNxM++;
                }else if (dto instanceof DescuentoPorcentaje) {
                    numDescuentosPorcentaje++;
                }else if (dto instanceof DescuentoSegundo) {
                    numDescuentosSegundo++;
                }
                if (dto.isSoloParaSocios()){
                    numDescuentosSocios++;
                }
            }
        }
        numComprasTotales = listaCompras.size();
        sb.append(TXT_NUM_COMPRAS_TOTALES).append(": ").append(numComprasTotales).append("\n");
        sb.append(TXT_NUM_COMPRAS_SOCIOS).append(": ").append(numComprasSocios).append("\n");
        sb.append(TXT_DTOS_CADUCIDAD).append(": ").append(numDescuentosCaducidad).append("\n");
        sb.append(TXT_DTOS_NXM).append(": ").append(numDescuentosNxM).append("\n");
        sb.append(TXT_DTOS_PORCENTAJE).append(": ").append(numDescuentosPorcentaje).append("\n");
        sb.append(TXT_DTOS_SEGUNDO).append(": ").append(numDescuentosSegundo).append("\n");
        sb.append(TXT_DTOS_SOCIOS).append(": ").append(numDescuentosSocios).append("\n");
        return sb.toString();
    }

}
