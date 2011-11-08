package controller;

import Entity.VehicleType;
import java.util.Date;

public class QuitVehicleController {

    public QuitVehicleController() {
    }

    public static long getDifferenceBetweenHours(Date entry, Date exit) {
        long resultInMinutes = 0;
        long miliseconds = exit.getTime() - entry.getTime();
        long seconds = miliseconds / 1000;
        long hours = seconds / 3600;
        seconds -= hours * 3600;
        long minutes = seconds / 60;
        seconds -= minutes * 60;
        resultInMinutes = resultInMinutes + hours*60;
        resultInMinutes = resultInMinutes + minutes;
        if (seconds >= 30){
            resultInMinutes = resultInMinutes + 1;
        }
        return resultInMinutes;
    }

    public static double calculateCost(Date entry, Date exit, VehicleType vehicleType) {
        double cost = 0;
        long minutesParked = getDifferenceBetweenHours(entry, exit);
        System.out.println(minutesParked);
        return cost;
    }
}
