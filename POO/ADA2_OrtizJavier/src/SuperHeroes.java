public class SuperHeroes {
    //Atributos
    private String nombre;
    private String descripcion;
    private boolean capa;

    //Constructor
    public SuperHeroes(String nombre, String descripcion, boolean capa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capa = capa;

    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getCapa() {
        return capa;
    }

}
