package modelo;

public class EmpleadoPorComision extends Empleado{
    //Atributos
    private double ventasBrutas;
    private double tarifaComision;

    //Constructor
    public EmpleadoPorComision(int nss, String nombre, String apellidoPaterno, String apellidoMaterno, double ventasBrutas, double tarifaComision) {
        super(nss, nombre, apellidoPaterno, apellidoMaterno);
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    //Métodos get y set

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

    //Método abstracto
    @Override
    public double ingresos() {
        return ventasBrutas * tarifaComision;
    }

    //Método toString

    @Override
    public String toString(){
        return "\n---Empleado por Comisión---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getNss() + "\n" + "Ventas Brutas: " + getVentasBrutas() + "\n" + "Tarifa de Comisión: " + getTarifaComision();
    }



}
