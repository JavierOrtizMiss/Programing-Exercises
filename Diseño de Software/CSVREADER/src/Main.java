public class Main {

    public static void main(String[] args) {
        // Ruta del archivo CSV
        String ruta = "alumnas.csv"; 

        String[][] matriz = ComponenteLeerCsv.leerCsv(ruta);

        if (matriz != null) {
            System.out.println("-------Contenido del archivo CSV---------\n");
            for (String[] fila : matriz) {
                for (String valor : fila) {
                    if (valor != null) {
                        System.out.print(valor + " \t");
                    } else {
                        System.out.print(" \t");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("El archivo CSV no se pudo leer.");
        }
    }
}
