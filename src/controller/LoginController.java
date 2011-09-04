package controller;

import model.Employee;
import model.Parkway;
import view.LoginView;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {
    
    private final String titleMessage = "Inicio Sesión";
    private final String errorMessage = "Datos Incorrectos";
    private final String okMessage = "Bienvenido";
    private final int errorIcon = 0;
    private final int infoIcon = 1;
    
    private LoginView loginView;
    private Parkway parkway;

    public LoginController() {
        loginView = new LoginView(this);
        parkway = new Parkway();
    }
    
    public static void main(String args[]){
        LoginController logincontrol = new LoginController();
    }
    
    public void startLogin(){
        String user = loginView.getUserName();
        String pass = loginView.getUserPassword();
        if(verifyUser(user, pass)){
            loginView.showMessage(titleMessage, okMessage, infoIcon);
        }else{
            loginView.showMessage(titleMessage, errorMessage, errorIcon);
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
