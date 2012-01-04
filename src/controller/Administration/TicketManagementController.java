/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.CustomEntryTicket;
import Entity.CustomExitTicket;
import controller.MainController;

/**
 *
 * @author DiegoAl
 */
public class TicketManagementController {
    
    // Crud
    public static CustomEntryTicket getInfoEntryTicket(){
        if(MainController.customEntryJpaController.findCustomTicket(idTickets)==null){
            CustomEntryTicket customEntryTicket = new CustomEntryTicket();
            customEntryTicket.setId(idTickets);
            MainController.customEntryJpaController.create(customEntryTicket);
        }
        return MainController.customEntryJpaController.findCustomTicket(idTickets);
    }
    
    public static CustomExitTicket getInfoExitTicket(){
        if(MainController.customExitJpaController.findCustomExitTicket(idTickets)==null){
            CustomExitTicket customExitTicket = new CustomExitTicket();
            customExitTicket.setId(idTickets);
            MainController.customExitJpaController.create(customExitTicket);
        }
        return MainController.customExitJpaController.findCustomExitTicket(idTickets);
    }
    
    public static String getEntryTittle(){
        return getInfoEntryTicket().getTittle();
    }
    
    public static String getEntryFootPage(){
        return getInfoEntryTicket().getFootPage();
    }
    
    public static boolean isEntryParkwayName(){
        return getInfoEntryTicket().isParkwayName();
    }
    
    public static boolean isEntryParkwayAddress(){
        return getInfoEntryTicket().isParkwayAddress();
    }
    
    public static boolean isEntryParkwayNIT(){
        return getInfoEntryTicket().isParkwayNit();
    }
    
    public static boolean isEntryEmployee(){
        return getInfoEntryTicket().isEntryEmployee();
    }
    
    public static boolean isEntryParkwayBarcode(){
        return getInfoEntryTicket().isBarcode();
    }
    
    public static String getExitTittle(){
        return getInfoExitTicket().getTittle();
    }
    
    public static String getExitFootPage(){
        return getInfoExitTicket().getFootPage();
    }
    
    public static boolean isExitParkwayName(){
        return getInfoExitTicket().isParkwayName();
    }
    
    public static boolean isExitParkwayAddress(){
        return getInfoExitTicket().isParkwayAddress();
    }
    
    public static boolean isExitParkwayNIT(){
        return getInfoExitTicket().isParkwayNit();
    }
    
    public static boolean isExitEmployee(){
        return getInfoExitTicket().isExitEmployee();
    }
    
    public static void updateEntryTicket(String title, String footPage, boolean name, boolean address, boolean nit, boolean employee, boolean barcode){
        int confirm = MainController.adminView.showOptionMessage("¿Está seguro de modificar el tiquete de entrada?");
        if(confirm==0){
            CustomEntryTicket entryTicket = new CustomEntryTicket();
            entryTicket.setId(idTickets);
            entryTicket.setTittle(title);
            entryTicket.setFootPage(footPage);
            entryTicket.setParkwayName(name);
            entryTicket.setParkwayAddress(address);
            entryTicket.setParkwayNit(nit);
            entryTicket.setEntryEmployee(employee);
            entryTicket.setBarcode(barcode);
            MainController.customEntryJpaController.edit(entryTicket, idTickets);
            MainController.adminView.showMessage("Exito", "Modificación Exitosa", 1);
        }
    }
    
    public static void updateExitTicket(String title, String footPage, boolean name, boolean address, boolean nit, boolean employee){
        int confirm = MainController.adminView.showOptionMessage("¿Está seguro de modificar el tiquete de salida?");
        if(confirm==0){
            CustomExitTicket exitTicket = new CustomExitTicket();
            exitTicket.setId(idTickets);
            exitTicket.setTittle(title);
            exitTicket.setFootPage(footPage);
            exitTicket.setParkwayName(name);
            exitTicket.setParkwayAddress(address);
            exitTicket.setParkwayNit(nit);
            exitTicket.setExitEmployee(employee);
            MainController.customExitJpaController.edit(exitTicket, idTickets);
            MainController.adminView.showMessage("Exito", "Modificación Exitosa", 1);
        }
    }

    public static final long idTickets = 1;
}
