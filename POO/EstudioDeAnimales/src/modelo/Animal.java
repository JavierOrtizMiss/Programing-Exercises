package modelo;

public abstract class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Métodos get
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    //Métodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Método abstracto
    public abstract String mover();

    //Método toString
    @Override
    public String toString() {
        return "Nombre=" + getNombre() + ", Edad=" + getEdad();
    }

}
