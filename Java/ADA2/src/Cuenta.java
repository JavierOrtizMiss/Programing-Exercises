public class Cuenta {

    //Atributos
    private Double saldo;
    private int numCuenta;
    private String description;

    //Constructor
    public Cuenta(Double saldo, int numCuenta, String description){
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.description = description;
    }

    //Métodos getter
    public Double getSaldo(){
        return saldo;
    }
    public int getNumcuenta(){
        return numCuenta;
    }
    public String getDescription(){
        return description;
    }

    //Setter
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Métodos
    public void ingreso(Double cantidad){
    }

    public void retiro(){
    }

    public void transferencia(){   
    }
    

}