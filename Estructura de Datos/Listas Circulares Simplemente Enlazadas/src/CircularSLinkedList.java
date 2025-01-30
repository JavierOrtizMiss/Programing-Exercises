
import java.util.Scanner;


public class CircularSLinkedList
{    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Lista Circular Simple Ligada \n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nOperaciones de la Lista Circular Simple Ligada\n");
            System.out.println("1. inserta al principio");
            System.out.println("2. inserta al final");
            System.out.println("3. inserta en la posición");
            System.out.println("4. elimina de la posición");
            System.out.println("5. verifica si la lista circular está vacía");
            System.out.println("6. tamaño");
            System.out.println("7. inserta ordenadamente");            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Proporciona el entero a insertar");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Proporciona el entero a inserar");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Proporciona el entero a insertar");
                int num = scan.nextInt() ;
                System.out.println("Proporciona posición");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("posición no válida\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Proporciona la posición");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("posición no válida\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("La lista está vacía ? = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Tamaño = "+ list.getSize() +" \n");
                break;
            case 7 :
                System.out.println("Captura el elemento entero a insertar con orden");
                list.insert( scan.nextInt() );
                break;
             default : 
                System.out.println("Opción no válida \n ");
                break;   
            }
            list.display();
            System.out.println("\n Deseas continuaar ( s o n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'S'|| ch == 's');                    
    } 
}