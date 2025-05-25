public class Motocicleta implements Vehiculo {

    public String getInfoMoto() {
        return "Moto GP";
    }

    @Override
    public void dibujar() {
        System.out.println(getInfoMoto());
    }
}