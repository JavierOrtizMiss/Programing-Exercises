import java.util.Scanner;

public class dequeImplement
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Deque Implement\n");
        System.out.println("Enter Size of Integer Queue ");
        int n = scan.nextInt();
        
        Deque q = new Deque(n);        
        /* Perform Queue Operations */        
        char ch;
        do{
            System.out.println("\nDeque Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter in which end you want to insert (1. Front, 2. Rear)");

                if (scan.nextInt() == 1) {
                    System.out.println("Enter integer element to insert");
                    try
                    {
                        q.insertfront( scan.nextInt() );
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : " +e.getMessage());
                    }                         
                } else {
                    System.out.println("Enter integer element to insert");
                    try
                    {
                        q.insertrear( scan.nextInt() );
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : " +e.getMessage());
                    }
                    
                }                        
                break;                         
            case 2 : 
                System.out.println("Enter in which end you want to remove (1. Front, 2. Rear)");
                if (scan.nextInt() == 1) {
                    try
                    {
                        q.deletefront();
                        System.out.println("Removed Element from front");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : " +e.getMessage());
                    }
                } else {
                    try
                    {
                        q.deleterear();
                        System.out.println("Removed Element from rear");

                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : " +e.getMessage());
                    }
                    
                }
                break;                         
            case 3 : 
                System.out.println("Enter in which end you want to peek (1. Front, 2. Rear)");
                if (scan.nextInt() == 1) {
                    try
                    {
                        System.out.println("Peek Element from front = "+q.getFront());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : "+e.getMessage());
                    }
                } else {
                    try
                    {
                        System.out.println("Peek Element from rear = "+q.getRear());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error : "+e.getMessage());
                    }
                    
                }
                break;                            
            case 4 : 
                System.out.println("Empty status = "+q.isEmpty());
                break;                
            case 5 : 
                System.out.println("Full status = "+q.isFull());
                break;                          
            case 6 : 
                System.out.println("Size = "+ q.getSize());
                break;                         
            default : System.out.println("Wrong Entry \n ");
                break;
            }
            /* display Queue */
            q.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                                                        
    }    
}