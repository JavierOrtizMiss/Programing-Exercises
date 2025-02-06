// Clase que representa una lista doblemente enlazada
class linkedList {
    private Node start; // Inicio de la lista
    private Node end;   // Final de la lista
    private int size;   // Tamaño de la lista

    // Constructor
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }

    // Verifica si la lista está vacía
    public boolean isEmpty() {
        return start == null;
    }

    // Obtiene el tamaño de la lista
    public int getSize() {
        return size;
    }

    // Inserta un nodo al inicio de la lista
    public void insertAtStart(int val) {
        Node nptr = new Node(val, start, null);

        if (start == null) {
            start = nptr;
            end = start;
        } else {
            start.setPrev(nptr);
            nptr.setNext(start);
            start = nptr;
        }
        size++;
    }

    // Inserta un nodo al final de la lista
    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null, end);

        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setNext(nptr);
            nptr.setPrev(end);
            end = nptr;
            
        }
    }

    // Inserta un nodo en una posición específica
    public void insertAtPos(int val, int pos) {
        Node nptr = new Node(val, null, null);

        if (pos == 1) {
            insertAtStart(val);
            return;
        }

        Node ptr = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setPrev(ptr);
                nptr.setNext(tmp);
                tmp.setPrev(nptr);
            }
            ptr = ptr.getNext();
        }
        size++;
    }

    // Elimina un nodo en una posición específica
    public void deleteAtPos(int pos) {
        if (pos == 1){

            if (size == 1){
                start = null;
                end = null;
                size = 0;
                return;
                
            }
            start = start.getNext();
            start.setPrev(null);
            size--;
            return;
        }
        if (pos == size){
            end = end.getPrev();
            end.setNext(null);
            size--;
        }
        Node ptr = start.getNext();
        for (int i = 2; i <= size; i++){
            if (i == pos){
                Node p = ptr.getPrev();
                Node n = ptr.getNext();
                p.setNext(n);
                n.setPrev(p);
                size--;
                return;
            }
            ptr = ptr.getNext();
        }
    }


    

    // Muestra la lista en orden normal
    public void displayForward() {
        System.out.print("\nLista (inicio a fin): ");
        if (isEmpty()) {
            System.out.println("Vacía");
            return;
        }

        Node ptr = start;
        while (ptr != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getNext();
        }
        System.out.println("null");
    }

    // Muestra la lista en orden inverso
    public void displayBackward() {
        System.out.print("\nLista (fin a inicio): ");
        if (isEmpty()) {
            System.out.println("Vacía");
            return;
        }

        Node ptr = end;
        while (ptr != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getPrev();
        }
        System.out.println("null");
    }
}


