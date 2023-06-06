package com.masanz.pos.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maestro {
    private Map<Integer, Producto> mapaProductos;

    public Maestro() {
        mapaProductos = new HashMap<>();
    }

    public void loadProductos(String fileName) {
        Scanner sc = new Scanner(Maestro.class.getResourceAsStream(fileName));
        while (sc.hasNext()){
            String linea = sc.nextLine();
            String[] a = linea.split(";");
            int id = Integer.parseInt(a[0]);
            String nombre = a[1];
            double precio = Double.parseDouble(a[2]);
            Producto producto = new Producto(id, nombre, precio);
            mapaProductos.put(id,producto);
        }
    }

    public void loadDescuentos(String fileName) {
        Scanner sc = new Scanner(Maestro.class.getResourceAsStream(fileName));
        while (sc.hasNext()){
            String linea = sc.next();
            String[] a = linea.split(";");
            int id = Integer.parseInt(a[0]);
            String descuento = a[1];
            Producto producto = mapaProductos.get(id);
            producto.setDescuento(descuento);
        }
    }

    public void emptyProductos(){
        mapaProductos.clear();
    }

    public Producto getProducto(int i){
        return mapaProductos.get(i).clone();
    }

    public int cantidadProductos() { return mapaProductos.size(); }

    public String[][] getProductosAsMatrixOfStrings(){
        int i = 0;
        String [][] m = new String[cantidadProductos()][];
        for (Producto producto : mapaProductos.values()) {
            m[i++] = producto.toStringArray();
        }
        return m;
    }

}
