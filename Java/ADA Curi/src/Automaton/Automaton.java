// src/automata/Automaton.java
package Automaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import States.States;

public class Automaton {
    private List<States> estados; // Lista de estados
    private String estadoInicial; // Estado inicial
    private Set<String> estadosFinales; // Conjunto de estados finales
    private Set<String> alfabeto; // Alfabeto del autómata

    public Automaton(String archivo) throws IOException {
        estados = new ArrayList<>();
        estadosFinales = new HashSet<>();
        alfabeto = new HashSet<>();
        cargarAutomata(archivo);
    }

    // Método para cargar el autómata desde un archivo
    private void cargarAutomata(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        String seccionActual = "";

        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;

            if (linea.startsWith("#")) {
                seccionActual = linea.substring(1); // Extraer sección sin el #
                continue;
            }

            switch (seccionActual) {
                case "states":
                    estados.add(new States(linea)); // Crear un nuevo estado
                    break;
                case "initial":
                    estadoInicial = linea; // Definir el estado inicial
                    break;
                case "accepting":
                    estadosFinales.add(linea); // Añadir estado final
                    break;
                case "alphabet":
                    alfabeto.add(linea); // Añadir símbolo al alfabeto
                    break;
                case "transitions":
                    // Separar la línea de transición en partes
                    String[] partes = linea.split(">");
                    String[] estadoYSimbolo = partes[0].split(":");
                    String estadoDesde = estadoYSimbolo[0];
                    String simbolo = estadoYSimbolo[1];
                    String estadoDestino = partes[1];
                    // Añadir transición al estado correspondiente
                    for (States estado : estados) {
                        if (estado.getNombre().equals(estadoDesde)) {
                            estado.agregarTransicion(simbolo, estadoDestino);
                        }
                    }
                    break;
            }
        }
        br.close();
    }

    // Método para validar si una cadena pertenece al lenguaje del autómata
    public boolean validarCadena(String cadena) {
        String estadoActual = estadoInicial;

        for (char simbolo : cadena.toCharArray()) {
            String simboloStr = String.valueOf(simbolo);
            States estado = obtenerEstado(estadoActual);

            if (estado == null || !estado.tieneTransicion(simboloStr)) {
                return false; // Si no hay transición, la cadena no es válida
            }

            estadoActual = estado.obtenerDestino(simboloStr); // Avanzar al siguiente estado
        }

        return estadosFinales.contains(estadoActual); // Comprobar si el estado final es válido
    }

    // Método para obtener un estado por su nombre
    private States obtenerEstado(String nombre) {
        for (States estado : estados) {
            if (estado.getNombre().equals(nombre)) {
                return estado;
            }
        }
        return null;
    }
}
