// Definición de la clase linkedList para representar una lista doblemente enlazada circular
class linkedList
{ 
    // Nodo inicial de la lista
    protected Node start;
    // Nodo final de la lista
    protected Node end;
    // Tamaño de la lista 
    public int size;
 
    // Constructor de la clase
    public linkedList()
    {
        start = null;  // Inicializar el inicio de la lista
        end = null;    // Inicializar el final de la lista
        size = 0;      // Inicializar el tamaño de la lista
    }
    
    // Método que verifica si la lista está vacía
    public boolean isEmpty()
    {
        return start == null; // Devuelve true si no hay nodos en la lista y establece el inicio con nada
    }
    
    // Método que devuelve el tamaño de la lista
    public int getSize()
    {
        return size; //Solo llama a la variable size
    }
    
    // Método para insertar un nodo al inicio de la lista
    public void insertAtStart(int val)
    {
        // Se crea un nuevo nodo con el valor dado y sin enlaces
        Node nptr = new Node(val, null, null);    
        
        // Si la lista está vacía
        if (start == null)
        {            
            nptr.setLinkNext(nptr); // Se enlaza al siguiente nodo
            nptr.setLinkPrev(nptr); // Se enlaza al anterior nodo
            start = nptr;  // El inicio de la lista apunta a este nodo
            end = start;    // El final de la lista también apunta al mismo nodo
        }
        else
        {
            nptr.setLinkPrev(end);    // El nuevo nodo apunta al nodo final 
            end.setLinkNext(nptr);    // El nodo final apunta al nuevo nodo como siguiente
            start.setLinkPrev(nptr);  // El nodo inicial apunta al nuevo nodo como previo
            nptr.setLinkNext(start);  // El nuevo nodo apunta al inicio de la lista
            start = nptr;             // Ahora el inicio de la lista es el nuevo nodo
        }
        size++; // Se incrementa el tamaño de la lista
    }
    
    // Método para insertar un nodo al final de la lista
    public void insertAtEnd(int val)
    {
        // Se crea un nuevo nodo con el valor dado
        Node nptr = new Node(val, null, null);        
        
        // Si la lista está vacía, se inserta el primer nodo
        if (start == null)
        {
            nptr.setLinkNext(nptr);
            nptr.setLinkPrev(nptr);
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLinkPrev(end);    // El nuevo nodo apunta al nodo final 
            end.setLinkNext(nptr);    // El nodo final apunta al nuevo nodo como siguiente
            start.setLinkPrev(nptr);  // El nodo inicial apunta al nuevo nodo 
            nptr.setLinkNext(start);  // El nuevo nodo apunta al inicio de la lista
            end = nptr;               // Ahora el final de la lista es el nuevo nodo
        }
        size++; // Se incrementa el tamaño de la lista
    }
    
    // Método para insertar un nodo en una posición específica
    public void insertAtPos(int val, int pos)
    {
        // Se crea un nuevo nodo con el valor dado
        Node nptr = new Node(val, null, null);    
        
        // Si la posición es la primera, se inserta al inicio
        if (pos == 1)
        {
            insertAtStart(val);
            return;
        }            
        
        Node ptr = start; // Se usa un puntero para recorrer la lista
        
        // Se recorre la lista hasta la posición deseada
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLinkNext();  // Se obtiene el siguiente nodo
                ptr.setLinkNext(nptr);         // Se enlaza el nodo actual con el nuevo
                nptr.setLinkPrev(ptr);         // El nuevo nodo apunta al anterior
                nptr.setLinkNext(tmp);         // El nuevo nodo apunta al siguiente
                tmp.setLinkPrev(nptr);         // El siguiente nodo apunta al nuevo nodo
            }
            ptr = ptr.getLinkNext();            
        }
        size++; // Se incrementa el tamaño de la lista
    }
   
    // Método para eliminar un nodo en una posición específica
    public void deleteAtPos(int pos)
    {        
        // Si se quiere eliminar el primer nodo
        if (pos == 1) 
        {
            // Si hay un solo nodo en la lista, se vacía completamente
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return; 
            }
            start = start.getLinkNext(); // El nuevo inicio será el siguiente nodo
            start.setLinkPrev(end);      // Se enlaza el nuevo inicio con el final
            end.setLinkNext(start);      // Se enlaza el final con el nuevo inicio
            size--; // Se reduce el tamaño de la lista
            return;
        }
        
        // Si se quiere eliminar el último nodo
        if (pos == size)
        {
            end = end.getLinkPrev(); // El nuevo final será el nodo anterior
            end.setLinkNext(start);  // Se enlaza el nuevo final con el inicio
            start.setLinkPrev(end);  // Se enlaza el inicio con el nuevo final
            size--; // Se reduce el tamaño de la lista
            return;
        }

        // Se usa un puntero para recorrer la lista desde el segundo nodo
        Node ptr = start.getLinkNext();
        
        // Se recorre la lista hasta la posición deseada
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrev(); // Nodo anterior
                Node n = ptr.getLinkNext(); // Nodo siguiente

                p.setLinkNext(n); // Se enlaza el anterior con el siguiente
                n.setLinkPrev(p); // Se enlaza el siguiente con el anterior
                
                size--; // Se reduce el tamaño de la lista
                return;
            }
            ptr = ptr.getLinkNext();
        }        
    }    

    // Método para mostrar los elementos de la lista
    public void display()
    {
        System.out.print("\nLista Circular Doble Liga = ");
        
        Node ptr = start; // Se usa un puntero para recorrer la lista
        
        // Si la lista está vacía
        if (size == 0) 
        {
            System.out.print("Vacía\n");
            return;
        }
        
        // Si la lista tiene un solo nodo
        if (start.getLinkNext() == start) 
        {
            System.out.print(start.getData() + " <-> " + ptr.getData() + "\n");
            return;
        }
        
        // Se imprime el primer nodo
        System.out.print(start.getData() + " <-> ");
        
        ptr = start.getLinkNext(); // Se avanza al siguiente nodo
        
        // Se recorre la lista hasta volver al inicio
        while (ptr.getLinkNext() != start) 
        {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        
        // Se imprime el último nodo y el inicio nuevamente para cerrar el ciclo
        System.out.print(ptr.getData() + " <-> ");
        ptr = ptr.getLinkNext();
        System.out.print(ptr.getData() + "\n");
    }
}
