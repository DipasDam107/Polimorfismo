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
public class Furgoneta extends Vehiculo{
    float metros;
    
    Furgoneta(String matricula, float metros){
        super(matricula);
        this.metros=metros;
    }
    
    @Override
    public float importe(){
        return super.importe() + this.metros*PRECIO_METRO_FURGO;
    }
    
    @Override
    public String toString(){
        return "Matricula: " + this.matricula + " Tipo: Furgoneta" + " Metros: " + this.metros + " Importe Actual: " + this.importe();
    }
}
