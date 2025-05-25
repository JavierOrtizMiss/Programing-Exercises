import java.util.Scanner;

public class SLinkedListTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList();
        System.out.println("Lista Doblemente Enlazada\n");

        char ch;
        do {
            System.out.println("\nOperaciones en la Lista Doblemente Enlazada:");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en una posición");
            System.out.println("4. Eliminar de una posición");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar al final");
            System.out.println("7. Verificar si la lista está vacía");
            System.out.println("8. Obtener el tamaño de la lista");

            System.out.print("Selecciona una opción: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el valor a insertar: ");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.print("Ingresa el valor a insertar: ");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.print("Ingresa el valor a insertar: ");
                    int num = scan.nextInt();
                    System.out.print("Ingresa la posición: ");
                    int pos = scan.nextInt();
                    list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.print("Ingresa la posición a eliminar: ");
                    int p = scan.nextInt();
                    list.deleteAtPos(p);
                    break;
                case 5:
                    list.deleteAtStart();
                    System.out.println("Se ha eliminado un nodo al inicio.");
                    break;
                case 6:
                    list.deleteAtEnd();
                    System.out.println("Se ha eliminado un nodo al final.");
                    break;
                case 7:
                    System.out.println("¿La lista está vacía? " + list.isEmpty());
                    break;
                case 8:
                    System.out.println("Tamaño de la lista: " + list.getSize());
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.print("¿En qué sentido deseas ver la lista? (F/B): ");
            String direction = scan.next();
            if (direction.equalsIgnoreCase("F")) {
                list.displayForward();
            } else if (direction.equalsIgnoreCase("B")) {
                list.displayBackward();
            } else {
                System.out.println("Opción no válida.");
            }

            System.out.print("\n¿Deseas continuar? (s/n): ");
            ch = scan.next().charAt(0);
        } while (ch == 's' || ch == 'S');

        scan.close();
    }
}
