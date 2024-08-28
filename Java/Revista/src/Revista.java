public class Revista {
    // Atributos
    private String nombre;
    private Double issn;
    private int year;
    private String editorial;

    // Inicialización
    public Revista(String nombre, Double issn, int year, String editorial) {
        this.nombre = nombre;
        this.issn = issn;
        this.year = year;
        this.editorial = editorial;
    }

    // Métodos obtener
    public String obtenerNombre() {
        return nombre;
    }

    public Double obtenerIssn() {
        return issn;
    }

    public int obtenerYear() {
        return year;
    }

    public String obtenerEditorial() {
        return editorial;
    }

    // Método para imprimir los atributos
    public String imprimir() {
        return "Nombre: " + nombre + ", ISSN: " + issn + ", Año: " + year + ", Editorial: " + editorial;
    }
}
