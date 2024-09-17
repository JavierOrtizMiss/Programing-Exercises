public class Horario {
    private String horaInicio;
    private String horaFin;

    public Horario(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    @Override
    public String toString() {
        return horaInicio + "-" + horaFin;
    }
}