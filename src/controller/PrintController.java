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
import javax.swing.JFrame;
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
        PrintFrame pf = new PrintFrame(); 
        ticket.setVisible(true);
        pf.setPreferredSize(ticket.getSize());
        pf.getPrintPanel().removeAll();
        pf.getPrintPanel().setPreferredSize(ticket.getPreferredSize());
        pf.getPrintPanel().add(ticket).setVisible(true);
        pf.setVisible(true);
        
                       
        //pf.printMethod();
    }
}
