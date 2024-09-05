import java.util.Scanner;
import java.util.ArrayList;

public class ProbarCuenta {

    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        int option;

        do {
            System.out.println("---Menú de opciones---");
            System.out.println("1 - Crear una cuenta");
            System.out.println("2 - Retiro");
            System.out.println("3 - Pago");
            System.out.println("4 - Ingreso o abono");
            System.out.println("5 - Transferencia");
            System.out.println("6 - Consultar saldos");
            System.out.println("7 - Terminar");
            option = leer.nextInt();
            leer.nextLine(); 

            switch (option) {
                case 1:
                    clean();
                    System.out.println("Por favor, ingrese el número de cuenta: ");
                    int numCuenta = leer.nextInt();
                    System.out.println("Por favor, ingrese el saldo de la cuenta:");
                    double saldo = leer.nextDouble();
                    leer.nextLine(); 
                    System.out.println("Ingrese 1 para Debito o 2 para Credito: ");
                    int tipoCuenta = leer.nextInt();
                    
                    String descripcion = "";
                    if (tipoCuenta == 1) {
                        descripcion = "Debito";
                    } else if (tipoCuenta == 2) {
                        descripcion = "Credito";
                    } else {
                        System.out.println("Por favor, introduzca un valor válido.");
                        break; 
                    }
                    Cuenta cuenta = new Cuenta(saldo, numCuenta, descripcion);
                    cuentas.add(cuenta);
                    System.out.println("Cuenta creada");
                    break;
                case 2:
                    clean();
                    Cuenta cuentaRetiro = buscarCuenta(cuentas, leer);
                    if (cuentaRetiro != null) {
                        System.out.println("Ingrese el monto a retirar: ");
                        double montoRetiro = leer.nextDouble();
                        cuentaRetiro.retiro(montoRetiro);
                    } else {
                        System.out.println("No se puede realizar el retiro. La cuenta no existe.");
                    }
                    break;
                case 3:
                    clean();
                    System.out.println("-Introduzca el número de cuenta para el pago-");
                    Cuenta cuentaPago = buscarCuenta(cuentas, leer);
                    if (cuentaPago != null) {
                        if (cuentaPago.getDescripcion().equals("Credito")) {
                            System.out.println("Ingrese el monto a pagar: ");
                            double montoPago = leer.nextDouble();
                            cuentaPago.retiro(montoPago);
                        } else {
                            System.out.println("La cuenta no es de tipo 'Credito'. No se puede realizar el pago.");
                        }
                    } else {
                        System.out.println("No se puede realizar el pago. La cuenta no existe.");
                    }
                    break;
                case 4:
                    clean();
                    System.out.println("-Introduzca el número de cuenta para el ingreso-");
                    Cuenta cuentaIngreso = buscarCuenta(cuentas, leer);
                    if (cuentaIngreso != null) {
                        System.out.println("Ingrese el monto a ingresar: ");
                        double montoIngreso = leer.nextDouble();
                        cuentaIngreso.ingreso(montoIngreso);
                    } else {
                        System.out.println("No se puede realizar el ingreso. La cuenta no existe.");
                    }
                    break;
                case 5:
                    clean();
                    System.out.println("-Introduzca el número de cuenta de origen-");
                    Cuenta cuentaOrigen = buscarCuenta(cuentas, leer);
                    if (cuentaOrigen != null) {
                        System.out.println("-Introduzca el número de cuenta destino-");
                        Cuenta cuentaDestino = buscarCuenta(cuentas, leer);
                        if (cuentaDestino != null) {
                            System.out.println("Ingrese el monto a transferir: ");
                            double montoTransferencia = leer.nextDouble();
                            cuentaOrigen.transferencia(cuentaDestino, montoTransferencia);
                        } else {
                            System.out.println("No se puede realizar la transferencia. La cuenta destino no existe.");
                        }
                    } else {
                        System.out.println("No se puede realizar la transferencia. La cuenta origen no existe.");
                    }
                    break;
                case 6:
                    clean();
                    for (int i = 0; i < cuentas.size(); i++) {
                        Cuenta obtenerSaldos = cuentas.get(i);
                        System.out.println(obtenerSaldos);
                        System.out.println("-----------------------------");
                    }
                    break;
                case 7:
                    System.out.println("Programa terminado pa");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (option != 7);

        leer.close();
    }

    public static Cuenta buscarCuenta(ArrayList<Cuenta> cuentas, Scanner leer) {
        System.out.print("Ingrese el número de la cuenta: ");
        int numero = leer.nextInt();
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            if (cuenta.getNumCuenta() == numero) {
                return cuenta;
            }
        }
        System.out.println("Cuenta no encontrada.");
        return null;
    }
}
