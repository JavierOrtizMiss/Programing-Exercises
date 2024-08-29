import java.util.Scanner;

public class ProbarCuenta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de cuenta a ingresar: ");
        String nocuenta = scanner.nextLine();

        System.out.println("Ingrese su saldo inicial: ");
        Double saldo = scanner.nextDouble();

        System.out.println("Ingrese la descripción de la cuenta: ");
        scanner.nextLine();
        String description = scanner.nextLine();

        Cuenta nuevacuenta = new Cuenta(saldo, nocuenta, description);
        int option;  

        do {
            System.out.println("\nIngrese las opciones que desea hacer con la cuenta.\n");
            System.out.println("Opciones: \n 1) Abonar \n 2) Consultar saldo \n 3) Salir");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingrese la cantidad para abonar: ");
                    Double abono = scanner.nextDouble();
                    nuevacuenta.abonar(abono);
                    System.out.println("Su saldo es de " + nuevacuenta.getSaldo());
                    break;
                case 2:
                    System.out.println("Su saldo es de " + nuevacuenta.getSaldo());
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                    break;
            }

        } while (option != 3);  

        scanner.close(); 
    }
}