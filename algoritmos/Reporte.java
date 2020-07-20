/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis2.algoritmos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.management.remote.JMXServiceURL;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

/**
 *
 * @author Andres
 */
public class Reporte extends javax.swing.JDialog {

    /**
     * Creates new form Reporte
     */
    public Reporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    Reporte(JDialog aThis, String resultados, ModalityType modalityType, Resultados resultadoG) {
        super(aThis, modalityType);
        initComponents();
        this.setTitle("Reporte de Resultados");
        this.setSize(900, 600);
        // TODO add your handling code here:
        double[] xData = new double[]{1, 2, 3, 4};
        double[] yData = new double[]{2, 1, 2, 0};

        //JPanel1
        XYChart chart = QuickChart.getChart("Mejor Solucion por Generacion", "Generacion", "Puntaje", "Mejor", resultadoG.generaciones, resultadoG.puntajesMejoresSoluciones);
        XChartPanel xcp = new XChartPanel((XYChart) chart);
        jTabbedPane1.addTab("Por Generacion", xcp);

//JPanel2
        XYChart chart2 = QuickChart.getChart("Promedio de Soluciones por Generacion", "Generacion", "Puntaje", "Promedio", resultadoG.generaciones, resultadoG.promedioSoluciones);
        XChartPanel xcp2 = new XChartPanel((XYChart) chart2);
        jTabbedPane1.addTab("Promedios", xcp2);

        //JPanel3
        XYChart chart3 = QuickChart.getChart("Puntajes de la Ultima Generacion", "Solucion", "Puntaje", "Puntaje", resultadoG.indicesSoluciones, resultadoG.soluciones);
        XChartPanel xcp3 = new XChartPanel((XYChart) chart3);
        jTabbedPane1.addTab("Ultima", xcp3);

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.removeRow(0);
        dtm.removeRow(0);
        dtm.removeRow(0);
        dtm.removeRow(0);
        for (int i = 0; i < resultadoG.mejorSolucion.cromosoma.size()
                && i < resultadoG.solucionFormateada1.size(); i++) {
            Object[] fila = new Object[4];
            fila[0] = resultadoG.solucionFormateada1.get(i);
            fila[1] = ((float) Math.round(resultadoG.solucionFormateada2.get(i) * 100)) / 100;

            fila[2] = resultadoG.solucionFormateada3.get(i);
            fila[3] = resultadoG.solucionFormateada4.get(i);
            dtm.addRow(fila);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(400, 200));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Material", "Posicion", "Item del Pedido", "Largo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Resultado", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reporte dialog = new Reporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
