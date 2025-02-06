public class Dimensiones {
    //Atributos
    private double alto;
    private double ancho;
    private double profundidad;
    //Constructor
    public Dimensiones(double alto, double ancho, double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }
    
    //Getters
    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public double getVolumen() {
        return alto * ancho * profundidad;
    }

    
}
