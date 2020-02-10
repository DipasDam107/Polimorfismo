package dam107t2e7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
        public static ArrayList <Trabajador> trabajadores;
	public static ArrayList <Asalariado> asalariados;
	public static ArrayList <ConsultorExterno> consultores;
	public static void main(String[] args) {
                trabajadores = new ArrayList<>();
		
		Scanner teclado = new Scanner (System.in);
		trabajadores.add(new Asalariado(1,"Daniel",LocalDate.of(1991, 2, 8),1000));
		trabajadores.add(new Asalariado(2,"Jose",LocalDate.of(1990, 12, 10),900)); 
		trabajadores.add(new Asalariado(3,"Pepe",LocalDate.of(1998, 2, 8),1200)); 
		
		trabajadores.add(new ConsultorExterno(1,"Daniel",LocalDate.of(1991, 2, 8)));
		trabajadores.add(new ConsultorExterno(2,"Jose",LocalDate.of(1990, 12, 10)));
		trabajadores.add(new ConsultorExterno(3,"Pepe",LocalDate.of(1998, 2, 8)));
		
                //Setear Horas extra
                for(Trabajador tra : trabajadores){
                    if(tra instanceof Asalariado){
                        System.out.println("Dime Horas Extra de " + tra.getNombre() + " : ");
                        ((Asalariado)tra).setHorasExtra(teclado.nextInt());
                    }
                    else if(tra instanceof ConsultorExterno){
                        System.out.println("Dime Horas Trabajadas de " + tra.getNombre() + " : ");
                        ((ConsultorExterno)tra).setHorasTabajadas(teclado.nextInt());
                    }
                }
                teclado.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                
		ConsultorExterno.setValorHora(100);
		Asalariado.setvalorHorasExtra(20);
                actualizar();
                
                System.out.println("Salarios Individuales");
                System.out.println("-----------------------------");
		calcularIndividuo();
                System.out.println("-----------------------------");
                System.out.println("Presiona Enter para continuar....");
                teclado.nextLine();
                
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.printf("A la empresa le costar�: %.2f\n", calcularEmpresa());
		}
        
        public static void calcularIndividuo(){
            for(Trabajador tra : trabajadores){
                if(tra instanceof Asalariado)
                            System.out.println(tra.getNombre() + " cobrara: " + ((Asalariado)tra).getSalarioFinal() + "€");
                else if(tra instanceof ConsultorExterno)
                    System.out.println(tra.getNombre() + " cobrara: " + ((ConsultorExterno)tra).getSalarioFinal() + "€");
            }
        }
	public static double calcularEmpresa() {
		double asalaria=0,consultor=0, trabajador=0;
		for(Trabajador x : trabajadores){
                    if(x instanceof Asalariado) trabajador+=((Asalariado)x).getSalarioFinal();
                    else if(x instanceof ConsultorExterno) trabajador+=((ConsultorExterno)x).getSalarioFinal();
                }
		return trabajador;
	}
	
	public static void actualizar() {
		for(Trabajador x : trabajadores) {
                    if(x instanceof Asalariado)
			((Asalariado)x).calcularSalarioFinal();
                    else if(x instanceof ConsultorExterno)
                        ((ConsultorExterno)x).calcularSalarioFinal();
		}
		
	}
	
}
