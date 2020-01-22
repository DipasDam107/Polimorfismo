
package dam107t2e2;

public class Rectangulo extends Figura2D {
    
    Rectangulo(double lados, String nombre){
        this.setAlto(lados);
        this.setAncho(lados);
        this.setNombre(nombre);
    }
    
    Rectangulo(double alto, double ancho, String nombre){
        this.setAlto(alto);
        this.setAncho(ancho);
        this.setNombre(nombre);
    }
    
    public boolean esCuadrado(){
        if(this.getAlto()==this.getAncho()) return true;
        else return false;
    }
}
