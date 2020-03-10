/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

/**
 *
 * @author dam107
 */
public class Autobus extends Vehiculo{
    int asientos;
    
    Autobus(String matricula, int asientos){
        super(matricula);
        this.asientos=asientos;
    }
    
    @Override
    public float importe(){
       return super.importe() + PRECIO_ASIENTO_BUS * asientos;
    }
   
    @Override
    public String toString(){
        return "Matricula: " + this.matricula + " Tipo: Autobus" + " Asientos: " + this.asientos + " Importe Actual: " + this.importe();
    }
}
