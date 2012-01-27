/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PreviewEntryTicket.java
 *
 * Created on 4/01/2012, 06:33:56 PM
 */
package view;

import controller.BarCodeMaker;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Martin Kanayet
 */
public class PreviewEntryTicket extends javax.swing.JPanel implements Printable {

    /** Creates new form PreviewEntryTicket */
    public PreviewEntryTicket() {
        initComponents();
    }

    public void setTittleText(String tittle) {
        this.Tittle.setText(tittle);
    }

    public void setNIT(String NIT) {
        this.ParkingNIT.setText(NIT);
    }

    public JLabel getAttendedByLabel() {
        return AttendedByLabel;
    }

    public void setAttendedByLabel(JLabel AttendedByLabel) {
        this.AttendedByLabel = AttendedByLabel;
    }

    public JPanel getBarCodePanel() {
        return BarCodePanel;
    }

    public void setBarCodePanel(JPanel BarCodePanel) {
        this.BarCodePanel = BarCodePanel;
    }

    public JLabel getDate() {
        return Date;
    }

    public void setDate(JLabel Date) {
        this.Date = Date;
    }

    public JLabel getEmployee() {
        return Employee;
    }

    public void setEmployee(JLabel Employee) {
        this.Employee = Employee;
    }

    public JLabel getFootPage() {
        return FootPage;
    }

    public void setFootPage(JLabel FootPage) {
        this.FootPage = FootPage;
    }

    public JLabel getParkingAddress() {
        return ParkingAddress;
    }

    public void setParkingAddress(JLabel ParkingAddress) {
        this.ParkingAddress = ParkingAddress;
    }

    public JLabel getParkingNIT() {
        return ParkingNIT;
    }

    public void setParkingNIT(JLabel ParkingNIT) {
        this.ParkingNIT = ParkingNIT;
    }

    public JLabel getParkingName() {
        return ParkingName;
    }

    public void setParkingName(JLabel ParkingName) {
        this.ParkingName = ParkingName;
    }

    public JLabel getPlate() {
        return Plate;
    }

    public void setPlate(JLabel Plate) {
        this.Plate = Plate;
    }

    public JLabel getPlateLabel() {
        return PlateLabel;
    }

    public void setPlateLabel(JLabel PlateLabel) {
        this.PlateLabel = PlateLabel;
    }

    public JLabel getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(JLabel TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public JLabel getTicketNumberLabel() {
        return TicketNumberLabel;
    }

    public void setTicketNumberLabel(JLabel TicketNumberLabel) {
        this.TicketNumberLabel = TicketNumberLabel;
    }

    public JLabel getTittle() {
        return Tittle;
    }

    public void setTittle(JLabel Tittle) {
        this.Tittle = Tittle;
    }

    public JLabel getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(JLabel VehicleType) {
        this.VehicleType = VehicleType;
    }

    public void setParkingName(String name) {
        this.ParkingName.setText(name);
    }

    public void setParkingAddress(String address) {
        this.ParkingAddress.setText(address);
    }

    public void setVisibleName(boolean isVisible) {
        this.ParkingName.setVisible(isVisible);
    }

    public void setVisibleAddress(boolean isVisible) {
        this.ParkingAddress.setVisible(isVisible);
    }

    public void setVisibleNIT(boolean isVisible) {
        this.ParkingNIT.setVisible(isVisible);
    }

    public void setVisibleBarCode(boolean isVisible) {
        this.BarCodePanel.setVisible(isVisible);
    }

    public void setVisibleEmployee(boolean isVisible) {
        this.Employee.setVisible(isVisible);
        this.AttendedByLabel.setVisible(isVisible);
    }

    public void setEmployee(String employee) {
        this.Employee.setText(employee);
    }

    public void setFootPage(String footPage) {
        this.FootPage.setText(footPage);
    }

    public void setBarCode() {
        BarCodePanel.removeAll();
        BarCodePanel.setLayout(new BorderLayout()); // Para que la imagen se agrande
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/images/barcode.jpg"));
        BarCodePanel.add(label, BorderLayout.CENTER);
    }

    public void setActualBarCode(String plate) {
        BarCodePanel.removeAll();
        File image = new File("Cache/barcode.jpg");
        if (image.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no puede ser borrado");        
        }
        new BarCodeMaker().Create(plate);
        BarCodePanel.setLayout(new BorderLayout()); // Para que la imagen se agrande
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("Cache/barcode.jpg"));
        BarCodePanel.add(label, BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TicketNumberLabel = new javax.swing.JLabel();
        TicketNumber = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        PlateLabel = new javax.swing.JLabel();
        Plate = new javax.swing.JLabel();
        VehicleType = new javax.swing.JLabel();
        Tittle = new javax.swing.JLabel();
        ParkingName = new javax.swing.JLabel();
        ParkingAddress = new javax.swing.JLabel();
        ParkingNIT = new javax.swing.JLabel();
        AttendedByLabel = new javax.swing.JLabel();
        Employee = new javax.swing.JLabel();
        BarCodePanel = new javax.swing.JPanel();
        FootPage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        TicketNumberLabel.setText("Tiquete número:");

        TicketNumber.setText("#####");

        Date.setText("#####");

        PlateLabel.setText("Placa:");

        Plate.setText("aaa111");

        VehicleType.setText("Tipo de vehiculo");

        Tittle.setText("Aquí va tu lindo titulo");

        ParkingName.setText("Nombre del parqueadero");

        ParkingAddress.setText("Dirección del parqueadero");

        ParkingNIT.setText("NIT del parqueadero");

        AttendedByLabel.setText("Atendido por:");

        Employee.setText("Aquí va tu lindo nombre");

        BarCodePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BarCodePanelLayout = new javax.swing.GroupLayout(BarCodePanel);
        BarCodePanel.setLayout(BarCodePanelLayout);
        BarCodePanelLayout.setHorizontalGroup(
            BarCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        BarCodePanelLayout.setVerticalGroup(
            BarCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        FootPage.setText("Aquí va tu lindo pie de página");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarCodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(TicketNumberLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TicketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(PlateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Plate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(ParkingName))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ParkingAddress)
                            .addComponent(VehicleType, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ParkingNIT)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttendedByLabel)
                        .addGap(64, 64, 64)
                        .addComponent(Employee, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addComponent(FootPage, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(Tittle, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tittle)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketNumberLabel)
                    .addComponent(TicketNumber)
                    .addComponent(Date))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlateLabel)
                    .addComponent(Plate)
                    .addComponent(VehicleType))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParkingName)
                    .addComponent(ParkingAddress))
                .addGap(18, 18, 18)
                .addComponent(ParkingNIT)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AttendedByLabel)
                    .addComponent(Employee))
                .addGap(18, 18, 18)
                .addComponent(BarCodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FootPage))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttendedByLabel;
    private javax.swing.JPanel BarCodePanel;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Employee;
    private javax.swing.JLabel FootPage;
    private javax.swing.JLabel ParkingAddress;
    private javax.swing.JLabel ParkingNIT;
    private javax.swing.JLabel ParkingName;
    private javax.swing.JLabel Plate;
    private javax.swing.JLabel PlateLabel;
    private javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel TicketNumberLabel;
    private javax.swing.JLabel Tittle;
    private javax.swing.JLabel VehicleType;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.scale(0.7, 0.7);
        this.printAll(g2d);
        return PAGE_EXISTS;
    }
}
