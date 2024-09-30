//Importamos la carpeta "Automaton"
package Automaton;
//Declaración de las librerías
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import States.States;

//Creamos la clase Automaton que hará todo el procedimiento de leer el automata y validarlo
public class Automaton {
    private List<States> estados; // Lista de estados
    private String estadoInicial; // Estado inicial
    private Set<String> estadosFinales; // Conjunto de estados finales
    private Set<String> alfabeto; // Alfabeto del autómata

    //Creamos un constructor de la clase donde creamos objetos de cada apartado del autómata, al igual que cargar el archivo
    public Automaton(String archivo) throws IOException {
        estados = new ArrayList<>();//Creamos el objeto lista
        estadosFinales = new HashSet<>();//Creamos el objeto set o conjunto
        alfabeto = new HashSet<>();//Creamos el objeto set o conjunto
        cargarAutomata(archivo);//Llamamos al método cargarAutómata que tiene como parámetro el archivo
        //Con throws vemos si hay alguna excepcion al cargar el archivo
    }

    // Método para cargar el autómata desde un archivo
    private void cargarAutomata(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo)); //Instanciamos el método br de BufferReader para poder leer el archivo
        String linea;//Declaramos la variable linea de tipo String, nos servirá para poder leer linea por linea
        String seccionActual = "";//Creamos una variable seccionActual de tipo String y le agregamos una cadena vacía

        //Ciclo while para poder ir leyendo linea 
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();//Quitamos espacios en blanco de la cadena si es que llegara a tener
            if (linea.isEmpty()) continue;//Si la cadena es vacía, pasa a la siguiente

            if (linea.startsWith("#")) {//Si empieza con # extrae esa seccion
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
                    String[] partes = linea.split(">");//Dividir la cadena en partes con el caracter ">"
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
