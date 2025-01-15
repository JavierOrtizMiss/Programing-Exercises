import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComponenteCsv {

    public List<Alumno> leerCsv(String ruta) {
        List<Alumno> alumnos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length >= 4) {
                    String matricula = values[0].trim();
                    String nombres = values[1].trim();
                    String apellido1 = values[2].trim();
                    String apellido2 = values[3].trim();

                    Alumno alumno = new Alumno(matricula, nombres, apellido1, apellido2);
                    alumnos.add(alumno);
                } else {
                    System.out.println("Línea con formato inválido: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return alumnos;
    }
}
