/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejemplo.view;

import com.mycompany.ejemplo.controller.Controller;
// Elimina o comenta la siguiente línea:
// import com.mycompany.ejemplo.controller.ResultDto;
import com.mycompany.ejemplo.model.DataInicial;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author javierortiz
 */
public class FrmView extends javax.swing.JFrame {
    private Controller controller;
    private int step;
    private TbProcesos tbProcesosHelper;
    private TbParticiones tbParticionesHelper;
    private MemoryPanel memoryPanel;
    

    /**
     * Creates new form FrmView
     */
    public FrmView() {
        initComponents();
        customizeTables();
        memoryPanel = new MemoryPanel(10, 64); // SO=10, total=64
        getContentPane().add(memoryPanel);
        memoryPanel.setBounds(600, 150, 200, 400); 
        initializeSimulation();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void initializeSimulation() {
        this.controller = new Controller(DataInicial.execute(), 64, 10);
        this.step = 0;
        this.tbProcesosHelper = new TbProcesos();
        this.tbParticionesHelper = new TbParticiones();
        btnSteps.setText("Paso " + step);
        updateTables();
        memoryPanel.setParticiones(controller.getMvt().getParticiones());
    }
        
    private void updateTables() {
        tbProcesosHelper.iniciaTabla(tbProcesos, controller.getMvt().getParticiones(), 10); 
        tbParticionesHelper.iniciaTabla(tbParticiones, controller.getMvt().getParticiones(), 10, step); 
        memoryPanel.setParticiones(controller.getMvt().getParticiones());
    }
    
  

    
    
    private void customizeTables() {
 //Set background color
        getContentPane().setBackground(Color.WHITE);

        // Customize tbProcesos header
        tbProcesos.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = new JLabel(value.toString());
                headerLabel.setOpaque(true);
                headerLabel.setBackground(Color.decode("#00E4A8")); 
                headerLabel.setForeground(Color.WHITE); 
                headerLabel.setFont(new Font("SansSerif", Font.BOLD, 12)); 
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                return headerLabel;
            }
        });

        // Customize tbParticiones header
        tbParticiones.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = new JLabel(value.toString());
                headerLabel.setOpaque(true);
                headerLabel.setBackground(Color.decode("#00E4A8")); 
                headerLabel.setForeground(Color.WHITE); 
                headerLabel.setFont(new Font("SansSerif", Font.BOLD, 12)); 
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                return headerLabel;
            }
        });

        // Customize row appearance for tbProcesos
        tbProcesos.setBackground(Color.decode("#CAF5E1")); 
        tbProcesos.setForeground(Color.BLACK); 
        tbProcesos.setFont(new Font("SansSerif", Font.PLAIN, 12)); 
        tbProcesos.setGridColor(Color.WHITE); 
        tbProcesos.setShowGrid(true); 
        tbProcesos.setRowHeight(25); 

        // Customize row appearance for tbParticiones
        tbParticiones.setBackground(Color.decode("#CAF5E1")); 
        tbParticiones.setForeground(Color.BLACK); 
        tbParticiones.setFont(new Font("SansSerif", Font.PLAIN, 12)); 
        tbParticiones.setGridColor(Color.WHITE); 
        tbParticiones.setShowGrid(true); 
        tbParticiones.setRowHeight(25); 

        // Adjust column widths for tbProcesos
        tbProcesos.getColumnModel().getColumn(0).setPreferredWidth(50); 
        tbProcesos.getColumnModel().getColumn(1).setPreferredWidth(100); 

        // Adjust column widths for tbParticiones
        tbParticiones.getColumnModel().getColumn(0).setPreferredWidth(50); 
        tbParticiones.getColumnModel().getColumn(1).setPreferredWidth(100); 

        // Center align the text in the cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbProcesos.getColumnModel().getColumns().asIterator().forEachRemaining(column -> column.setCellRenderer(centerRenderer));
        tbParticiones.getColumnModel().getColumns().asIterator().forEachRemaining(column -> column.setCellRenderer(centerRenderer));
        
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProcesos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbParticiones = new javax.swing.JTable();
        btnSteps = new javax.swing.JButton();
        txtAreasLibres = new javax.swing.JLabel();
        txtTbParticiones = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuItemSalir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("SIMULACIÓN DE ASIGNACIÓN DE MEMORIA CON MVT");

        tbProcesos.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tbProcesos.setForeground(new java.awt.Color(0, 0, 0));
        tbProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbProcesos);

        tbParticiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbParticiones);

        btnSteps.setText("Paso");
        btnSteps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStepsActionPerformed(evt);
            }
        });

        txtAreasLibres.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        txtAreasLibres.setText("Tabla Áreas Libres (TAL[])");

        txtTbParticiones.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        txtTbParticiones.setText("Tabla Particiones (TP[])");

        menuItemSalir.setText("Options");
        menuItemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemSalirMouseClicked(evt);
            }
        });
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Reiniciar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuItemSalir.add(jMenuItem1);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuItemSalir.add(jMenuItem4);

        jMenuBar1.add(menuItemSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtTbParticiones))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtAreasLibres))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSteps, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(txtAreasLibres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtTbParticiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnSteps)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStepsActionPerformed

        if (btnSteps.getText().equals("Simulación Finalizada")) {
            int option = JOptionPane.showConfirmDialog(
                this,
                "¿Quieres reiniciar el simulador?",
                "Simulación Terminada",
                JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {
                initializeSimulation();
                btnSteps.setEnabled(true); 
            } else {
                this.dispose();
            }
            return; 
        }

        controller.realizarPaso();
        step++;
        btnSteps.setText("Paso " + step);
        updateTables();

        long finalizedCount = controller.getColaProcesos().stream()
            .filter(proceso -> proceso.isFinalized())
            .count();

        long totalProcesses = controller.getColaProcesos().size();

        if (finalizedCount == totalProcesses) {
            btnSteps.setText("Simulación Finalizada");
            btnSteps.setEnabled(false); 

            // Mostrar el estado de la memoria en un JOptionPane
            StringBuilder status = new StringBuilder();
            status.append("=== Estado de la Memoria ===\n");
            int totalMemorySize = controller.getMvt().getParticiones().stream().mapToInt(p -> p.getSize()).sum();
            int soSize = 10; // Hardcodeado igual que en el resto del código
            status.append("Memoria total (sin SO): ").append(totalMemorySize).append(" KB\n");
            status.append("Tamaño SO: ").append(soSize).append(" KB\n\n");

            int usedMemory = 0;
            int freeMemory = 0;
            int largestFreeBlock = 0;
            for (var block : controller.getMvt().getParticiones()) {
                if (block.isFree()) {
                    status.append("[").append(block.getStartAddress() + soSize).append("-")
                        .append(block.getEndAddress() + soSize).append("] Libre: ")
                        .append(block.getSize()).append(" KB\n");
                    freeMemory += block.getSize();
                    largestFreeBlock = Math.max(largestFreeBlock, block.getSize());
                } else {
                    status.append("[").append(block.getStartAddress() + soSize).append("-")
                        .append(block.getEndAddress() + soSize).append("] Proceso: ")
                        .append(block.getProcesoId()).append(" (")
                        .append(block.getSize()).append(" KB)\n");
                    usedMemory += block.getSize();
                }
            }
            status.append("\nMemoria utilizada: ").append(usedMemory).append(" KB\n");
            status.append("Memoria libre: ").append(freeMemory).append(" KB\n");
            status.append("Fragmentación externa: ").append(freeMemory - largestFreeBlock).append(" KB\n");
            status.append("============================");

            JOptionPane.showMessageDialog(this, status.toString(), "Estado final de la memoria", JOptionPane.INFORMATION_MESSAGE);

            return;
        }
    }//GEN-LAST:event_btnStepsActionPerformed

    private void menuItemSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemSalirMouseClicked
        
    }//GEN-LAST:event_menuItemSalirMouseClicked

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       initializeSimulation();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSteps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuItemSalir;
    private javax.swing.JTable tbParticiones;
    private javax.swing.JTable tbProcesos;
    private javax.swing.JLabel txtAreasLibres;
    private javax.swing.JLabel txtTbParticiones;
    // End of variables declaration//GEN-END:variables
}
