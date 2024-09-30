//Importamos la carpeta donde conteiene la clase
package States;
//Importamos las librerías
import java.util.HashMap;
import java.util.Map;

//Inicializamos la clase "States"
public class States {
    private String nombre; //Declaramos el nombre de la clase
    private Map<String, String> transiciones;//Creamos un map o diccionario que tendrá clave y valor de tipo String

    //Creamos el constructor de la clase
    public States(String nombre) {
        this.nombre = nombre;
        this.transiciones = new HashMap<>();
    }
    //Método getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }
    //Creamos un método de tipo void para agregar las transiciones al diccionario
    public void agregarTransicion(String simbolo, String estadoDestino) {
        transiciones.put(simbolo, estadoDestino);
    }
    //Método para obtener el destino del automata con la función get para obtener el simbolo
    public String obtenerDestino(String simbolo) {
        return transiciones.get(simbolo);
    }
    //Método para ver si el diccionario contiene el simbolo y devuelve un valor boleano
    public boolean tieneTransicion(String simbolo) {
        return transiciones.containsKey(simbolo);
    }
}
