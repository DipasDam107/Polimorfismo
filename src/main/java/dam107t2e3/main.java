/*
Modificar el ejercicio anterior para añadir a las figuras posibles el Triancolor. Así pues, el usuario
seleccionará entre: Triangulo, Triancolor, Rectangulo.
    • Después de crear la figura, mostrará las dimensiones de la misma (sea cual sea su tipo).
    • Finalmente, y utilizando el operador instanceof, mostrará unos datos adicionales dependiendo del
tipo de figura que sea:
    - Si es de tipo Triangulo, mostrará el área (sea Triancolor o no).
    - Si es de tipo Rectangulo, mostrará si es de forma cuadrada o no.
    - Si es de tipo Triancolor, mostrará el color. 
*/

package dam107t2e3;
import java.util.Scanner;

public class main {
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        Figura2D figura;
        int opcion;
        String color="No", nom;
        double alto, ancho;
        System.out.println("Dime nombre: ");
        nom=teclado.nextLine();
        
        System.out.println("Dime alto: ");
        alto=teclado.nextDouble();
        
        System.out.println("Dime ancho: ");
        ancho=teclado.nextDouble();
        
        do{
            System.out.println("Quieres hacer un Cuadrado(1), un triangulo(2) o Triangulo de Color (3)?");
            opcion=teclado.nextInt();
            teclado.nextLine();
            
            if(opcion==3){ 
                System.out.println("Dime color: ");
                color=teclado.nextLine();
            }
        }while(opcion!=1 && opcion!=2 && opcion!=3);
       
       
        if(opcion==2)   figura = new Triangulo(ancho,alto,"Isosceles",nom);
        else if(opcion==1) figura = new Rectangulo(ancho,alto,nom);
        else figura = new TrianColor(ancho,alto,"Isosceles", color, nom);
        
        System.out.println("Nombre: " + figura.getNombre());
        figura.verDim();
        
        if(figura instanceof Triangulo) System.out.println("Estilo: " + ((Triangulo) figura).getEstilo());
        else if(figura instanceof Rectangulo){
            if(((Rectangulo) figura).esCuadrado()) System.out.println("Es cuadrado");
            else System.out.println("No es cuadrado");
        }
        else System.out.println("Color: " + ((TrianColor)figura).getColor());
    }
}
