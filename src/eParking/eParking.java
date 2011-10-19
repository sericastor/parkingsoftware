/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import controller.MainController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
