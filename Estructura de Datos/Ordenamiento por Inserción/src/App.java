public class App {
    public static void main(String[] args){
        int arr[] = {3, 10, 5, 1, 2};
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
        System.out.println("Arreglo ordenado: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nComparaciones: " + ob.contadorcomparaciones);
        System.out.println("Intercambios: " + ob.contadorintercambios);

        
    }

}
