package com.masanz.pos.io;

import com.masanz.pos.enums.EMenu;

import java.util.Scanner;

import static com.masanz.pos.modelo.AppConsts.NO_VALIDO;

public class Entrada {

    public static EMenu leerOpcionMenu(String txt) {
        boolean insistir = true;
        Scanner teclado = new Scanner(System.in);
        int v = -1;
        while (insistir) {
            System.out.printf("%s: ", txt);
            v = teclado.nextInt();
            if (EMenu.fromNumero(v)!=null) {
                insistir = false;
            }
        }
        teclado.nextLine();
        return EMenu.fromNumero(v);
    }

    public static int leerNumero(String txt, int min, int max) {
        Scanner teclado = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.printf("%s: ", txt);
            s = teclado.nextLine();
            try{
                int num = Integer.parseInt(s);
                if (num>=min && num<=max){
                    return num;
                }
            }catch (Exception e){ }
            System.out.println(NO_VALIDO);
        }
    }

    public static boolean leerConfirmacion(String txt) {
        Scanner teclado = new Scanner(System.in);
        String s = "";
        System.out.printf("%s [S/n]: ", txt);
        s = teclado.nextLine();
        return !s.toUpperCase().startsWith("N");
    }

}