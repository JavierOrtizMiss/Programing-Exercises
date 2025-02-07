package Modelo;

public class Empleado {
    //Atributos 
    private int seguroSocial;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    //Constructor
    public Empleado(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.seguroSocial = seguroSocial;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    //Getters y Setters

    public int getSeguroSocial() {
        return seguroSocial;
    }

    public void setSeguroSocial(int seguroSocial) {
        this.seguroSocial = seguroSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
