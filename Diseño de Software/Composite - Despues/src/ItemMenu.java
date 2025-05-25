class ItemMenu extends ComponenteMenu {
    private String nombre;
    private double precio;
    private boolean vegetariano;

    public ItemMenu(String nombre, double precio, boolean vegetariano) {
        this.nombre = nombre;
        this.precio = precio;
        this.vegetariano = vegetariano;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean esVegetariano() {
        return vegetariano;
    }

    @Override
    public void operacion() {
        System.out.print("  " + nombre);
        if (vegetariano) {
            System.out.print("(V)");
        }
        System.out.println(", " + precio);
    }
}
