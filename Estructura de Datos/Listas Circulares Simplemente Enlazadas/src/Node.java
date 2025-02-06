import java.util.Scanner; 

class Node // Definimos la clase "Node", que representará un nodo en una lista enlazada.
{
    protected int data; // Declaramos una variable entera "data", que almacenará el valor del nodo.
    protected Node link; // Declaramos una variable de tipo "Node" llamada "link", que servirá como referencia al siguiente nodo en la lista.

    // Constructor sin parámetros: inicializa un nodo con valores predeterminados.
    public Node()
    {
        link = null; // Inicializamos "link" en null, indicando que el nodo no apunta a ningún otro nodo.
        data = 0; // Inicializamos "data" en 0, estableciendo un valor predeterminado para el nodo.
    }    

    // Constructor con parámetros: permite inicializar un nodo con un valor y una referencia a otro nodo.
    public Node(int d, Node n)
    {
        data = d; // Asignamos el valor "d" a la variable "data".
        link = n; // Asignamos el nodo "n" a la variable "link", estableciendo la conexión con otro nodo.
    }    

    // Método para establecer el enlace del nodo actual a otro nodo.
    public void setLink(Node n)
    {
        link = n; // Asignamos el nodo "n" a la variable "link", cambiando la referencia al siguiente nodo.
    }    

    // Método para establecer el valor del nodo.
    public void setData(int d)
    {
        data = d; // Asignamos el valor "d" a la variable "data", cambiando el valor almacenado en el nodo.
    }    

    // Método para obtener el enlace del nodo actual.
    public Node getLink()
    {
        return link; // Retornamos el nodo al que está apuntando "link", permitiendo acceder al siguiente nodo en la lista.
    }    

    // Método para obtener el valor almacenado en el nodo.
    public int getData()
    {
        return data; // Retornamos el valor almacenado en "data", permitiendo conocer el dato del nodo.
    }
}
