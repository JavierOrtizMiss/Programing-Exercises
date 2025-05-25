class AVLNode
{    
    AVLNode left, right; // Referencias a los nodos hijo izquierdo y derecho
    int data; // Valor almacenado en el nodo
    int height; // Altura del nodo

    // Constructor por defecto
    public AVLNode()
    {
        left = null; // Inicializa el hijo izquierdo como nulo
        right = null; // Inicializa el hijo derecho como nulo
        data = 0; // Inicializa el dato en 0
        height = 0; // Inicializa la altura en 0
    }

    // Constructor con parámetro
    public AVLNode(int n)
    {
        left = null; // Inicializa el hijo izquierdo como nulo
        right = null; // Inicializa el hijo derecho como nulo
        data = n; // Asigna el valor recibido al dato
        height = 0; // Inicializa la altura en 0
    }     
}