package model.Queue;
import controller.exceptions.QueueEmptyException;
import model.ListImplement.LinkedListImplement;
import controller.exceptions.QueueEmptyException;

/**
 * Implementación de una cola utilizando una lista enlazada.
 */
public class QueueImplement {
    private LinkedListImplement queue;

    public QueueImplement(){
        queue = new LinkedListImplement();
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * Obtiene el tamaño de la cola.
     * @return Número de elementos en la cola.
     */
    public int getSize(){
        return queue.getSize();
    }

    /**
     * Inserta un valor al final de la cola.
     * @param value Valor a insertar.
     */
    public void enqueue(int value) {
        queue.insertAtEnd(value);
    }

    /**
     * Elimina y devuelve el valor al frente de la cola.
     * @return Valor eliminado.
     * @throws QueueEmptyException Si la cola está vacía.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        int data = queue.getStart().getData();
        queue.deleteAtStart();
        return data;
    }

    /**
     * Obtiene el valor al frente de la cola sin eliminarlo.
     * @return Valor al frente de la cola.
     * @throws QueueEmptyException Si la cola está vacía.
     */
    public int peek() {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return queue.getStart().getData();
    }

}
