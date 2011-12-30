package controller;

import Entity.BandsRate;
import Entity.Entries;
import Entity.Exits;
import Entity.FactureTurn;
import Entity.VehicleType;
import controller.Administration.AddVehicleManagementController;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class QuitVehicleController {

    public QuitVehicleController() {
    }

    private static long getDifferenceBetweenHours(Date entry, Date exit) {
        
        long resultInMinutes = 0;
        long miliseconds = exit.getTime() - entry.getTime();
        long seconds = miliseconds / 1000;
        long hours = seconds / 3600;
        seconds -= hours * 3600;
        long minutes = seconds / 60;
        seconds -= minutes * 60;
        resultInMinutes = resultInMinutes + hours * 60;
        resultInMinutes = resultInMinutes + minutes;
        if (seconds >= 30) {
            resultInMinutes = resultInMinutes + 1;
        }
        return resultInMinutes;   
    }
    

    public static double calculateCost(Date entry, Date exit, VehicleType vehicleType) {
        double cost = 0, value, units;
        int from, to;
        double numberOfUnits;
        double minutesParked = getDifferenceBetweenHours(entry, exit);
        System.out.println(getDifferenceBetweenHours(entry, exit));
        List<BandsRate> ratesOfVehicleType = MainController.bandsRateJpaController.queryByVehicleTypes(vehicleType);
        BandsRate lastRate = null;
        for (BandsRate b : ratesOfVehicleType) {
            from = b.getFromm();
            to = b.getToo();
            units = b.getUnits();
            value = b.getUnitValue();
            if(minutesParked<=0){
                break;
            }
            if (minutesParked <= to) {
                numberOfUnits = (minutesParked) / units;
                cost = cost + (numberOfUnits * value);
            }
            else {
                numberOfUnits = (to - from) / units;
                cost = cost + (numberOfUnits * value);
            }
            minutesParked = minutesParked - to;
            lastRate = b;
        }
        if(minutesParked > 0){
            units = lastRate.getUnits();
            value = lastRate.getUnitValue();
            
            numberOfUnits = minutesParked/units;
            cost = cost + (numberOfUnits * value);
        }
        cost = roundTo50(cost);
        return cost;
    }

    private static double roundTo50(double x) {
        double result = 0;
        if (x % 50 == 0) {
            result = x;
        } else {
            x = x / 50;
            x = Math.round(x);
            x = x * 50;
            result = x;
        }
        if(result < 0){
            return 0;
        }       
        return result;
    }
    public static void changeStateOfVehicle(String plate){
        
        Entries entry=MainController.entriesJpaController.getEntriesByPlate(plate);
        Exits exit=new Exits();
        try{
            //eliminar de la tabla entries
       
        exit.setEmployee(entry.getEmployee());
        exit.setEntry(entry);
        exit.setExitDate(MainController.getSystemTime());
        exit.setIVA(0);
        exit.setPlate(entry.getPlate());
        //v. auxiliar, para hacer los calculos para total sin tener que recurrir
        //a una busqueda en la BD de subtotal e iva, lo que consume mas tiempo.
        double subtotal=calculateCost(entry.getEntryDate(),
                MainController.getSystemTime(),
                entry.getVehicleType());
        exit.setSubtotal(subtotal);
        exit.setTicket(entry.getTicket());
        exit.setTotal(exit.getIVA()+subtotal);
        exit.setVehicleType(entry.getVehicleType());
        MainController.exitsJpaController.create(exit);
        MainController.entriesJpaController.destroy(entry.getId());
        }
        catch(Exception e){
            MainController.mainView.confirmationMessages(
                    "Error transaccional en la base de datos!", "Error!");
        }
        //actualiza tabla entries y exits
        DefaultTableModel entriesModel=AddVehicleManagementController.TotalSearchOfEntries();
        MainController.mainView.setEntriesTableModel(entriesModel);
        DefaultTableModel exitsModel=AddVehicleManagementController.TotalSearchOfExits();
        MainController.mainView.setExitsTableModel(exitsModel);
    }
   
}
