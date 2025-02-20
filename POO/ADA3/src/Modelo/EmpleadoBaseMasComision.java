package modelo;

public class EmpleadoBaseMasComision extends EmpleadoPorComision{
    private double sueldoBase;

    public EmpleadoBaseMasComision(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno, double ventasBrutas, double tarifaComision, double sueldoBase){
        super(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, ventasBrutas, tarifaComision);
        this.sueldoBase = sueldoBase;
    }

    //Metodos get y set

    public double getSueldoBase(){
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase){
        this.sueldoBase = sueldoBase;
    }

    //Método para calcular el sueldo
    @Override
    public double calcularSueldo(){
        return getSueldoBase() + super.calcularSueldo();
    }

    @Override
    public String toString(){
        return "\n---Empleado Base Más Comisión---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getSeguroSocial() + "\n" + "Sueldo: " + calcularSueldo();
    }

}
    
    