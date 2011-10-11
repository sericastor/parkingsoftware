/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.VehicleType;
import controller.MainController;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author miguel
 */
public class AdministrateRates {
    
    public static DefaultComboBoxModel AllVehicleTypes(){
        DefaultComboBoxModel results=new DefaultComboBoxModel();
        AllVehicleTypes=MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        for(VehicleType e:AllVehicleTypes){
            results.addElement(e.getName());
        }
        return results;
    }
    private static List<VehicleType> AllVehicleTypes=null;
    
}
