public class Estudiante {
    //Atributos
    private String matricula;
    private String apellido1;
    private String apellido2;
    private String nombres;
    private double calificacion;

    //Constructor
    public Estudiante(String matricula, String apellido1, String apellido2, String nombres) {
        this.matricula = matricula;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombres = nombres;
        setCalificacion(calificacion);
        
    }

    //Getters
    public String getMatricula() {
        return matricula;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombres() {
        return nombres;
    }

    public double getCalificacion() {
        return calificacion;
    }

    //Setters
    public double setCalificacion(double calificacion) {
        return this.calificacion = calificacion;
    }
    
}
