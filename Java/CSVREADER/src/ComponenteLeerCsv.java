import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComponenteLeerCsv {

    public static String[][] leerCsv(String filePath) {
        String[][] matriz = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int filas = 0;
            int columnas = 0;
            String line;

            // Leer para contar filas y columnas
            while ((line = br.readLine()) != null) {
                filas++;
                int numColumnas = line.split(",").length;
                columnas = Math.max(columnas, numColumnas);
            }

            // Inicializar la matriz
            matriz = new String[filas][columnas];

            // Reiniciar el BufferedReader para leer de nuevo
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(filePath));

            // Llenar la matriz con los datos del archivo
            int filaActual = 0;
            while ((line = br2.readLine()) != null) {
                String[] valores = line.split(",");
                for (int i = 0; i < valores.length; i++) {
                    matriz[filaActual][i] = valores[i].trim();
                }
                filaActual++;
            }
            br2.close();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return matriz;
    }
}
