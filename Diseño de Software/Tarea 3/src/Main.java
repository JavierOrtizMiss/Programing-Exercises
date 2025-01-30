import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        
        while (true) {
            System.out.print("¿Desea ingresar calificaciones? (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            
            if (respuesta.equals("s")) {
                break;
            } else if (respuesta.equals("n")) {
                System.out.println("Saliendo del programa...");
                scanner.close();
                return;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese 's' para sí o 'n' para no.");
            }
        }
        
        String nombreArchivo;
        File file;
        
        while (true) {
            System.out.print("Ingrese el nombre del archivo CSV (sin poner el .csv): ");
            nombreArchivo = scanner.nextLine().trim();
            
            try {
                String directorioActual = new File(".").getCanonicalPath();
                String archivo = directorioActual + File.separator + nombreArchivo + ".csv";
                file = new File(archivo);
                
                if (!file.exists()) {
                    System.out.println("El archivo no existe. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error al obtener la ruta del archivo: " + e.getMessage());
            }
        }
        
        try {
            ArrayList<Estudiante> students = LeerCSV.leerCSV(file.getAbsolutePath());
            CapCali.capturarCalificaciones(students);
            
            String outputFilename = file.getParent() + File.separator + "calificaciones.csv";
            CrearCSV.crearCSV(students, outputFilename);
            
            System.out.println("Archivo de calificaciones generado correctamente en: " + outputFilename);
        } catch (Exception e) {
            System.out.println("Error al generar el archivo de calificaciones: " + e.getMessage());
        }
        
        scanner.close();
    }
}
