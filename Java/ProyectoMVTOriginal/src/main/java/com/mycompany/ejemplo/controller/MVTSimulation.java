/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.controller;

import com.mycompany.ejemplo.model.DataInicial;
import com.mycompany.ejemplo.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class MVTSimulation {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var controller = new Controller(DataInicial.execute(), 64, 10);
        while (true) {
            System.out.println("Introduzca 1 para hacer un paso");
            int option = scanner.nextInt();
            if (option == 1) {
                controller.realizarPaso();
            }
        }
    }
}
