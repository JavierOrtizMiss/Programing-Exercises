/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo.controller;

/**
 *
 * @author Tony
 */
public record TablasDto(
    int localidad,
    int size,
    String proceso,
    int memoriaUsada,
    int memeoriaLibre,
    int numeroProceso,
    String estado,
    boolean isFree
) {}
