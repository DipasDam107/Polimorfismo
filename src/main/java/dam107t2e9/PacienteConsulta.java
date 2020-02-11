package dam107t2e9;

import java.time.LocalDate;

public class PacienteConsulta extends Paciente {
    private String motivo;
    static final double TARIFA_CONSULTA=100;
    
    PacienteConsulta(String nombre, LocalDate fecNac, String motivo){
        super(nombre, fecNac);
        this.motivo=motivo;
    }

    public String getMotivo() {
        return motivo;
    }
    
    public void facturar(){
        this.setTarifa(TARIFA_CONSULTA);
    }
    
}
