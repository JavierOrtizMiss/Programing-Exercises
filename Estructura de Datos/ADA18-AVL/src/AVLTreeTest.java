import java.util.Scanner; // Importa la clase Scanner para entrada de usuario

public class AVLTreeTest
{
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        AVLTree avlt = new AVLTree(); // Crea una instancia del árbol AVL

        System.out.println("Árbol AVL Test\n"); // Mensaje de bienvenida
        char ch; // Variable para controlar la continuación del ciclo

        do    
        {
            System.out.println("\nOperaciones en Árbol AVL\n"); // Muestra las opciones del menú
            System.out.println("1. insertar ");
            System.out.println("2. buscar");
            System.out.println("3. contar nodos");
            System.out.println("4. está vacío");
            System.out.println("5. limpiar árbol");

            int choice = scan.nextInt(); // Lee la opción elegida por el usuario
            switch (choice)
            {
                case 1 : 
                    System.out.println("Proporciona el elemento entero a insertar"); // Solicita el valor a insertar
                    avlt.insert( scan.nextInt() ); // Inserta el valor en el árbol
                    break;                          
                case 2 : 
                    System.out.println("Proporciona el elemento entero a buscar"); // Solicita el valor a buscar
                    System.out.println("Resultado de búsqueda : "+ avlt.search( scan.nextInt() )); // Muestra el resultado de la búsqueda
                    break;                                          
                case 3 : 
                    System.out.println("Nodos = "+ avlt.countNodes()); // Muestra el número de nodos en el árbol
                    break;     
                case 4 : 
                    System.out.println("Está vacío = "+ avlt.isEmpty()); // Indica si el árbol está vacío
                    break;     
                case 5 : 
                    System.out.println("\nÁrbol eliminado"); // Mensaje de árbol eliminado
                    avlt.makeEmpty(); // Vacía el árbol
                    break;         
                default : 
                    System.out.println("Opción no válida \n "); // Mensaje para opción inválida
                    break;   
            }

            System.out.print("\nPost order : ");
            avlt.postorder(); // Muestra el recorrido postorden
            System.out.print("\nPre order : ");
            avlt.preorder(); // Muestra el recorrido preorden
            System.out.print("\nIn order : ");
            avlt.inorder(); // Muestra el recorrido inorden

            System.out.println("\nDeseas continuar (Type s o n) \n"); // Pregunta si desea continuar
            ch = scan.next().charAt(0); // Lee la respuesta del usuario
        } while (ch == 'S'|| ch == 's'); // Repite mientras el usuario escriba 's' o 'S'
    }
}