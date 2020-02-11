/*
Haz un programa con un menú que permita gestionar la cola de espera de un médico. Hay
tres tipos de pacientes: los que vienen a consulta (se le pide al usuario nombre, fecha de nacimiento,
motivo de la consulta), los que viene por recetas (se le pide: nombre, fecha de nacimiento, lista de
medicamentos) y el que viene a revisión (se le pide nombre, fecha de nacimiento y fecha de la visita
anterior).
    • Las tarifas del médico son: Consulta: 100 eur. Recetas: 5 eur por cada unidad. Revisión: 30 eur para
    mayores de 65 años, 50 eur para resto.
    • Crear una clase para cada tipo de paciente en el propio archivo del programa con los constructores
    necesarios y el método de facturar() en cada una de las clases. Implementa herencia si lo crees
    necesario.
    • El programa tendrá un menú para: 
    a) Registrar la llegada del paciente: se le preguntará por qué viene al médico y se le piden
    sus datos.
    b) Llamar a consulta (por orden de llegada). Se le cobra la tarifa correspondiente.
    c) Consultar total facturado hasta ese momento
 */

package dam107t2e9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static ArrayList <Paciente> pacientes;
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
    pacientes = new ArrayList<>();
    int opcion;
       
    do{
        menu();
        opcion=teclado.nextInt();
        teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(opcion==1) pacientes.add(registrar());
        if(opcion==2) llamar();
        if(opcion==3) System.out.printf("Total Facturado: %.2f \n",facturado());
        if(opcion==4) cola();
    }while(opcion!=0 || (opcion <0||opcion>4));
    
    }
    
    public static void menu(){
        System.out.println("-----------------------------");
        System.out.println("MENU");
        System.out.println("-----------------------------");
        System.out.println("1 - Registrar Paciente");
        System.out.println("2 - Llamar Paciente");
        System.out.println("3 - Consultar Facturado");
        System.out.println("4 - Consultar Cola");
        System.out.println("0 - Salir");
        System.out.println("-----------------------------");
        System.out.println("Dime Opcion: ");
    }
    
    public static void menuMotivo(){
        System.out.println("-----------------------------");
        System.out.println("MENU NUEVO PACIENTE");
        System.out.println("-----------------------------");
        System.out.println("1 - Consulta");
        System.out.println("2 - Receta");
        System.out.println("3 - Revision");
        System.out.println("-----------------------------");
        System.out.println("Dime Motivo de la visita: ");
    }
    
    public static Paciente registrar(){
        int opcion;
        Paciente pac;
        String nombre, fecNac, ultRev; 
        do{
            menuMotivo();
            opcion=teclado.nextInt();
            teclado.nextLine();
        }while(opcion!=1 && opcion!=2 && opcion!=3);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Dime Nombre: ");
        nombre=teclado.nextLine();
    
        System.out.println("Dime Fecha de Nacimiento (aaaa-mm-dd): ");
        fecNac=teclado.nextLine();
        
        if(opcion==1){
            System.out.println("Dime motivo de la consulta: ");
            pac=new PacienteConsulta(nombre,LocalDate.parse(fecNac),teclado.nextLine());
        }
        else if(opcion==2){
            String medicamento;
            ArrayList <String> meds= new ArrayList<>();
            do{
                System.out.println("Dime Medicamento (Deja vacio para salir): ");
                medicamento=teclado.nextLine();
                if(medicamento.length()!=0) meds.add(medicamento);
            }while(medicamento.length()!=0);
        
            pac=new PacienteReceta(nombre,LocalDate.parse(fecNac), meds);
        }
        else{
            System.out.println("Fecha de última revisión (aaaa-mm-dd): ");
            ultRev=teclado.nextLine();
            pac=new PacienteRevision(nombre,LocalDate.parse(fecNac),LocalDate.parse(ultRev));
        }
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Paciente Registrado con Exito");
        return pac;
    }
    public static void llamar(){
        int cont=0;
        boolean encontrado=false;
        if(pacientes.size()>0){
            do{
                if(!pacientes.get(cont).isAtendido()){
                    System.out.println("Es el Turno del paciente " + pacientes.get(cont).getNombre() + " nacido el " + pacientes.get(cont).getFecNac());
                    encontrado=true;
                    pacientes.get(cont).setAtendido(true);
                    facturarPaciente(pacientes.get(cont));
                    System.out.printf("Paciente tratado. Importe: %.2f \n" , pacientes.get(cont).getTarifa());
                }
                if(!encontrado)cont++;
            }while(cont<pacientes.size() && !encontrado);
            
            if(!encontrado) System.out.println("No hay pacientes a la espera");
        }
       
        else System.out.println("No hay pacientes a la espera");
    }
    
    public static void facturarPaciente(Paciente pac){
        if(pac instanceof PacienteConsulta) ((PacienteConsulta)pac).facturar();
        else if(pac instanceof PacienteReceta) ((PacienteReceta)pac).facturar();
        else ((PacienteRevision)pac).facturar();
    }
    public static double facturado(){
        double facturado=0;
        for(Paciente x : pacientes)
            facturado+=x.getTarifa();
        
        return facturado;
    }
    public static void cola(){
        String motivo;
        System.out.println("-----------------------------");
        System.out.println("COLA");
        System.out.println("-----------------------------");
        if(pacientes.size()!=0){
            int cont=1;
            for(Paciente x : pacientes){
                if(!x.isAtendido()){
                    if(x instanceof PacienteConsulta) motivo="Consulta";
                    else if(x instanceof PacienteReceta) motivo="Receta";
                    else motivo="Revision";
                    System.out.println(cont + " - " + x.toString() + " Motivo: " + motivo);
                    cont++;
                }
            }
            if(cont==1) System.out.println("Cola vacia");
        }
        else System.out.println("No hay pacientes en cola");
    }
    
}
