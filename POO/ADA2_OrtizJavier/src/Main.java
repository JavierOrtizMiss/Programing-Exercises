import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);
        ArrayList<Figuras> figuras = new ArrayList<>();
        int opcion = 0;
        System.out.println("--Registro de SuperHeroes--");
        do{
            System.out.println("Introduzca el código del superhéroe que desea registrar:");
            String codigo = sc.next();
            System.out.println("Introduzca el precio del superhéroe:");
            double precio = sc.nextDouble();
            System.out.println("Introduzca el nombre del superhéroe:");
            String nombre = sc.next();
            System.out.println("Introduzca la descripción del superhéroe:");
            String descripcion = sc.next();
            System.out.println("Introduzca si el superhéroe tiene capa (true/false):");
            boolean capa = sc.nextBoolean();
            System.out.println("Introduzca el alto del superhéroe:");
            double alto = sc.nextDouble();
            System.out.println("Introduzca el ancho del superhéroe:");
            double ancho = sc.nextDouble();
            System.out.println("Introduzca la profundidad del superhéroe:");
            double profundidad = sc.nextDouble();


            boolean codigoExiste = false;
            for(Figuras figura : figuras){
                if(figura.getCodigo().equals(codigo)){
                    codigoExiste = true;
                    break;
                }
            }
            if (!codigoExiste) {
                SuperHeroes superHeroe = new SuperHeroes(nombre, descripcion, capa);
                Dimensiones dimension = new Dimensiones(alto, ancho, profundidad);
                Figuras figura = new Figuras(codigo, precio, dimension, superHeroe);
                figuras.add(figura);
                
            }
            

            System.out.println("¿Desea registrar otro superhéroe? (1: Sí, 0: No)");
            opcion = sc.nextInt();
        }while(opcion != 0);
        sc.close();

        //Mostrar los superhéroes registrados
        System.out.println("Código      Precio        Nombre           Descripción      Capa      Volumen");
        for(Figuras figura : figuras){
            System.out.println(figura.getCodigo() + "      " + figura.getPrecio() + "      " + figura.getSuperHeroe().getNombre() + "      " + figura.getSuperHeroe().getDescripcion() + "      " + figura.getSuperHeroe().getCapa() + "      " + figura.getDimension().getVolumen());
        }
    
    }
}

