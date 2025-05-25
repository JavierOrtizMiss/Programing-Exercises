import java.util.Scanner; // Importa la clase Scanner para entrada de datos (aunque no se usa en esta clase).

// Clase que representa un nodo en un árbol binario de búsqueda.
class BSTNode
{
    BSTNode left, right; // Referencias a los nodos hijo izquierdo y derecho.
    int data; // Dato almacenado en el nodo.

    // Constructor por defecto: inicializa los hijos como null y el dato como 0.
    public BSTNode()
    {
        left = null; // Nodo izquierdo inicializado como null.
        right = null; // Nodo derecho inicializado como null.
        data = 0; // Dato inicializado como 0.
    }
    
    // Constructor que inicializa el nodo con un valor específico.
    public BSTNode(int n)
    {
        left = null; // Nodo izquierdo inicializado como null.
        right = null; // Nodo derecho inicializado como null.
        data = n; // Dato inicializado con el valor proporcionado.
    }
    
    // Establece el nodo hijo izquierdo.
    public void setLeft(BSTNode n)
    {
        left = n; // Asigna el nodo proporcionado como hijo izquierdo.
    }
     
    // Establece el nodo hijo derecho.
    public void setRight(BSTNode n)
    {
        right = n; // Asigna el nodo proporcionado como hijo derecho.
    }
    
    // Obtiene el nodo hijo izquierdo.
    public BSTNode getLeft()
    {
        return left; // Devuelve el nodo hijo izquierdo.
    }
    
    // Obtiene el nodo hijo derecho.
    public BSTNode getRight()
    {
        return right; // Devuelve el nodo hijo derecho.
    }
    
    // Establece el dato almacenado en el nodo.
    public void setData(int d)
    {
        data = d; // Asigna el valor proporcionado al dato del nodo.
    }
    
    // Obtiene el dato almacenado en el nodo.
    public int getData()
    {
        return data; // Devuelve el dato almacenado en el nodo.
    }     
}