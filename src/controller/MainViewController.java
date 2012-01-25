/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author DiegoAl
 */
public class MainViewController {
    
    public static void searchPlateEvent(){
        String plate = MainController.mainView.getPlate();
        AddVehicleController.setPlate(plate);
        String result = AddVehicleController.verifyCarInParkway(plate);
        if(result.equals(INVALID_PLATE)){
            javax.swing.JOptionPane.showMessageDialog(null, result, "Error", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            MainController.mainView.getPlateTextField().removeAll();
        }else if(result.equals(VEHICLE_ADDED)){
            MainController.mainView.getPlateTextField().removeAll();
        }else if(result.equals(DO_NOTHING)){
        }else if(result.equals(VEHICLE_NOT_FOUND)){
            MainController.addPanel.setComentaryArea("");
            MainController.mainView.setAddOrQuitPanel(MainController.addPanel);
        }else if(result.equals(VEHICLE_FOUND)){
            MainController.setQuitPanelParameters(plate);
            MainController.mainView.setAddOrQuitPanel(MainController.quitPanel);
        }
    }
    
    public static void administrateAccessEvent(){
        if(SystemSession.getSessionEmployee().isAdministrator()){
             MainController.setVisibleAdminView(true);
        }else{
             MainController.setVisibleAdminAccessView(true);
        }
    }
    
    private final static String INVALID_PLATE = "Inserte un tipo de placa valida";
    private final static String VEHICLE_ADDED = "Vehículo Ingresado";
    private final static String DO_NOTHING = "Do Nothing";
    private final static String VEHICLE_NOT_FOUND = "Tipo de placa encontrado y vehículo no encontrado";
    private final static String VEHICLE_FOUND = "Tipo de placa encontrado y vehículo encontrado";
}
