// src/main/Aplication.java
import Automaton.Automaton;
import java.io.IOException;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        String rutaArchivo = "automata.txt"; // Ruta del archivo del autómata

        try {
            Automaton automata = new Automaton(rutaArchivo);
            Scanner scanner = new Scanner(System.in);
            String cadena;

            System.out.println("Ingrese cadenas para verificar si pertenecen al autómata (escriba 'salir' para terminar):");
            while (true) {
                System.out.print("Cadena: ");
                cadena = scanner.nextLine();

                if (cadena.equalsIgnoreCase("salir")) {
                    break;
                }

                if (automata.validarCadena(cadena)) {
                    System.out.println("La cadena '" + cadena + "' pertenece al autómata.");
                } else {
                    System.out.println("La cadena '" + cadena + "' no pertenece al autómata.");
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
