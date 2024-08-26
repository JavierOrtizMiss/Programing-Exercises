[26/08/24, 8:10:36 a.m.] Greco: xd
[26/08/24, 8:12:38 a.m.] Greco: /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hundai;

import java.util.Scanner;

public class ProbarAuto {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Auto ionic = new Auto(); // Creamos el objeto (también conocido como "instancia de la clase" Auto)
        System.out.println("Escriba la velocidad: ");
        int velocidad = entrada.nextInt();
        System.out.println(ionic.acelerar(velocidad)); // Corregido para pasar la velocidad como argumento
        
    }
}