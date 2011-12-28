package controller;

import Entity.BandsRate;
import Entity.VehicleType;
import java.util.Date;
import java.util.List;

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
        double cost = 0, value;
        int from, to, units;
        double numberOfUnits;
        long minutesParked = getDifferenceBetweenHours(entry, exit);
        System.out.println(minutesParked);
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
    
    private static double roundTo50(double x){
        double result = 0;
        if (x%50 == 0){
            result = x;
        }
        else{
            x = x/50;
            x = Math.round(x);
            x = x*50;
            result = x;
        }
        return result;
    }
}
