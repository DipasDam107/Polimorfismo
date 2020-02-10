/*
Modificar el programa anterior para que el usuario tenga un Array de 5 teléfonos, y que después
de elegir la operación a realizar pueda elegir con cuál de los 5 teléfonos desea hacerla.
*/

package dam107t2e6;

import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static cMovilPrepago movil;
    public static ArrayList <cMovilPrepago> moviles;
    static Scanner teclado=new Scanner(System.in);
    public static void main(String[] args) {
        moviles=new ArrayList<>();
        
        moviles.add(new cMovilPrepago(981666666,2,2,2,0));
        moviles.add(new cMovilPrepago(777777777,2,2,2,0));
        moviles.add(new movilPlus(666666666,2,2,0));
        moviles.add(new movilTarifaPlana(200000000,2,2,0));
        moviles.add(new movilPlus(111111111,2,2,0));
        
        int opcion,opMovil,numOpciones; 
   
        do{
            menu();
            opcion=teclado.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if (opcion>0 && opcion<=moviles.size()){ 
                movil = moviles.get(opcion-1);
                
                if(movil instanceof movilPlus) numOpciones=5;
                else numOpciones=4;
                do{
                    menuMovil();
                    opMovil=teclado.nextInt();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if(opMovil==1) navegar();
                    if(opMovil==2) llamar();
                    if(opMovil==3) recargar();
                    if(opMovil==4 && movil instanceof movilPlus) videollamar();
                }while(opMovil!=0 || (opMovil>numOpciones || opMovil<0));
            }
        }while(opcion!=0 || (opcion>3 || opcion<0));
    }
    
    public static void menu(){
        int num=1;
        System.out.println("-----------------------------");
        System.out.println("MENU");
        System.out.println("-----------------------------");
        for(cMovilPrepago movil : moviles){
            if(movil instanceof movilPlus) System.out.println(num+"- Numero:  " + movil.numeroMovil + " Tipo: Movil Plus");
            else if(movil instanceof movilTarifaPlana) System.out.println(num+"- Numero:  " + movil.numeroMovil + " Tipo: Tarifa Plana");
            else System.out.println(num+"- Numero:  " + movil.numeroMovil + " Tipo: Movil Prepago");
            num++;
        }
        System.out.println("0 - Salir");
        System.out.println("-----------------------------");
        System.out.println("Dime que movil quieres usar: ");
    }
    
    public static void menuMovil(){
        System.out.println("-----------------------------");
        System.out.println(movil.toString());
        System.out.println("-----------------------------");
        System.out.println("1 - Navegar");
        System.out.println("2 - Llamar");
        System.out.println("3 - Recargar");
        if(movil instanceof movilPlus)
            System.out.println("4 - Videollamar"); 
        System.out.println("0 - Salir");
        System.out.println("-----------------------------");
        System.out.println("Dime que movil tienes: ");
    }
    public static void navegar(){
        System.out.println("Cuantos Megas: ");
        if(movil instanceof movilTarifaPlana) ((movilTarifaPlana)movil).navegar(teclado.nextInt());
        else movil.navegar(teclado.nextInt());
    }
    
    public static void llamar(){
        System.out.println("Cuantos segundos: ");
        movil.efectuarLlamada(teclado.nextInt())
    ;}
    public static void recargar(){
        System.out.println("Dime Importe: ");
        if(movil.recargar(teclado.nextInt())) System.out.println("Ingreso Correcto");
        else System.out.println("La cantidad a ingresar debe ser múltiplo de cinco");
    }
    
    public static void videollamar(){
        System.out.println("Dime Segundos: ");
        ((movilPlus)movil).videollamada(teclado.nextInt());
    }
    public static void verSaldo(){
        System.out.println("Saldo " + movil.consultarSaldo());
    }
    
}
    
        