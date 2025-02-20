package modelo;

public class Conejo extends Animal{
    private double peso;

    //Constructor
    public Conejo(String nombre, int edad, double peso) {
        super(nombre, edad);
        this.peso = peso;
    }

    //Métodos getter y setter
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Código del método abstracto
    public String mover(){
        return "se mueve brincando";
    }

    //Método toString
    public String toString() {
        return super.toString() + ", Peso=" + getPeso();
    }

}
