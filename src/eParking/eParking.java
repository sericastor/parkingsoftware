/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import controller.Administration.AdministrateEmployeeController;
import controller.Administration.AdministrationController;
import controller.MainController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LoginView;

/**
 *
 * @author r4wd3r
 */
public class eParking{ 
    public static void main(String args[]) throws ClassNotFoundException{   
        try {
            //inserta la piel segun el sistema operativo
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
            //inserta la piel de la libreria agregada "jtatoo" que contiene varios skins
             //UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (InstantiationException ex) {
            Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null, ex);
        }
        new MainController();
       // new Parkway();
        new AdministrationController();
        MainController.startClock();
    }
}
