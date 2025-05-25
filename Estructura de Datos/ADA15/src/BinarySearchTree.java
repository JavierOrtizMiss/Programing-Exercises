import java.util.Scanner;

public class BinarySearchTree
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        
        BST bst = new BST(); 
        System.out.println("Binary Search Tree \n");          
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nOperaciones en un Binary Search Tree\n");
            System.out.println("1. inserta ");
            System.out.println("2. elimina");
            System.out.println("3. busca");
            System.out.println("4. cuenta nodos");
            System.out.println("5. está vacío?"); 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Proporciona elemento a insertar");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Proporciona elemento a eliminar");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Proporciona elemento a buscar");
                System.out.println("Resultado de la búsqueda : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodos totales = "+ bst.countNodes());
                break;     
            case 5 :  
                System.out.println("Está vacío = "+ bst.isEmpty());
                break;            
            default : 
                System.out.println("Entrada no válida \n ");
                break;   
            }
            
            System.out.print("\nPost orden : ");
            bst.postorder();
            System.out.print("\nPre orden : ");
            bst.preorder();
            System.out.print("\nIn orden : ");
            bst.inorder();
 
            System.out.println("\nContinuar (S o N) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'S'|| ch == 's');               
    }
}
          