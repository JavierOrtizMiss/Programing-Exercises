import java.util.ArrayList;
import java.util.Scanner;

public class Bachoco{
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Departamento> departamentos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDepartamentos();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de empleados.");

        boolean continuar = true;
        while (continuar) {
            registrarEmpleado(sc);
            System.out.print("¿Desea registrar otro empleado? (s/n): ");
            String respuesta = sc.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        mostrarEmpleados();
        sc.close();
    }

    private static void inicializarDepartamentos() {
        departamentos.add(new Departamento("CO", "Compras"));
        departamentos.add(new Departamento("AL", "Almacén"));
        departamentos.add(new Departamento("FI", "Finanzas"));
        departamentos.add(new Departamento("RH", "Recursos Humanos"));
    }

    private static void registrarEmpleado(Scanner sc) {
        System.out.print("Ingrese la clave del empleado: ");
        String clave = sc.next();

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.next();

        System.out.print("Ingrese el apellido paterno del empleado: ");
        String apellidoPaterno = sc.next();

        System.out.print("Ingrese el apellido materno del empleado: ");
        String apellidoMaterno = sc.next();

        System.out.println("Fecha de nacimiento:");
        Fecha fechaNacimiento = capturarFecha(sc);

        System.out.println("Fecha de ingreso:");
        Fecha fechaIngreso = capturarFecha(sc);

        Departamento departamento = capturarDepartamento(sc);

        System.out.println("Horario de lunes a viernes:");
        Horario horarioLV = capturarHorario(sc);

        System.out.println("¿El empleado trabaja los sábados? (s/n): ");
        Horario horarioS = null;
        if (sc.next().equalsIgnoreCase("s")) {
            horarioS = capturarHorario(sc);
        }

        System.out.println("¿El empleado trabaja los domingos? (s/n): ");
        Horario horarioD = null;
        if (sc.next().equalsIgnoreCase("s")) {
            horarioD = capturarHorario(sc);
        }

        Empleado empleado = new Empleado(clave, nombre, apellidoPaterno, apellidoMaterno,
                fechaNacimiento, fechaIngreso, departamento, horarioLV, horarioS, horarioD);

        empleados.add(empleado);
        System.out.println("Empleado registrado con éxito.");
    }

    private static Fecha capturarFecha(Scanner sc) {
        int dia, mes, anio;
        boolean fechaValida;
        do {
            System.out.print("Ingrese el día: ");
            dia = sc.nextInt();
            System.out.print("Ingrese el mes: ");
            mes = sc.nextInt();
            System.out.print("Ingrese el año: ");
            anio = sc.nextInt();

            fechaValida = Fecha.validFecha(dia, mes, anio);
            if (!fechaValida) {
                System.out.println("Fecha no válida, por favor inténtalo de nuevo.");
            }
        } while (!fechaValida); 

        return new Fecha(dia, mes, anio); 
    }

    private static Horario capturarHorario(Scanner sc) {
        System.out.print("Ingrese la hora de inicio (HH:MM): ");
        String horaInicio = sc.next();
        System.out.print("Ingrese la hora de fin (HH:MM): ");
        String horaFin = sc.next();
        return new Horario(horaInicio, horaFin);
    }

    private static Departamento capturarDepartamento(Scanner sc) {
        System.out.println("Seleccione el departamento:");
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println((i + 1) + ". " + departamentos.get(i).getNombre());
        }
        int seleccion = sc.nextInt();
        return departamentos.get(seleccion - 1);
    }

    private static void mostrarEmpleados() {
        System.out.println("\nEmpleados registrados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
}
