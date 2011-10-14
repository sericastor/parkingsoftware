package controller;

public class AddVehicleManagementController {

    public AddVehicleManagementController() {
    }
    /* Debido a que tomamos esto del sistema.
    public static boolean validateDate(String day, String month, String year, String hour) {

        int d;
        int m;
        int y;

        try {
            d = Integer.parseInt(day);
            m = Integer.parseInt(month);
            y = Integer.parseInt(year);

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }

        if (y > 2010 && m > 0 && m < 13 && d > 0 && d < 31) {
            return true;
        }
        return false;
    }

    public static boolean validateHour(String hour) {

        int h = 0;
        int m = 0;

        try {
            h = Integer.parseInt(hour.substring(0, hour.indexOf(":")));
            m = Integer.parseInt(hour.substring(hour.indexOf(":") + 1, hour.length()));
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }

        if (h >= 0 && h < 24 && m >= 0 && m < 60) {

            return true;

        }
        return false;

    }
     */

     
    
    
    public static boolean validatePlate(String plate, int vehicleType) {
        //Type 1: cars
        //Type 2: motorcycles
        //Type 3: bicycles
        int number = 0;

        if (vehicleType == 1 || vehicleType == 2) {
            String letters = plate.substring(0, 3);
            for (int i = 0; i < letters.length(); i++) {
                if (!Character.isLetter(letters.charAt(i))) {
                    return false;
                }
            }
            plate = plate.substring(3, plate.length());
            if (!(vehicleType == 1 && plate.length() == 3) || (!(vehicleType == 2 && plate.length() == 2))) {
                return false;
            }

        }

        if (!(vehicleType == 3 && plate.length() == 3)) {
            return false;
        }

        try {
            number = Integer.parseInt(plate);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
        return true;

    }
}
