package despues;

public class PDFDocumento1 implements Lectura, Escritura, Impresion {
    @Override
    public void leer() {
        System.out.println("Leyendo PDF...");
    }

    @Override
    public void escribir() {
        System.out.println("Escribiendo PDF...");
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo PDF");
    }
}
