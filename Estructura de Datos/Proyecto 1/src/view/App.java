package view;

import model.Stack.StackImplement;
import model.Queue.QueueImplement;

import java.util.Scanner;

public class App {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una estructura de datos:");
            System.out.println("1. Pila");
            System.out.println("2. Cola");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    clean();
                    menuStack(scanner);
                    break;
                case 2:
                    clean();
                    menuQueue(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }

    private static void menuStack(Scanner scanner) {
        StackImplement stack = new StackImplement();

        while (true) {
            System.out.println("\nElige una operación para la pila:");
            System.out.println("1. Insertar un valor (push)");
            System.out.println("2. Eliminar un valor (pop)");
            System.out.println("3. Ver el valor superior (peek)");
            System.out.println("4. Ver el estado de la pila");
            System.out.println("5. Ver el tamaño de la pila");
            System.out.println("6. Verificar si está vacía");
            System.out.println("7. Regresar al menú principal");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    clean();
                    System.out.print("Ingresa el valor a insertar: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Valor " + value + " insertado en la pila.");
                    System.out.println("");
                    System.out.println("Estado actual de la pila:");
                    imprimirPila(stack);
                    break;
                case 2:
                    clean();
                    if (stack.isEmpty()) {
                        System.out.println("La pila está vacía, no se puede eliminar.");
                    } else {
                        int removedValue = stack.pop();
                        System.out.println("Valor " + removedValue + " eliminado de la pila.");
                        System.out.println("");
                        System.out.println("Estado actual de la pila:");
                        imprimirPila(stack);
                    }
                    break;
                case 3:
                    clean();
                    if (stack.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("El valor superior de la pila es: " + stack.peek());
                    }
                    break;
                case 4:
                    clean();
                    System.out.println("Estado actual de la pila:");
                    imprimirPila(stack);
                    break;
                case 5:
                    clean();
                    System.out.println("El tamaño de la pila es: " + stack.getSize());
                    break;
                case 6:
                    clean();
                    System.out.println("¿La pila está vacía? " + stack.isEmpty());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }

    private static void menuQueue(Scanner scanner) {
        QueueImplement queue = new QueueImplement();

        while (true) {
            System.out.println("\nElige una operación para la cola:");
            System.out.println("1. Insertar un valor (enqueue)");
            System.out.println("2. Eliminar un valor (dequeue)");
            System.out.println("3. Ver el valor frontal (peek)");
            System.out.println("4. Ver el estado de la cola");
            System.out.println("5. Ver el tamaño de la cola");
            System.out.println("6. Verificar si está vacía");
            System.out.println("7. Regresar al menú principal");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    clean();
                    System.out.print("Ingresa el valor a insertar: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    System.out.println("Valor " + value + " insertado en la cola.");
                    System.out.println("");
                    System.out.println("Estado actual de la cola:");
                    imprimirCola(queue);
                    break;
                case 2:
                    clean();
                    if (queue.isEmpty()) {
                        System.out.println("La cola está vacía, no se puede eliminar.");
                    } else {
                        int removedValue = queue.dequeue();
                        System.out.println("Valor " + removedValue + " eliminado de la cola.");
                        System.out.println("");
                        System.out.println("Estado actual de la cola:");
                        imprimirCola(queue);
                    }
                    break;
                case 3:
                    clean();
                    if (queue.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("El valor frontal de la cola es: " + queue.peek());
                    }
                    break;
                case 4:
                    clean();
                    System.out.println("Estado actual de la cola:");
                    imprimirCola(queue);
                    break;
                case 5:
                    clean();
                    System.out.println("El tamaño de la cola es: " + queue.getSize());
                    break;
                case 6:
                    clean();
                    System.out.println("¿La cola está vacía? " + queue.isEmpty());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }

    // Método auxiliar para imprimir el contenido de la pila
    public static void imprimirPila(StackImplement stack) {
        StackImplement tempStack = new StackImplement();

        // Usar un stack temporal para no modificar el original
        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.print(val + " ");
            tempStack.push(val);  // Almacenar en el stack temporal
        }

        // Restaurar los elementos al stack original
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        System.out.println();
    }

    // Método auxiliar para imprimir el contenido de la cola
    public static void imprimirCola(QueueImplement queue) {
        QueueImplement tempQueue = new QueueImplement();

        while (!queue.isEmpty()) {
            int val = queue.dequeue();
            System.out.print(val + " ");
            tempQueue.enqueue(val);
        }

        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        System.out.println();
    }
}
