package Vista;
import Modelo.Empleado;
import Modelo.EmpleadoAsalariado;
import Modelo.EmpleadoPorHoras;
import Modelo.EmpleadoPorComision;
import Modelo.EmpleadoBaseMasComision;
import java.util.Scanner;
import java.util.ArrayList;

public class GenerarNomina {
    public static void main(String[] args) {
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner entradaStr = new Scanner(System.in);
        Scanner entradaNum = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("\n**Bienvenido al programa para generar nómina** \n");
            System.out.println("----------------------------------------------");
            System.out.println("Por favor seleccione una opción:");
            System.out.println("1. Empleado Asalariado");
            System.out.println("2. Empleado por Horas");
            System.out.println("3. Empleado por Comisión");
            System.out.println("4. Empleado Base más Comisión");
            System.out.println("5. Imprimir nómina");
            opcion = entradaNum.nextInt();
            entradaNum.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de seguro social:");
                    int seguroSocial = entradaNum.nextInt();
                    entradaNum.nextLine(); 
                    System.out.println("Ingrese el nombre del empleado:");
                    String nombre = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido paterno del empleado:");
                    String apellidoPaterno = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido materno del empleado:");
                    String apellidoMaterno = entradaStr.nextLine();
                    System.out.println("Ingrese el sueldo del empleado:");
                    double sueldo = entradaNum.nextDouble();
                    EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, sueldo);
                    empleados.add(empleadoAsalariado);
                    System.out.println("Empleado Asalariado creado con éxito \n");
                    break;
                case 2:
                    System.out.println("Ingrese el número de seguro social:");
                    seguroSocial = entradaNum.nextInt();
                    entradaNum.nextLine(); 
                    System.out.println("Ingrese el nombre del empleado:");
                    nombre = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido paterno del empleado:");
                    apellidoPaterno = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido materno del empleado:");
                    apellidoMaterno = entradaStr.nextLine();
                    System.out.println("Ingrese las horas trabajadas:");
                    double horasTrabajadas = entradaNum.nextDouble();
                    System.out.println("Ingrese la tarifa por hora:");
                    double tarifaPorHora = entradaNum.nextDouble();
                    EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, horasTrabajadas, tarifaPorHora);
                    empleados.add(empleadoPorHoras);
                    System.out.println("Empleado por Horas creado con éxito \n");
                    break;
                case 3:
                    System.out.println("Ingrese el número de seguro social:");
                    seguroSocial = entradaNum.nextInt();
                    entradaNum.nextLine(); 
                    System.out.println("Ingrese el nombre del empleado:");
                    nombre = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido paterno del empleado:");
                    apellidoPaterno = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido materno del empleado:");
                    apellidoMaterno = entradaStr.nextLine();
                    System.out.println("Ingrese las ventas brutas:");
                    double ventasBrutas = entradaNum.nextDouble();
                    System.out.println("Ingrese la tarifa de comisión:");
                    double tarifaComision = entradaNum.nextDouble();
                    EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, ventasBrutas, tarifaComision);
                    empleados.add(empleadoPorComision);
                    System.out.println("Empleado por Comisión creado con éxito \n");
                    break;
                case 4:
                    System.out.println("Ingrese el número de seguro social:");
                    seguroSocial = entradaNum.nextInt();
                    entradaNum.nextLine(); 
                    System.out.println("Ingrese el nombre del empleado:");
                    nombre = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido paterno del empleado:");
                    apellidoPaterno = entradaStr.nextLine();
                    System.out.println("Ingrese el apellido materno del empleado:");
                    apellidoMaterno = entradaStr.nextLine();
                    System.out.println("Ingrese las ventas brutas:");
                    ventasBrutas = entradaNum.nextDouble();
                    System.out.println("Ingrese la tarifa de comisión:");
                    tarifaComision = entradaNum.nextDouble();
                    System.out.println("Ingrese el sueldo base:");
                    double sueldoBase = entradaNum.nextDouble();
                    EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(seguroSocial, nombre, apellidoPaterno, apellidoMaterno, ventasBrutas, tarifaComision, sueldoBase);
                    empleados.add(empleadoBaseMasComision);
                    System.out.println("Empleado Base más Comisión creado con éxito \n");
                    break;
                case 5:
                    System.out.println("Nómina de empleados:");
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado);
                    }
                    break;
                default:
                    break;
            }
        }while(opcion != 6);

    }
}