/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.model;

import java.util.List;

/**
 *
 * @author Tony
 */
public class DataInicial {
    public static List<Data> execute() {
        var DataA = new Data("A", 8, 1, 7, 1);
        var DataB = new Data("B", 14, 2, 7, 2);
        var DataC = new Data("C", 18, 3, 4, 3);
        var DataD = new Data("D", 6, 4, 6, 4);
        var DataE = new Data("E", 14, 5, 5, 5);
        return List.of(DataA, DataB, DataC, DataD, DataE);
    }
}
