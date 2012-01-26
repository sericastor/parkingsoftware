/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;


import Entity.Entries;
import Entity.Facture;
import controller.MainController;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author miguel
 */
public class PreviewReport {
    
    public static DefaultTableModel loadPreview(long Date1,long Date2){
        Date date1 = new Date(Date1);  
        Date date2 = new Date(Date2);
        double total=0;
        if(Date2==0){
            Long yesterday=Date1-86400000;
            date2.setTime(yesterday);
        }
        DefaultTableModel results = new DefaultTableModel();
        AllFactures = MainController.factureJpaController.findFactureEntities();
        results.addColumn("Ticket");
        results.addColumn("Fecha de Salida");
        results.addColumn("Placa");
        results.addColumn("Costo");
        
        for (Facture f : AllFactures) {
            if(f.getExitDate().after(date2)&&f.getExitDate().before(date1)){
            results.addRow( new Object []{String.valueOf(f.getTicket()), f.getEntryDate().toLocaleString(), f.getPlate(), f.getTotal()});
            total+=f.getTotal();
            }
            }
        if(Date2==0){
        MainController.adminView.setPartialReportTable(results);
        MainController.adminView.setPartialReportTotalTextField(total);
        }
        else{
        MainController.adminView.setCustomReportTable(results);
        MainController.adminView.setCustomReportTotalTextField(total);
        }
        return results;
        
    }
    private static List<Facture> AllFactures=null; 
    
}
