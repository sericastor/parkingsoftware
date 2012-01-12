/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author miguel
 */
import Entity.VehicleType;
import controller.MainController;
import java.util.List;
import java.util.Random;
import javax.swing.table.TableModel;

public class AdministrateVehicleTypeController {

    public static DefaultTableModel totalSearchOfVehicles() {
        DefaultTableModel results = new DefaultTableModel();
        AllVehiclesTypes=MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        results.addColumn("Identificador");
        results.addColumn("Tipo de Vehículo");
        results.addColumn("Ejemplo de Placa");
        results.addColumn("Cantidad de espacio ocupado por vehículo");
        
        for (VehicleType e : AllVehiclesTypes) {
            results.addRow( new Object []{String.valueOf(e.getNumber()), e.getName(), decodePlate(e.getCodification()), e.getPlaces()});
        }
        return results;
    }
    public static String encodePlate(String plate){
         String code="";
         for(int i=0;i<plate.length();i++){
             if(Character.isLetter(plate.charAt(i))){
                 code=code+"1";}
             else if(Character.isDigit(plate.charAt(i))){
                 code=code+"0";}
             else{
                 return "No es un tipo valido de placa";
             }
         }
         return code;
     }
    public static String decodePlate(String code){
        String decode="";
        for(int i=0;i<code.length();i++){
            
            Random rnd = new Random();
            if(code.charAt(i)==49){
            int n=rnd.nextInt(25)+65;
            decode=decode+Character.toString((char)n);
            }
            else{
            int n=rnd.nextInt(9);
            decode=decode+String.valueOf(n);
            }
        }
        return decode;
    }
    public static void saveNewVehicleType(String plate, String example,Boolean places, String numberOfPlaces) {
        double indexPlace=1;
        if(places){
            indexPlace=1/Double.parseDouble(numberOfPlaces);
        }
        else{
            indexPlace=Double.parseDouble(numberOfPlaces);
        }
        if (!AdministrateVehicleTypeController.verifyTypePlate(plate)) {
            MainController.adminView.showMessage("Error", "Nombre de Vehiculo vacio, por favor ingrese un nombre descriptivo", 0);
        } else if (!AdministrateVehicleTypeController.verifyExamplePlate(example)) {
            MainController.adminView.showMessage("Error", "Ejemplo de placa vacio, por favor ingrese un ejemplo de la placa", 0);
        } else {
            int confirm = MainController.adminView.showOptionMessage("Esta seguro crear un nuevo tipo de placa? ("
                    + plate + ")");
            if (confirm == 0) {
                if (verifyUniqueness(plate) == true) {
                    String state = savePlate(plate, example, indexPlace);
                    if (state.equals("Failure")) {
                        MainController.adminView.showMessage("Error", "Solo se permiten valores alfa-numericos en la placa", 0);
                    } else {
                        MainController.adminView.showMessage("Se ha creado un nuevo tipo de placa", "Se ha creado exitosamente el tipo de placa " + plate, 1);
                        MainController.adminView.setPlatesTableModel(totalSearchOfVehicles());
                        MainController.adminView.updatePlatesTable();
                        MainController.adminView.setVehicleTypeComboBoxModel(AdministrateBandRates.AllVehicleTypes());
                        MainController.adminView.updateVehicleTypeComboBox();
                        MainController.mainView.setVehicleTypeTableModel(totalSearchOfVehicles());
                        MainController.mainView.updateStateTabbed();
                    }
                }
                else{
                    MainController.adminView.showMessage("Error", "El tipo de vehículo "+plate+" ya existe", 0);
                }
            }
        }

    }
    public static Boolean verifyUniqueness(String vehicleName){
        AllVehiclesTypes=MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        for (VehicleType vehicleType : AllVehiclesTypes) {
            if(vehicleType.getName().equals(vehicleName)){
                return false;
            }
        }
        return true;
    }
    public static String savePlate(String Name, String Plate,double Places){
       String code=encodePlate(Plate);
       if(!code.equals("No es un tipo valido de placa")){
           VehicleType v=new VehicleType();
           v.setCodification(code);
           v.setName(Name);
           v.setPlaces(Places);
           MainController.vehicleTypeJpaController.create(v);
           String action="Add vehicle type: "+Name;
           MainController.system.NewLogAction(action, null);
           return "Succes";
       }
       return "Failure";
    }
    
    public static void rowIsEdited(long id, String vehicleType, String plateExample, String spaces){
        try{
            double space = Double.parseDouble(spaces);
            String codification = encodePlate(plateExample);
            VehicleType vehicle = MainController.vehicleTypeJpaController.findVehicleType(id);
            if(!(vehicle.getName().equals(vehicleType) && vehicle.getCodification().equals(codification) && vehicle.getPlaces() == space)){
                vehicle.setNumber(id);
                vehicle.setName(vehicleType);
                vehicle.setCodification(codification);
                vehicle.setPlaces(space);
                MainController.vehicleTypeJpaController.edit(vehicle);
            }
        }catch(Exception ex){
            MainController.adminView.showMessage("Error", "Los espacios deben ser numéricos", 0);
        }
    }
    
    public static TableModel getModelTable(){
        DefaultTableModel results = new DefaultTableModel();
        List<VehicleType> list = MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        results.addColumn("Identificador");
        results.addColumn("Tipo de Vehículo");
        results.addColumn("Tipo de Placa");
        results.addColumn("Cantidad de Espacio ocupado por vehículo");
        
        for (VehicleType vehicleType : list) {
           results.addRow(new Object[]{vehicleType.getNumber(), vehicleType.getName(), decodePlate(vehicleType.getCodification()), vehicleType.getPlaces()});
        }
        
        return results;
    }
    
    public static boolean verifyTypePlate(String plate){
        
        if(plate.length()<=0 || plate.length()>=25){return false;}
        return true;
        
    }
    public static boolean verifyExamplePlate(String example){
        
        if(example.length()<=0){return false;}
        return true;
    }
    
    private static List<VehicleType> AllVehiclesTypes=null;
}
