/**
 * Cuenta
 */
public class Cuenta {

    private Double saldo;
    private String nocuenta;
    private String description;

    public Cuenta(Double saldo, String nocuenta, String description){
        this.saldo = saldo;
        this.nocuenta = nocuenta;
        this.description = description;
    }

    public Double getSaldo(){
        return saldo;
    }
    public String getNocuenta(){
        return nocuenta;
    }
    public String getDescription(){
        return description;
    }

    //hola como estas
    
}