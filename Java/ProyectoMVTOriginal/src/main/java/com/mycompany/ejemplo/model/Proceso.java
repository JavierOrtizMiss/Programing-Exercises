/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.model;

/**
 *
 * @author Tony
 */
public class Proceso {
    private String id;
    private int numero;
    private int size;
    private boolean isAllocated;
    
    public Proceso(String id, int size, int numero) {
        this.id = id;
        this.size = size;
        this.isAllocated = false;
    }
    
    public String getId() {
        return id;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isAllocated() {
        return isAllocated;
    }
    
    public void setAllocated(boolean allocated) {
        this.isAllocated = allocated;
    }
    
    public int getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return "Process " + id + " (" + size + "KB)";
    }
}
