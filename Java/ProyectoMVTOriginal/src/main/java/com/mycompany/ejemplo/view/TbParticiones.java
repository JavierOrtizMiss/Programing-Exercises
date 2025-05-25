package com.mycompany.ejemplo.view;

import com.mycompany.ejemplo.model.Particion;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TbParticiones {

    public void iniciaTabla(JTable tabla, List<Particion> particiones, int tamanoSO, int pasoActual) {
        Vector<String> titulos = new Vector<>();
        Vector<Vector<Object>> datos = new Vector<>();

        titulos.add("No");
        titulos.add("Localidad");
        titulos.add("Tamaño");
        titulos.add("Proceso");

        int index = 1;
        for (Particion particion : particiones) {
            if (!particion.isFree()) {
                Vector<Object> fila = new Vector<>();
                fila.add(index++);
                fila.add(particion.getStartAddress() + tamanoSO);
                fila.add(particion.getSize());
                fila.add(particion.getProcesoId());
                datos.add(fila);
            }
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modelo);
    }
}
