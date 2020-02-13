package dam107t2e10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList <Coche> parking;
	public static Scanner teclado = new Scanner(System.in);
	public static final int NUM_PLAZAS = 100;
	public static void main(String[] args) {
		parking=new ArrayList<>();
		int opcion;
		do {
			menu();
			opcion=teclado.nextInt();
			teclado.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			 	if(opcion==1) regEntrada();
		        if(opcion==2) regSalida();
		        if(opcion==3) mostrarParking();
		}while(opcion!=0||(opcion>3||opcion<0));
		

	}
	
	 public static void menu(){
	        System.out.println("-----------------------------");
	        System.out.println("MENU PARKING");
	        System.out.println("-----------------------------");
	        System.out.println("1 - Registrar Entrada");
	        System.out.println("2 - Registrar Salida");
	        System.out.println("3 - Mostrar Lista");
	        System.out.println("0 - Salir");
	        System.out.println("-----------------------------");
	        System.out.println("Dime Opcion: ");
	    }
	 
	 public static void menuTipo(){
	        System.out.println("-----------------------------");
	        System.out.println("MENU ENTRADA");
	        System.out.println("-----------------------------");
	        System.out.println("1 - Coche");
	        System.out.println("2 - Furgoneta");
	        System.out.println("3 - Autobus");
	        System.out.println("-----------------------------");
	        System.out.println("Dime Tipò de vehículo: ");
	    }
	 public static void regEntrada() {
		 int opcion;
		 String matricula;
		 if(parking.size()<100) {
			do {
				menuTipo();
				opcion=teclado.nextInt();
				teclado.nextLine();
				
			}while(opcion!=1 && opcion!=2 && opcion!=3);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			System.out.println("Dime Matricula: ");
			matricula=teclado.nextLine();
			if(parking.indexOf(new Coche(LocalDateTime.now(), matricula))==-1) {
				if(opcion==1) parking.add(new Coche(LocalDateTime.now(), matricula));
				else if (opcion==2) {
					System.out.println("Dime longitud del Vehículo en metros: ");
					parking.add(new Furgoneta(teclado.nextFloat(), matricula,LocalDateTime.now()));
				}
				else {
					System.out.println("Dime numero de asientos del vehículo: ");
					parking.add(new Autobus(teclado.nextInt(), matricula,LocalDateTime.now()));
				}
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		        System.out.println("Vehiculo Registrado con exito");
			}
			else { System.out.println("Ya hay un coche con esa matricula");
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}
		 }
		 else {
			 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		     System.out.println("No hay sitio en el parking");
		 }
	 }
	 public static void regSalida(){
		 String mat;
		 System.out.println("Matricula del vehículo a retirar: ");
		 mat=teclado.nextLine();
		 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		 int pos = parking.indexOf(new Coche(LocalDateTime.now(),mat));
		 if(pos!=-1){
			 cobrar(pos);
			 parking.remove(pos);
			 System.out.println("Vehiculo Retirado con exito. Matricula: " + mat);
		 }
		 else System.out.println("No hay ningun coche con la matricula " + mat);
	 }
	 public static void mostrarParking() {
		 
        System.out.println("-----------------------------");
        System.out.println("PARKING");
        System.out.println("-----------------------------");
		if(parking.size()!=0) {
			for(Coche car : parking) {
				if(car instanceof Furgoneta)System.out.println(((Furgoneta)car).toString());
				 else if (car instanceof Autobus) System.out.println(((Autobus)car).toString());
				 else System.out.println(car.toString()); 
			}
			System.out.println();
			System.out.println("Plazas Ocupadas: " + parking.size() + " Plazas Libres: " + (NUM_PLAZAS-parking.size()));
		}
		else System.out.println("No hay vehículos aparcados. Plazas Libres: " + (NUM_PLAZAS-parking.size()));
	 }
	 
	 public static void cobrar(int pos) {
		 double tarifa;
		 if(parking.get(pos) instanceof Furgoneta)  tarifa=((Furgoneta)parking.get(pos)).calcularTarifa();
		 else if (parking.get(pos) instanceof Autobus) tarifa=((Autobus)parking.get(pos)).calcularTarifa(); 
		 else tarifa=parking.get(pos).calcularTarifa();
		 
		 System.out.printf("Total a pagar: %.2f \n", tarifa);
	 }
}
