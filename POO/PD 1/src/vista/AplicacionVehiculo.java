package vista;

import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AplicacionVehiculo {
    public static void main(String[] args) throws Exception {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Scanner entradaStr = new Scanner(System.in);
        Scanner entradaNum = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n**Bienvenido al programa de vehículos** \n");
            System.out.println("----------------------------------------------");
            System.out.println("Por favor seleccione una opción:");
            System.out.println("Mneú: ");
            System.out.println("1. Electrico");
            System.out.println("2. Gasolina");
            System.out.println("3. Imprimir aceleraciones");
            System.out.println("4. Imprimir frenados");
            System.out.println("5. Terminar");

            opcion = entradaNum.nextInt();
            entradaNum.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la matrícula del vehículo:");
                    String matricula = entradaStr.nextLine();
                    System.out.println("Ingrese la velocidad actual del vehículo:");
                    double velocidadActual = entradaNum.nextDouble();
                    System.out.println("Ingrese la velocidad máxima del vehículo:");
                    double velocidadMaxima = entradaNum.nextDouble();
                    System.out.println("Ingrese la autonomía del vehículo:");
                    double autonomia = entradaNum.nextDouble();
                    System.out.println("Ingrese el uso del vehículo:");
                    String usoVehiculo = entradaStr.nextLine();
                    Electrico electrico = new Electrico(matricula, velocidadActual, velocidadMaxima, autonomia, usoVehiculo);
                    vehiculos.add(electrico);
                    System.out.println("Vehículo eléctrico creado con éxito \n");
                    break;
                case 2:
                    System.out.println("Ingrese la matrícula del vehículo:");
                    matricula = entradaStr.nextLine();
                    System.out.println("Ingrese la velocidad actual del vehículo:");
                    velocidadActual = entradaNum.nextDouble();
                    System.out.println("Ingrese la velocidad máxima del vehículo:");
                    velocidadMaxima = entradaNum.nextDouble();
                    System.out.println("Ingrese el motor del vehículo:");
                    double motor = entradaNum.nextDouble();
                    System.out.println("Ingrese la capacidad de pasajeros del vehículo:");
                    int capacidadPasajeros = entradaNum.nextInt();
                    Gasolina gasolina = new Gasolina(matricula, velocidadActual, velocidadMaxima, motor, capacidadPasajeros);
                    vehiculos.add(gasolina);
                    System.out.println("Vehículo de gasolina creado con éxito \n");
                    break;
                case 3:
                    for (Vehiculo vehiculo : vehiculos) {
                        vehiculo.acelerar(10);
                        System.out.println("La velocidad actual del vehículo con matrícula " + vehiculo.getMatricula() + " es: " + vehiculo.getVelocidadActual());
                    }
                    break;
                case 4:
                    for (Vehiculo vehiculo : vehiculos) {
                        vehiculo.frenar(10);
                        System.out.println("La velocidad actual del vehículo con matrícula " + vehiculo.getMatricula() + " es: " + vehiculo.getVelocidadActual());
                    }
                    break;
                case 5:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        entradaStr.close();
        entradaNum.close();
    }
}
