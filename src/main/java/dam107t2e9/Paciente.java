package dam107t2e9;

import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private LocalDate fecNac;
    private boolean atendido;
    private double tarifa;
    
    Paciente(String nombre, LocalDate fecNac){
        this.nombre=nombre;
        this.fecNac=fecNac;
        this.atendido=false;
        this.tarifa=0;
    }
    
    

    public double getTarifa() {
        return tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }
    
    public boolean isAtendido() {
        return atendido;
    }
    
    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    @Override
    public String toString(){
        return " Nombre: " + this.nombre + " Fecha de Nacimiento: " + this.fecNac;
    }

    
    
    
   
}
