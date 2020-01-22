
package dam107t2e3;

import dam107t2e2.*;






public class Triangulo extends Figura2D{
    public String estilo;
    Triangulo(){
        estilo=null;
    }
    
    Triangulo(double valor, String nombre){
        super(valor, nombre);
        this.estilo="IgualBaseAltura";
    }
    
    Triangulo(double alto, double ancho, String estilo, String nombre){
        super(ancho, alto, nombre);
        this.estilo=estilo;
    }

    Triangulo(Triangulo tri){
        super(new Figura2D(tri.getAlto(),tri.getAncho(), tri.getNombre()));
        this.estilo=tri.getEstilo();
    }
    public String getEstilo() {
        return estilo;
    }
    
    public double area(){ 
        return (this.getAlto()*this.getAncho())/2d;
    }
    
}
