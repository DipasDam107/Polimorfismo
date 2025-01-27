package dam107t2e11;

public class CuentaCorriente {
    public String IBAN;
    private float saldo;
    private int contadorIngresos;
    private static float porcentajeComision;
    private static float minimoComision;
    
CuentaCorriente () {}
CuentaCorriente (String i) {
    IBAN = i; 
    saldo =0;
    contadorIngresos = 0;
}

public static void setComision (float pc, float mc) {
    porcentajeComision = pc;
    minimoComision = mc;
}
public static float getPorcentajeComision () {return porcentajeComision;}
public static float getMinimoCosmision ()    {return minimoComision;}
public float        getSaldo ()              {return (saldo);}

    public void setContadorIngresos(int contadorIngresos) {
        this.contadorIngresos = contadorIngresos;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


public void ingresar (float importe) {
    float bonus=0;
    if (++contadorIngresos == 3) {
       contadorIngresos = 0; 
       bonus =0.7f;
    }    
    saldo += importe + bonus;
}

public boolean retirar (float importe) {
    float comision;
    if (porcentajeComision * importe < minimoComision) 
        comision = minimoComision;
    else 
        comision = porcentajeComision * importe;
    if (importe + comision <= saldo) {
       saldo -= importe+comision;  //resta (importe+comision)
       contadorIngresos = 0;
       return true;
    }
    else return false; 
}

@Override
public boolean equals (Object o){
	if(o instanceof CuentaCorriente && ((CuentaCorriente)o).IBAN.equals(this.IBAN)) return true;
	else return false;
}

@Override
public String toString (){
	return "IBAN: " + this.IBAN + " Saldo: " +this.saldo + " Tipo: Cuenta Corriente";
}
} // fin clase
