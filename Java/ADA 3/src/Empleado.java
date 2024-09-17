public class Empleado {
    private String clave;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Fecha fechaNacimiento;
    private Fecha fechaIngreso;
    private Departamento departamento;
    private Horario horarioLV;
    private Horario horarioS;  
    private Horario horarioD;   

    public Empleado(String clave, String nombre, String apellidoPaterno, String apellidoMaterno,
                    Fecha fechaNacimiento, Fecha fechaIngreso, Departamento departamento,
                    Horario horarioLV, Horario horarioS, Horario horarioD) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.departamento = departamento;
        this.horarioLV = horarioLV;
        this.horarioS = horarioS;
        this.horarioD = horarioD;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Horario getHorarioLV() {
        return horarioLV;
    }

    public Horario getHorarioS() {
        return horarioS;
    }

    public Horario getHorarioD() {
        return horarioD;
    }

    @Override
    public String toString() {
        String result = clave + " " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + " "
                + fechaNacimiento.toString() + " " + fechaIngreso.toString() + " " + departamento.toString() + " ";
        result += "Horario: LV = " + horarioLV.toString();
        if (horarioS != null) result += ", S = " + horarioS.toString();
        if (horarioD != null) result += ", D = " + horarioD.toString();
        return result;
    }
}