package modelo;

public abstract class Vehiculo {
    private String matricula;
    private double velocidadActual;
    private double velocidadMaxima;

    public Vehiculo(String matricula, double velocidadActual, double velocidadMaxima) {
        this.matricula = matricula;
        setVelocidadActual(velocidadActual);
        setVelocidadMaxima(velocidadMaxima);
   
    }

    //Métodos getter y setter
    public String getMatricula() {
        return matricula;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    //Métodos abstractos (Polimorfismo)
    public abstract void acelerar(double aceleracion);
    public abstract void frenar(double frenada);

    

}
