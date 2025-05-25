class ItemMenu {
    private String nombre;
    private double precio;
    private boolean vegetariano;

    public ItemMenu(String nombre, double precio, boolean vegetariano) {
        this.nombre = nombre;
        this.precio = precio;
        this.vegetariano = vegetariano;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esVegetariano() {
        return vegetariano;
    }

    public void mostrar() {
        System.out.print("  " + nombre);
        if (vegetariano) {
            System.out.print("(V)");
        }
        System.out.println(", " + precio);
    }
}
