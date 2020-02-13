
package dam107t2e12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bicicleta {
    private String marca;
    private String modelo;
    private float precio;
    private double descuento;
    private LocalDate fechaFinDesc;
    
    //CONSTRUCTOR
    Bicicleta(String marca, String modelo, float precio){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
        this.descuento=0;
        this.fechaFinDesc=null;
    }

    // GETTERS/SETTERS
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    //METODOS SOBRECARGADOS
    
    public void fjarDescuento(){
        this.descuento=0.1;
        this.fechaFinDesc=LocalDate.now().plus(1, ChronoUnit.MONTHS);
    }
    public void fjarDescuento(double d){
        this.descuento=d;
        this.fechaFinDesc=LocalDate.now().plus(1, ChronoUnit.MONTHS);
    }
    public void fjarDescuento(double d, int n){
        this.descuento=d;
        this.fechaFinDesc=LocalDate.now().plus(n, ChronoUnit.MONTHS);
    }
    
    public double devolverPrecioDescuento(){
        if(this.fechaFinDesc!=null && (this.fechaFinDesc.isAfter(LocalDate.now())||this.fechaFinDesc.isEqual(LocalDate.now())))
            return precio-(precio*descuento);
        else{
            if( this.fechaFinDesc!=null && LocalDate.now().isAfter(this.fechaFinDesc)){
                this.fechaFinDesc=null;
                this.descuento=0;
            } 
            return precio;
        }
    }
    
    //METODOS SOBREESCRITOS
    @Override
    public String toString(){
        if(this.fechaFinDesc==null)
            return "Marca: " + this.marca + " Modelo: " + this.modelo + " Precio: " + this.precio;
        else
            return "Marca: " + this.marca + " Modelo: " + this.modelo + " Descuento: " + this.descuento+  " Precio con descuento: " + this.devolverPrecioDescuento() + " Fecha Fin Descuento: " +this.fechaFinDesc;
            
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Bicicleta && ((Bicicleta)o).marca == this.marca && ((Bicicleta)o).modelo == this.modelo){
            return true;
        }
        else return false;
    }
    
}
