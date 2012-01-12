/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.Employee;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import controller.MainController;
import eParking.eParking;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.MainView;

/**
 *
 * @author miguel
 */
public class OtherOptionsController {
    
    public static void setTheme() {
        int i=0;
        try{
            i=MainController.system.getSessionEmployee().getTheme();
        }
        catch(Exception e){
            //tema por defecto
            System.out.println("error tema");
        }
        if (i != 0) {
            //tema prediseniado
            String path = "src/external sources/theme" + i + ".theme";
            try {
                NimRODTheme nt = new NimRODTheme(path);
                NimRODLookAndFeel nf = new NimRODLookAndFeel();
                nf.setCurrentTheme(nt);
                UIManager.setLookAndFeel(nf);
                SwingUtilities.updateComponentTreeUI(MainController.addPanel);
                SwingUtilities.updateComponentTreeUI(MainController.quitPanel);
                SwingUtilities.updateComponentTreeUI(MainController.finishTurnView);
                SwingUtilities.updateComponentTreeUI(MainController.mainView);
                MainController.mainView.pack();
                SwingUtilities.updateComponentTreeUI(MainController.adminView);
                MainController.adminView.pack();
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
        } else {
            try {
                //entorno por defecto del SO
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(MainController.addPanel);
                SwingUtilities.updateComponentTreeUI(MainController.quitPanel);
                SwingUtilities.updateComponentTreeUI(MainController.finishTurnView);
                SwingUtilities.updateComponentTreeUI(MainController.mainView);
                MainController.mainView.pack();
                SwingUtilities.updateComponentTreeUI(MainController.adminView);
                MainController.adminView.pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     public static void setTheme(int i) {   
         Employee e=MainController.system.getSessionEmployee();
         e.setTheme(i);
         MainController.employeeJpaController.edit(e, e.getId());
         setTheme();
     }

    
}
