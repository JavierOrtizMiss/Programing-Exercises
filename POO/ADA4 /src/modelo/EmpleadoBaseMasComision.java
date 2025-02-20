package modelo;

public class EmpleadoBaseMasComision extends EmpleadoPorComision{
    //Atributos
    private double sueldoBase;

    //Constructor
    public EmpleadoBaseMasComision(int nss, String nombre, String apellidoPaterno, String apellidoMaterno, double ventasBrutas, double tarifaComision, double sueldoBase) {
        super(nss, nombre, apellidoPaterno, apellidoMaterno, ventasBrutas, tarifaComision);
        this.sueldoBase = sueldoBase;
    }

    //Métodos get y set

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setsueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    //Método abstracto
    @Override
    public double ingresos() {
        return super.ingresos() + getSueldoBase();
    }

    //Método toString
    @Override
    public String toString(){
        return "\n---Empleado Base más Comisión---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getNss() + "\n" + "Ventas Brutas: " + getVentasBrutas() + "\n" + "Tarifa de Comisión: " + getTarifaComision() + "\n" + "Sueldo Base: " + getSueldoBase();
    }

}
