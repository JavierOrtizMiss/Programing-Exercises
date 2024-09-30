// src/automata/States.java
package States;

import java.util.HashMap;
import java.util.Map;

public class States {
    private String nombre;
    private Map<String, String> transiciones;

    public States(String nombre) {
        this.nombre = nombre;
        this.transiciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarTransicion(String simbolo, String estadoDestino) {
        transiciones.put(simbolo, estadoDestino);
    }

    public String obtenerDestino(String simbolo) {
        return transiciones.get(simbolo);
    }

    public boolean tieneTransicion(String simbolo) {
        return transiciones.containsKey(simbolo);
    }
}
