import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    // Método para mezclar los arreglos
    static void merge(int[] array, int low, int mid, int high) {
        int i, j, k;
        // Crear un arreglo temporal para almacenar los elementos mezclados
        int[] c = new int[high - low + 1];
        k = 0; // Índice para el arreglo temporal
        i = low; // Índice inicial del primer subarreglo
        j = mid + 1; // Índice inicial del segundo subarreglo

        // Mezclar los elementos de los dos subarreglos en orden
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                c[k++] = array[i++]; // Copiar el elemento del primer subarreglo
            } else {
                c[k++] = array[j++]; // Copiar el elemento del segundo subarreglo
            }
        }

        // Copiar los elementos restantes del primer subarreglo, si los hay
        while (i <= mid) {
            c[k++] = array[i++];
        }

        // Copiar los elementos restantes del segundo subarreglo, si los hay
        while (j <= high) {
            c[k++] = array[j++];
        }

        // Copiar los elementos mezclados de vuelta al arreglo original
        k = 0;
        for (i = low; i <= high; i++) {
            array[i] = c[k++];
        }

        // Imprimir el arreglo después de la mezcla
        int n = array.length;
        System.out.println("Arreglo al final del merge ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    // Método para dividir el arreglo en subarreglos y ordenarlos
    static void mergeSort(int[] array, int low, int high) {
        // Verificar si el subarreglo tiene más de un elemento
        if (high - low + 1 > 1) {
            int mid = (low + high) / 2; // Calcular el índice medio

            // Imprimir información sobre el lado izquierdo
            System.out.println("lado izquierdo++++++++++++++++++++++++++");
            System.out.println("Índice low es :" + low);
            System.out.println("Índice mid es :" + mid);
            for (int i = low; i <= mid; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");

            // Llamada recursiva para ordenar el lado izquierdo
            mergeSort(array, low, mid);

            // Imprimir información sobre el lado derecho
            System.out.println("Ahora lado derecho----------------------");
            System.out.println("Índice mid+1 es :" + mid + " más 1");
            System.out.println("Índice high es :" + high);
            for (int i = mid + 1; i <= high; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");

            // Llamada recursiva para ordenar el lado derecho
            mergeSort(array, mid + 1, high);

            // Imprimir información antes de mezclar
            System.out.println("Ahora Merge++++++++++++++++++++++++++++++");
            System.out.println("Índice low es :" + low);
            System.out.println("Índice mid es :" + mid);
            System.out.println("Índice high es :" + high);

            // Mezclar los dos subarreglos ordenados
            merge(array, low, mid, high);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Leer entrada del usuario
        int size; // Tamaño del arreglo
        System.out.println("Proporciona el tamaño del arreglo a ordenar");
        try {
            size = Integer.parseInt(br.readLine()); // Leer el tamaño del arreglo
        } catch (Exception e) {
            System.out.println("Entrada no válida"); // Manejar entrada inválida
            return;
        }

        int[] array = new int[size]; // Crear el arreglo
        System.out.println("Proporciona los elementos del arreglo");
        int i;
        for (i = 0; i < array.length; i++) {
            try {
                array[i] = Integer.parseInt(br.readLine()); // Leer los elementos del arreglo
            } catch (Exception e) {
                System.out.println("Error"); // Manejar errores de entrada
            }
        }

        // Imprimir el arreglo inicial
        System.out.println("El arreglo inicial es: ");
        System.out.println(Arrays.toString(array));
        // Ejemplo de salida para el arreglo inicial:
        // El arreglo inicial es: 
        // [9, 8, 7, 6, 5, 4, 3, 2, 1]

        // Ordenar el arreglo usando merge sort
        mergeSort(array, 0, array.length - 1);
        // Ejemplo de salida durante el proceso de ordenamiento:
        // lado izquierdo++++++++++++++++++++++++++
        // Índice low es :0
        // Índice mid es :4
        // 9 8 7 6 5 
        // Ahora lado derecho----------------------
        // Índice mid+1 es :4 más 1
        // Índice high es :8
        // 4 3 2 1 
        // Ahora Merge++++++++++++++++++++++++++++++
        // Índice low es :0
        // Índice mid es :4
        // Índice high es :8
        // Arreglo al final del merge 
        // 1 2 3 4 5 6 7 8 9 

        // Imprimir el arreglo ordenado
        System.out.println("El arreglo ordenado es: ");
        System.out.println(Arrays.toString(array));
        // Ejemplo de salida final:
        // El arreglo ordenado es: 
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}