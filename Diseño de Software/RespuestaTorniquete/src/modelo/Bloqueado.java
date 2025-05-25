package modelo;
public class Bloqueado implements Estado {
    @Override
    public void pasar(MEF mef) {

    }

    @Override
    public void moneda(MEF mef) {
        mef.getTorniquete().desbloquear();
        mef.setEstado(new Desbloqueado());
        

    }

}
