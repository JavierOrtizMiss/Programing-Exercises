package modelo;

public class Serpiente extends Animal{
    private double longitud;

    //Constructor
    public Serpiente(String nombre, int edad, double longitud) {
        super(nombre, edad);
        this.longitud = longitud;
    }

    //Métodos getter y setter
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    //Código del método abstracto
    public String mover(){
        return "se mueve arrastrándo";
    }

    //Método toString
    @Override
    public String toString() {
        return super.toString() + ", Longitud=" + getLongitud();
    }


}

