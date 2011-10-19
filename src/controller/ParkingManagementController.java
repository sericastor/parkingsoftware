
package controller;


public class ParkingManagementController {

     public ParkingManagementController() {
     }
    
     public static boolean validateName(String Name) {

        if (Name.length() >= 7 && Name.length() <= 15) {

            return true;
        }
        return false;
    }
     
     public static boolean validateMaxCapacity(String mc) {

        int maxCapacity;

        try {
            maxCapacity = Integer.parseInt(mc);

            if (maxCapacity > 0) {
                return true;
            }

        } catch (Exception ex) {
            //Mandar a la vista y mandar error
            System.out.println("Ha ocurrido el siguiente error " + ex.getMessage());
        }
        return false;

    }
}
