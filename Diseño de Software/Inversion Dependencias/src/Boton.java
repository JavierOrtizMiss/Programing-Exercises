public class Boton {
    public void push() {
        System.out.println("El botón ha sido presionado.");
    }
    public static void main(String[] args) {
        new Boton().push(new Lampara());
    }

}
