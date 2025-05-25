public class Torniquete {
    private boolean locked;

    public Torniquete(boolean locked) {
        this.locked = locked; 
    }

    public boolean bloqueado() {
        return locked;
    }

    public void insertarMoneda() {
        if (locked) {
            System.out.println("Desbloqueado");
            locked = false;
        } else {
            System.out.println("Desbloqueado");
        }
    }

    public void pasar() {
        if (!locked) {
            System.out.println("Bloqueado");
            locked = true;
        } else {
            System.out.println("Bloqueado");
        }
    }

    public void bloquear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bloquear'");
    }

    public void desbloquear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desbloquear'");
    }
}