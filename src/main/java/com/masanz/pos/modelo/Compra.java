package com.masanz.pos.modelo;

import com.masanz.pos.descuentos.ADescuento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.masanz.pos.modelo.AppConsts.*;

public class Compra {

    Map<Producto, Integer> productosCantidades;

    int numSocio;

    static int contFactura = NUM_FACTURA;
    int numFactura;

    public Compra() {
        productosCantidades = new TreeMap<>(GeneradorComparadorProductos.getComparador());
        numSocio = 0;
        numFactura = ++contFactura;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public void resetCompra() {
        productosCantidades.clear();
    }

    public void addProducto(Producto producto){
        if (productosCantidades.containsKey(producto)) {
            int n = productosCantidades.get(producto);
            productosCantidades.put(producto, ++n);
        }else {
            productosCantidades.put(producto, 1);
        }
    }

    public int cantidadDeArticulosComprados() {
        int n = 0;
        for (Integer cantidad : productosCantidades.values()) {
            n += cantidad;
        }
        return n;
    }

    public Map<Producto, Integer> getProductosCantidades(){
        return productosCantidades;
    }

    private int getAnchoTicket() {
        int n = 0;
        for (int w : NUM_CAMPOS_TICKET) {
            n += Math.abs(w) + 1;
        }
        return n;
    }

    public String getTicket() {
        Producto producto;
        int cantidad;
        int m;
        int n = getAnchoTicket();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        //TITULO
        sb.append("#".repeat(n)).append("\n");
        m = (n-PUNTO_DE_VENTA.length()-2)/2;
        sb.append("#").append(" ".repeat(m)).append(PUNTO_DE_VENTA).append(" ".repeat(n-m-PUNTO_DE_VENTA.length()-2)).append("#").append("\n");
        m = (n- TU_NOMBRE.length()-2)/2;
        sb.append("#").append(" ".repeat(m)).append(TU_NOMBRE).append(" ".repeat(n-m- TU_NOMBRE.length()-2)).append("#").append("\n");
        sb.append("#".repeat(n)).append("\n");

        //NUMERO FACTURA Y SOCIO
        m = (n - String.valueOf(numFactura).length())/2;
        sb.append(" ".repeat(m)).append(numFactura).append("\n");
        if (numSocio!=0) {
            sb.append("-".repeat(n)).append("\n");
            m = n - TXT_SOCIO.length() - String.valueOf(numSocio).length();
            sb.append(TXT_SOCIO).append(" ".repeat(m)).append(numSocio).append("\n");
        }

        //ENCABEZADO PRODUCTOS
        sb.append("-".repeat(n)).append("\n");
        for (int i = 0; i < TXT_CAMPOS_TICKET.length; i++) {
            m = NUM_CAMPOS_TICKET[i];
            sb.append(" ");
            sb.append(String.format("%"+m+"s",TXT_CAMPOS_TICKET[i]));
        }
        sb.append("\n");
        sb.append("-".repeat(n)).append("\n");

        //CANTIDAD-PRODUCTOS-PRECIO_UNO-PRECIO_CANT
        for (Map.Entry<Producto, Integer> entry : productosCantidades.entrySet()) {
            producto = entry.getKey();
            cantidad = entry.getValue();
            m = NUM_CAMPOS_TICKET[0];
            sb.append(" ");
            if (cantidad>1){
                sb.append(String.format("%"+m+"s",cantidad));
            }else{
                sb.append(String.format("%"+m+"s"," "));
            }
            sb.append(" ");
            m = NUM_CAMPOS_TICKET[1];
            sb.append(String.format("%"+m+"s",producto.getNombre()));
            sb.append(" ");
            m = NUM_CAMPOS_TICKET[2];
            if (cantidad>1){
                sb.append(String.format("%"+m+"s",String.format("%.2f",producto.getPrecio())));
            }else{
                sb.append(String.format("%"+m+"s"," "));
            }
            sb.append(" ");
            m = NUM_CAMPOS_TICKET[3];
            sb.append(String.format("%"+m+"s",String.format("%.2f",cantidad * producto.getPrecio())));
            sb.append("\n");
        }

        //TOTAL SIN DESCUENTOS
        sb.append("-".repeat(n)).append("\n");
        sb.append(String.format("%-"+(n-8)+"s",TXT_TOTAL));
        double totalSinDescuentos = GeneradorDescuentos.getTotalSinDescuentos(productosCantidades);
        sb.append(String.format("%8.2f", totalSinDescuentos));
        sb.append("\n");

        //DESCUENTOS
        List<ADescuento> dtos = GeneradorDescuentos.getDescuentos(productosCantidades);
        if (numSocio == 0) {
            dtos = GeneradorDescuentos.filtroDescuentos(false, dtos);
        }
        sb.append("-".repeat(n)).append("\n");
        for (ADescuento dto : dtos) {
            double valor = dto.getValorDescuento();
            if (valor>0){
                sb.append(String.format("%-"+(n-8)+"s",dto.getProducto().getNombre()));
                sb.append(String.format("%8.2f", -valor));
                sb.append("\n");
            }
        }

        //TOTAL DESCUENTOS
        sb.append("-".repeat(n)).append("\n");
        sb.append(String.format("%-"+(n-8)+"s",TXT_TOTAL_DESCUENTOS));
        double totalDescuentos = GeneradorDescuentos.getTotalDescuentos(dtos);
        sb.append(String.format("%8.2f", -totalDescuentos));
        sb.append("\n");

        //TOTAL A PAGAR
        sb.append("-".repeat(n)).append("\n");
        sb.append(String.format("%-"+(n-8)+"s",TXT_TOTAL_A_PAGAR));
        double totalAPagar = totalSinDescuentos - totalDescuentos;
        sb.append(String.format("%8.2f", totalAPagar));
        sb.append("\n");

        //FECHA Y HORA
        sb.append("-".repeat(n)).append("\n");
        String s = LocalDateTime.now().toString();
        s = s.replace("T"," ");
        s = s.substring(0, 19);
        sb.append(" ".repeat((n-s.length())/2));
        sb.append(s);
        sb.append("\n");

        sb.append("-".repeat(n)).append("\n");
        return sb.toString();
    }

}
