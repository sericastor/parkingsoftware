/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.PreviewEntryTicket;

/**
 *
 * @author r4wd3r
 */
public class PrintController {

    public PrintController() {
    }
    public static void printEntryTicket(PreviewEntryTicket ticket){
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(ticket);
            
            boolean aceptar_impresion =job.printDialog();
             if(aceptar_impresion)
                job.print();
        } catch (PrinterException ex) {
            System.out.println("pedo");            
        }
    }
}
