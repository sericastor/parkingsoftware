package controller;

public class EmployeeManagmentController {

    public EmployeeManagmentController() {
    }

    
    
    public static boolean validateID(String ID) {

        int id;

        try {
            id = Integer.parseInt(ID);
            //validar en la base de datos el ID
            return true;

        } catch (Exception ex) {
            //Mandar a la vista y mandar error
            System.out.println("Ha ocurrido el siguiente error " + ex.getMessage());
        }
        return false;

    }

    public static boolean validateLastName(String lastName) {

        if (lastName.length() >= 2 && lastName.length() <= 25) {

            return true;
        }

        //mandar error
        return false;

    }

    public static boolean validateName(String name) {

        if (name.length() > 1 && name.length() < 26) {

            return true;
        }

        //mandar error
        return false;

    }

    public static boolean validateDocument(String document) {

        if (document.length() >= 6 && document.length() <= 15) {

            return true;
        }

        //mandar error
        return false;
    }
        
    

    public static boolean validateUser(String user) {

        if (user.length() >= 6 && user.length() <= 10) {

            return true;
        }

        //mandar error
        return false;

    }
    
    public static boolean validatePassword(String password) {

        if (password.length() >= 4 && password.length() <= 10) {

            return true;
        }

        //mandar error
        return false;

    }
    
    
}
