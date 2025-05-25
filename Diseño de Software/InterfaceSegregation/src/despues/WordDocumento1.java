package despues;

public class WordDocumento1 implements Lectura, Escritura, ConversionAPDF {
    @Override
    public void leer() {
        System.out.println("Leyendo Word...");
    }

    @Override
    public void escribir() {
        System.out.println("Escribiendo Word...");
    }

    @Override
    public void convertirAPDF() {
        System.out.println("Convirtiendo Word a PDF...");
    }
}
