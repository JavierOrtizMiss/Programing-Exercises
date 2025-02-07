import java.io.*;
import java.util.*;

public class LeerCSV {

    public static ArrayList<Estudiante> leerCSV (String ruta) throws Exception{
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
         try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea=br.readLine()) != null) {
                String[] contenido = linea.split(",");
                Estudiante estudiante = new Estudiante(contenido[0], contenido[1], contenido[2], contenido[3]);
                estudiantes.add(estudiante);
            }
         } catch (Exception e) {
            throw new Exception(e.getMessage());
         }
        return estudiantes;
    }
    
    
}