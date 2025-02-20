
import java.util.ArrayList;

public class PruebaBotones {
    public static void main(String[] args) {
        ArrayList<Botones> listaBotones = new ArrayList<Botones>();

        listaBotones.add(new Radio("Sony"));
        listaBotones.add(new Radio("Majestic"));
        listaBotones.add(new Computadora("Lenovo", "1234ss"));
        listaBotones.add(new Computadora("HP", "8234ss"));

        //Procesamiento polimórfico o general

        for (int i=0; i<listaBotones.size(); i++){
            if (listaBotones.get(i) instanceof Radio){
                System.out.println("Radio: " + listaBotones.get(i));
            } else if (listaBotones.get(i) instanceof Computadora){
                System.out.println("Computadora: " + listaBotones.get(i));    
            }
            System.out.println(listaBotones.get(i) + ", el volumen " + listaBotones.get(i).volumen());

        }
    }

}
