/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import controller.MainController;

/**
 *
 * @author r4wd3r
 */
public class AdministrationController {
    public AdministrationController(){
        new AdministrateEmployeeController();
    }
    public void loadAdministrationData(){
        initializeAdminEmployee();
    }
    public static void initializeAdminEmployee(){
        MainController.getAdminView().getEmployeeList().setModel(AdministrateEmployeeController.TotalSearchOfEmployees());
    }
    public static void initializeAdminPlate(){
        MainController.getAdminView().getPlatesTable().setModel(AdministrateVehicleTypeController.TotalSearchOfVehicles());
    }
}
