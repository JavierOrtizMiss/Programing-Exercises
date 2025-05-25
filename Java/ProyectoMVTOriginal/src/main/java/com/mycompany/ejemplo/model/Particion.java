/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.model;

/**
 *
 * @author Tony
 */
public class Particion {
    
    private int startAddress;
    private int size;
    private boolean isFree;
    private String procesoId;
    private int numeroProceso;
    private boolean fragmented = false;
    private boolean pendingRemove = false; // Nuevo campo
    private boolean visualFinalizada = false; // Nuevo campo

    public Particion(int startAddress, int size, boolean isFree) {
        this.startAddress = startAddress;
        this.size = size;
        this.isFree = isFree;
        this.procesoId = null;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getSize() {
        return size;
    }

    public boolean isFree() {
        return isFree;
    }

    public String getProcesoId() {
        return procesoId;
    }
    

    public void allocate(String procesoId, int numeroProceso) {
        this.isFree = false;
        this.procesoId = procesoId;
        this.numeroProceso = numeroProceso;
    }

    public void free() {
        this.isFree = true;
        this.procesoId = null;
        this.pendingRemove = true; // Marcar como pendiente de eliminación
    }
    
    public boolean isPendingRemove() {
        return pendingRemove;
    }

    public void setPendingRemove(boolean pendingRemove) {
        this.pendingRemove = pendingRemove;
    }

    public int getNumeroProceso() {
        return numeroProceso;
    }

    public int getEndAddress() {
        return startAddress + size;
    }
    
    public Particion cloneForVisual() {
        Particion copia = new Particion(this.startAddress, this.size, this.isFree);
        copia.procesoId = this.procesoId;
        copia.numeroProceso = this.numeroProceso;
        copia.visualFinalizada = true;
        return copia;
    }

    public boolean isVisualFinalizada() {
        return visualFinalizada;
    }

    @Override
    public String toString() {
        if (isFree) {
            return "[" + startAddress + "-" + getEndAddress() + "] Free: " + size + "KB";
        } else {
            return "[" + startAddress + "-" + getEndAddress() + "] Proceso: " + procesoId + " (" + size + "KB)";
        }
    }
}
