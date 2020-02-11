package dam107t2e9;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteReceta extends Paciente {
    ArrayList <String> medicamentos;
    private static final double PRECIO_MED = 5;
    
    PacienteReceta(String nombre, LocalDate fecNac, ArrayList <String> unidades){
        super(nombre, fecNac);
        this.medicamentos=new ArrayList<>(unidades);
    }

    public ArrayList <String> getUnidades() {
        return medicamentos;
    }
      
    public void facturar(){
        this.setTarifa(this.medicamentos.size()*PRECIO_MED);
    }
}
