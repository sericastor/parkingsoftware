package controller;

import DAO.EntriesJpaController;
import Entity.Entries;
import Entity.VehicleType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class AddOrQuitVehicleController {

    public AddOrQuitVehicleController() {
    }

    public static boolean verifyCarParked(String plate) {
        Entries entry = new Entries();
        entry = entriesJpaController.getEntriesByPlate(plate);
        if (entry == null) {
            return false;
        }
        return true;
    }

    public static String verifyCarInParkway(String plate) {
        String codification = encodePlate(plate);
        AllVehicleTypes = MainController.vehicleTypeJpaController.matchPlateType(codification);
        if (plate.equals("")) {
            return "Do Nothing";
        } else if (AllVehicleTypes.size() == 0) {
            return "Inserte un tipo de placa valida";
        } else if (AllVehicleTypes.size() >= 1 && !verifyCarParked(plate)) {
            MainController.addPanel.setVehicleTypeCombobox(getModelComboBox(plate));
            MainController.addPanel.setVisible(true);
            return "Tipo de placa encontrado y vehículo no encontrado";
        } else if (AllVehicleTypes.size() >= 1 && verifyCarParked(plate)) {
            return "Tipo de placa encontrado y vehículo encontrado";
        }
        return null;
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

    public static String encodePlate(String plate) {
        String code = "";
        for (int i = 0; i < plate.length(); i++) {
            if (Character.isLetter(plate.charAt(i))) {
                code = code + "1";
            } else if (Character.isDigit(plate.charAt(i))) {
                code = code + "0";
            } else {
                return "No es un tipo valido de placa";
            }
        }
        return code;
    }

    public static void CreateVehicle(String vehicleType) {
        //por el momento se deja comentado dado que toca revisar bien el modelo
        Entries m = new Entries();
        m.setEmployee(MainController.system.getSesionemployee());
        m.setEntryDate(Calendar.getInstance().getTime());
        m.setPlate(plate);
        m.setTicket(123);
        m.setVehicleType(getVehicleTypeSelected(vehicleType));
        //Verificar existencia de tarifas para el tipo de vehiculo
        if (!MainController.bandsRateJpaController.queryByVehicleTypes(vehicleTypeIsSelected).isEmpty()) {
            MainController.entriesJpaController.create(m);
            MainController.adminView.showMessage("Información", "El vehiculo con placas " + plate + " ha sido registrado", 1);
            MainController.mainView.setPlateTextField("");
        } else {
            MainController.adminView.showMessage("Error", "El tipo de vehiculo seleccionado no tiene tarifas. Por favor cree una nueva tarifa", 0);
        }

    }
    private static String plate;

    public static String getPlate() {
        return plate;
    }
    public Date getEntryDateByPlate(String Plate){
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(plate);
        return entry.getEntryDate();
    }
    public String getEntryRateByPlate(String plate){
        Entries entry = new Entries();
        entry = MainController.entriesJpaController.getEntriesByPlate(plate);
        return entry.getVehicleType().getName();
    }
    
    public static void setPlate(String plate) {
        AddOrQuitVehicleController.plate = plate;
    }
    public static DefaultComboBoxModel comboBoxModel = null;
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<VehicleType> AllVehicleTypes = null;
    private static EntriesJpaController entriesJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
}
