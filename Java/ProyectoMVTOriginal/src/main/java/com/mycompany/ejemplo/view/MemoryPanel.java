package com.mycompany.ejemplo.view;

/**
 *
 * @author javierortiz
 */

import com.mycompany.ejemplo.model.Particion;
import java.awt.*;
import java.util.List;
import javax.swing.JPanel;

public class MemoryPanel extends JPanel {
    private List<Particion> particiones;
    private int tamanoSO;
    private int tamanoTotal;

    public MemoryPanel(int tamanoSO, int tamanoTotal) {
        this.tamanoSO = tamanoSO;
        this.tamanoTotal = tamanoTotal;
        setPreferredSize(new Dimension(200, 400)); 
        setOpaque(false); 
    }

    public void setParticiones(List<Particion> particiones) {
        this.particiones = particiones;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelHeight = getHeight();
        int panelWidth = getWidth();

        int leftMargin = 50; // margen izquierdo mayor para dejar espacio a la localidad

        // Dibuja el SO
        int soHeight = (int) ((tamanoSO / (double) tamanoTotal) * panelHeight);
        g.setColor(new Color(41, 128, 185));
        g.fillRect(leftMargin, 0, panelWidth - leftMargin - 10, soHeight); 
        g.setColor(Color.WHITE);
        Font soFont = new Font("SansSerif", Font.BOLD, 18);
        g.setFont(soFont);
        String soLabel = "SO";
        FontMetrics soFm = g.getFontMetrics(soFont);
        int soLabelWidth = soFm.stringWidth(soLabel);
        int soLabelX = leftMargin + ((panelWidth - leftMargin - 10) - soLabelWidth) / 2;
        int soLabelY = soHeight / 2 + soFm.getAscent() / 2 - 2;
        g.drawString(soLabel, soLabelX, soLabelY);

        // Determinar si hay fragmentación externa (más de un área libre)
        int freeCount = 0;
        if (particiones != null) {
            for (Particion p : particiones) {
                if (p.isFree()) freeCount++;
            }
        }
        boolean hayFragmentacion = freeCount > 1;

        // Dibuja las particiones dinámicas
        if (particiones != null) {
            int y = soHeight;
            for (int i = 0; i < particiones.size(); i++) {
                Particion p = particiones.get(i);
                int partHeight = (int) ((p.getSize() / (double) tamanoTotal) * panelHeight);
                if (p.isFree()) {
                    if (hayFragmentacion) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(new Color(175, 200, 205));
                    }
                } else {
                    g.setColor(new Color(0, 228, 168));
                }
                g.fillRect(leftMargin, y, panelWidth - leftMargin - 10, partHeight); 

                // Línea blanca de separación (no antes de la primera partición)
                if (i > 0) {
                    g.setColor(Color.WHITE);
                    g.drawLine(leftMargin, y, panelWidth - 10, y);
                }

                // Etiqueta del proceso (centrada)
                g.setColor(Color.BLACK);
                Font labelFont = new Font("SansSerif", Font.BOLD, 12);
                g.setFont(labelFont);
                String label = p.isFree() ? "Libre" : p.getProcesoId();
                FontMetrics fm = g.getFontMetrics(labelFont);
                int labelWidth = fm.stringWidth(label);
                int labelX = leftMargin + ((panelWidth - leftMargin - 10) - labelWidth) / 2;
                int labelY = y + partHeight / 2 + fm.getAscent() / 2 - 2;
                g.drawString(label, labelX, labelY);

                // Dibuja la localidad de inicio a la izquierda del bloque
                g.setFont(new Font("SansSerif", Font.PLAIN, 14));
                int localidadInicio = p.getStartAddress() + tamanoSO;
                g.drawString(localidadInicio + "K", 21, y + 3); // Ahora sí se ve

                // Solo para la última partición, dibuja la localidad de fin
                if (i == particiones.size() - 1) {
                    int localidadFin = p.getStartAddress() + p.getSize() + tamanoSO;
                    g.drawString(localidadFin + "K", 21, y + partHeight - 4);
                }

                y += partHeight;
            }
        }

        // Dibuja solo los números de inicio y fin (0K)
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("0 K", 25, 11);

    }
}
