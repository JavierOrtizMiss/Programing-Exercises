import java.util.ArrayList;
import java.util.List;

class SubMenu extends ComponenteMenu {
    private String nombre;
    private String descripcion;
    private List<ComponenteMenu> componentes = new ArrayList<>();

    public SubMenu(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public void agregar(ComponenteMenu componente) {
        componentes.add(componente);
    }

    @Override
    public void eliminar(ComponenteMenu componente) {
        componentes.remove(componente);
    }

    @Override
    public ComponenteMenu obtenerHijo(int i) {
        return componentes.get(i);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void mostrar() {
        System.out.println("\n" + nombre + ": " + descripcion);
        System.out.println("---------------------");
        for (ComponenteMenu componente : componentes) {
            componente.mostrar();
        }
    }
}
