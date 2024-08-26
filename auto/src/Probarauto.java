import java.util.Scanner;

public class Probarauto {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Auto ionic = new Auto(); // Creamos el objeto (también conocido como "instancia de la clase" Auto)
        
        System.out.println("Escriba el numero de puertas: ");
        int puertas = entrada.nextInt();
        ionic.establecerPuertas(puertas);

        System.out.println("Escriba un color: ");
        String unColor = entrada.next();
        ionic.establecerColor(unColor);

        System.out.println("Escriba el tipo de motor: ");
        String motor = entrada.next();
        ionic.establecerMotor(motor);

        System.out.println(ionic.imprimir());

        //System.out.println("No. de puertas = " + ionic.obtenerPuertas());
        //System.out.println("Color = " + ionic.obtenerColor());
        //System.out.println("Tipo de motor = " + ionic.obtenerMotor());
        
        System.out.println("Escriba la velocidad: ");
        int velocidad = entrada.nextInt();
        System.out.println(ionic.acelerar(velocidad)); // Corregido para pasar la velocidad como argumento
        
    }
}