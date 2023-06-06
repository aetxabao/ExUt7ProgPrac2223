package com.masanz.pos.modelo;

import com.masanz.pos.enums.EMenu;
import com.masanz.pos.enums.EOrdenTicket;
import com.masanz.pos.io.Entrada;
import com.masanz.pos.io.Salida;

import java.util.ArrayList;
import java.util.List;

import static com.masanz.pos.modelo.AppConsts.*;

public class Tienda {

    private String nombre;
    private Maestro maestro;
    private List<Compra> listaCompras;
    private Compra compra;

    public Tienda(String nombre){
        this.nombre = nombre;
        maestro = new Maestro();
        maestro.loadProductos(FICHERO_PRODUCTOS);
        maestro.loadDescuentos(FICHERO_DESCUENTOS);
        listaCompras = new ArrayList<>();
    }

    public void run() {
        Salida.mostrarMenu();
        EMenu opcion = Entrada.leerOpcionMenu(TXT_OPCION);
        while (opcion != EMenu.SALIR) {
            switch (opcion) {
                case NUEVA_COMPRA -> nuevaCompra();
                case LISTAR_PRODUCTOS -> listarProductos();
                case DEFINIR_ORDEN -> definirOrden();
                default -> { }
            }
            if (!Entrada.leerConfirmacion(TXT_CONTINUAR)) {
                break;
            }
            Salida.mostrarMenu();
            opcion = Entrada.leerOpcionMenu(TXT_OPCION);
        }
        estadisticas();
    }

    public void estadisticas() {
        Salida.mostrarEstadisticas(EstadisticasDescuentos.getResumen(listaCompras));
    }

    private void definirOrden() {
        Salida.mostrarOrden();
        int orden = Entrada.leerNumero("Orden",0, EOrdenTicket.opciones() - 1);
        setOrden(EOrdenTicket.fromNumero(orden));
    }

    public void setOrden(EOrdenTicket orden) {
        GeneradorComparadorProductos.setOrden(orden);
    }

    private void listarProductos() {
        Salida.mostrarProductos(maestro.getProductosAsMatrixOfStrings());
    }

    private void nuevaCompra() {
        int idProd = 0;
        iniCompra();
        while (true) {
            idProd = Entrada.leerNumero("Id producto",0, cantidadProductosDisponibles() );
            if (idProd == 0) break;
            compra(idProd);
        }
        if (cantidadDeArticulosEnCompra()>0) {
            int numSocio = Entrada.leerNumero(TXT_NUMERO_SOCIO, 0, 99999999);
            setNumSocio(numSocio);
            finCompra();
        }else {
            Salida.mostrar(TXT_COMPRA_ANULADA);
        }
    }

    private int cantidadProductosDisponibles() {
        return maestro.cantidadProductos();
    }

    private int cantidadDeArticulosEnCompra() {
        return compra.cantidadDeArticulosComprados();
    }

    public void iniCompra(){
        compra = new Compra();
    }
    public void compra(int idProducto){
        compra.addProducto(maestro.getProducto(idProducto));
    }
    public void finCompra(){
        listaCompras.add(compra);
        Salida.imprimir(
            compra.getTicket()
        );
    }
    public void setNumSocio(int numSocio) {
        compra.setNumSocio(numSocio);
    }


}
