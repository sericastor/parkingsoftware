/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import controller.Administration.AdministrateEmployeeController;
import controller.Administration.AdministrationController;
import controller.MainController;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LoginView;

/**
 *
 * @author r4wd3r
 */
public class eParking {
    public static void main(String args[]) throws ClassNotFoundException {
        try {
            //nuevo look and feel modificable!!!
            UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null, ex);
        }
        new MainController();
        MainController.startClock();
    }
}
