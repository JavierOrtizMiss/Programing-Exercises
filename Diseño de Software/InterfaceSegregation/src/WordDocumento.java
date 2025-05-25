public class WordDocumento implements Documento{
    @Override
    public void leer() {
        System.out.println("Leyendo Word...");
    }

    @Override
    public void escribir() {
        System.out.println("Escribiendo Word...");
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Impresión no soportada");
    }

    @Override
    public void convertirAPDF() {
        System.out.println("Convirtiendo Word a PDF...");
    }

}
