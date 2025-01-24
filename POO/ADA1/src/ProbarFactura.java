import java.util.Scanner;

public class ProbarFactura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de factura: ");
        int numFactura = sc.nextInt();
        System.out.println("Ingrese el numero de pieza: ");
        String numPieza = sc.next();
        System.out.println("Ingrese la descripcion de la pieza: ");
        String descripcionPieza = sc.next();
        System.out.println("Ingrese la cantidad de articulos: ");
        int cantidadArticulos = sc.nextInt();
        System.out.println("Ingrese el precio del articulo: ");
        double precioArticulo = sc.nextDouble();

        sc.close();

        Factura factura = new Factura(numFactura, numPieza, descripcionPieza, cantidadArticulos, precioArticulo);

        System.out.println(factura);
        
        
    }
}
