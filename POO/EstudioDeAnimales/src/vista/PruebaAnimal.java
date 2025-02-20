package vista;

import modelo.*;
import java.util.ArrayList;

public class PruebaAnimal {
    public static void main(String[] args) {
        ArrayList<Animal> listAnimales = new ArrayList<Animal>();
        listAnimales.add(new Serpiente("Snaky", 2, 5.6));
        listAnimales.add(new Conejo("Bugs", 6, 4.5));
        listAnimales.add(new Aguila("Aguilucho", 10, 80));
        listAnimales.add(new Serpiente("Kay", 4, 3.8));

        //Procesamiento general o procesamiento polimórfico
        for(int i=0; i<listAnimales.size(); i++){
            if (listAnimales.get(i) instanceof Serpiente){
                Serpiente unaSerpiente = (Serpiente) listAnimales.get(i);
                unaSerpiente.setLongitud(2*unaSerpiente.getLongitud());
            } 
            System.out.println(listAnimales.get(i).toString() + ", " + listAnimales.get(i).mover());
        }
    }

}
