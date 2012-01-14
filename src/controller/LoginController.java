package controller;

import view.LoginView;
import Entity.Employee;
import controller.Administration.AdministrateEmployeeController;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {
    
    public static void startLogin(){
        boolean access = false;
        String user = loginView.getUserName();
        String password = loginView.getUserPassword();
        if(AdministrateEmployeeController.quickValidatePassword(password) 
                && AdministrateEmployeeController.quickValidateUser(user)){
            access = verifyUser(user,controller.MainController.md5Security.MD5Security(password));
            if(access){
                loginView.showMessage(titleMessage, okMessage, JOptionPane.INFORMATION_MESSAGE);
                loginView.setVisible(false);
                MainController.verifyStatus(access);
                return;
            }
        }
        loginView.showMessage(titleMessage, errorMessage, JOptionPane.ERROR_MESSAGE);
        loginView.getUserTextField().setText("");
        loginView.getPasswordField().setText("");
    }
    
    private static boolean verifyUser(String user, String password) {
        Employee employee = MainController.employeeJpaController.findEmployeeByUser(user);
        if (employee == null) {
            return false;
        }
        if (employee.getUser().equals(user) && employee.getPassword().equals(password) && employee.isIsActive() == true) {
            controller.MainController.system.setEmployee(employee);
            controller.MainController.system.Login();
            MainController.otherOptionsController.setTheme();
            MainController.loadTablesMainView();  
            return true;
        }
        return false;
    }

    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    
    private static LoginView loginView = new LoginView();
    private static final String titleMessage = "Inicio Sesión";
    private static final String errorMessage = "Datos Incorrectos";
    private static final String okMessage = "Bienvenido";
}
