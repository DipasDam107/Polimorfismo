/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author dam107
 */
public abstract class Vehiculo implements intVehiculos{
    String matricula;
    LocalDateTime fechaEntrada;
    
    Vehiculo(String matricula){
        this.matricula=matricula;
        this.fechaEntrada=LocalDateTime.now();
    }
    
    @Override
    public float importe(){
        return PRECIO_VEHICULO *ChronoUnit.MINUTES.between(fechaEntrada, LocalDateTime.now());
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Vehiculo && ((Vehiculo)o).matricula.equals(this.matricula))
            return true;
        else
            return false;
    }
    
    @Override
    public abstract String toString();

}
