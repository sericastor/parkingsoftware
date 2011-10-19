package controller;

import DAO.EntriesJpaController;
import Entity.Entries;
import Entity.VehicleType;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class AddOrQuitVehicleController {

    public AddOrQuitVehicleController() {
    }
    
    public static boolean verifyCarParked(String plate){
        Entries entry = new Entries();
        entry = entriesJpaController.getEntriesByPlate(plate);
        if (entry == null){
            return false;
        }
        return true;
    }
    

    public static String verifyCarInParkway(String plate) {
        String codification = encodePlate(plate);
        AllVehicleTypes = MainController.vehicleTypeJpaController.matchPlateType(codification);
        if (plate.equals("")) {
            return "Do Nothing";
        } 
        else if(AllVehicleTypes.size()==0){
            return "Inserte un tipo de placa valida";
        }
        else if(AllVehicleTypes.size()==1){
            CreateVehicle(plate);
            return "Vehículo Ingresado";
        }
        else if (AllVehicleTypes.size() > 1 && !verifyCarParked(plate)){
                MainController.addPanel.setVehicleTypeCombobox(getModelComboBox(plate));
                MainController.addPanel.setVisible(true);
                return "Tipo de placa encontrado y vehículo no encontrado";     
        }
        else if (AllVehicleTypes.size() > 1 && verifyCarParked(plate)){
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
        comboBoxModel=results;
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

    public static String CreateVehicle(String plate) {
        /* por el momento se deja comentado dado que toca revisar bien el modelo
        Entries entries = new Entries();
        entries.setEmployee(MainController.system.getSesionemployee());
        entries.setEntryDate(Calendar.getInstance().getTime());
        entries.setPlate(MainController.mainView.getPlate());
        entries.setVehicleType(getVehicleTypeSelected(plate));
        //que fuckin es un ticket?
        //para que fuckin es el rate? si se supone que no sabemos cuanto va a durar?
        //es decir, el rate sera determinado por las reglas segun el tiempo transcurrido
        //y NO de ante mano.
        MainController.entriesJpaController.create(null);*/
        return null;

    }
    public static DefaultComboBoxModel comboBoxModel=null;
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<VehicleType> AllVehicleTypes = null;
    private static EntriesJpaController entriesJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
}
