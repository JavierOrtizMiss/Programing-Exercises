public class Factura implements PorPagar {
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        this.cantidad = cantidad;
        this.precioPorArticulo = precioPorArticulo;
    }

    public String getNumeropieza(){
        return numeroPieza;
    }

    @Override
    public double ingresos() {
        return cantidad * precioPorArticulo;
    }

    @Override
    public String toString() {
        return String.format("Factura:\nNúmero de pieza: %s\nDescripción: %s\nCantidad: %d\nPrecio por artículo: $%.2f",
                             numeroPieza, descripcionPieza, cantidad, precioPorArticulo);
    }
}
