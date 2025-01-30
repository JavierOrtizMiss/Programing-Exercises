import java.util.ArrayList;
import java.util.Scanner;

public class CapCali {
    public static void capturarCalificaciones(ArrayList<Estudiante> estudiantes){
        Scanner sc = new Scanner(System.in);
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Ingrese la calificación de " + estudiante.getNombres() + " " + estudiante.getApellido1() + " " + estudiante.getApellido2());
            double calificacion;
            while (true) {
                try{
                calificacion = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("Calificación inválida.");
                    sc.nextLine();
                    continue;

                }
                if (calificacion >= 1 && calificacion <= 100) {
                    break;
                } else {
                    System.out.println("Calificación inválida. Debe ser un número entre 1 y 100.");
                    }
                }
            estudiante.setCalificacion(calificacion);
            }
        }
    
    }
    

