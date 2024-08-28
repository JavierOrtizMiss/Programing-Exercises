import java.util.Scanner;

public class ProbarRevista {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese los datos de la revista
        System.out.print("Ingrese el nombre de la revista: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el ISSN de la revista (número entero): ");
        Double issn = scanner.nextDouble();

        System.out.print("Ingrese el año de publicación: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la editorial de la revista: ");
        String editorial = scanner.nextLine();

        // Crear una instancia de la clase Revista con los datos ingresados
        Revista revista = new Revista(nombre, issn, year, editorial);

        // Imprimir los atributos de la revista
        System.out.println("\nDetalles de la Revista:");
        System.out.println(revista.imprimir());

        scanner.close();
    }

}
