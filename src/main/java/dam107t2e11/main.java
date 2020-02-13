package dam107t2e11;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static Scanner teclado = new Scanner(System.in);
    public static ArrayList <CuentaCorriente> cuentas;
    public static CuentaCorriente c1;
    public static void main(String[] args){
    	cuentas=new ArrayList<>();
    	c1=new CuentaCorriente();
        int opcion;
        do{
        	menuCuentas();
        	opcion=teclado.nextInt();
            teclado.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if(opcion==1) aniadir();
            if(opcion==2) borrar();
            if(opcion==3) gestionar();
            if(opcion==4) listado();
            if(opcion==5) comision();
        }while(opcion!=0 || (opcion<0 || opcion>5));   
    }
    
    public static void menuCuentas(){
    	System.out.println("-----------------------");
        System.out.println("MENU CUENTAS ");
        System.out.println("-----------------------");
        System.out.println("1 - Añadir Cuenta");
        System.out.println("2 - Borrar Cuenta");
        System.out.println("3 - Gestionar Cuenta");
        System.out.println("4 - Listado ");
        System.out.printf("5 - Comisiones (Porcentaje: %.2f | Minimo %.2f) \n" , CuentaCorriente.getPorcentajeComision(), CuentaCorriente.getMinimoCosmision());
        System.out.println("0 - Salir");
        System.out.println("-----------------------");
        System.out.println("Dime Opcion: ");
    	
    } 
    public static void menu(String iban){
        System.out.println("-----------------------");
        System.out.println("MENU CUENTA: " + iban);
        System.out.println("-----------------------");
        System.out.println("1 - Ingresar");
        System.out.println("2 - Retirar");
        System.out.println("3 - Consultar Saldo");
        System.out.println("0 - Salir");
        System.out.println("-----------------------");
        System.out.println("Dime Opcion: ");
    }
    
    public static void menuTipo(){
    	System.out.println("-----------------------");
        System.out.println("MENU TIPO ");
        System.out.println("-----------------------");
        System.out.println("1 - Corriente");
        System.out.println("2 - Plazos");
        System.out.println("-----------------------");
        System.out.println("Dime Tipo de cuenta: ");
    } 
    //Primer menu
    public static void aniadir() {
    	int opcion;
    	String iban;
    	do {
    		menuTipo();
    		opcion=teclado.nextInt();
    		teclado.nextLine();
    	}while(opcion!=1 && opcion!=2);
    	
    	 System.out.println("Dime IBAN: ");
    	 iban=teclado.nextLine();
    	 if(cuentas.indexOf(new CuentaCorriente(iban))!=-1) System.out.println("Ya hay una cuenta con ese IBAN");
    	 else {
    		 if(opcion==1) cuentas.add(new CuentaCorriente(iban));
    		 else cuentas.add(new CuentaPlazo(iban));
    	 }
    }
    public static void borrar() {
    	String iban;
    	System.out.println("Dime IBAN: ");
   	 	iban=teclado.nextLine();
   	 	int pos = cuentas.indexOf(new CuentaCorriente(iban));
   	 	if(pos!=-1) {
   	 		System.out.println("Se ha borrado la cuenta de IBAN: "+ cuentas.get(pos).IBAN);
   	 		cuentas.remove(pos);
   	 	}
   	 	else System.out.println("No existe una cuenta con ese IBAN");
    }
    public static void gestionar(){
    	String iban;
    	int opcion;
    	System.out.println("Dime IBAN: ");
   	 	iban=teclado.nextLine();
   	 	int pos = cuentas.indexOf(new CuentaCorriente(iban));
   	 	if(pos!=-1) {
	 		 c1=cuentas.get(pos);
	 		 do{
	             menu(c1.IBAN);
	             opcion=teclado.nextInt();
	             teclado.nextLine();
	             System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	             if(opcion==1) ingresar();
	             if(opcion==2) retirar();
	             if(opcion==3) System.out.println("El saldo es " + c1.getSaldo());
	         }while(opcion!=0 || (opcion<0 || opcion>3));
	 	}
	 	else System.out.println("No existe una cuenta con ese IBAN");
    } 
    
    public static void listado(){
    	System.out.println("-----------------------------");
        System.out.println("CUENTAS");
        System.out.println("-----------------------------");
        if(cuentas.size()!=0)
	    	for(CuentaCorriente x : cuentas) {
	    		if (x instanceof CuentaPlazo) System.out.println(((CuentaPlazo)x).toString());
	    		else System.out.println(x.toString());
	    	}
        else System.out.println("No hay cuentas");
    }
    
    public static void comision(){
    	float por, min;
    	System.out.println("Dime Porcentaje de Comision: ");
    	por=teclado.nextFloat();
    	System.out.println("Dime Minimo comision: ");
    	min=teclado.nextFloat();
    	
    	CuentaCorriente.setComision(por, min);
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    	System.out.println("Comision Modificada");
        
    }
    public static void ingresar(){
        System.out.println("Cantidad a ingresar: ");
        c1.ingresar(teclado.nextFloat());
        System.out.println("Ingreso exitoso. Saldo:  " + c1.getSaldo());
    }
    
    public static void retirar(){
    	float cantidad;
        System.out.println("Cantidad a retirar: ");
        cantidad=teclado.nextFloat();
        if(c1 instanceof CuentaPlazo) {
        	 if (((CuentaPlazo)c1).retirar(cantidad)) System.out.println("Retirada exitosa. Saldo: " + c1.getSaldo());
             else System.out.println("No hay tanto saldo");
        }
        else {
        	if (c1.retirar(cantidad)) System.out.println("Retirada exitosa. Saldo: " + c1.getSaldo());
            else System.out.println("No hay tanto saldo");
        }
       

    }
}
