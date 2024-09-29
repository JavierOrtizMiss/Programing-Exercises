public class Cuadrilatero {
    protected double[][] vertices;

    public Cuadrilatero(double[][] vertices) {
        this.vertices = vertices;
    }

    // Método genérico que puede ser sobrescrito por las subclases
    public double calcularArea() {
        return 0.0;
    }
}
