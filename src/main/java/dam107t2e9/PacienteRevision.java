/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t2e9;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 *
 * @author dam107
 */
public class PacienteRevision extends Paciente{
    LocalDate fecVisitaPrevia;
    static final double TARIFA_REVISION_MAYORES=30;
    static final double TARIFA_REVISION_JOVENES=50;
    static final int AÑOS_PARA_SER_VEJETE=65;
    
    PacienteRevision(String nombre, LocalDate fecNac, LocalDate fecVisitaPrevia){
        super(nombre, fecNac);
        this.fecVisitaPrevia=fecVisitaPrevia;
    }
    
    public void facturar(){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate nac = this.getFecNac();
        
        if(YEARS.between(fechaHoy, nac)>AÑOS_PARA_SER_VEJETE) this.setTarifa(TARIFA_REVISION_MAYORES);
        else this.setTarifa(TARIFA_REVISION_JOVENES);
    }
    
}
