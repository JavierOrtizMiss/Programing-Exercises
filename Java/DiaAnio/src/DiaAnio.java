public class DiaAnio {

    // Atributos
    private int mes;
    private int dia;
    private int anio;

    // Constructor
    public DiaAnio(int mes, int dia, int anio){
        this.mes = mes;
        this.dia = dia; 
        this.anio = anio;
    }

    // Getters
    public int getMes(){
        return mes;
    }

    public int getDia(){
        return dia;
    }

    public int getAnio(){
        return anio;
    }

    public boolean igual(int mes, int dia, int anio){
        return this.mes == mes && this.dia == dia && this.anio == anio;
    }

    public void visualizar(){
        System.out.println(dia + "/" + mes + "/" + anio);
    }
}
