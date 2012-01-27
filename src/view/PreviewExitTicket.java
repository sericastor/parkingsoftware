/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PreviewExitTicket.java
 *
 * Created on 4/01/2012, 07:08:27 PM
 */
package view;

import javax.swing.JLabel;

/**
 *
 * @author Martin Kanayet
 */
public class PreviewExitTicket extends javax.swing.JPanel {

    /** Creates new form PreviewExitTicket */
    public PreviewExitTicket() {
        initComponents();
    }

    public JLabel getAttendedByLabel() {
        return AttendedByLabel;
    }

    public void setAttendedByLabel(JLabel AttendedByLabel) {
        this.AttendedByLabel = AttendedByLabel;
    }

    public JLabel getDateLabel() {
        return DateLabel;
    }

    public void setDateLabel(JLabel DateLabel) {
        this.DateLabel = DateLabel;
    }

    public JLabel getEmployee() {
        return Employee;
    }

    public void setEmployee(JLabel Employee) {
        this.Employee = Employee;
    }

    public JLabel getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(JLabel EntryDate) {
        this.EntryDate = EntryDate;
    }

    public JLabel getExitDate() {
        return ExitDate;
    }

    public void setExitDate(JLabel ExitDate) {
        this.ExitDate = ExitDate;
    }

    public JLabel getFootPage() {
        return FootPage;
    }

    public void setFootPage(JLabel FootPage) {
        this.FootPage = FootPage;
    }

    public JLabel getIVA() {
        return IVA;
    }

    public void setIVA(JLabel IVA) {
        this.IVA = IVA;
    }

    public JLabel getIVALabel() {
        return IVALabel;
    }

    public void setIVALabel(JLabel IVALabel) {
        this.IVALabel = IVALabel;
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

    public JLabel getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(JLabel Subtotal) {
        this.Subtotal = Subtotal;
    }

    public JLabel getSubtotalLabel() {
        return SubtotalLabel;
    }

    public void setSubtotalLabel(JLabel SubtotalLabel) {
        this.SubtotalLabel = SubtotalLabel;
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

    public JLabel getTotal() {
        return Total;
    }

    public void setTotal(JLabel Total) {
        this.Total = Total;
    }

    public JLabel getTotalLabel() {
        return TotalLabel;
    }

    public void setTotalLabel(JLabel TotalLabel) {
        this.TotalLabel = TotalLabel;
    }

    public JLabel getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(JLabel VehicleType) {
        this.VehicleType = VehicleType;
    }
    
    public void setVisibleTittle(boolean isVisible) {
        this.Tittle.setVisible(isVisible);
    }

    public void setTittleText(String tittle) {
        this.Tittle.setText(tittle);
    }

    public void setVisibleName(boolean isVisible){
        this.ParkingName.setVisible(isVisible);
    }

    public void setVisibleAddress(boolean isVisible){
        this.ParkingAddress.setVisible(isVisible);
    }
        
    public void setVisibleNIT(boolean isVisible){
        this.ParkingNIT.setVisible(isVisible);
    }
     
    public void setVisibleEmployee(boolean isVisible){
        this.Employee.setVisible(isVisible);
        this.AttendedByLabel.setVisible(isVisible);
    }
    
    public void setEmployee(String employee){
        this.Employee.setText(employee);
    }
        
    public void setFootPage(String footPage){
        this.FootPage.setText(footPage);
    }
    
    public void setNIT(String NIT){
        this.ParkingNIT.setText(NIT);
    }
    
    public void setParkingName(String name){
        this.ParkingName.setText(name);
    }
    
    public void setParkingAddress(String address){
        this.ParkingAddress.setText(address);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TicketNumber = new javax.swing.JLabel();
        TicketNumberLabel = new javax.swing.JLabel();
        ParkingName = new javax.swing.JLabel();
        Tittle = new javax.swing.JLabel();
        ParkingNIT = new javax.swing.JLabel();
        ParkingAddress = new javax.swing.JLabel();
        AttendedByLabel = new javax.swing.JLabel();
        Employee = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        EntryDate = new javax.swing.JLabel();
        PlateLabel = new javax.swing.JLabel();
        Plate = new javax.swing.JLabel();
        VehicleType = new javax.swing.JLabel();
        ExitDateLabel = new javax.swing.JLabel();
        ExitDate = new javax.swing.JLabel();
        SubtotalLabel = new javax.swing.JLabel();
        Subtotal = new javax.swing.JLabel();
        IVALabel = new javax.swing.JLabel();
        IVA = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        FootPage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        TicketNumber.setText("#####");

        TicketNumberLabel.setText("Tiquete número:");

        ParkingName.setText("Nombre del parqueadero");

        Tittle.setText("Aquí va tu lindo titulo");

        ParkingNIT.setText("NIT del parqueadero");

        ParkingAddress.setText("Dirección del parqueadero");

        AttendedByLabel.setText("Atendido por:");

        Employee.setText("Aquí va tu lindo nombre");

        DateLabel.setText("Fecha de entrada");

        EntryDate.setText("#####");

        PlateLabel.setText("Placa:");

        Plate.setText("aaa111");

        VehicleType.setText("Tipo de vehiculo");

        ExitDateLabel.setText("Fecha de salida");

        ExitDate.setText("#####");

        SubtotalLabel.setText("Subtotal:");

        Subtotal.setText("####");

        IVALabel.setText("IVA:");

        IVA.setText("####");

        TotalLabel.setText("Total:");

        Total.setText("####");

        FootPage.setText("Aquí va tu lindo pie de página");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tittle, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PlateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Plate, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                    .addComponent(ParkingName))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VehicleType, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ExitDateLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(ExitDate, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                    .addComponent(ParkingAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                            .addComponent(ParkingNIT))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubtotalLabel)
                            .addComponent(IVALabel)
                            .addComponent(TotalLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttendedByLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EntryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(TicketNumberLabel))
                        .addGap(37, 37, 37)
                        .addComponent(TicketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FootPage, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tittle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketNumberLabel)
                    .addComponent(TicketNumber))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel)
                    .addComponent(ExitDateLabel)
                    .addComponent(ExitDate)
                    .addComponent(EntryDate))
                .addGap(11, 11, 11)
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
                    .addComponent(SubtotalLabel)
                    .addComponent(Subtotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IVALabel)
                    .addComponent(IVA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AttendedByLabel)
                    .addComponent(Employee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FootPage)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttendedByLabel;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel Employee;
    private javax.swing.JLabel EntryDate;
    private javax.swing.JLabel ExitDate;
    private javax.swing.JLabel ExitDateLabel;
    private javax.swing.JLabel FootPage;
    private javax.swing.JLabel IVA;
    private javax.swing.JLabel IVALabel;
    private javax.swing.JLabel ParkingAddress;
    private javax.swing.JLabel ParkingNIT;
    private javax.swing.JLabel ParkingName;
    private javax.swing.JLabel Plate;
    private javax.swing.JLabel PlateLabel;
    private javax.swing.JLabel Subtotal;
    private javax.swing.JLabel SubtotalLabel;
    private javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel TicketNumberLabel;
    private javax.swing.JLabel Tittle;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel VehicleType;
    // End of variables declaration//GEN-END:variables
}
