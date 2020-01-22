/*
Realiza un programa que contenga un ArrayList de figuras2D de cualquiera de sus tipos e introduce
valores “a mano”, por ejemplo, un par de instancias de cada tipo. A continuación, el programa:
    • Sumar el área de todas ellas. ¿Tienen implementado el método área () todas ellas?
    • Contar cuantos triángulos (sean de color o no) y cuantos rectángulos
*/

package dam107t2e4;
import java.util.ArrayList;

public class main {
    public static void main(String [] args){
       ArrayList <Figura2D> figuras = new ArrayList<>();
       double area=0;
       int tris=0, rects=0;
       
       //Triangulos
       figuras.add(new Triangulo(2,3,"Isosceles","Pepe"));
       figuras.add(new Triangulo(5,3,"Lo que sea","Pepe"));
       figuras.add(new Triangulo(5,5,"Jas","Pepe"));
       figuras.add(new Triangulo(1,3,"XD","Pepe"));
       
       //Triangulos Color
       figuras.add(new TrianColor(1,2,"TC1", "Rojo", "TC1"));
       figuras.add(new TrianColor(1,2,"TC2", "Rojo", "TC2"));
       figuras.add(new TrianColor(1,2,"TC3", "Rojo", "TC3"));
       figuras.add(new TrianColor(1,2,"TC4", "Rojo", "TC4"));
       
       //Rectangulos
       figuras.add(new Rectangulo(1,2,"Rect1"));        
       figuras.add(new Rectangulo(3,3,"Rect2"));        
       figuras.add(new Rectangulo(4,2,"Rect3"));        
       figuras.add(new Rectangulo(4,4,"Rect4"));        
       
        for (int i = 0; i < figuras.size(); i++) {
            if(figuras.get(i) instanceof Triangulo || figuras.get(i) instanceof TrianColor){ area+=((Triangulo)figuras.get(i)).area(); tris++;}
            if(figuras.get(i) instanceof Rectangulo){ area+=((Rectangulo)figuras.get(i)).area(); rects++;}
        }
        
        System.out.println("Rectangulos: " + rects);
        System.out.println("Triangulos: " + tris);
        System.out.printf("Area Total: %.2f", area);
       
    }
}
