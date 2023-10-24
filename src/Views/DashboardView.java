/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ChartController;
import Models.ChartModel;
import Models.UsuarioModel;
import Views.CustomView.AgregarFlotillaView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author 000093883
 */
public class DashboardView extends javax.swing.JFrame {

    UsuarioModel user = new UsuarioModel();

    /**
     * Creates new form DashboardView
     */
    public DashboardView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getDataCharts();
    }

    public DashboardView(UsuarioModel user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        if (user.getRoleID() != 1) {
            VerCatalogo.setEnabled(false);
        }
        this.user = user;
        this.Nombre.setText("Nombre: " + user.getNombre());
        this.Correo.setText("Correo: " + user.getEmail());
        this.Telefono.setText("Telefono: " + user.getTelefono());
        getDataCharts();
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
        VerMiFlotilla = new rojeru_san.RSButton();
        AgregarAFlotilla = new rojeru_san.RSButton();
        VerCatalogo = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();
        Graficar = new rojeru_san.RSButton();
        CerrarSesion = new rojeru_san.RSButton();
        Tareas = new rojeru_san.RSButton();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Correo = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        rSPanelShadow2 = new rojeru_san.RSPanelShadow();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        chart1 = new javax.swing.JPanel();
        rSPanelShadow4 = new rojeru_san.RSPanelShadow();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        chart2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(98, 0, 238));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VerMiFlotilla.setBackground(new java.awt.Color(3, 218, 197));
        VerMiFlotilla.setForeground(new java.awt.Color(0, 0, 0));
        VerMiFlotilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grupo.png"))); // NOI18N
        VerMiFlotilla.setText("Ver flotilla");
        VerMiFlotilla.setColorText(new java.awt.Color(0, 0, 0));
        VerMiFlotilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerMiFlotillaActionPerformed(evt);
            }
        });
        jPanel2.add(VerMiFlotilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, -1));

        AgregarAFlotilla.setBackground(new java.awt.Color(3, 218, 197));
        AgregarAFlotilla.setForeground(new java.awt.Color(0, 0, 0));
        AgregarAFlotilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boton-mas.png"))); // NOI18N
        AgregarAFlotilla.setText("Agregar a mi flotilla");
        AgregarAFlotilla.setColorText(new java.awt.Color(0, 0, 0));
        AgregarAFlotilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAFlotillaActionPerformed(evt);
            }
        });
        jPanel2.add(AgregarAFlotilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, -1));

        VerCatalogo.setBackground(new java.awt.Color(3, 218, 197));
        VerCatalogo.setForeground(new java.awt.Color(0, 0, 0));
        VerCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/libro-abierto.png"))); // NOI18N
        VerCatalogo.setText("Catalogo de colonias");
        VerCatalogo.setColorText(new java.awt.Color(0, 0, 0));
        VerCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCatalogoActionPerformed(evt);
            }
        });
        jPanel2.add(VerCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 240, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cubeta.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        Graficar.setBackground(new java.awt.Color(3, 218, 197));
        Graficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/barra-grafica.png"))); // NOI18N
        Graficar.setText("Ver graficas");
        Graficar.setColorText(new java.awt.Color(0, 0, 0));
        Graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficarActionPerformed(evt);
            }
        });
        jPanel2.add(Graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 240, -1));

        CerrarSesion.setBackground(new java.awt.Color(176, 0, 32));
        CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cerrar-sesion.png"))); // NOI18N
        CerrarSesion.setText("Cerrar sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 240, -1));

        Tareas.setBackground(new java.awt.Color(3, 218, 197));
        Tareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tarea-completada.png"))); // NOI18N
        Tareas.setText("Tareas");
        Tareas.setColorText(new java.awt.Color(0, 0, 0));
        Tareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TareasActionPerformed(evt);
            }
        });
        jPanel2.add(Tareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Información del usuario");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        Nombre.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Nombre.setText("Nombre: Gerardo Cárcamo");
        jPanel3.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 420, -1));

        Correo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Correo.setText("Correo: gerca4401@gmail.com");
        jPanel3.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 420, -1));

        Telefono.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Telefono.setText("Telefono: 8443832692");
        jPanel3.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 420, -1));

        jPanel15.setBackground(new java.awt.Color(25, 118, 210));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSPanelShadow1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 430, 570));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(25, 118, 210));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        chart1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(rSPanelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 430, 290));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(25, 118, 210));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        chart2.setBackground(new java.awt.Color(255, 255, 255));
        chart2.setPreferredSize(new java.awt.Dimension(520, 234));

        javax.swing.GroupLayout chart2Layout = new javax.swing.GroupLayout(chart2);
        chart2.setLayout(chart2Layout);
        chart2Layout.setHorizontalGroup(
            chart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart2Layout.setVerticalGroup(
            chart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
        );

        rSPanelShadow4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(rSPanelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 430, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCatalogoActionPerformed
        new ColoniaView().setVisible(true);
    }//GEN-LAST:event_VerCatalogoActionPerformed

    private void GraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficarActionPerformed
        getDataCharts();
    }//GEN-LAST:event_GraficarActionPerformed

    private void AgregarAFlotillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAFlotillaActionPerformed
        new AgregarFlotillaView(this, true, user).setVisible(true);
    }//GEN-LAST:event_AgregarAFlotillaActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        new Login().setVisible(true);
        this.user = null;
        this.dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void VerMiFlotillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerMiFlotillaActionPerformed
        new FlotillaView(user).setVisible(true);
    }//GEN-LAST:event_VerMiFlotillaActionPerformed

    private void TareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TareasActionPerformed
        new TareaView(user).setVisible(true);
    }//GEN-LAST:event_TareasActionPerformed

    void getDataCharts() {
        List<ChartModel> listPorMes = new ChartController().getTareasPorMes();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        listPorMes.forEach(x -> {
            datos.setValue(x.getConteo(), x.getNombre(), "Mes: " + String.valueOf(x.getMes()));
        });
        JFreeChart chart = ChartFactory.createBarChart("Tareas asignadas del mes: ", "", "", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(520, 234));
        chart1.setLayout(new BorderLayout());
        chart1.add(chartPanel, BorderLayout.NORTH);

        List<ChartModel> listPorMesCompletadas = new ChartController().getTareasCompletadasPorMes();
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        listPorMesCompletadas.forEach(x -> {
            datos2.setValue(x.getConteo(), x.getNombre(), "Mes: " + String.valueOf(x.getMes()));
        });
        JFreeChart chartBar2 = ChartFactory.createBarChart("Tareas completadas del mes: ", "", "", datos2, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel2 = new ChartPanel(chartBar2);
        chartPanel2.setPreferredSize(new Dimension(520, 215));
        chart2.setLayout(new BorderLayout());
        chart2.add(chartPanel2, BorderLayout.NORTH);
        chartPanel.repaint();
        chartPanel2.repaint();
        pack();
        revalidate();
        repaint();

    }

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
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton AgregarAFlotilla;
    private rojeru_san.RSButton CerrarSesion;
    private javax.swing.JLabel Correo;
    private rojeru_san.RSButton Graficar;
    private javax.swing.JLabel Nombre;
    private rojeru_san.RSButton Tareas;
    private javax.swing.JLabel Telefono;
    private rojeru_san.RSButton VerCatalogo;
    private rojeru_san.RSButton VerMiFlotilla;
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojeru_san.RSPanelShadow rSPanelShadow2;
    private rojeru_san.RSPanelShadow rSPanelShadow4;
    // End of variables declaration//GEN-END:variables
}
