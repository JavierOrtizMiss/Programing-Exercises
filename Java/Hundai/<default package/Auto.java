/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundai;

public class Auto {
    // Atributos
    private int noPuertas;
    private String color;
    private String tipoMotor;
    private int velocidad; // Añadido

    // Métodos
    public String acelerar(int velocidad) { // Modificado para recibir un parámetro
        this.velocidad = velocidad; // Asignar el valor del parámetro al atributo velocidad
        return "Acelerando auto ... a " + velocidad + " km/h";
    }
}