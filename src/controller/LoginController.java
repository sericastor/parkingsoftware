package controller;

import model.Employee;
import model.Parkway;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {

    public LoginController() {
    }
    
    public static boolean verifyUser(String user, String password){
        System.out.println(user+" "+password);     
        for (Employee employee : Parkway.getStaff()) {
            if(employee.getUser().equals(user)&&employee.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    

}
