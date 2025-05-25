package com.mycompany.ejemplo.view;

/**
 *
 * @author javierortiz
 */

import com.mycompany.ejemplo.model.Particion;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TbProcesos {

    public void iniciaTabla(JTable tabla, List<Particion> particiones, int tamanoSO) {
        Vector<String> titulos = new Vector<>();
        Vector<Vector<Object>> datos = new Vector<>();

        titulos.add("No");
        titulos.add("Localidad");
        titulos.add("Tamaño");
        titulos.add("Estado");

        int index = 1;
        for (Particion particion : particiones) {
            if (particion.isFree()) {
                Vector<Object> fila = new Vector<>();
                fila.add(index++);
                fila.add(particion.getStartAddress() + tamanoSO);
                fila.add(particion.getSize());
                fila.add("D");
                datos.add(fila);
            }
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        tabla.setModel(modelo);
    }
}
