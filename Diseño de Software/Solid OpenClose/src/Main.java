public class Main {
    public Main() {
        Vehiculo coche = new Coche();
        Vehiculo moto = new Motocicleta();
        dibujarVehiculo(moto);
        dibujarVehiculo(coche);
    }

    public void dibujarVehiculo(Vehiculo vehiculo) {
        vehiculo.dibujar();
    }

    public static void main(String args[]) {
        new Main();
    }
}