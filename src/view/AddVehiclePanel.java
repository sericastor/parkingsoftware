/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntryPanel.java
 *
 * Created on 01-oct-2011, 18:17:38
 */
package view;

/**
 *
 * @author r4wd3r
 */
public class AddVehiclePanel extends javax.swing.JPanel {

    /** Creates new form EntryPanel */
    public AddVehiclePanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TypeVehicleCombobox = new javax.swing.JComboBox();
        TypeClientCombobox = new javax.swing.JComboBox();
        RateLabel = new javax.swing.JLabel();
        VehicleTypeLabel = new javax.swing.JLabel();
        AddVehicleButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        TypeVehicleCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TypeVehicleCombobox.setToolTipText("Seleccione el tipo de vehículo del cliente.");

        TypeClientCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TypeClientCombobox.setToolTipText("Seleccione el tipo de tarifa para el cliente.");

        RateLabel.setText("Tipo de Cobro:");

        VehicleTypeLabel.setText("Tipo de Vehículo:");

        AddVehicleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        AddVehicleButton.setToolTipText("Ingresa el vehículo y la tarifa seleccionada al parqueadero.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(RateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TypeClientCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(VehicleTypeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(TypeVehicleCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(AddVehicleButton)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VehicleTypeLabel)
                    .addComponent(TypeVehicleCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RateLabel)
                    .addComponent(TypeClientCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddVehicleButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddVehicleButton;
    private javax.swing.JLabel RateLabel;
    private javax.swing.JComboBox TypeClientCombobox;
    private javax.swing.JComboBox TypeVehicleCombobox;
    private javax.swing.JLabel VehicleTypeLabel;
    // End of variables declaration//GEN-END:variables
}
