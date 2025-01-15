import java.util.List;

public class Main {
    public static void main(String[] args) {
        String ruta = "alumnos.csv";

        ComponenteCsv ComponenteCsv = new ComponenteCsv();

        List<Alumno> alumnos = ComponenteCsv.leerCsv(ruta);

        System.out.println("Datos de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
