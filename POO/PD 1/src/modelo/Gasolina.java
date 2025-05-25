package modelo;

public class Gasolina extends Vehiculo{
    private double motor;
    private int capacidadPasajeros;

    public Gasolina(String matricula, double velocidadActual, double velocidadMaxima, double motor, int capacidadPasajeros) {
        super(matricula, velocidadActual, velocidadMaxima);
        this.motor = motor;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
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
            return;
        } else {
            setVelocidadActual(nuevaVelocidad);
        }
    }

    //Método toString

    @Override
    public String toString() {
        return "--Vehículo de gasolina-- \n Matrícula: " + getMatricula() + "\nVelocidad actual:  " + getVelocidadActual() + " km/h" + "\nVelocidad máxima: " + getVelocidadMaxima() + " km/h" + "\nMotor: " + motor + " cc" + "\nCapacidad de pasajeros: " + capacidadPasajeros;
    }





}
