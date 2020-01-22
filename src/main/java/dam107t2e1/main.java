/*
Realiza un programa con una variable de tipo Figura2D_v8, y sobre ella llama a uno de los
constructores de Triangulo_v8. Muestra sus dimensiones y el cálculo del área.

*/
package dam107t2e1;

import java.util.Scanner;

public class main {
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        double alto, ancho;
        
        System.out.println("Dime alto: ");
        alto=teclado.nextDouble();
        
        System.out.println("Dime ancho: ");
        ancho=teclado.nextDouble();
        
        Figura2D figura = new Triangulo(ancho,alto,"Isosceles","Pepe");
        figura.verDim();
        System.out.println("El area es: " + ((Triangulo)figura).area());
  
    }
}