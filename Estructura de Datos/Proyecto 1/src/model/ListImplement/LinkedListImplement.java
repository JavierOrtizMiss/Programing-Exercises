package model.ListImplement;

/**
 * Implementación de una lista enlazada simple.
 */
public class LinkedListImplement {
    private Node start;
    private Node end;
    public int size;

    public LinkedListImplement(){
        start = null;
        end = null;
        size = 0;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty(){
        return start == null;
    }

    /**
     * Obtiene el tamaño de la lista.
     * @return Número de elementos en la lista.
     */
    public int getSize(){
        return size;
    }

    /**
     * Inserta un valor al inicio de la lista.
     * @param val Valor a insertar.
     */
    public void insertAtStart(int val){
        Node nptr = new Node(val, null);    
        size++;    
        if(start == null){    
            start = nptr;
            end = start;    
        } else {
            nptr.setLink(start);    
            start = nptr;    
        }
    }

    /**
     * Inserta un valor en una posición específica de la lista.
     * @param val Valor a insertar.
     * @param pos Posición donde se insertará el valor (1-indexado).
     */
    public void insertAtPos(int val, int pos){
        Node nptr = new Node(val, null);    
        Node ptr = start;    
        pos = pos - 1 ;
        for (int i = 1; i < size; i++){    
            if (i == pos){    
                Node tmp = ptr.getLink() ;    
                ptr.setLink(nptr);    
                nptr.setLink(tmp);    
                break;    
            }    
            ptr = ptr.getLink();    
        }    
        size++ ;
    }

    /**
     * Inserta un valor al final de la lista.
     * @param val Valor a insertar.
     */
    public void insertAtEnd(int val){
        Node nptr = new Node(val, null);    
        size++;    
        if(start == null){    
            start = nptr;
            end = start;    
        } else {
            end.setLink(nptr);    
            end = nptr;    
        }
    }

    /**
     * Elimina el último elemento de la lista.
     */
    public void deleteAtEnd(){
        if(start == null){  
            return;
        }
        if(start.getLink() == null){  
            start = null;
            end = null;
        } else {
            Node ptr = start;
            while(ptr.getLink() != end){  
                ptr = ptr.getLink();
            }
            end = ptr;  
            end.setLink(null);  
        }
        size--;  
    }

    /**
     * Elimina el primer elemento de la lista.
     */
    public void deleteAtStart(){
        if(start == null){  
            return;
        }
        start = start.getLink();  
        if(start == null){  
            end = null;
        }
        size--;  
    }

    /**
     * Obtiene el nodo al final de la lista.
     * @return Nodo final de la lista.
     */
    public Node getEnd(){
        return end;
    }

    /**
     * Obtiene el nodo al inicio de la lista.
     * @return Nodo inicial de la lista.
     */
    public Node getStart(){
        return start;
    }

}
