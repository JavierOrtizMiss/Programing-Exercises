public class Main {

    public static void main(String[] args) {
        // Ruta del archivo CSV
        String filePath = "alumnos.csv"; // Cambia esto por la ruta real del archivo

        // Llamar al método leerCsv desde la clase CsvReader
        String[][] matriz = ComponenteLeerCsv.leerCsv(filePath);

        // Imprimir el contenido del archivo CSV
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
            System.out.println("El archivo CSV no pudo ser procesado.");
        }
    }
}
