package controller;

import eParking.eParking;
import model.Employee;
import model.Parkway;
import view.LoginView;
import view.MainView;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {
    
    private LoginView loginView;

    public LoginController() {    
    }
    
    public void startLogin(String u, String p){
        boolean result=false;
        String user = u;
        String pass = p;
        if(verifyUser(user, pass)){
        
        }
   }
        
    public boolean verifyUser(String user, String password){
        System.out.println(user+" "+password);     
        for (Employee employee : Parkway.getStaff()) {
            if(employee.getUser().equals(user)&&employee.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
 }
