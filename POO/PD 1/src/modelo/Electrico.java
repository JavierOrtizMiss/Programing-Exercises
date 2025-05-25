package modelo;

public class Electrico extends Vehiculo{
    private double autonomia;
    private String usoVehiculo;

    public Electrico(String matricula, double velocidadActual, double velocidadMaxima, double autonomia, String usoVehiculo) {
        super(matricula, velocidadActual, velocidadMaxima);
        this.autonomia = autonomia;
        this.usoVehiculo = usoVehiculo;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public String getUsoVehiculo() {
        return usoVehiculo;
    }

    public void setUsoVehiculo(String usoVehiculo) {
        this.usoVehiculo = usoVehiculo;
    }


    //Métodos abstractos
    @Override
    public void acelerar(double velocidadPasada) {
        double nuevaVelocidad = getVelocidadActual() + velocidadPasada;
        setVelocidadActual(nuevaVelocidad);
    }

    @Override
    public void frenar(double frenada) {
        double nuevaVelocidad = getVelocidadActual() - frenada;
        if (nuevaVelocidad < 0) {
            System.out.println("La velocidad actual no puede ser negativa");
            setVelocidadActual(0);
        } else {
            setVelocidadActual(nuevaVelocidad);
        }
    }

    //Método toString
    @Override
    public String toString() {
        return "--Vehículo eléctrico-- \n Matrícula: " + getMatricula() + "\nVelocidad actual:  " + getVelocidadActual() + " km/h" + "\nVelocidad máxima: " + getVelocidadMaxima() + " km/h" + "\nAutonomía: " + autonomia + " km" + "\nUso del vehículo: " + usoVehiculo;
    }

    




    

}
