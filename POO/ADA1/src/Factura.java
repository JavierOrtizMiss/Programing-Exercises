public class Factura {
    //Atributos
    int numFactura;
    String numPieza;
    String descripcionPieza;
    int cantidadArticulos;
    double precioArticulo;

    //Constructor
    public Factura(int numFactura, String numPieza, String descripcionPieza, int cantidadArticulos, double precioArticulo) {
        this.numFactura = numFactura;
        this.numPieza = numPieza;
        this.descripcionPieza = descripcionPieza;
        setCantidadArticulos(cantidadArticulos);
        setPrecioArticulo(precioArticulo);
    }

    //Metodos get y set

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getNumPieza() {
        return numPieza;
    }

    public void setNumPieza(String numPieza) {
        this.numPieza = numPieza;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {

        if (cantidadArticulos < 0){
            this.cantidadArticulos = 0;
        } else {
            this.cantidadArticulos = cantidadArticulos;
        }
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        if (precioArticulo < 0){
            this.precioArticulo = 0.0;
        } else {
            this.precioArticulo = precioArticulo;  
        }
    }

    //Metodo para obtener el monto de la factura
    public double obtenerMontoFactura(){
        return cantidadArticulos * precioArticulo;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "\nFactura: " + getNumFactura() + "\n" +
                "Número de pieza: " + getNumPieza() + "\n" +
                "Descripción: " + getDescripcionPieza() + "\n" +
                "Cantidad: " + getCantidadArticulos() + "\n" +
                "Precio por pieza: " + getPrecioArticulo() + "\n" +
                "Impore total: " + obtenerMontoFactura();
        
    }

}
