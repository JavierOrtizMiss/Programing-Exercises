//Clase en la cual nos permitirá hacer la función de una lista enlazada simple
class linkedList
{
    //Creamos una variable llamada "start" en la cual será el inicio de la lista (o la cabeza) y esta será de tipo Node
    protected Node start;
    //Creamos una variable llamada "end" en la cual será el final de la lista (o la cola) y esta será de tipo Node
    protected Node end ;
    //Creamos una variable llamada "size" en la cual será el tamaño de la lista y esta será de tipo entero
    public int size ;
 
    //Constructor de la clase linkedList. En el constructor inicializamos las variables "start" y "end" en null, ya que no sabemos que nodo será el inicio y el final, y la variable "size" en 0, ya que no hay nodos en la lista
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    //Método en el cual devolverá un valor booleano, este método nos servirá para saber si la lista está vacía o no. Es un método en el cual si la cabeza o el inicio del nodo es nulo es porque no hay nodos en la lista, por lo tanto, la lista está vacía

    public boolean isEmpty()
    {
        return start == null;
    }

    //Método en el cual devolverá un entero, este método nos servirá para obtener el tamaño de la lista, es decir, cuantos nodos hay en la lista
    public int getSize()
    {
        return size;
    }    


    //Método en el cual insertará un nodo al inicio de la lista, este método recibirá un valor entero llamado "val" en el cual será el dato del nodo que se creará, y este método no devolverá nada
    public void insertAtStart(int val)
    {   
        //Instanciamos un nodo llamado "nptr" de tipo Node, en el cual será un nuevo nodo con el dato "val" y el link en null (ya que no sabemos si hay algún nodo en la lista, por lo tanto nos conveiene por ahora que no apunte a nada)
        Node nptr = new Node(val, null);    
        //Incrementamos el tamaño de la lista ya que estamos insertando un nodo
        size++ ;    
        
        //Si el inicio de la lista es nulo, es decir, que no hay nodos en la lista, entonces el nodo que acabamos de crear será el inicio y el final de la lista
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        //Si hay nodos en la lista, entonces el nodo que acabamos de crear será el inicio de la lista y el link de este nodo apuntará al nodo que era el inicio de la lista.
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    //Método en el cual insertará un nodo al final de la lista, este método recibirá un valor entero llamado "val" en el cual será el dato del nodo que se creará.
    public void insertAtEnd(int val)
    {
        //Instanciamos un nodo como habíamos hecho para insertar al inicio, pero en este caso el nodo que crearemos será el final de la lista.
        Node nptr = new Node(val,null);    
        //Incrementamos el tamaño de la lista ya que estamos insertando un nodo
        size++ ; 
        
        //Comprabmos como en el de inicio si la lista está vacía, si está vacía, entonces el nodo que acabamos de crear será el inicio y el final de la lista
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        //Si hay nodos en la lista, entonces el nodo que acabamos de crear será el final de la lista y el link del nodo que era el final de la lista apuntará al nodo que acabamos de crear (null)
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }

    //Método en el cual insertará un nodo en una posición específica, este método recibirá un valor entero llamado "val" en el cual será el dato del nodo que se creará, y un valor entero llamado "pos" en el cual será la posición en la cual se insertará el nodo
    public void insertAtPos(int val , int pos)
    {
        //Instanciamos un nodo como habíamos hecho antes
        Node nptr = new Node(val, null);
        //Creamos un nodo auxiliar el cual nos servirá para ir recorriendo la lista, y le asignamos el inicio de la lista           
        Node ptr = start;
        //Creamos una variable pos el cual siempre será la posición menos 1, ya que en las listas enlazadas la posición siempre empieza en 1 y esta variable nos servirá como apuntador de la posición anterior al nodo donde lo queremos insertar
        pos = pos - 1 ;
        //Recorremos la lista
        for (int i = 1; i < size; i++) 
        {
            //Condición que nos dice si la posición i es igual a la posición en la cual queremos insertar el nodo entonces..
            if (i == pos) 
            {
                //Creamos un nodo auxiliar el cual nos servirá para guardar el enlace del nodo que está en la posición i, es decir, que donde está apuntando nuestro nodo ptr guardamos ese link en la variable tmp de tipo Node
                Node tmp = ptr.getLink() ;
                //El link del nodo que está en la posición i apuntará al nodo que acabamos de crear
                ptr.setLink(nptr);
                //El link del nodo que acabamos de crear apuntará al nodo que estaba guardado en la variable tmp
                nptr.setLink(tmp);
                //Salimos del ciclo
                break;
            }
            //Si no se cumple la condición, entonces el nodo auxiliar ptr apuntará al siguiente nodo
            ptr = ptr.getLink();
        }
        //Incrementamos el tamaño de la lista ya que estamos insertando un nodo
        size++ ;
    }
    //Método en el cual insertará un nodo en orden, este método recibirá un valor entero llamado "val" en el cual será el dato del nodo que se creará
    public void insert(int val)
    {
        //Creamos nodos que nos ayudarán a recorrer la lista, "nptr" será el nodo que crearemos, "ptr" será el nodo que nos ayudará a recorrer la lista y "tmp" será un nodo auxiliar que nos ayudará como referencia para insertar el nodo en la posición correcta, y si inicializamos en null porque no sabemos si la lista está vacía o no
        Node nptr, ptr, tmp = null;
        //Instanciamos un nodo como habíamos hecho antes
        nptr = new Node(val, null);

        //Creamos una variable booleana llamada "ins" en la cual nos servirá para saber si el nodo se insertó o no
        boolean ins = false;
        
        //Si la lista está vacía, entonces el nodo que acabamos de crear será el inicio de la lista
        if (start == null)
           start = nptr;
        //Si el dato del nodo que acabamos de crear es menor o igual al dato del nodo que está en el inicio de la lista, entonces el nodo que acabamos de crear será el inicio de la lista y el link de este nodo apuntará al nodo que estaba en el inicio de la lista
        else if (val <= start.getData())
        {
            nptr.setLink(start);
            start = nptr;
        }
        
        else
        {
            //El nodo auxiliar tmp apuntará al inicio de la lista
            tmp = start;
            //El nodo ptr apuntará al siguiente nodo del nodo auxiliar tmp
            ptr = start.getLink();
            //Recorremos la lista
            while(ptr != null)
            {
                //Si el dato del nodo que acabamos de crear es mayor o igual al dato del nodo que está en el nodo auxiliar tmp y el dato del nodo que acabamos de crear es menor o igual al dato del nodo que está en el nodo ptr, entonces..
                if (val >= tmp.getData() && val <= ptr.getData())
                {
                    //El link del nodo que está en el nodo auxiliar tmp apuntará al nodo que acabamos de crear
                    tmp.setLink(nptr);
                    //El link del nodo que acabamos de crear apuntará al nodo que está en el nodo ptr
                    nptr.setLink(ptr);
                    //Salimos del ciclo
                    ins = true;
                    break;
                }
                else
                {
                    //El nodo auxiliar tmp apuntará al nodo que está en el nodo ptr
                    tmp = ptr;
                    //El nodo ptr apuntará al siguiente nodo
                    ptr = ptr.getLink();
                }
            }
            //Si la variable ins es falsa, entonces el link del nodo que está en el nodo auxiliar tmp apuntará al nodo que acabamos de crear
            if (ins == false)
            {
                tmp.setLink(nptr);
            }
        }
        size++;
    }
    
    //Método en el cual eliminará un nodo en una posición específica, este método recibirá un valor entero llamado "pos" en el cual será la posición en la cual se eliminará el nodo
    public void deleteAtPos(int pos)
    {       
        //Si pos es igual a 1, entonces el inicio de la lista apuntará al siguiente nodo y decrementamos el tamaño de la lista 
        if (pos == 1) 
        {

            start = start.getLink();
            size--; 
            return ;
        }
        //Si pos es igual al tamaño de la lista, entonces el nodo auxiliar "s" apuntará al inicio de la lista y el nodo auxiliar "t" apuntará al inicio de la lista, y recorreremos la lista hasta que el nodo "s" sea diferente al nodo "end", entonces el nodo "t" apuntará al nodo "s" y el nodo "s" apuntará al siguiente nodo, y el final de la lista será el nodo "t" y el link de este nodo apuntará a nulo, y decrementamos el tamaño de la lista
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        //Creamos un nodo auxiliar "ptr" el cual nos servirá para recorrer la lista y apuntará al inicio de la lista, y la variable "pos" siempre será la posición menos 1
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }    
    public void display()
    {
        System.out.print("\nLista Simple Ligada = ");
        if (size == 0) 
        {
            System.out.print("Vacía\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}