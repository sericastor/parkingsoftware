/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Entity.Entries;
import Entity.InfoParkway;
import java.util.List;

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
    public void recalculateStatus(double places){
        try{
        List<Entries> entries=MainController.entriesJpaController.findEntriesEntities();
        List<InfoParkway> list=MainController.infoJpaController.findInfoParkwayEntities();
        InfoParkway info=list.get(0);
        double acumulate=0;
        for (Entries e : entries) {
            acumulate+=e.getVehicleType().getPlaces();
        }
        acumulate=(acumulate/places)*100;
        info.setCapacityStatus(acumulate);
        MainController.infoJpaController.edit(info);
        MainController.mainView.updateStatusBar(info.getCapacityStatus());
        }
        catch(Exception e){
        MainController.mainView.confirmationMessages("Error en el recalculo de la capacidad", "Error", 1);
        }
    }
}
