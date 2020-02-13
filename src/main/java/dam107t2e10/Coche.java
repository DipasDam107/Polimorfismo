package dam107t2e10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Coche {
	private static final int PRECIO_MINUTO=4;
	private LocalDateTime entrada;
	private String matricula;
	
	Coche(LocalDateTime entrada, String matricula){
		this.entrada=entrada;
		this.matricula=matricula;
	}
	
	
	public LocalDateTime getEntrada() {
		return entrada;
	}


	public String getMatricula() {
		return matricula;
	}

	public double calcularTarifa() {
		long minutos=ChronoUnit.MINUTES.between(entrada, LocalDateTime.now());
		return (PRECIO_MINUTO*minutos)/100f;
	}
	
	@Override
	public String toString() {
		return "Matricula: " + this.matricula + " Fecha: " +DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(this.entrada) + " Tipo: Coche";
	}
	
	@Override
	public boolean equals(Object o){
		boolean encontrado=false;
		if(o instanceof Coche && this.matricula.equals(((Coche)o).matricula)) encontrado=true;
		return encontrado;
	} 
}
