package modelo;

public class EmpleadoAsalariado  extends Empleado{
    private double sueldo;

    public EmpleadoAsalariado(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno, double sueldo) {
        super(seguroSocial, nombre, apellidoPaterno, apellidoMaterno);
        this.sueldo = sueldo;
    }

    //Getters y Setters
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override

    public String toString() {
        return "\n---Empleado Asalariado---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getSeguroSocial() + "\n" + "Sueldo: " + getSueldo();
    }
    
}
