/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t2e8;

import java.util.Scanner;

/**
 *
 * @author dam107
 */
public class Consola {
    static Scanner teclado = new Scanner(System.in);
    
    public static int leerEntero(){
        return teclado.nextInt();
    }
    public static int leerEntero(String cadena){
        System.out.println(cadena);
        return teclado.nextInt();
    }
    public static boolean leerEntero(String cadena, int num1, int num2){
        int max=Math.max(num1, num2);
        int min=Math.min(num1, num2);
        System.out.println(cadena);
        int valor = teclado.nextInt();
        if(valor>=min && valor<=max) return true;
        else return false;
    }
    public static boolean leerEntero(int num1, int num2){
        int max=Math.max(num1, num2);
        int min=Math.min(num1, num2);
        int valor = teclado.nextInt();
        if(valor>=min && valor<=max) return true;
        else return false;
    }
}
