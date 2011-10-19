package controller.Administration;

public class RateManagementController {

    public RateManagementController() {
    }

    
    
    public static boolean validateName(String Name) {

        if (Name.length() >= 5 && Name.length() <= 15) {

            return true;
        }

        //mandar error
        return false;
    }

    public static boolean validateFrom(String f, String t) {

        int from;
        int to;

        try {
            from = Integer.parseInt(f);
            to = Integer.parseInt(t);

            if (from > 0 && to > from) {
                return true;
            }


        } catch (Exception ex) {
            //Mandar a la vista y mandar error
            System.out.println("Ha ocurrido el siguiente error " + ex.getMessage());
        }

        return false;
    }

    public static boolean validateUnitValue(String v) {

        int unitValue;

        try {
            unitValue = Integer.parseInt(v);

            return true;

        } catch (Exception ex) {
            //Mandar a la vista y mandar error
            System.out.println("Ha ocurrido el siguiente error " + ex.getMessage());
        }
        return false;

    }

    public static boolean validateUnits(String u) {

        int units;

        try {
            units = Integer.parseInt(u);

            if (units > 0) {
                return true;
            }

        } catch (Exception ex) {
            //Mandar a la vista y mandar error
            System.out.println("Ha ocurrido el siguiente error " + ex.getMessage());
        }
        return false;

    }
}
