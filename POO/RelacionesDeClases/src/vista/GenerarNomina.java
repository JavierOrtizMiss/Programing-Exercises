package vista;
import java.util.Scanner;
import modelo.EmpleadoPorComision;

public class GenerarNomina {
    public static void main(String[] args) {
        Scanner entradaStr = new Scanner(System.in);
        Scanner entradaNum = new Scanner(System.in);

        System.out.println("***Empleado por comisión***");

        System.out.println("Escriba el seguro social: ");
        int seguroSocial = entradaNum.nextInt();

        System.out.println("Escriba el nombre: ");
        String nombre = entradaStr.nextLine();

        System.out.println("Escriba el apellido paterno: ");
        String apellidoPaterno = entradaStr.nextLine();

        System.out.println("Escriba el apellido materno: ");
        String apellidoMaterno = entradaStr.nextLine();

        System.out.println("Escriba las ventas brutas: ");
        double ventasBrutas = entradaNum.nextDouble();

        System.out.println("Escriba la tarifa de comisión: ");
        double tarifaComision = entradaNum.nextDouble();

        EmpleadoPorComision unEmpleado = new EmpleadoPorComision(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, ventasBrutas, tarifaComision);
        System.out.println(unEmpleado);
        System.out.println("El sueldo es: " + unEmpleado.sueldo());

    }
    
}
