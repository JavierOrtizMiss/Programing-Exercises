package Modelo;

public class EmpleadoPorHoras extends Empleado{
    //Atributos
    private double horasTrabajadas;
    private double tarifaPorHora;

    //Constructor
    public EmpleadoPorHoras(int seguroSocial, String nombre, String apellidoPaterno, String apellidoMaterno, double horasTrabajadas, double tarifaPorHora) {
        super(seguroSocial, nombre, apellidoPaterno, apellidoMaterno);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    //Getters y Setters

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public double calcularSueldo(){
        return horasTrabajadas * tarifaPorHora;
    }

    public String toString() {
        return "\n---Empleado por Horas---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getSeguroSocial() + "\n" + "Sueldo: " + calcularSueldo();
    }



    
}
