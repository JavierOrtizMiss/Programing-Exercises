public class Figuras {
    private String codigo;
    private double precio;
    private Dimensiones dimension;
    private SuperHeroes superHeroe;

    //Constructor
    public Figuras(String codigo, double precio , Dimensiones dimension, SuperHeroes superHeroe) {
        this.codigo = codigo;
        this.precio = precio;
        this.dimension = dimension;
        this.superHeroe = superHeroe;
    }

    //Getters
    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public Dimensiones getDimension() {
        return dimension;
    }

    public SuperHeroes getSuperHeroe() {
        return superHeroe;
    }


}
