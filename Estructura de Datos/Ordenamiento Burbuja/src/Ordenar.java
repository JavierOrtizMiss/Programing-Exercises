class Burbuja {
    //Atributos
    private int[] arr;
    private int k;

    //Constructor
    public Burbuja(int[] arr) {
        this.arr = arr;
        this.k = 0;
    }

    //Método de ordenar
    public void ordenar() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    k++;
                }
            }
        }
    }

    //Método de mostrar
    public void mostrar() {
        System.out.println("Arreglo ordenado");
        System.out.println("Veces que se hace el swap: " + k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class Ordenar {
    public static void main(String[] args) throws Exception {
        //int[] arr = {1,4,3,5};
        int[] arr = {9,7,2,1};
        Burbuja burbuja = new Burbuja(arr);
        burbuja.ordenar();
        burbuja.mostrar();
    }
}

