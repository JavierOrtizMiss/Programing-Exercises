import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        while (true) {
            String bienvenida = """

                '########::'####:'########:'##::: ##:'##::::'##:'########:'##::: ##:'####:'########:::'#######::
                ##.... ##:. ##:: ##.....:: ###:: ##: ##:::: ##: ##.....:: ###:: ##:. ##:: ##.... ##:'##.... ##:
                ##:::: ##:: ##:: ##::::::: ####: ##: ##:::: ##: ##::::::: ####: ##:: ##:: ##:::: ##: ##:::: ##:
                ########::: ##:: ######::: ## ## ##: ##:::: ##: ######::: ## ## ##:: ##:: ##:::: ##: ##:::: ##:
                ##.... ##:: ##:: ##...:::: ##. ####:. ##:: ##:: ##...:::: ##. ####:: ##:: ##:::: ##: ##:::: ##:
                ##:::: ##:: ##:: ##::::::: ##:. ###::. ## ##::: ##::::::: ##:. ###:: ##:: ##:::: ##: ##:::: ##:
                ########::'####: ########: ##::. ##:::. ###:::: ########: ##::. ##:'####: ########::. #######::
                ........:::....::........::..::::..:::::...:::::........::..::::..::....::........::::.......:::
                           
            """;

            System.out.println(bienvenida);
            System.out.print("\n¿Desea ingresar calificaciones? (s/n): \n");
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

        clean();

        System.out.println("\n---El programa utlizará la ruta en la que esté este programa---\n");
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
            clean();
            ArrayList<Estudiante> students = LeerCSV.leerCSV(file.getAbsolutePath());
            CapCali.capturarCalificaciones(students);
            
            System.out.println("\nEscriba el nombre con el que desea guardar el archivo: ");
            String nameoutputfile = scanner.nextLine().trim();
            String outputFilename = file.getParent() + File.separator + nameoutputfile + ".csv";
            CrearCSV.crearCSV(students, outputFilename);
            System.out.println("Archivo de calificaciones generado correctamente en: " + outputFilename);
        } catch (Exception e) {
            System.out.println("Error al generar el archivo de calificaciones: " + e.getMessage());
            main(args);
        }
        
        scanner.close();
    }
}
