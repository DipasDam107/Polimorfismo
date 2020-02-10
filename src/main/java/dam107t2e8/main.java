/*
 Crea una clase llamada Consola con un método estático sobrecargado llamado leerEntero() que
solicite al usuario que teclee un valor entero, cumpliendo las siguientes características:
    • Si no se le pasa ningún parámetro, no tiene requisitos, es simplemente un nextInt().
    • Si se le pasa un parámetro de tipo texto, escribe ese texto antes de solicitar el valor. Ejemplo:
    leerEntero (“Introduzca su edad”);
    • Si se le pasa un parámetro tipo texto y dos enteros, garantizará que el valor tecleado esté
    comprendido entre ambos. Ejemplo:
    leerEntero (“Introduzca su edad”, 0, 120);
    • Si se le pasan dos enteros, garantizará que el valor tecleado esté comprendido entre ambos,
    pero no muestra texto de instrucciones previo. Ejemplo:
    System.out.println (“Introduzca su edad”); leerEntero (0, 120);
Finalmente, haz un programa que pruebe todas las variantes del método
 */
package dam107t2e8;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("----------------------");
        System.out.println("EJER 1");
        System.out.println("----------------------");
        System.out.println("Dame Valor: ");
        System.out.println("El valor es " +Consola.leerEntero());
        
        System.out.println("----------------------");
        System.out.println("EJER 2");
        System.out.println("----------------------");
        System.out.println("El valor es " +Consola.leerEntero("Dime tu Edad: "));
        
        System.out.println("----------------------");
        System.out.println("EJER 3");
        System.out.println("----------------------");
        if(Consola.leerEntero("Dime tu Edad: ", 1,50)) System.out.println("Valor Correcto");
        else System.out.println("Valor incorrecto");
      
        System.out.println("----------------------");
        System.out.println("EJER 4");
        System.out.println("----------------------");
        if(Consola.leerEntero(1,50)) System.out.println("Valor Correcto");
        else System.out.println("Valor incorrecto");
      
    }
}
