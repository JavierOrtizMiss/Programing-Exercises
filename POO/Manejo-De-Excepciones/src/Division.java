
import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {

    public static double dividir(int num1, int num2) throws ArithmeticException {
        double resultado;
        resultado = (num1) / num2; // Punto de lanzamiento de excepción ArithmeticException
        return resultado;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        System.out.println("****Programa para dividir dos números enteros****\n");
        do{
            try {
                System.out.print("Escriba el numerador: ");
                int numerador = entrada.nextInt(); // Punto de lanzamiento InputMismatchException
                System.out.print("Escriba el denominador: ");
                int denominador = entrada.nextInt(); // Punto de lanzamiento InputMismatchException
                if (denominador < 0) {
                    throw new RangoException("El denominador no puede ser negativo"); //Punto de lanzamiento de excepción RangoException
                }
                double resultado = dividir(numerador, denominador); // Punto de lanzamiento de excepción ArithmeticException
                System.out.println("El resultado de la división es: " + resultado);
                continuar = false;
            } catch (ArithmeticException ex1) {
                System.out.println("Error: No se puede dividir entre cero");
                entrada.nextLine();
            } catch (InputMismatchException ex2) {
                System.out.println("Error: Entrada no válida. Por favor ingrese números enteros.");
                entrada.nextLine();
                StackTraceElement[] listaDeErrores= ex2.getStackTrace();
                System.out.println("Clase\tArchivo\tMétodo\tLínea");
                for (int i=0; i<listaDeErrores.length; i++){
                    System.out.println(listaDeErrores[i].getClassName() + "\t" + listaDeErrores[i].getFileName() + "\t" + listaDeErrores[i].getMethodName() + "\t" + listaDeErrores[i].getLineNumber());
                }
            }catch (RangoException ex3) {
                System.out.println(ex3.getMessage());
                ex3.printStackTrace();
            }
        } while (continuar);

        
    }
}