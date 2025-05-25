/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.controller;

import com.mycompany.ejemplo.model.Proceso;
import com.mycompany.ejemplo.model.Particion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class MVT {
    private int allocationSizeSO;
    private int totalMemorySize;
    private List<Particion> particiones;
    private int pasoActual = 0; // Agrega esto si quieres llevar el control aquí

    public MVT(int totalMemorySize, int allocationSizeSO) {
        this.totalMemorySize = totalMemorySize - allocationSizeSO;
        this.allocationSizeSO = allocationSizeSO;
        this.particiones = new ArrayList<>();
        particiones.add(new Particion(0, this.totalMemorySize, true));
    }

    public void setPasoActual(int paso) {
        this.pasoActual = paso;
    }
    
    // Método para asignar memoria a un proceso usando Best Fit (Mejor Ajuste)
    public boolean allocateMemory(Proceso proceso) {
        if (proceso.isAllocated()) {
            System.out.println("Proceso " + proceso.getId() + " ya tiene memoria asignada.");
            return false;
        }
        
        int procesoSize = proceso.getSize();
        Particion bestFitBlock = null;
        int bestFitIndex = -1;
        int minExcessSize = Integer.MAX_VALUE;
        
        // Buscar el bloque libre más pequeño que pueda contener el proceso
        for (int i = 0; i < particiones.size(); i++) {
            Particion block = particiones.get(i);
            if (block.isFree() && block.getSize() >= procesoSize) {
                int excessSize = block.getSize() - procesoSize;
                if (excessSize < minExcessSize) {
                    bestFitBlock = block;
                    bestFitIndex = i;
                    minExcessSize = excessSize;
                }
            }
        }
        
        // Si no se encontró un bloque adecuado
        if (bestFitBlock == null) {
            System.out.println("No hay suficiente memoria contigua para el proceso " + proceso.getId());
            JOptionPane.showMessageDialog(null, "No hay suficiente memoria contigua para el proceso " + proceso.getId());
            return false;
        }
        
        // Si el bloque encontrado es exactamente del tamaño necesario
        if (bestFitBlock.getSize() == procesoSize) {
            bestFitBlock.allocate(proceso.getId(), proceso.getNumero());
        } else {
            // Si el bloque es más grande, dividirlo
            int startAddress = bestFitBlock.getStartAddress();
            particiones.remove(bestFitIndex);
            
            // Crear el bloque asignado
            Particion allocatedBlock = new Particion(startAddress, procesoSize, false);
            allocatedBlock.allocate(proceso.getId(), proceso.getNumero());
            
            // Crear el bloque libre restante
            Particion remainingBlock = new Particion(
                startAddress + procesoSize,
                bestFitBlock.getSize() - procesoSize,
                true
            );
            
            // Añadir los bloques a la lista en orden
            particiones.add(bestFitIndex, remainingBlock);
            particiones.add(bestFitIndex, allocatedBlock);
        }
        
        proceso.setAllocated(true);
        System.out.println("Proceso " + proceso.getId() + " asignado con éxito.");
        return true;
    }
    
    // Método para liberar la memoria de un proceso
    public boolean freeMemory(String procesoId, int pasoActual) {
        boolean found = false;
        
        for (int i = 0; i < particiones.size(); i++) {
            Particion block = particiones.get(i);
            
            if (!block.isFree() && block.getProcesoId().equals(procesoId)) {
                block.free();
                found = true;
                
                // Verificar si se puede combinar con bloques libres adyacentes
                mergeAdjacentFreeBlocks();
                break;
            }
        }
        
        if (!found) {
            System.out.println("No se encontró el proceso " + procesoId + " en memoria.");
            JOptionPane.showMessageDialog(null, "No se encontró el proceso " + procesoId + " en memoria.");
            return false;
        }
        
        System.out.println("Memoria liberada para el proceso " + procesoId);
        return true;
    }
    
    // Método para combinar bloques libres adyacentes
    private void mergeAdjacentFreeBlocks() {
        for (int i = 0; i < particiones.size() - 1; i++) {
            Particion currentBlock = particiones.get(i);
            Particion nextBlock = particiones.get(i + 1);
            
            if (currentBlock.isFree() && nextBlock.isFree()) {
                // Crear un nuevo bloque combinado
                Particion mergedBlock = new Particion(
                    currentBlock.getStartAddress(),
                    currentBlock.getSize() + nextBlock.getSize(),
                    true
                );
                
                // Eliminar los bloques originales
                particiones.remove(i); // Elimina el bloque actual
                particiones.remove(i); // Elimina el siguiente bloque (ahora en la posición i)
                
                // Insertar el bloque combinado
                particiones.add(i, mergedBlock);
                
                // Retroceder el índice para verificar si se puede combinar con el bloque anterior
                i--;
            }
        }
    }
    
    public List<TablasDto> getEstadoMemoria() {
        var data = new ArrayList<TablasDto>();
        
        for (int i = 0; i < particiones.size(); i++) {
            Particion block = particiones.get(i);
            int memoriaUsada = block.isFree() ? 0 : block.getSize();
            int memoriaLibre = block.isFree() ? block.getSize() : 0;
            data.add(new TablasDto(
                block.getStartAddress(),  // localidad
                block.getSize(),          // size
                block.isFree() ? "" : block.getProcesoId(),  // proceso (vacío si está libre)
                memoriaUsada,             // memoriaUsada
                memoriaLibre,             // memoriaLibre
                block.getNumeroProceso(), // Numero de proceso
                block.isFree() ? "D" : "A",
                block.isFree()
            ));
        }
        return data;
    }
    
    // Método para mostrar el estado actual de la memoria
    public void displayMemoryStatus() {
        System.out.println("\n=== Estado de la Memoria ===");
        System.out.println("Memoria total: " + totalMemorySize + "KB");
        
        int usedMemory = 0;
        for (Particion block : particiones) {
            if (!block.isFree()) {
                usedMemory += block.getSize();
                
                System.out.println("[" + (block.getStartAddress() + allocationSizeSO) + "-" + (block.getEndAddress() + allocationSizeSO) + "] Free: " + block.getSize() + "KB");
            }
            System.out.println("[" + (block.getStartAddress() + allocationSizeSO) + "-" + (block.getEndAddress() + allocationSizeSO) + "] Proceso: " + block.getProcesoId() + " (" + block.getSize() + "KB)");
        }
        
        System.out.println("Memoria utilizada: " + usedMemory + "KB");
        System.out.println("Memoria libre: " + (totalMemorySize - usedMemory) + "KB");
        System.out.println("Fragmentación externa: " + calculateExternalFragmentation() + "KB");
        System.out.println("============================\n");
    }
    
    // Método para calcular la fragmentación externa
    private int calculateExternalFragmentation() {
        int totalFreeMemory = 0;
        int largestFreeBlock = 0;
        
        for (Particion block : particiones) {
            if (block.isFree()) {
                totalFreeMemory += block.getSize();
                largestFreeBlock = Math.max(largestFreeBlock, block.getSize());
            }
        }
        
        // La fragmentación externa es la memoria libre que no se puede usar para el proceso más grande
        return totalFreeMemory - largestFreeBlock;
    }
    
    public List<Particion> getParticiones() {
        return particiones;
    }
}
