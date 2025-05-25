/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.model;

import com.mycompany.ejemplo.controller.EstadoProceso;
import com.mycompany.ejemplo.model.Proceso;

/**
 *
 * @author Tony
 */
public class Data {
    private Proceso proceso;
    private int tiempoLlegada;
    private int pasoDeSalida;
    private EstadoProceso estado;
    
    public Data(String procesoId, int tamanoProceso, int tiempoLlegada, int duracion, int numeroProceso) {
        this.proceso = new Proceso(procesoId, tamanoProceso, numeroProceso);
        this.tiempoLlegada = tiempoLlegada;
        this.pasoDeSalida = duracion + tiempoLlegada;
        this.estado = EstadoProceso.ESPERA;
    }

    public void actualizarEstado(EstadoProceso estado) {
        this.estado = estado;
    }
    
    public boolean isFinalized() {
        return estado.name().equals("FINALIZADO");
    }
    
    public Proceso getValue() {
        return proceso;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getPasoDeSalida() {
        return pasoDeSalida;
    }
    
    public int getDuracion() {
        return pasoDeSalida - tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setPasoDeSalida(int pasoDeSalida) {
        this.pasoDeSalida = pasoDeSalida;
    }
}
