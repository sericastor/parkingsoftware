/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AboutParkQuickView.java
 *
 * Created on 8/10/2011, 05:57:29 PM
 */
package view;

import controller.Administration.ParkingManagementController;
import controller.MainController;
import javax.swing.ImageIcon;

/**
 *
 * @author Grupo E
 */
public class AboutParkQuickView extends javax.swing.JFrame {

    /** Creates new form AboutParkQuickView */
    public AboutParkQuickView() {
        ImageIcon img=new ImageIcon("src/images/parking1.gif"); 
         setIconImage(img.getImage()); 
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        CountLabel.setText("1,3");
    }
    
    public void setClientLabel(String name){
        ClientLabel.setText(name);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoPanel = new javax.swing.JPanel();
        InfoPanel = new javax.swing.JPanel();
        SoftwareLabel = new javax.swing.JLabel();
        IconLabel = new javax.swing.JLabel();
        VersionLabel = new javax.swing.JLabel();
        CountLabel = new javax.swing.JLabel();
        CopyrightLabel = new javax.swing.JLabel();
        SebastianLabel = new javax.swing.JLabel();
        MigueLabel = new javax.swing.JLabel();
        DiegoLabel = new javax.swing.JLabel();
        MartinLabel = new javax.swing.JLabel();
        PipexLabel = new javax.swing.JLabel();
        LicenseLabel = new javax.swing.JLabel();
        ClientLabel = new javax.swing.JLabel();
        OkLabel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de ParkQuick");
        setResizable(false);

        LogoPanel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout LogoPanelLayout = new javax.swing.GroupLayout(LogoPanel);
        LogoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        LogoPanelLayout.setVerticalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );

        SoftwareLabel.setText("ParkQuick");

        IconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flag.png"))); // NOI18N

        VersionLabel.setText("Versión");

        CountLabel.setText("(0.0)");

        CopyrightLabel.setText("Copyright © 2011 Grupo-E. Reservados todos los derechos.");

        SebastianLabel.setText("Sebastián Castro");

        MigueLabel.setText("Miguel Chitiva");

        DiegoLabel.setText("Diego Salgado");

        MartinLabel.setText("Martn Kanayet");

        PipexLabel.setText("Felipe Castaño");

        LicenseLabel.setText("La licencia de este producto se condece a:");

        ClientLabel.setText("(Park)");

        OkLabel.setText("Aceptar");
        OkLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkLabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(IconLabel)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SoftwareLabel)
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addComponent(VersionLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CountLabel))
                                    .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(OkLabel)
                                        .addComponent(CopyrightLabel))))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MigueLabel)
                                    .addComponent(SebastianLabel)
                                    .addComponent(DiegoLabel)
                                    .addComponent(MartinLabel)
                                    .addComponent(PipexLabel)))))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(LicenseLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ClientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(SoftwareLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VersionLabel)
                            .addComponent(CountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CopyrightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SebastianLabel))
                    .addComponent(IconLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MigueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiegoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MartinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PipexLabel)
                .addGap(18, 18, 18)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LicenseLabel)
                    .addComponent(ClientLabel))
                .addGap(18, 18, 18)
                .addComponent(OkLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkLabelActionPerformed
        this.dispose();
    }//GEN-LAST:event_OkLabelActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClientLabel;
    private javax.swing.JLabel CopyrightLabel;
    private javax.swing.JLabel CountLabel;
    private javax.swing.JLabel DiegoLabel;
    private javax.swing.JLabel IconLabel;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JLabel LicenseLabel;
    private javax.swing.JPanel LogoPanel;
    private javax.swing.JLabel MartinLabel;
    private javax.swing.JLabel MigueLabel;
    private javax.swing.JButton OkLabel;
    private javax.swing.JLabel PipexLabel;
    private javax.swing.JLabel SebastianLabel;
    private javax.swing.JLabel SoftwareLabel;
    private javax.swing.JLabel VersionLabel;
    // End of variables declaration//GEN-END:variables
}
