import java.util.ArrayList;
import java.util.Scanner;

public class Bachoco{
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Departamento> departamentos = new ArrayList<>();

    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        inicializarDepartamentos();
        Scanner sc = new Scanner(System.in);

        System.out.println("#####################################################################");
        System.out.println("#                                                                   #");
        System.out.println("#           Bienvenido al sistema de registo de empleados           #");
        System.out.println("#                                                                   #");                                       
        System.out.println("#####################################################################\n");

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
        System.out.print("Ingrese la clave del empleado (4 caracteres máximo): ");
        String clave = sc.next();
        clean();
        while (clave.length() > 4) {
            System.out.print("La clave excede los 4 caracteres. Intente nuevamente: ");
            clave = sc.next();
            clean();
        }
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.next();
        clean();
        while (!nombre.matches("[a-zA-Z]+")) {
            System.out.print("Nombre inválido. Ingrese solo letras: ");
            nombre = sc.next();
            clean();
        }
        System.out.print("Ingrese el apellido paterno del empleado: ");
        String apellidoPaterno = sc.next();
        clean();
        while (!nombre.matches("[a-zA-Z]+")) {
            System.out.print("Apellido inválido. Ingrese solo letras: ");
            nombre = sc.next();
            clean();
        }
        System.out.print("Ingrese el apellido materno del empleado: ");
        String apellidoMaterno = sc.next();
        clean();
        while (!nombre.matches("[a-zA-Z]+")) {
            System.out.print("Apellido inválido. Ingrese solo letras: ");
            nombre = sc.next();
            clean();
        }
        System.out.println("Fecha de nacimiento:");
        Fecha fechaNacimiento = capturarFecha(sc);
        clean();
        System.out.println("Fecha de ingreso:");
        Fecha fechaIngreso = capturarFecha(sc);
        if (!Fecha.fechaEsConsistente(fechaNacimiento, fechaIngreso)) {
            System.out.println("La fecha de ingreso no es consistente con la fecha de nacimiento.");
            return;
        }
        clean();
        Departamento departamento = capturarDepartamento(sc);
        clean();
        System.out.println("Horario de lunes a viernes:");
        Horario horarioLV = capturarHorario(sc);
        clean();
        System.out.println("¿El empleado trabaja los sábados? (s/n): ");
        Horario horarioS = null;
        if (sc.next().equalsIgnoreCase("s")) {
            horarioS = capturarHorario(sc);
        }
        clean();
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

    public static Fecha capturarFecha(Scanner sc) {
        int dia, mes, anio;

        while (true) {
            System.out.print("Ingrese el día: ");
            dia = sc.nextInt();
            System.out.print("Ingrese el mes: ");
            mes = sc.nextInt();
            System.out.print("Ingrese el año: ");
            anio = sc.nextInt();

            Fecha fecha = new Fecha(dia, mes, anio);

            if (Fecha.validFecha(dia, mes, anio)) {
                return fecha;
            } else {
                System.out.println("Fecha inválida o la persona no es mayor de edad. Inténtelo nuevamente.");
            }
        }
    }
    private static Horario capturarHorario(Scanner sc) {
        int horaInicio, minutoInicio, horaFin, minutoFin;
        
        
        while (true) {
            System.out.print("Ingrese la hora de inicio (0-23): ");
            horaInicio = sc.nextInt();
            if (horaInicio >= 0 && horaInicio <= 23) break;
            System.out.println("Hora inválida. Debe estar entre 0 y 23.");
        }
    
        
        while (true) {
            System.out.print("Ingrese los minutos de inicio (0-59): ");
            minutoInicio = sc.nextInt();
            if (minutoInicio >= 0 && minutoInicio <= 59) break;
            System.out.println("Minutos inválidos. Deben estar entre 0 y 59.");
        }
        

        while (true) {
            System.out.print("Ingrese la hora de fin (0-23): ");
            horaFin = sc.nextInt();
            if (horaFin >= 0 && horaFin <= 23) break;
            System.out.println("Hora inválida. Debe estar entre 0 y 23.");
        }
    
        
        while (true) {
            System.out.print("Ingrese los minutos de fin (0-59): ");
            minutoFin = sc.nextInt();
            if (minutoFin >= 0 && minutoFin <= 59) break;
            System.out.println("Minutos inválidos. Deben estar entre 0 y 59.");
        }
    
        if (horaFin < horaInicio || (horaFin == horaInicio && minutoFin <= minutoInicio)) {
            System.out.println("La hora de fin debe ser después de la hora de inicio.");
            return capturarHorario(sc); 
        }

        String horaInicioStr = String.format("%02d:%02d", horaInicio, minutoInicio);
        String horaFinStr = String.format("%02d:%02d", horaFin, minutoFin);
        return new Horario(horaInicioStr, horaFinStr);
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
        System.out.printf("%-10s %-20s %-20s %-20s %-15s %-15s %-15s %-30s\n", 
                          "Clave", "Nombre", "Apellido Paterno", "Apellido Materno", 
                          "Fecha Nac.", "Fecha Ingreso", "Departamento", "Horario");
    
        for (Empleado empleado : empleados) {
            String clave = empleado.getClave();
            String nombre = empleado.getNombre();
            String apellidoPaterno = empleado.getApellidoPaterno();
            String apellidoMaterno = empleado.getApellidoMaterno();
            String fechaNacimiento = empleado.getFechaNacimiento().toString();
            String fechaIngreso = empleado.getFechaIngreso().toString();
            String departamento = empleado.getDepartamento().getNombre();
            String horario = empleado.getHorarioLV().toString();
            
            if (empleado.getHorarioS() != null) {
                horario += ", S = " + empleado.getHorarioS().toString();
            }
            if (empleado.getHorarioD() != null) {
                horario += ", D = " + empleado.getHorarioD().toString();
            }
    
            System.out.printf("%-10s %-20s %-20s %-20s %-15s %-15s %-15s %-30s\n",
                              clave, nombre, apellidoPaterno, apellidoMaterno,
                              fechaNacimiento, fechaIngreso, departamento, horario);
        }
    }
    
}
