import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aplication {
    public static void main(String[] args) {
        String rutaArchivo = "automata.txt"; 

        try (BufferedReader readfile = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = readfile.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
