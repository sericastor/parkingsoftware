/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import view.PreviewEntryTicket;
import view.PrintFrame;

/**
 *
 * @author r4wd3r
 */
public class PrintController {

    public PrintController() {
    }
    public static void printEntryTicket(PreviewEntryTicket ticket){
        /*JFrame frame = new JFrame();
        frame.add(ticket);
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.repaint();
        frame.setVisible(true);
        System.out.println(frame.getComponent(0).getName());*/
        ImageIcon img = new ImageIcon("src/images/parking1.gif");        
        JDialog dialog = new JDialog((JFrame)null, "Vista Preliminar de Recibo");
        dialog.setIconImage(img.getImage());
        dialog.getContentPane().add(ticket);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        
                       
        //pf.printMethod();
    }
}
