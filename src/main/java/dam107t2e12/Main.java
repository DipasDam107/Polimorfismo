/*
 Crea una clase Bicicleta de la que deseamos mantener los siguientes datos: marca, modelo, precio
y descuento. Se pide crear el constructor, getters y setters, método toString (), equals (), un método que
devuelva el precio con el descuento aplicado y finalmente un método que fije el descuento a aplicar. Este
último método estará sobrecargado de la siguiente forma:
    • fjarDescuento ()  (se le hace 10% y dura ese descuento 1 mes)
    • fjarDescuento (double d)  (se le hace d %, 1 mes)
    • fjarDescuento (double d , int n)  (se le hace d %, n meses)
Haz un programa sencillo que defina una o dos instancias de bicicletas y use los métodos creados
Notas:
    • Dos bicicletas son iguales si tienen la misma marca y modelo.
    • Si se fija un descuento, se elimina el descuento que pudiera haber anteriormente.
    • Piensa si es necesario incorporar algún atributo adicional, para que, cuando ejecutemos el método
    de ver el precio final (con descuento aplicado), sepa si tiene que aplicar algún descuento o no.
 */
package dam107t2e12;

public class Main {
    public static void main (String [] args){
        Bicicleta b1 = new Bicicleta("Marca1", "Modelo1", 10);
        Bicicleta b2 = new Bicicleta("Marca1", "Modelo1", 5);
        Bicicleta b3 = new Bicicleta("Marca1", "Modelo2", 15);
        
        // DESCUENTOS
        System.out.println("----------------------");
        System.out.println("DESCUENTOS");
        System.out.println("----------------------");
        System.out.println(b1.toString());
        b1.fjarDescuento();
        System.out.println(b1.toString());
        
        System.out.println(b2.toString());
        b2.fjarDescuento(0.15);
        System.out.println(b2.toString());
        
        System.out.println(b3.toString());
        b3.fjarDescuento(0.2, 2);
        System.out.println(b3.toString());
        
        System.out.println("----------------------");
        System.out.println("COMPARACION");
        System.out.println("----------------------");
        
        System.out.println("b1 y b2 son iguales?: " + b1.equals(b2));
        System.out.println("b1 y b3 son iguales?: " + b1.equals(b3));
        
        
        
    }
}
