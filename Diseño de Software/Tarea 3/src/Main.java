import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            String archivo = "estudiantes.csv";
            File file = new File(archivo);

            if (!file.exists()) {
                throw new Exception("El archivo " + archivo + " no existe.");
            }
            ArrayList<Estudiante> students = LeerCSV.leerCSV(archivo);
            CapCali.capturarCalificaciones(students);
            String outputFilename = "calificaciones.csv";
            CrearCSV.crearCSV(students, outputFilename);

            System.out.println("Archivo de calificaciones generado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al generar el archivo de calificaciones: " + e.getMessage());
        }
    }
}
