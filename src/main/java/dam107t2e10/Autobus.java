package dam107t2e10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Autobus extends Coche{
	private static final int PRECIO_ASIENTOS=25;
	private int asientos;
	
	Autobus(int asientos, String matricula, LocalDateTime entrada){
		super(entrada,matricula);
		this.asientos=asientos;
	}
	
	public double calcularTarifa() {
		double tarifa=super.calcularTarifa();
		return tarifa + ((asientos*PRECIO_ASIENTOS)/100d);
	}
	
	@Override
	public String toString() {
		return "Matricula: " + this.getMatricula() + " Fecha: " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(getEntrada()) + " Tipo: Autobus";
	}
}
