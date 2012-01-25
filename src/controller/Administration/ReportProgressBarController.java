/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import controller.MainController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import view.ReportProgressBar;

/**
 *
 * @author miguel
 */
public class ReportProgressBarController extends Thread {
    private JDialog dialog = new JDialog((JFrame) null, "Trabajando...");
    public ReportProgressBarController() {
    }

    public void run() {
//        dialog.getContentPane().add(MainController.reporProgresBar, BorderLayout.CENTER);
//        ImageIcon img = new ImageIcon("src/images/parking1.gif");
//        dialog.setIconImage(img.getImage());
//        dialog.pack();
//        dialog.setLocationRelativeTo(null); // center on screen
//        dialog.setVisible(true);
        
        

    }
    public void stopIt(){
        try {
            dialog.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(ReportProgressBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
