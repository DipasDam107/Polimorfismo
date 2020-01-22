package dam107t2e4;

import dam107t2e3.*;
import dam107t2e2.*;

public class Figura2D {
    private double ancho;
    private double alto;
    private String nombre;
    
    
    Figura2D(){
        this.alto=0;
        this.ancho=0;
        //this.nombre=null;
    }

    Figura2D(double valor, String nombre){
        this.alto=valor;
        this.ancho=valor;
        this.nombre=nombre;
    }
    Figura2D(double ancho, double alto, String nombre){
        this.alto=alto;
        this.ancho=ancho;
        this.nombre=nombre;
    }
    
    Figura2D(Figura2D figura){
        this.alto=figura.getAlto();
        this.ancho=figura.getAncho();
        this.nombre=figura.getNombre();
    }
    
    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    public void verDim(){
        System.out.printf("Alto : %.2f Ancho : %.2f \n", this.alto, this.ancho);
    }
}
