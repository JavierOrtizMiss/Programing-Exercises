package modelo;

public class EmpleadoPorHoras extends Empleado{
    //Atributos
    private double horasTrabajadas;
    private double tarifaPorHora;

    //Constructor
    public EmpleadoPorHoras(int nss, String nombre, String apellidoPaterno, String apellidoMaterno, double horasTrabajadas, double tarifaPorHora) {
        super(nss, nombre, apellidoPaterno, apellidoMaterno);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    //Métodos get y set

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

    //Método abstracto
    @Override
    public double ingresos() {
        if (getHorasTrabajadas() <= 40) {
            return getTarifaPorHora() * getHorasTrabajadas();
        } else {
            return 40 * getTarifaPorHora() + (getHorasTrabajadas() - 40) * getTarifaPorHora() * 1.5;
        }
    }

    //Método toString
    @Override
    public String toString(){
        return "\n---Empleado por Horas---\n" + "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + "\n" + "Seguro Social: " + getNss() + "\n" + "Horas Trabajadas: " + getHorasTrabajadas() + "\n" + "Tarifa por Hora: " + getTarifaPorHora();
    }

    
}
