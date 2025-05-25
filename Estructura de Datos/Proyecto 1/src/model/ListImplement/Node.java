package model.ListImplement;

/**
 * Clase que representa un nodo en una lista enlazada.
 */
public class Node {
    private int data;
    private Node link;

    /**
     * Constructor por defecto que inicializa el nodo con valores predeterminados.
     */
    public Node() {
        link = null;
        data = 0;
    }

    /**
     * Constructor que inicializa el nodo con un valor y un enlace.
     * @param d Valor del nodo.
     * @param n Enlace al siguiente nodo.
     */
    public Node(int d, Node n){
        this.data = d;
        this.link = n;
    }

    /**
     * Establece el enlace al siguiente nodo.
     * @param n Nodo al que se enlazará.
     */
    public void setLink(Node n){
        link = n;
    }

    /**
     * Establece el valor del nodo.
     * @param d Valor a asignar.
     */
    public void setData(int d){
        data = d;
    }

    /**
     * Obtiene el enlace al siguiente nodo.
     * @return Nodo enlazado.
     */
    public Node getLink(){
        return link;
    }

    /**
     * Obtiene el valor del nodo.
     * @return Valor del nodo.
     */
    public int getData(){
        return data;
    }
}
