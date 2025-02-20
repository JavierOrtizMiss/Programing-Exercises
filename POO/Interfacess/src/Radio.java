public class Radio implements Botones{
    private String marca;

    public Radio(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String volumen() {
        return "se sube girando el botón";
    }

    //Método toString
    @Override
    public String toString() {
        return "marca= " + getMarca();
    }
    
}
