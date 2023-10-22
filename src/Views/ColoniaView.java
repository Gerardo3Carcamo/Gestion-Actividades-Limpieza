/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ColoniaController;
import Models.ColoniaModel;
import Models.TableModels.ColoniaTableModel;
import Views.CustomView.AgregarColonia;
import java.util.List;

/**
 *
 * @author 000093883
 */
public class ColoniaView extends javax.swing.JFrame {
    
    private ColoniaController colonia = new ColoniaController();

    /**
     * Creates new form ColoniaView
     */
    public ColoniaView() {
        initComponents();
        getColoniaData();
    }

    public void getColoniaData(){
        List<ColoniaModel> list = colonia.getColonias();
        ColoniaTableModel modelo = new ColoniaTableModel(list);
        jTable1.setModel(modelo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Catalogo colonias");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Refrescar = new rojeru_san.RSButton();
        Volver = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();
        AgregarColonia = new rojeru_san.RSButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(98, 0, 238));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Refrescar.setBackground(new java.awt.Color(3, 218, 197));
        Refrescar.setForeground(new java.awt.Color(0, 0, 0));
        Refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recargar.png"))); // NOI18N
        Refrescar.setText("Recargar tabla");
        Refrescar.setColorText(new java.awt.Color(0, 0, 0));
        Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefrescarActionPerformed(evt);
            }
        });
        jPanel2.add(Refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, -1));

        Volver.setBackground(new java.awt.Color(176, 0, 32));
        Volver.setForeground(new java.awt.Color(0, 0, 0));
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cerrar-sesion.png"))); // NOI18N
        Volver.setText("Cerrar ventana");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel2.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 240, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cubeta.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        AgregarColonia.setBackground(new java.awt.Color(3, 218, 197));
        AgregarColonia.setForeground(new java.awt.Color(0, 0, 0));
        AgregarColonia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boton-mas.png"))); // NOI18N
        AgregarColonia.setText("Agregar colonia nueva");
        AgregarColonia.setColorText(new java.awt.Color(0, 0, 0));
        AgregarColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarColoniaActionPerformed(evt);
            }
        });
        jPanel2.add(AgregarColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 570));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 860, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefrescarActionPerformed
        getColoniaData();
    }//GEN-LAST:event_RefrescarActionPerformed

    private void AgregarColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarColoniaActionPerformed
        AgregarColonia ac = new AgregarColonia(this, true);
        ac.setVisible(true);
    }//GEN-LAST:event_AgregarColoniaActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColoniaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColoniaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColoniaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColoniaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColoniaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton AgregarColonia;
    private rojeru_san.RSButton Refrescar;
    private rojeru_san.RSButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
