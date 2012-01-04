/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.exceptions.NonexistentEntityException;
import Entity.InfoParkway;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class OcupationController {
    public void sumOcupation(double plus){
        try{
        List<InfoParkway> list=MainController.infoJpaController.findInfoParkwayEntities();
        InfoParkway info=list.get(0);
        double percentage=(plus/info.getMaxCapacity())*100;
        info.setCapacityStatus(percentage+info.getCapacityStatus());
        MainController.infoJpaController.edit(info);
        MainController.mainView.updateStatusBar(info.getCapacityStatus());
        }
        catch(Exception e){
        MainController.mainView.confirmationMessages("configure primero la capacidad maxima de el establecimiento", "Error", 1);
        }
          
    }
    
    public void subsstractionOcupation(double sub){
        try{
        List<InfoParkway> list=MainController.infoJpaController.findInfoParkwayEntities();
        InfoParkway info=list.get(0);
        double percentage=(sub/info.getMaxCapacity())*100;
        info.setCapacityStatus(info.getCapacityStatus()-percentage);
        
        MainController.infoJpaController.edit(info);
        MainController.mainView.updateStatusBar(info.getCapacityStatus());
        }
        catch(Exception e){
        MainController.mainView.confirmationMessages("configure primero la capacidad maxima de el establecimiento", "Error", 1);
        }       
    }
    public double returnStatus(){
        try{
        List<InfoParkway> list=MainController.infoJpaController.findInfoParkwayEntities();
        InfoParkway info=list.get(0);
        return info.getCapacityStatus();}
        catch(Exception e){
        return 0;
        }
    }
}
