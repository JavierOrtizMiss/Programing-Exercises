public abstract class ComponenteMenu {
    void adicionar(ComponenteMenu componente);
    void remover(ComponenteMenu componente);
    ComponenteMenu obtenerHijo(int i);
    void operacion();
    String getNombre();
    String getDescripcion();
    double getPrecio();
    boolean esVegetariano();
    void mostrar();

}
