public class Coche implements Vehiculo {

    public String getInfoCoche() {
        return "Auto F1";
    }

    @Override
    public void dibujar() {
        System.out.println(getInfoCoche());
    }
}