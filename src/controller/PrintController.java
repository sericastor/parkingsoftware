/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
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
import view.PreviewExitTicket;
import view.PrintFrame;

/**
 *
 * @author r4wd3r
 */
public class PrintController {

    public PrintController() {
    }
    public static void printEntryTicket(PreviewEntryTicket ticket){
        ImageIcon img = new ImageIcon("src/images/parking1.gif");        
        PrintFrame pf = new PrintFrame();
        pf.setIconImage(img.getImage());
        pf.setPrintPanel(ticket);                       
        pf.printMethod();
    }
    public static void printExitTicket(PreviewExitTicket ticket){
        ImageIcon img = new ImageIcon("src/images/parking1.gif");        
        PrintFrame pf = new PrintFrame();
        pf.setIconImage(img.getImage());
        pf.setPrintPanel(ticket);                       
        pf.printMethod();
    }
}
