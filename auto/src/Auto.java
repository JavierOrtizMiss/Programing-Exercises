public class Auto {
    // Atributos
    private int noPuertas;
    private String color;
    private String tipoMotor;
    private int velocidad; // Añadido

    //métodos obtener
    public int obtenerPuertas(){
        return noPuertas;
    }

    public String obtenerColor(){
        return color;
    }

    public String obtenerMotor(){
        return tipoMotor;
    }

    //métodos establecer
    public void establecerPuertas(int puertas){
        noPuertas=puertas;
    }

    public void establecerColor(String unColor){
        color=unColor;
    }
    
    public void establecerMotor(String motor){
        tipoMotor=motor;

    }

    // Métodos
    public String acelerar(int velocidad) { // Modificado para recibir un parámetro
        this.velocidad = velocidad; // Asignar el valor del parámetro al atributo velocidad
        return "Acelerando auto ... a " + velocidad + " km/h";
    }

    public String imprimir(){
        return "No, de puertas = " + obtenerPuertas() + ", color = " + obtenerColor() + ", tipo de motor = " + obtenerMotor();
    }
}