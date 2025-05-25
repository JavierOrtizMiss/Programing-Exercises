package despues;

public class App {
    public static void main(String[] args) {
        PDFDocumento1 pdfDocumento = new PDFDocumento1();
        WordDocumento1 wordDocumento = new WordDocumento1();

        System.out.println("Operaciones con PDF:");
        pdfDocumento.leer();
        pdfDocumento.escribir();
        pdfDocumento.imprimir();

        System.out.println("\nOperaciones con Word:");
        wordDocumento.leer();
        wordDocumento.escribir();
        wordDocumento.convertirAPDF();
    }
}
