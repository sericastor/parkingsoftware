/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import controller.Administration.AdministrateEmployeeController;
import controller.Administration.AdministrationController;
import controller.MainController;
import model.Employee;
import model.Parkway;
import view.LoginView;

/**
 *
 * @author r4wd3r
 */
public class eParking{ 
    public static void main(String args[]){        
        new MainController();
        new Parkway();
        new AdministrationController();
        MainController.startClock();
    }
}
