import java.util.Scanner;

import modelo.Torniquete;

public class App {
    public static void main(String[] args) {
        boolean locked = true;
        Torniquete torniquete = new Torniquete(locked);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bloqueado");
        while (true) { 
            System.out.println("1. Insertar moneda");
            System.out.println("2. Pasar torniquete");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    torniquete.insertarMoneda();
                    break;
                case 2:
                    torniquete.pasar();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}


