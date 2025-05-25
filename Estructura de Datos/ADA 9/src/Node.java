// Importa la clase Scanner para la entrada de datos desde el usuario
import java.util.Scanner;

// Definición de la clase Node para representar un nodo en una lista doblemente enlazada
class Node
{
    // Datos almacenados en el nodo
    protected int data;
    // Referencias al siguiente y al nodo previo en la lista
    protected Node next, prev;
  
    // Constructor por defecto (crea un nodo vacío sin enlaces y con data = 0)
    public Node()
    {
        next = null;  // No apunta a ningún siguiente nodo
        prev = null;  // No apunta a ningún nodo previo
        data = 0;     // El valor del nodo es 0 por defecto
    }
   
    // Constructor con parámetros para inicializar el nodo con valores específicos
    public Node(int d, Node n, Node p)
    {
        data = d;  // Se asigna el valor del nodo
        next = n;  // Se asigna el enlace al siguiente nodo
        prev = p;  // Se asigna el enlace al nodo previo
    }
    
    // Método para establecer el enlace al siguiente nodo
    public void setLinkNext(Node n)
    {
        next = n;
    }
    
    // Método para establecer el enlace al nodo previo
    public void setLinkPrev(Node p)
    {
        prev = p;
    }    

    // Método para obtener el siguiente nodo en la lista
    public Node getLinkNext()
    {
        return next;
    }
   
    // Método para obtener el nodo previo en la lista
    public Node getLinkPrev()
    {
        return prev;
    }
   
    // Método para establecer el dato del nodo
    public void setData(int d)
    {
        data = d;
    }
  
    // Método para obtener el dato almacenado en el nodo
    public int getData()
    {
        return data;
    }
}
