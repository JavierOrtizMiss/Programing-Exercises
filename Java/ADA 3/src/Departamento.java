public class Departamento {
    private String clave;
    private String nombre;

    public Departamento(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}