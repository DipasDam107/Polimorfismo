package dam107t2e11;

import java.time.LocalDate;

/**
 *
 * @author dam107
 */
final public class CuentaPlazo extends CuentaCorriente{
    private LocalDate fechaCreacion;
    
    CuentaPlazo(String i){
        super(i);
        this.fechaCreacion=LocalDate.now();
    }
    
    @Override
    public boolean retirar (float importe) {
        if (importe <= this.getSaldo()) {
           this.setSaldo(this.getSaldo()- importe);  
           this.setContadorIngresos(0);
           return true;
        }
        else return false; 
    }
    
    @Override
    public String toString (){
    	return "IBAN: " + this.IBAN + " Saldo: " +this.getSaldo() + " Tipo: Cuenta Plazo";
    }
}