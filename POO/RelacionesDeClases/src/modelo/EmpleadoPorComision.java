package modelo;
public class EmpleadoPorComision{
    private int seguroSocial;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno, double ventasBrutas, double tarifaComision){
        this.seguroSocial = seguroSocial;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    //Getters
    public int getSeguroSocial(){
        return seguroSocial;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    public String getApellidoMaterno(){
        return apellidoMaterno;
    }

    public double getVentasBrutas(){
        return ventasBrutas;
    }

    public double getTarifaComision(){
        return tarifaComision;
    }

    //Setters

    public void setSeguroSocial(int seguroSocial){
        this.seguroSocial = seguroSocial;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setVentasBrutas(double ventasBrutas){
        this.ventasBrutas = ventasBrutas;
    }

    public void setTarifaComision(double tarifaComision){
        this.tarifaComision = tarifaComision;
    }

    //Método para calcular el sueldo
    public double sueldo(){
        return getVentasBrutas() * getTarifaComision();
    }

    //Método toString
    @Override
    public String toString(){
        return "Seguro social = " + getSeguroSocial() + "\nNombre = " + getNombre() + "\nApellido paterno = " + getApellidoPaterno() + "\nApellido materno = " + getApellidoMaterno() + "\nVentas brutas = " + getVentasBrutas() + "\nTarifa de comisión = " + getTarifaComision();
    }

}