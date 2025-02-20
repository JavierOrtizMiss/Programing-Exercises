public class Computadora implements Botones{
    private String modelo;
    private String noSerie;

    //Constructor

    public Computadora(String modelo, String noSerie) {
        this.modelo = modelo;
        this.noSerie = noSerie;
    }

    //Métodos

    public String getModelo() {
        return modelo;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    //Código del método abstracto
    @Override
    public String volumen() {
        return "se sube haciendo click con el mouse";
    }

    //Método toString

    @Override
    public String toString() {
        return "modelo= " + getModelo() + ", noSerie= " + getNoSerie();
    }


}
