class linkedList // Definimos la clase "linkedList", que representa una lista circular simplemente enlazada.
{
    protected Node start; // Nodo que apunta al inicio de la lista.
    protected Node end;   // Nodo que apunta al final de la lista.
    public int size;      // Variable que almacena el tamaño de la lista.
 
    // Constructor: inicializa la lista como vacía.
    public linkedList()
    {
        start = null; // La lista comienza vacía, sin un nodo inicial.
        end = null;   // El nodo final también es nulo.
        size = 0;     // El tamaño de la lista comienza en 0.
    }
    
    // Método que verifica si la lista está vacía.
    public boolean isEmpty()
    {
        return start == null; // Retorna true si no hay nodos en la lista.
    }
    
    // Método que devuelve el tamaño actual de la lista.
    public int getSize()
    {
        return size;
    }
    
    // Método para insertar un nodo al inicio de la lista.
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null); // Se crea un nuevo nodo con el valor dado.
        nptr.setLink(start); // El nuevo nodo apunta al nodo que era el inicio.
        
        if(start == null) // Si la lista está vacía
        {            
            start = nptr; // El nuevo nodo se convierte en el inicio.
            nptr.setLink(start); // Se enlaza consigo mismo, formando una lista circular.
            end = start; // El nodo final también es el mismo.
        }
        else
        {
            end.setLink(nptr); // El último nodo apunta al nuevo nodo.
            start = nptr; // El nuevo nodo ahora es el inicio de la lista.
        }
        size++; // Incrementamos el tamaño de la lista.
    }
    
    // Método para insertar un nodo al final de la lista.
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val, null); // Se crea un nuevo nodo con el valor dado.
        nptr.setLink(start); // El nuevo nodo apuntará al inicio para mantener la circularidad.
        
        if(start == null) // Si la lista está vacía
        {            
            start = nptr; // El nuevo nodo se convierte en el inicio.
            nptr.setLink(start); // Se enlaza consigo mismo.
            end = start; // El nodo final también es el mismo.
        }
        else
        {
            end.setLink(nptr); // El último nodo apunta al nuevo nodo.
            end = nptr; // El nuevo nodo ahora es el final de la lista.
        }
        size++; // Incrementamos el tamaño de la lista.
    }
    
    // Método para insertar un nodo en una posición específica.
    public void insertAtPos(int val, int pos) 
    {
        Node nptr = new Node(val, null); // Se crea un nuevo nodo con el valor dado.
        Node ptr = start; // Puntero que recorrerá la lista.
        pos = pos - 1; // Ajustamos la posición para acceder correctamente al nodo anterior.
        
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink(); // Guardamos el nodo siguiente en una variable temporal.
                ptr.setLink(nptr); // Insertamos el nuevo nodo después del nodo actual.
                nptr.setLink(tmp); // El nuevo nodo apunta al nodo que antes era el siguiente.
                break;
            }
            ptr = ptr.getLink(); // Avanzamos al siguiente nodo.
        }
        size++; // Incrementamos el tamaño de la lista.
    }
    
    // Método para insertar un nodo manteniendo la lista ordenada.
    public void insert(int val)
    {
        Node nptr, ptr, tmp = null;
        nptr = new Node(val, null); // Se crea un nuevo nodo con el valor dado.
        boolean ins = false; // Variable para verificar si se ha insertado el nodo.
        
        if (start == null) // Si la lista está vacía
        {
            start = nptr; // El nuevo nodo se convierte en el primer nodo.
            nptr.setLink(start); // Se enlaza consigo mismo para mantener la circularidad.
            end = start; // Como es el único nodo, también es el último.
        }
        else if (val <= start.getData()) // Si el valor es menor o igual al inicio
        {
            nptr.setLink(start); // Se enlaza el nuevo nodo con el nodo inicial actual.
            end.setLink(nptr); // Se mantiene la circularidad enlazando el último nodo con el nuevo nodo.
            start = nptr; // Se actualiza el inicio de la lista.
        }
        else if (val >= end.getData()) // Si el valor es mayor o igual al final
        {
            end.setLink(nptr); // Se enlaza el último nodo con el nuevo nodo.
            nptr.setLink(start); // Se enlaza el nuevo nodo con el inicio para mantener la circularidad.
            end = nptr; // Se actualiza el puntero 'end' al nuevo nodo insertado.
        }
        else // Si el nodo debe insertarse en una posición intermedia
        {
            tmp = start; // Se inicia desde el primer nodo.
            ptr = start.getLink(); // Se apunta al segundo nodo.

            // Se recorre la lista hasta encontrar la posición correcta para insertar el nodo.
            while (tmp != end)
            {
                // Si el valor está entre dos nodos, se inserta en esa posición.
                if (val >= tmp.getData() && val <= ptr.getData())
                {
                    tmp.setLink(nptr); // Se enlaza el nodo actual con el nuevo nodo.
                    nptr.setLink(ptr); // Se enlaza el nuevo nodo con el siguiente nodo.
                    ins = true; // Se marca como insertado.
                    break; // Se termina el bucle.
                }
                else // Si aún no se encuentra la posición adecuada, se avanza en la lista.
                {
                    tmp = ptr; // Se mueve el puntero al siguiente nodo.
                    ptr = ptr.getLink(); // Se mueve al nodo siguiente.
                }
            }
            
            // Si por alguna razón no se insertó dentro del bucle, se enlaza al final.
            if (!ins)
            {
                tmp.setLink(nptr);
            }
        }
        size++; // Se incrementa el tamaño de la lista.
    }

    // Método para eliminar un nodo en una posición específica.
    public void deleteAtPos(int pos)
    {    
        if (size == 1 && pos == 1) // Si solo hay un nodo y se quiere eliminar
        {
            start = null; // Se elimina el nodo, dejando la lista vacía.
            end = null;
            size = 0;
            return;
        }        
        if (pos == 1) // Si se quiere eliminar el primer nodo
        {
            start = start.getLink(); // Se actualiza el inicio de la lista.
            end.setLink(start); // Se mantiene la circularidad.
            size--; 
            return;
        }
        if (pos == size) // Si se quiere eliminar el último nodo
        {
            Node s = start;
            Node t = start;
            while (s != end) // Se recorre la lista hasta el penúltimo nodo.
            {
                t = s;
                s = s.getLink();
            }
            end = t; // Se actualiza el puntero 'end'.
            end.setLink(start); // Se mantiene la circularidad.
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1; // Se ajusta la posición para recorrer la lista.
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) // Cuando se encuentra el nodo anterior al que se quiere eliminar
            {
                Node tmp = ptr.getLink(); // Se apunta al nodo a eliminar.
                tmp = tmp.getLink(); // Se salta el nodo a eliminar.
                ptr.setLink(tmp); // Se enlaza el nodo anterior con el siguiente.
                break;
            }
            ptr = ptr.getLink(); // Se avanza en la lista.
        }
        size--; // Se reduce el tamaño de la lista.
    }

    // Método para mostrar los elementos de la lista.
    public void display()
    {
        System.out.print("\nLista circular simple ligada = ");
        Node ptr = start;
        if (size == 0) 
        {
            System.out.print("Lista circular vacía\n");
            return;
        }
        if (start.getLink() == start) 
        {
            System.out.print(start.getData()+ "->"+ptr.getData()+ "\n");
            return;
        }
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != start) 
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "->");
        ptr = ptr.getLink();
        System.out.print(ptr.getData()+ "\n");
    }
}
