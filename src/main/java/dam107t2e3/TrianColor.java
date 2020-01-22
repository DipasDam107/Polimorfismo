
package dam107t2e3;

public class TrianColor extends Triangulo{
    private String color;
    
    TrianColor(double ancho, double alto, String estilo, String color, String nombre){
        super(alto, ancho, estilo, nombre);
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
