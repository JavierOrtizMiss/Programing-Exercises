// Creamos una clase Node para representar un nodo en una lista doblemente enlazada.
class Node
{
    protected int data;
    protected Node prev;
    protected Node next;

    // Constructor de la clase Node
    public Node()
    {
        prev = null;
        next = null;
        data = 0;
    }    

    public Node(int d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }

    // Método setter para establecer el nodo siguiente
    public void setNext(Node n)
    {
        next = n;
    }    

    // Método setter para establecer el nodo anterior
    public void setPrev(Node p)
    {
        prev = p;
    }

    // Método setter para establecer el dato del nodo
    public void setData(int d)
    {
        data = d;
    }  

    // Método getter para obtener el nodo siguiente
    public Node getNext()
    {
        return next;
    }    

    // Método getter para obtener el nodo anterior
    public Node getPrev()
    {
        return prev;
    }

    // Método getter para obtener el dato del nodo
    public int getData()
    {
        return data;
    }

    
}