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
public class Coche extends Vehiculo{
    
    Coche(String matricula){
        super(matricula);
    }
    
    @Override
    public String toString(){
        return "Matricula: " + this.matricula + " Tipo: Coche" + " Importe Actual: " + this.importe();
    }
}
