import java.util.ArrayList;
import java.util.Scanner;


public class CapCali {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void capturarCalificaciones(ArrayList<Estudiante> estudiantes){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for (Estudiante estudiante : estudiantes) {
            System.out.println("### Estudiante " + i +" ###\n");
            System.out.println("Matricula: " + estudiante.getMatricula());
            System.out.println("Nombres: " + estudiante.getNombres());
            System.out.println("Apellido Paterno: " + estudiante.getApellido1());
            System.out.println("Apellido Materno: " + estudiante.getApellido2());
            System.out.print("\nIngrese la calificación del alumno: ");
            double calificacion;
            while (true) {
                try{
                calificacion = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("Calificación inválida. Intente otra vez con un valor válido");
                    sc.nextLine();
                    continue;

                }
                if (calificacion >= 1 && calificacion <= 100) {
                    break;
                } else {
                    System.out.println("Calificación inválida. Debe ser un número entre 1 y 100.");
                    }
                }
            i++;
            estudiante.setCalificacion(calificacion);
            clean();
            }
        }
    
    }
    

