package modelo;

public class Desbloqueado implements Estado{
    @Override
    public void pasar(MEF mef) {
        mef.getTorniquete().bloquear();
        mef.setEstado(new Bloqueado());
    }

    @Override
    public void moneda(MEF mef) {

    }


}
