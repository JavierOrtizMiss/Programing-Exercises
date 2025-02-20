package modelo;

public class Aguila extends Animal{
    private double velocidadVuelo;

    //Constructor
    public Aguila(String nombre, int edad, double velocidadVuelo) {
        super(nombre, edad);
        this.velocidadVuelo = velocidadVuelo;
    }

    //Métodos getter y setter
    public double getVelocidadVuelo() {
        return velocidadVuelo;
    }

    public void setVelocidadVuelo(double velocidadVuelo) {
        this.velocidadVuelo = velocidadVuelo;
    }

    //Código del método abstracto
    public String mover(){
        return "se mueve volando";
    }

    //Método toString
    @Override
    public String toString() {
        return super.toString() + ", Velocidad de vuelo=" + getVelocidadVuelo();
    }

}
