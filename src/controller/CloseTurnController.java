/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Exits;
import Entity.Facture;
import Entity.FactureTurn;
import controller.Administration.AddVehicleManagementController;
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
                facture.setExit(e);
                facture.setIVA(e.getIVA());
                facture.setSubtotal(e.getSubtotal());
                facture.setTotal(e.getTotal());
                MainController.factureTurnJpaController.create(facture);
                MainController.exitsJpaController.destroy(e.getId());
            }
        }
        catch(Exception e){
            MainController.mainView.confirmationMessages(
                    "Error transaccional en la base de datos!", "Error!",1);
        }
        /*//actualiza tabla entries y exits (vista)
        DefaultTableModel entriesModel=AddVehicleManagementController.TotalSearchOfEntries();
        MainController.mainView.setEntriesTableModel(entriesModel);
        DefaultTableModel exitsModel=AddVehicleManagementController.TotalSearchOfExits();
        MainController.mainView.setExitsTableModel(exitsModel);*/
    }
    public void closeTurnTotal(){
        List<FactureTurn> facturesToPersist = MainController.factureTurnJpaController.findFactureTurnEntities();
        Facture facture = new Facture();
        facture.setActualDate(MainController.getSystemTime());
        try{
            for(FactureTurn e:facturesToPersist){
                facture.setId(getNextFactureID());
                facture.setFactureTurn(e);
                facture.setIva(e.getIVA());
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
        /*//actualiza tabla entries y exits (vista)
        DefaultTableModel entriesModel=AddVehicleManagementController.TotalSearchOfEntries();
        MainController.mainView.setEntriesTableModel(entriesModel);
        DefaultTableModel exitsModel=AddVehicleManagementController.TotalSearchOfExits();
        MainController.mainView.setExitsTableModel(exitsModel);*/
    }
    
    
}
