public class InsertionSort {
    int contadorcomparaciones = 0;
    int contadorintercambios = 0;
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            contadorcomparaciones++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
                contadorintercambios++;

            }
            arr[j + 1] = key;
        }
    }

    
}