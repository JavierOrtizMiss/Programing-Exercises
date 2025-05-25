import java.util.Scanner;

import modelo.Bloqueado;
import modelo.Estado;
import modelo.MEF;
import modelo.Torniquete;

public class Lanzador {
    public static void main(String[] args) {
        Torniquete torniquete = new Torniquete();
        Estado estadoInicial = new Bloqueado();
        MEF mef = new MEF(torniquete, estadoInicial);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Moneda");
            System.out.println("2. Pasar");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mef.moneda();
                    break;
                case 2:
                    mef.pasar();
                    break;
                default:
                    break;
            }
        }
    }
    
}
