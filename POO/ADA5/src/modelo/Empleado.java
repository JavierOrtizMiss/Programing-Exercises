package modelo;

public abstract class Empleado implements PorPagar{
    //Atributos
    private int nss;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    //Constructor
    public Empleado(int nss, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    //Métodos get y set

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String primerNombre) {
        this.nombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }


}
