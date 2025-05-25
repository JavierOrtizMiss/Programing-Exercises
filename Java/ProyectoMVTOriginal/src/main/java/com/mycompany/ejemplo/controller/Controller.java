/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.controller;

import com.mycompany.ejemplo.model.Data;
import com.mycompany.ejemplo.model.Viewer;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class Controller {
    private int paso;
    private List<Data> colaProcesos;
    private List<Data> procesosEnEspera; // Procesos que no han podido entrar aún
    private MVT mvt;
    private HashMap<String, Viewer> viewers;

    public Controller(List<Data> colaProcesos, int tamanoMemoria, int tamanoSO) {
        this.paso = 0;
        this.colaProcesos = colaProcesos;
        this.procesosEnEspera = new ArrayList<>();
        this.mvt = new MVT(tamanoMemoria, tamanoSO);
        this.viewers = new HashMap<>();
    }
    
    public void realizarPaso() {
        boolean finalized = false;
        for (var proceso : colaProcesos) {
            finalized = proceso.isFinalized();
        }
        if (finalized) {
            System.out.println("Terminado");
            mvt.displayMemoryStatus();
            return;
        }
        paso++;
        System.out.println("paso: " + paso);

        // 1. Liberar memoria de procesos que terminan en este paso
        for (var proceso : colaProcesos) {
            if (proceso.getPasoDeSalida() == paso && proceso.getValue().isAllocated()) {
                mvt.freeMemory(proceso.getValue().getId(), paso); // pasa el paso actual
                notifyAll(mvt.getEstadoMemoria());
                proceso.actualizarEstado(EstadoProceso.FINALIZADO);
            }
        }

        // 2. Intentar asignar procesos en espera primero
        List<Data> asignadosEnEstePaso = new ArrayList<>();
        for (Data proceso : procesosEnEspera) {
            if (!proceso.isFinalized() && !proceso.getValue().isAllocated()) {
                boolean asignado = mvt.allocateMemory(proceso.getValue());
                if (asignado) {
                    // Actualiza tiempo de llegada y salida para que cumpla su duración completa desde ahora
                    proceso.setTiempoLlegada(paso);
                    proceso.setPasoDeSalida(paso + proceso.getDuracion());
                    proceso.actualizarEstado(EstadoProceso.ACTIVO);
                    notifyAll(mvt.getEstadoMemoria());
                    asignadosEnEstePaso.add(proceso);
                    // Mostrar mensaje solo para procesos que estuvieron en espera
                    JOptionPane.showMessageDialog(null, 
                        "El proceso " + proceso.getValue().getId() + " fue asignado con éxito después de estar en espera.",
                        "Asignación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
        // Elimina los procesos que ya fueron asignados de la lista de espera
        procesosEnEspera.removeAll(asignadosEnEstePaso);

        // 3. Intentar asignar procesos que llegan en este paso
        for (var proceso : colaProcesos) {
            if (proceso.getTiempoLlegada() == paso && !proceso.isFinalized() && !proceso.getValue().isAllocated()) {
                boolean asignado = mvt.allocateMemory(proceso.getValue());
                if (asignado) {
                    proceso.actualizarEstado(EstadoProceso.ACTIVO);
                    notifyAll(mvt.getEstadoMemoria());
                } else {
                    // Si no se pudo asignar, agregar a la lista de espera
                    procesosEnEspera.add(proceso);
                }
            }
        }
    }
    
    public void subscribe(String type, Viewer listener) {
        viewers.put(type, listener);
    }
    
    public void unsuscribe(String type) {
        viewers.remove(type);
    }

    private void notifyAll(List<TablasDto> dtos) {
        for (String key : viewers.keySet()) {
            var value = viewers.get(key);
            value.display(dtos);
        }
    }
    
    public List<Data> getColaProcesos() {
        return colaProcesos;
    }

    public MVT getMvt() {
        return mvt;
    }


    
    
}
