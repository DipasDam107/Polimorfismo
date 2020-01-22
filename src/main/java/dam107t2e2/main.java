/*
Realiza un programa con una variable de tipo Figura2D_v8, y sobre ella llama a uno de los
constructores de Triangulo_v8. Muestra sus dimensiones y el cálculo del área.

*/

package dam107t2e2;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        Figura2D figura;
        int opcion;
        double alto, ancho;
        System.out.println("Dime alto: ");
        alto=teclado.nextDouble();
        
        System.out.println("Dime ancho: ");
        ancho=teclado.nextDouble();
        
        do{
        System.out.println("Quieres hacer un Cuadrado(1) o un triangulo(2)?");
        opcion=teclado.nextInt();
        }while(opcion!=1 && opcion!=2);
        teclado.nextLine();
       
        if(opcion==2)   figura = new Triangulo(ancho,alto,"Isosceles","Pepe");
        else figura = new Rectangulo(ancho,alto,"Pepe");
        
        System.out.println("Nombre: " + figura.getNombre());
        figura.verDim();
        
        if(figura instanceof Triangulo) System.out.println("Estilo: " + ((Triangulo) figura).getEstilo());
        else if(figura instanceof Rectangulo){
            if(((Rectangulo) figura).esCuadrado()) System.out.println("Es cuadrado");
            else System.out.println("No es cuadrado");
        } 
    }
}
