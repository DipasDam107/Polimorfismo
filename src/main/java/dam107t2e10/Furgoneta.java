package dam107t2e10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Furgoneta extends Coche{
	private static final int PRECIO_METRO=20;
	private float metros;
	
	Furgoneta(float metros, String matricula, LocalDateTime entrada){
		super(entrada,matricula);
		this.metros=metros;
	}
	
	public double calcularTarifa() {
		double tarifa=super.calcularTarifa();
		return tarifa + ((metros*PRECIO_METRO)/100d);
	}
	
	@Override
	public String toString() {
		return "Matricula: " + this.getMatricula() + " Fecha: " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(getEntrada()) + " Tipo: Furgoneta";
	}
}
