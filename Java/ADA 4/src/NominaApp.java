import java.util.ArrayList;
import java.util.Scanner;

public class NominaApp {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Nómina de Empleados:");
            System.out.println("Menú");
            System.out.println("1. Empleado asalariado");
            System.out.println("2. Empleado por comisión");
            System.out.println("3. Empleado por horas");
            System.out.println("4. Empleado base más comisión");
            System.out.println("5. Imprimir nómina");
            System.out.println("6. Terminar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  

            switch (opcion) {
                case 1:
                    clean();
                    // Empleado asalariado
                    System.out.println("Ingrese los datos del empleado asalariado:");
                    System.out.print("Primer nombre: ");
                    String firstName = sc.nextLine();
                    System.out.print("Apellido paterno: ");
                    String flastName = sc.nextLine();
                    System.out.print("Apellido materno: ");
                    String mlastName = sc.nextLine();
                    System.out.print("NSS: ");
                    String nss = sc.nextLine();
                    System.out.print("Salario semanal: ");
                    double weeklySalary = sc.nextDouble();
                    empleados.add(new EmpleadoAsalariado(firstName, flastName, mlastName, nss, weeklySalary));
                    clean();
                    break;

                case 2:
                    // Empleado por comisión
                    clean();
                    System.out.println("Ingrese los datos del empleado por comisión:");
                    System.out.print("Primer nombre: ");
                    firstName = sc.nextLine();
                    System.out.print("Apellido paterno: ");
                    flastName = sc.nextLine();
                    System.out.print("Apellido materno: ");
                    mlastName = sc.nextLine();
                    System.out.print("NSS: ");
                    nss = sc.nextLine();
                    System.out.print("Ventas brutas: ");
                    double grossSales = sc.nextDouble();
                    System.out.print("Tarifa de comisión: ");
                    double commissionRates = sc.nextDouble();
                    empleados.add(new EmpleadoPorComision(firstName, flastName, mlastName, nss, grossSales, commissionRates));
                    clean();
                    break;

                case 3:
                    // Empleado por horas
                    clean();
                    System.out.println("Ingrese los datos del empleado por horas:");
                    System.out.print("Primer nombre: ");
                    firstName = sc.nextLine();
                    System.out.print("Apellido paterno: ");
                    flastName = sc.nextLine();
                    System.out.print("Apellido materno: ");
                    mlastName = sc.nextLine();
                    System.out.print("NSS: ");
                    nss = sc.nextLine();
                    System.out.print("Sueldo por hora: ");
                    double hourlyWage = sc.nextDouble();
                    System.out.print("Horas trabajadas: ");
                    int hoursWorked = sc.nextInt();
                    empleados.add(new EmpleadoPorHoras(firstName, flastName, mlastName, nss, hourlyWage, hoursWorked));
                    clean();
                    break;

                case 4:
                    // Empleado base más comisión
                    clean();
                    System.out.println("Ingrese los datos del empleado base más comisión:");
                    System.out.print("Primer nombre: ");
                    firstName = sc.nextLine();
                    System.out.print("Apellido paterno: ");
                    flastName = sc.nextLine();
                    System.out.print("Apellido materno: ");
                    mlastName = sc.nextLine();
                    System.out.print("NSS: ");
                    nss = sc.nextLine();
                    System.out.print("Ventas brutas: ");
                    grossSales = sc.nextDouble();
                    System.out.print("Tasa de comisión: ");
                    commissionRates = sc.nextDouble();
                    System.out.print("Salario base: ");
                    double baseSalary = sc.nextDouble();
                    empleados.add(new EmpleadoBaseMasComision(firstName, flastName, mlastName, nss, grossSales, commissionRates, baseSalary));
                    clean();
                    break;

                case 5:
                    // Imprimir nómina
                    clean();
                    System.out.println("\nNómina:");
                    for (Empleado emp : empleados) {
                        System.out.println(emp); 
                        System.out.println("Ingresos: $" + emp.ingresos());
                        System.out.println("-------------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Terminando programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
