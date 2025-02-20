package modelo;

public class EmpleadoAsalariado extends Empleado{
    //Atributos
    private double sueldo;

    //Constructor
    public EmpleadoAsalariado(int nss, String nombre, String apellidoPaterno, String apellidoMaterno, double sueldo) {
        super(nss, nombre, apellidoPaterno, apellidoMaterno);
        this.sueldo = sueldo;
    }

    //Métodos get y set

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    //Método abstracto
    @Override
    public double ingresos() {
        return sueldo;
    }

    //Método toString
    @Override
    public String toString(){
        return "\n---Empleado Asalariado---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getNss() + "\n" + "Sueldo: " + getSueldo();
    }


}
