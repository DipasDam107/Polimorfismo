/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dam107
 */
public class Main {
    static ArrayList <Vehiculo> vehiculos;
    static Scanner teclado = new Scanner(System.in);
    public static void main(String [] args){
        vehiculos = new ArrayList<>();
        int menu;
        do{
            menu();
            menu=teclado.nextInt();
            teclado.nextLine();
            if(menu == 1)  listar();
            if(menu == 2)  aparcar();
            if(menu == 3)  salir();
        }while(menu!=0 || (menu>3 || menu < 0));
        
    }
    
    public static void menu(){
        System.out.println("1 - Listar");
        System.out.println("2 - Aparcar Nuevo");
        System.out.println("3 - Salir del Parking");
        System.out.println("----------------------------");
        System.out.println("Dime Opcion: ");
    }
    
    public static void menuTipoVehiculo(){
        System.out.println("1 - Coche");
        System.out.println("2 - Furgoneta");
        System.out.println("3 - Autobus");
        System.out.println("----------------------------");
        System.out.println("Dime Opcion: ");
    }
    
    public static void listar(){
        for(Vehiculo x : vehiculos)
                System.out.println(x.toString());
    }
    public static void aparcar(){
        int opcion;
        System.out.println("Dime Matricula: ");
        String matricula = teclado.nextLine();
        if(vehiculos.indexOf(new Coche(matricula))==-1){
            do{
                menuTipoVehiculo();
                opcion=teclado.nextInt();
                teclado.nextLine();
            }while(opcion!=1 && opcion!=2 && opcion!=3);
            
            if(opcion==1) vehiculos.add(new Coche(matricula));
            else if(opcion==2){
                System.out.println("Dime metros del vehículo: ");
                float metros = teclado.nextFloat();
                vehiculos.add(new Furgoneta(matricula,metros));
            }
            else{
                System.out.println("Dime asientos del vehículo: ");
                int asientos = teclado.nextInt();
                vehiculos.add(new Autobus(matricula,asientos));
            }
         
            System.out.println("Vehiculo aparcado correctamente");
              
        }
      
        else
            System.out.println("Error. El vehiculo de matricula " + matricula + " ya existe.");
            
            
        
    }
    public static void salir(){
        System.out.println("Dime Matricula: ");
        String matricula = teclado.nextLine();
        Vehiculo busca = new Coche(matricula);
        int pos = vehiculos.indexOf(busca);
        
        if(pos==-1)
            System.out.println("No hay vehiculo con esa matricula");
        else{
            System.out.println("Se procede a su salida. Importe: " + vehiculos.get(pos).importe());
            vehiculos.remove(pos);
        }
              
      
    }
}
