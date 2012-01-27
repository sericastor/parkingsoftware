package controller;

import Entity.Entries;
import Entity.InfoParkway;
import Entity.VehicleType;
import controller.Administration.CustomEntryTicketController;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import view.PreviewEntryTicket;

public class AddVehicleController {
    
    public AddVehicleController() {
    }
    
    public static void addVehicleEvent(){
        String id = (String) MainController.addPanel.getVehicleTypeComboBox().getSelectedItem();
        AddVehicleController.CreateVehicle(id, MainController.addPanel.getComentary());
        PrintableTicket();
        MainController.mainView.setPlateTextField("");
    }
    
    public static void formComponentShowEvent(){
        DefaultComboBoxModel model = getModelComboBox(MainController.mainView.getPlate());
        if(model.getSize() == 0){
            MainController.adminView.showMessage("Error", "Tipo de Placa no Existente, "
                    + "por favor ingrese un tipo de placa válida.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else{
            MainController.addPanel.getVehicleTypeComboBox().setModel(model);
            MainController.addPanel.getVehicleTypeComboBox().updateUI();
        }
    }
    
    public static boolean verifyCarParked(String plate) {
        Entries entry = new Entries();
        entry=MainController.entriesJpaController.getEntriesByPlate(plate);
        if (entry == null) {
            return false;
        }
        return true;
    }
    
    public static String verifyCarInParkway(String Plate) {
        //verifica si es leido por codigo de barras
        if(Plate.startsWith("+")){
            System.out.println("prueba"+Plate);
            System.out.println("prueba"+MainController.entriesJpaController.getEntriesByTicketCodification(Plate));
            Entries entrie=MainController.entriesJpaController.getEntriesByTicketCodification(Plate);
            Plate=entrie.getPlate();
            
            MainController.mainView.setPlateTextField(Plate);
        }
        //demas verificaciones
        String codification = encodePlate(Plate);
        AllVehicleTypes = MainController.vehicleTypeJpaController.matchPlateType(codification);
        if (Plate.equals("")) {
            return "Do Nothing";
        } else if (AllVehicleTypes.isEmpty()) {
            return "Inserte un tipo de placa valida";
        } else if (AllVehicleTypes.size() >= 1 && !verifyCarParked(Plate)) {
            MainController.addPanel.setVehicleTypeCombobox(getModelComboBox(Plate));
            MainController.addPanel.setVisible(true);
            return "Tipo de placa encontrado y vehículo no encontrado";
        } else if (AllVehicleTypes.size() >= 1 && verifyCarParked(Plate)) {
            return "Tipo de placa encontrado y vehículo encontrado";
        }
        return null;
    }
    public static String getPlatebyTicket(String plate){
        Entries entrie=MainController.entriesJpaController.getEntriesByTicketCodification(plate);
        System.out.println("entrieee"+entrie.getPlate());
        return entrie.getPlate();
    }
    
    public static DefaultComboBoxModel getModelComboBox(String plate) {
        //actualiza el combo box con la informacion de la base de datos
        //de vehicletype
        DefaultComboBoxModel results = new DefaultComboBoxModel();
        String codification = encodePlate(plate);
        AllVehicleTypes = MainController.vehicleTypeJpaController.matchPlateType(codification);
        for (VehicleType e : AllVehicleTypes) {
            results.addElement(e.getName());
        }
        comboBoxModel = results;
        return results;
    }
    
    public static VehicleType getVehicleTypeSelected(String vehicletype) {
        for (VehicleType v : AllVehicleTypes) {
            if (v.getName().equals(vehicletype)) {
                vehicleTypeIsSelected = v;
                return v;
            }
        }
        return null;
    }
    
    public static String encodePlate(String Plate) {
        String code = "";
        for (int i = 0; i < Plate.length(); i++) {
            if (Character.isLetter(Plate.charAt(i))) {
                code = code + "1";
            } else if (Character.isDigit(Plate.charAt(i))) {
                code = code + "0";
            } else {
                return "No es un tipo valido de placa";
            }
        }
        return code;
    }
    
    public static void CreateVehicle(String vehicleType, String coment) {
        //por el momento se deja comentado dado que toca revisar bien el modelo
        Entries m = new Entries();
        m.setEmployee(SystemSession.getSessionEmployee());
        m.setEntryDate(MainController.getSystemTime());
        m.setPlate(plate);
        m.setTicket(generateTicket());
        m.setTicketCodification(generateTicketCodification());
        m.setVehicleType(getVehicleTypeSelected(vehicleType));
        m.setComentary(coment);
        //Verificar existencia de tarifas para el tipo de vehiculo
        if (!MainController.bandsRateJpaController.queryByVehicleTypes(vehicleTypeIsSelected).isEmpty()) {
            MainController.generateBarCode(m.getTicketCodification());
            MainController.entriesJpaController.create(m);
            MainController.ocupationController.sumOcupation(getVehicleTypeSelected(vehicleType).getPlaces());
            MainController.system.NewLogAction("Entry Vehicle", plate);
            MainController.adminView.showMessage("Información", "El vehiculo con placas " + plate + " ha sido registrado", 1);
            MainController.mainView.setPlateTextField("");
            MainController.mainView.removePanel();
            //actualizar el panel con la nueva entrada automaticamente
            DefaultTableModel entriesModel=TotalSearchOfEntries();
            MainController.mainView.setEntriesTableModel(entriesModel);
            InfoParkway aux=MainController.infoJpaController.findInfoParkway(idParkway);
            aux.setTicketCount(m.getTicket());
            MainController.infoJpaController.edit(aux,idParkway);
        } else {
            MainController.adminView.showMessage("Error", "El tipo de vehiculo seleccionado no tiene tarifas. Por favor cree una nueva tarifa", 0);
        }
        
    }
    
    
    public static String generateTicketCodification(){
        Random rnd = new Random();
        String code="+"+String.valueOf(MainController.getSystemTime().getMonth())+
                String.valueOf(MainController.getSystemTime().getDay());
        code= code+SystemSession.getSessionEmployee().getUser().toString().substring(0, 2).toUpperCase();
        code= code+Calendar.getInstance().getTimeInMillis()%(rnd.nextInt(99999999)+1);
        return code;
    }
    
    public static String generateTicket(){
        Long lng=new Long(1);
        String ticket=MainController.infoJpaController.findInfoParkway(lng).getTicketCount();
        if(!ticket.startsWith(String.valueOf(MainController.getSystemTime().getDay()))){
            return String.valueOf(MainController.getSystemTime().getDay())+"1";
        }
        else{
            int aux=Integer.parseInt(ticket.substring(1,ticket.length()));
            aux++;
            return String.valueOf(MainController.getSystemTime().getDay())+
                    String.valueOf(aux);   
        }
    }

    public static String getPlate() {
        return plate;
    }

    public Date getEntryDateByPlate(String Plate) {
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(Plate);
        System.out.println(entry.getEntryDate().toString());
        return entry.getEntryDate();
    }

    public String getEntryRateByPlate(String plate) {
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(plate);
        return entry.getVehicleType().getName();
    }
    
    public String getEntryComentaryByPlate(String plate){
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(plate);
        return entry.getComentary();
    }
    
    public VehicleType getVehicleTypeByPlate(String plate){
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(plate);
        return entry.getVehicleType();
    }

    public static void setPlate(String plate) {
        AddVehicleController.plate = plate;
    }
    
    public static void setAllVehicleTypes(List<VehicleType> AllVehicleTypes) {
        AddVehicleController.AllVehicleTypes = AllVehicleTypes;
    }
    public static DefaultTableModel TotalSearchOfEntries() {
        DefaultTableModel results = new DefaultTableModel();
        AllEntries = MainController.entriesJpaController.findEntriesEntities();
        results.addColumn("Placa");
        results.addColumn("Fecha de Ingreso");
        results.addColumn("Tipo de Vehiculo");
        
        for (Entries e : AllEntries) {
            results.addRow( new Object []{String.valueOf(e.getPlate()), e.getEntryDate().toLocaleString(), e.getVehicleType().getName()});
        }
        return results;
    }
    private static String plate;
    public static DefaultComboBoxModel comboBoxModel = null;
    private static List<Entries> AllEntries=null;
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<VehicleType> AllVehicleTypes = null;
    private static final long idParkway = 1;
    
    private static void PrintableTicket(){
        PreviewEntryTicket ticket = new PreviewEntryTicket();
        ticket = CustomEntryTicketController.getFormatTicket();
        setTicketParameters(ticket);
        PrintController.printEntryTicket(ticket);
    }
    private static void setTicketParameters(PreviewEntryTicket ticket){
        ticket.getPlate().setText(plate);
        ticket.getVehicleType().setText(vehicleTypeIsSelected.getName());
        ticket.getEmployee().setText(SystemSession.getSessionEmployee().getName());
        ticket.getDate().setText(MainController.entriesJpaController.getEntriesByPlate(plate).getEntryDate().toLocaleString());
    }
    
}
