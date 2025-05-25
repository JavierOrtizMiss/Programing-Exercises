/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejemplo.model;

import com.mycompany.ejemplo.controller.TablasDto;
import java.util.List;

/**
 *
 * @author Tony
 */

public interface Viewer {
    void display(List<TablasDto> dtos);
}