public abstract class Empleado implements PorPagar{
    // Atributos
    private String firstName;
    private String flastName;
    private String mlastName;
    private String nss;

    // Constructor
    public Empleado(String firstName, String flastName, String mlastName, String nss) {
        this.firstName = firstName;
        this.flastName = flastName;
        this.mlastName = mlastName;
        this.nss = nss;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFlastName() {
        return this.flastName;
    }

    public void setFlastName(String flastName) {
        this.flastName = flastName;
    }

    public String getMlastName() {
        return this.mlastName;
    }

    public void setMlastName(String mlastName) {
        this.mlastName = mlastName;
    }

    public String getNss() {
        return this.nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public abstract double ingresos();


    @Override
    public String toString() {
        return String.format("Empleado: %s %s %s\nNúmero de seguro social: %s", 
        firstName, flastName, mlastName, nss);
    }
}
