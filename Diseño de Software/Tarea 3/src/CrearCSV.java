import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.FileWriter;

public class CrearCSV {
    public static void crearCSV(ArrayList<Estudiante> estudiantes, String ruta){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            for (Estudiante estudiante : estudiantes) {
                bw.write(estudiante.getMatricula() + ", Diseño de Software, " + estudiante.getCalificacion());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
        }
    }
}
