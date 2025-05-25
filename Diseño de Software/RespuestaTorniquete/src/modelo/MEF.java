package modelo;

public class MEF {
    Torniquete torniquete;
    Estado estado;

    public MEF(Torniquete torniquete, Estado estadoInicial){
        this.torniquete = torniquete;
        setEstado(estadoInicial);

    }

    public void pasar(){
        estado.pasar(this);
    }

    public void moneda(){
        estado.moneda(this);
    }
    public Torniquete getTorniquete(){
        return torniquete;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

}
