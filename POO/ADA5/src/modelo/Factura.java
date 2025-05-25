package modelo;

public class Factura implements PorPagar{
    //Atributos
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    //Constructor
    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        setCantidad(cantidad);
        setPrecioPorArticulo(precioPorArticulo);
    }

    //Métodos get y set
    public String getNumeroPieza() {
        return numeroPieza;
    }

    public void setNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void setPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = precioPorArticulo;
    }

    //Método de la interfaz PorPagar
    @Override
    public double ingresos() {
        return cantidad * precioPorArticulo;
    }

    //Método toString
    @Override
    public String toString(){
        return "\n---Factura---\n" + "Número de Pieza: " + getNumeroPieza() + "\n" + "Descripción de la Pieza: " + getDescripcionPieza() + "\n" + "Cantidad: " + getCantidad() + "\n" + "Precio por Artículo: " + getPrecioPorArticulo();
    }


}
