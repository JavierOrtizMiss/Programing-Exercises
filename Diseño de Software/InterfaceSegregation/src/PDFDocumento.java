public class PDFDocumento implements Documento{
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

    @Override
    public void convertirAPDF() {
        throw new UnsupportedOperationException("Ya es un PDF");
    }
    
}
