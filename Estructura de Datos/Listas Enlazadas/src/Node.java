//Creamos una clase Node para representar un nodo en una lista enlazada simple.
class Node
{
    //Creamos una variable llamada "data" en el cual estará el dato del nodo
    protected int data;
    //Creamos una variable llamada "link" en el cual estará el enlace al siguiente nodo
    protected Node link;
 
    //Constructor de la clase Node
    public Node()
    {
        //Inicializamos la variable "link" en null, ya que no sabemos a que nodo apuntará, y así que pues mejor por defecto, osea, que no apunte a nada (Esto nos servirá para métodos como insertar al inicio o al final)
        link = null;
        //Inicializamos la variable "data" en 0, ya que no sabemos que dato tendrá el nodo pero en este caso es de tipo entero, y por defecto ponemos 0 para decir que está vacío sus datos
        data = 0;
    }    

    //Constructor de la clase Node, pero en este se pasaran parametros como variables, esto nos servirá para poder crear un nodo o instanciar la clase nodo en el cual recibiará esta instancia con un dato y un enlace, vaya, como formato de lista enlazada
    public Node(int d,Node n)
    {
        //Asignamos el valor de la variable "d" a la variable "data"
        data = d;
        //Asignamos el valor de la variable "n" a la variable "link"
        link = n;
    }    

   //Método setter en el cual no devolverá nada, simplemente este método recibira la variable n de tipo Node y le asignara o "apuntará" hacia un nodo, es decir, que el enlace de este nodo apuntará a otro nodo.
    public void setLink(Node n)
    {
        link = n;
    }    

    //Método setter en el cual recibirá una variable d que su función es asingarle un valor a la variable "data" de este nodo
    public void setData(int d)
    {
        data = d;
    }  
    //Método getter en el cual devolverá un nodo, este método nos servirá para obtener el enlace de un nodo
    public Node getLink()
    {
        return link;
    }    

    //Método getter en el cual devolverá un entero, este método nos servirá para obtener el dato de un nodo
    public int getData()
    {
        return data;
    }
}