package model.Stack;

import java.util.EmptyStackException;
import model.ListImplement.LinkedListImplement;

/**
 * Implementación de una pila utilizando una lista enlazada.
 */
public class StackImplement {
    private LinkedListImplement stack;

    public StackImplement(){
        stack = new LinkedListImplement();
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /**
     * Obtiene el tamaño de la pila.
     * @return Número de elementos en la pila.
     */
    public int getSize(){
        return stack.getSize();
    }

    /**
     * Inserta un valor en la parte superior de la pila.
     * @param value Valor a insertar.
     */
    public void push(int value) {
        stack.insertAtEnd(value);
    }

    /**
     * Elimina y devuelve el valor en la parte superior de la pila.
     * @return Valor eliminado.
     * @throws EmptyStackException Si la pila está vacía.
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int data = stack.getEnd().getData();
        stack.deleteAtEnd();
        return data;
    }

    /**
     * Obtiene el valor en la parte superior de la pila sin eliminarlo.
     * @return Valor en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getEnd().getData();
    }
}
