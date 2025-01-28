import java.io.*;
import java.util.*;

public class LeerCSV {

    public static ArrayList<Estudiante> leerCSV (String ruta){
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
         try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            while (linea != null) {
                String[] contenido = linea.split(",");
                Estudiante estudiante = new Estudiante(contenido[0], contenido[1], contenido[2], contenido[3]);
                estudiantes.add(estudiante);
            }
         } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
         }
        return estudiantes;
    }
    
    
}