import java.util.Scanner;

public class stackImplement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pila Test\n");
        System.out.println("Proporciona la capacidad de almacenamiento de la pila ");
        int n = scan.nextInt();

        /* Instancia de la clase arrayStack */
        arrayStack stk = new arrayStack(n);

        /* Invoca operaciones */
        char ch;
        do {
            System.out.println("\nOperaciones de la pila");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek (verificar el elemento en la cima)");
            System.out.println("4. está vacía?");
            System.out.println("5. está llena?");
            System.out.println("6. tamaño de la pila");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Proporciona el elemento a meter");
                    try {
                        stk.push(scan.nextInt());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Elemento sacado = " + stk.pop());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento en la cima = " + stk.peek());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Está vacía? = " + stk.isEmpty());
                    break;
                case 5:
                    System.out.println("Está llena ? = " + stk.isFull());
                    break;
                case 6:
                    System.out.println("Tamaño de la pila = " + stk.getSize());
                    break;
                default:
                    System.out.println("Opción incorrecta \n ");
                    break;
            }

            stk.display();
            System.out.println("\nContinuar ( y o n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
