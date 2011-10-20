/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EntriesJpaController;
import Entity.Entries;

/**
 *
 * @author r4wd3r
 */
public class AddVehicleController {

    public AddVehicleController() {
    }
    public static boolean verifyCarInEntries(String plate){
        Entries entry = null;
        entry = entriesJpaController.getEntriesByPlate(plate);
        if(entry == null){
            return false;
        }
        return true;
    }
    private static EntriesJpaController entriesJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
}
