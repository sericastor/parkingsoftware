package controller.Administration;

import Entity.Entries;
import Entity.Exits;
import Entity.VehicleType;
import controller.MainController;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AddVehicleManagementController {

    public AddVehicleManagementController() {
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

    public static DefaultTableModel TotalSearchOfExits() {
        DefaultTableModel results = new DefaultTableModel();
        AllExits = MainController.exitsJpaController.findExitsEntities();
        results.addColumn("Placa");
        results.addColumn("Fecha de Ingreso");
        results.addColumn("Fecha de Salida");
        results.addColumn("Valor");
        for (Exits e : AllExits) {
            results.addRow( new Object []{String.valueOf(e.getPlate()), e.getEntryDate().toLocaleString(), e.getExitDate().toLocaleString(),String.valueOf(e.getTotal())});
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
         entries.setEmployee(MainController.system.getSessionEmployee());
         entries.setEntryDate(Calendar.getInstance().getTime());
         entries.setPlate(MainController.mainView.getPlate());
         entries.setVehicleType(getVehicleTypeSelected(plate));
         MainController.entriesJpaController.create(null);
         return null;
     }
     
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<VehicleType> AllVehicleTypes = null;
    private static List<Entries> AllEntries = null;
    private static List<Exits> AllExits = null;
}
