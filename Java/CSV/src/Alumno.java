public class Alumno {
    private String matricula;
    private String nombres;
    private String apellido1;
    private String apellido2;

    // Constructor
    public Alumno(String matricula, String nombres, String apellido1, String apellido2) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
}
