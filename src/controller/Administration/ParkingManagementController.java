
package controller.Administration;


public class ParkingManagementController {

     public ParkingManagementController() {
     }
     
     public static boolean validateNotEmptyFields(String name, String address, String nit, String phone, String maxC){
        if(name.isEmpty() || address.isEmpty() || nit.isEmpty() || phone.isEmpty() || maxC.isEmpty()){
            return false;
        }
        return true;
     }
    
     public static boolean validateAll(String name, String address, String nit, String phone, String maxC){
         if(validateName(name) && validateAddress(address) && validateNIT(nit) && validatePhone(phone) && validateMaxCapacity(maxC)){
             return true;
         }
         return false;
     }
     
     public static boolean validateName(String Name) {
        if (Name.length() >= 7 && Name.length() <= 15) {
            return true;
        }
        return false;
     }
     
     public static boolean validateAddress(String address){
         if(address.length() >= 5 && address.length() <=25){
             return true;
         }
         return false;
     }
     
     public static boolean validatePhone(String phone){
         if(phone.length() >= 7){
             return true;
         }
         return false;
     }
     
     public static boolean validateNIT(String nit){
         if(nit.length() >= 5){
             return true;
         }
         return false;
     }
     
     public static boolean validateMaxCapacity(String mc){
        int maxCapacity;
        try {
            maxCapacity = Integer.parseInt(mc);
            if (maxCapacity > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
