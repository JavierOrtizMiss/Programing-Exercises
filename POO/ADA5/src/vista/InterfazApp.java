package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;

public class InterfazApp {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        ArrayList<PorPagar> listaPorPagar = new ArrayList<PorPagar>();
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
            System.out.println("6. Añadir factura");
            System.out.println("7. Salir"); 
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
                    listaPorPagar.add(empleadoAsalariado);
                    clean();
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
                    listaPorPagar.add(empleadoPorHoras);
                    clean();
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
                    listaPorPagar.add(empleadoPorComision);
                    clean();
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
                    listaPorPagar.add(empleadoBaseMasComision);
                    clean();
                    System.out.println("Empleado Base más Comisión creado con éxito \n");
                    break;
                case 5:
                    System.out.println("¿Qué desea imprimir?: Nominas(1) o Facturas(2)");
                    int imprimir = entradaNum.nextInt();
                    entradaNum.nextLine();

                    if (imprimir == 1) {
                        System.out.println("Nómina de empleados:");
                        for (PorPagar porPagar : listaPorPagar) {
                            if (porPagar instanceof Empleado) {
                                Empleado empleado = (Empleado) porPagar;
                                if (empleado instanceof EmpleadoBaseMasComision) {
                                    EmpleadoBaseMasComision empBaseMasComision = (EmpleadoBaseMasComision) empleado;
                                    double nuevoSueldoBase = empBaseMasComision.getSueldoBase() + (empBaseMasComision.getSueldoBase() * 0.10);
                                    empBaseMasComision.setsueldoBase(nuevoSueldoBase);
                                    System.out.println("--Aumento al salario base del 10%--");
                                }
                                System.out.println(empleado);
                                System.out.println("Ingresos: $" + empleado.ingresos());
                                System.out.println("-------------------------------");
                            }
                        }
                    } else if (imprimir == 2) {
                        System.out.println("Facturas por pagar:");
                        for (PorPagar porPagar : listaPorPagar) {
                            if (porPagar instanceof Factura) {
                                Factura factura = (Factura) porPagar;
                                System.out.println(factura);
                                System.out.println("-------------------------------");
                            }
                        }
                    }
                    break;
                case 6:
                    //Añadir factura
                    System.out.println("Ingrese los datos de la factura: \n");
                    System.out.println("Número de piezas: ");
                    String numeroPiezas = entradaStr.nextLine();
                    System.out.println("Descripción: ");
                    String descripcion = entradaStr.nextLine();
                    System.out.println("Cantidad: ");
                    int cantidad = entradaNum.nextInt();
                    System.out.println("Precio por artículo: ");
                    double precioPorArticulo = entradaNum.nextDouble();
                    Factura factura = new Factura(numeroPiezas, descripcion, cantidad, precioPorArticulo);
                    listaPorPagar.add(factura);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 7); 
    }
}

