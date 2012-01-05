package controller;

import view.LoginView;
import Entity.Employee;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {

    public static boolean verifyUser(String user, String password) {
        Employee employee = MainController.employeeJpaController.findEmployeeByUser(user);
        if (employee == null) {
            return false;
        }
        if (employee.getUser().equals(user) && employee.getPassword().equals(password) && employee.isIsActive() == true) {
            controller.MainController.system.setEmployee(employee);
            controller.MainController.system.Login();
            MainController.managementStateTabbed(0);
            return true;
        }
        return false;

    }

    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    private static LoginView loginView = new LoginView();
}