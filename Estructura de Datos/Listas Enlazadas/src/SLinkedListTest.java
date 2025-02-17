
import java.util.Scanner;

public class SLinkedListTest
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Lista Ligada Simple\n");          
        char ch;
        
        do
        {
            System.out.println("\nOperaciones en una Lista Ligada Simple\n");
            System.out.println("1. inserta el inicio");
            System.out.println("2. inserta al final");
            System.out.println("3. inserta en la posición");
            System.out.println("4. elimina de la posición");
            System.out.println("5. verifica si lista esta vacía");
            System.out.println("6. tamaño de lista");
            System.out.println("7. inserta en orden");
            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Captura el elemento entero a insertar");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Captura el elemento entero a insertar");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Captura el elemento entero a insertar");
                int num = scan.nextInt() ;
                System.out.println("proporciona la posición");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("posición no válida\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("proporciona la posición");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("posición no válida\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("La lista está vacía ? "+ list.isEmpty());
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
            /*  Display List  */ 
            list.display();
            System.out.println("\nDeseas continuar (Escribe s o n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'S'|| ch == 's');               
    }
}
