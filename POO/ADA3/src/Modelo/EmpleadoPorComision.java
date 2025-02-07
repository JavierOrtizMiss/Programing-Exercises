
package Modelo;

public class EmpleadoPorComision extends Empleado{
    //Atributos
    private double ventasBrutas;
    private double tarifaComision;

    //Constructor
    public EmpleadoPorComision(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno, double ventasBrutas, double tarifaComision) {
        super(seguroSocial, nombre, apellidoPaterno, apellidoMaterno);
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    //Getters y Setters

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas;
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    public void setTarifaComision(double tarifaComision) {
        this.tarifaComision = tarifaComision;
    }

    public double calcularSueldo(){
        return ventasBrutas * tarifaComision;
    }

    @Override
    public String toString() {
        return "\n--Empleado Por Comisión---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getSeguroSocial() + "\n" + "Sueldo: " + calcularSueldo();
    }
    
}
