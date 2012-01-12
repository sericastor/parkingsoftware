/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Exits;
import Entity.Facture;
import Entity.FactureTurn;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author r4wd3r
 */
public class CloseTurnController {

    public CloseTurnController() {
    }
    public static int getNextFactureTurnID() {
        return MainController.factureTurnJpaController.getFactureTurnCount() + 1;
    }
    public static int getNextFactureID() {
        return MainController.factureJpaController.getFactureCount() + 1;
    }
    
    public void closeTurnPartial(){
        List<Exits> exitsToFacture = MainController.exitsJpaController.findExitsEntities();
        FactureTurn facture = new FactureTurn();
        facture.setActualDate(MainController.getSystemTime());
        try{
            for(Exits e:exitsToFacture){
                facture.setId(getNextFactureTurnID());
                facture.setEmployeeEntry(e.getEmployeeEntry());
                facture.setEmployeeExit(e.getEmployeeExit());
                facture.setEntryDate(e.getEntryDate());
                facture.setExitDate(e.getExitDate());
                facture.setPlate(e.getPlate());
                facture.setTicket(e.getTicket());
                facture.setVehicleType(e.getVehicleType());
                facture.setIVA(e.getIVA());
                facture.setSubtotal(e.getSubtotal());
                facture.setTotal(e.getTotal());
                MainController.factureTurnJpaController.create(facture);
                MainController.exitsJpaController.destroy(e.getId());
            }
            MainController.quitVehicleController.updateTableExits();      
            updateTableFacturesTurn();
            MainController.mainView.updateStateTabbed();
            
        }
        catch(Exception e){
            MainController.mainView.confirmationMessages(
                    "Error transaccional en la base de datos!", "Error!",1);
        }
    }
    
    
    public static void updateTableFacturesTurn(){ 
        DefaultTableModel facturesTurnModel=TotalSearchOfFactureTurn();
        MainController.mainView.setFactureTurnTableModel(facturesTurnModel);
    }
    public void closeTurnTotal(){
        List<FactureTurn> facturesToPersist = MainController.factureTurnJpaController.findFactureTurnEntities();
        Facture facture = new Facture();
        facture.setActualDate(MainController.getSystemTime());
        try{
            for(FactureTurn e:facturesToPersist){
                facture.setId(getNextFactureID());
                //facture.setFactureTurn(e);
                facture.setIva(e.getIVA());
                facture.setEmployeeEntry(e.getEmployeeEntry());
                facture.setEmployeeExit(e.getEmployeeExit());
                facture.setEntryDate(e.getEntryDate());
                facture.setExitDate(e.getExitDate());
                facture.setPlate(e.getPlate());
                facture.setTicket(e.getTicket());
                facture.setVehicleType(e.getVehicleType());
                facture.setSubtotal(e.getSubtotal());
                facture.setTotal(e.getTotal());
                MainController.factureJpaController.create(facture);
                MainController.factureTurnJpaController.destroy(e.getId());
            }
        }
        catch(Exception e){
            MainController.mainView.confirmationMessages(
                    "Error transaccional en la base de datos!", "Error!",1);
        }
        //actualiza tablas en la vista
        updateTableFacturesTurn();
        updateTableFactures();
        MainController.mainView.updateStateTabbed();
    }
    public static void updateTableFactures(){ 
        DefaultTableModel facturesModel=TotalSearchOfFactures();
        MainController.mainView.setFacturesTableModel(facturesModel);
    }
    
    public static DefaultTableModel TotalSearchOfFactureTurn() {
        DefaultTableModel results = new DefaultTableModel();
        AllFactureTurn = MainController.factureTurnJpaController.findFactureTurnEntities();
        
        results.addColumn("ID");
        results.addColumn("Operario Entrada");
        results.addColumn("Operario Salida");
        results.addColumn("Placa");
        results.addColumn("Fecha de Ingreso");
        results.addColumn("Fecha de Salida");
        results.addColumn("Subtotal");
        results.addColumn("IVA");
        results.addColumn("Total");
        
        for (FactureTurn e : AllFactureTurn) {
            results.addRow( new Object []{String.valueOf(e.getId()),String.valueOf(e.getEmployeeEntry().getId()),String.valueOf(e.getEmployeeExit().getId()),e.getPlate(), e.getEntryDate().toLocaleString(),e.getExitDate().toLocaleString(), String.valueOf(e.getSubtotal()),String.valueOf(e.getIVA()),String.valueOf(e.getTotal())});
        }
        return results;
    }
    
    public static DefaultTableModel TotalSearchOfFactures() {
        DefaultTableModel results = new DefaultTableModel();
        AllFactures = MainController.factureJpaController.findFactureEntities();
        
        results.addColumn("ID");
        results.addColumn("Operario Entrada");
        results.addColumn("Operario Salida");
        results.addColumn("Placa");
        results.addColumn("Fecha de Ingreso");
        results.addColumn("Fecha de Salida");
        results.addColumn("Subtotal");
        results.addColumn("IVA");
        results.addColumn("Total");
        
        for (Facture e : AllFactures) {
            results.addRow( new Object []{String.valueOf(e.getId()),String.valueOf(e.getEmployeeEntry().getId()),String.valueOf(e.getEmployeeExit().getId()),e.getPlate(), e.getEntryDate().toLocaleString(),e.getExitDate().toLocaleString(), String.valueOf(e.getSubtotal()),String.valueOf(e.getIva()),String.valueOf(e.getTotal())});
        }
        return results;
    }
    private static List<Facture> AllFactures = null;
    private static List<FactureTurn> AllFactureTurn = null;   
}
