package controller.Administration;

import Entity.Entries;
import Entity.VehicleType;
import controller.MainController;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class AddVehicleController {

    public AddVehicleController() {
    }
    
     public static DefaultComboBoxModel AllVehicleTypes() {
        //actualiza el combo box con la informacion de la base de datos
        //de vehicletype
        DefaultComboBoxModel results = new DefaultComboBoxModel();
        AllVehicleTypes = MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        for (VehicleType e : AllVehicleTypes) {
            results.addElement(e.getName());
        }
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
     
     public static String CreateVehicle(String plate){
         Entries entries=new Entries();
         entries.setEmployee(MainController.system.getSesionemployee());
         entries.setEntryDate(Calendar.getInstance().getTime());
         entries.setPlate(MainController.mainView.getPlate());
         entries.setVehicleType(getVehicleTypeSelected(plate));
         //que fuckin es un ticket?
         //para que fuckin es el rate? si se supone que no sabemos cuanto va a durar?
         //es decir, el rate sera determinado por las reglas segun el tiempo transcurrido
         //y NO de ante mano.
         MainController.entriesJpaController.create(null);
         return null;
     
     }
     
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<VehicleType> AllVehicleTypes = null;
}
