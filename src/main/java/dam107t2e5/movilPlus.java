package dam107t2e5;


public class movilPlus extends cMovilPrepago{
    private static final int DATOS_SEGUNDO_VIDEOLLAMADA=2; // Son dos megas de datos
    movilPlus(long nM, float cML, float cMB, float s){
        super(nM,0,cML, cMB,s);
    }
    
    public void videollamada(int segundos){
        this.navegar(segundos*DATOS_SEGUNDO_VIDEOLLAMADA);
    }
    
    
    @Override
    public boolean equals(Object movil){
        if(movil instanceof movilPlus)
             if(((movilPlus)movil).numeroMovil==this.numeroMovil) return true;
             else return false;
        else return false;
    }
   
}
