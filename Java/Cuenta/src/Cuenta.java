public class Cuenta {

    //Atributos de la clase
    private Double saldo;
    private String nocuenta;
    private String description;

    //Constructor
    public Cuenta(Double saldo, String nocuenta, String description){
        //Inicialización
        this.saldo = saldo;
        this.nocuenta = nocuenta;
        this.description = description;
    }

    //Métodos getter
    public Double getSaldo(){
        return saldo;
    }
    public String getNocuenta(){
        return nocuenta;
    }
    public String getDescription(){
        return description;
    }

    //Método para abonar un cantidad de dinero
    public void abonar(Double monto){
        if (monto>0) {
            saldo += monto;
        }
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setNocuenta(String nocuenta) {
        this.nocuenta = nocuenta;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Método Setter

}