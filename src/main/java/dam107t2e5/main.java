/*
Empleando las clases previas: movilPrepago, movilTarifaPlana, movilPlus realizar un programa que
inicialmente permita seleccionar al usuario qué tipo de tarifa tiene entre las tres posibles, luego configurará
el móvil solicitando al usuario los parámetros necesarios y finalmente presentará al usuario un menú para
realizar las operaciones permitidas (navegar, llamar, recargar, videollamar, ver saldo y salir) según el tipo
de tarifa.
 */
package dam107t2e5;

/**
 *
 * @author dam107
 */


import java.util.ArrayList;
import java.util.Scanner;
public class main {
    static final float ESTABLECIMIENTO_LLAMADA=2;
    static final float COSTE_MINUTO_LLAMADA=2;
    static final float COSTE_MB=2;
    static final float SALDO_INICIAL=0;
   
    public static cMovilPrepago movil;   
    static Scanner teclado=new Scanner(System.in);
    public static void main(String[] args) {
        int opcion,opMovil,numOpciones; 
   
        do{
            menu();
            opcion=teclado.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if (opcion==1 || opcion==2||opcion==3){  
                crearMovil(opcion);
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
        System.out.println("-----------------------------");
        System.out.println("MENU");
        System.out.println("-----------------------------");
        System.out.println("1 - Prepago");
        System.out.println("2 - Tarifa Plana");
        System.out.println("3 - Plus");
        System.out.println("0 - Salir");
        System.out.println("-----------------------------");
        System.out.println("Dime que movil tienes: ");
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
    
    
    public static void crearMovil(int opcion){
        long numero;
        float eLL, cML, cCMB, s;
        System.out.println("Dime número de Movil: ");
        numero=teclado.nextLong();
        if(opcion==1) movil=new cMovilPrepago(numero,ESTABLECIMIENTO_LLAMADA,COSTE_MINUTO_LLAMADA, COSTE_MB, SALDO_INICIAL);
        else if(opcion==2) movil=new movilTarifaPlana(numero,ESTABLECIMIENTO_LLAMADA,COSTE_MINUTO_LLAMADA, SALDO_INICIAL);
        else movil=new movilPlus(numero,COSTE_MINUTO_LLAMADA,COSTE_MB, SALDO_INICIAL);
    }
}
    
        