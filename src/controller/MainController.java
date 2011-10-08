package controller;

import DAO.EmployeeJpaController;
import java.util.Calendar;
import Entity.Employee;
import model.Parkway;
import view.ManagerAccessView;
import view.MainView;
import view.AdministrationView;

/**
 *
 * @author Martin Kanayet
 */
public class MainController {

    public MainController() {
    }

    public void verifyStatus(boolean isUser) {
        if (isUser) {
            setVisibleMainView(true);
        }
    }

    public static boolean verifyAdminAccess(String password) {
        for (Employee e : employeeJpaController.findEmployeeEntities(true, -1, -1)) {
            System.out.println(md5Security.MD5Security(e.getPassword()) + " " + e.getPassword());
            if (e.getPassword().equals(md5Security.MD5Security(password)) && e.isAdministrator() == true) {
                return true;
            }
        }
        return false;
    }

    public static void setVisibleMainView(boolean isVisible) {
        mainView.setVisible(isVisible);
    }

    public static void setVisibleAdminAccessView(boolean isVisible) {
        adminAccessView.setVisible(isVisible);
    }

    public static void updateClockInFrame() {
        mainView.updateFrame(Calendar.getInstance().getTime().toLocaleString());
    }
    
    public static void startClock(){
        mainView.run();
    }
    
    public static void setVisibleAdminView(boolean isVisible){
        adminView.setVisible(isVisible);
    }
    
    private static MainView mainView = new MainView();
    private static LoginController loginController = new LoginController();
    private static ManagerAccessView adminAccessView = new ManagerAccessView();
    private static AdministrationView adminView = new AdministrationView();
    private static EmployeeJpaController employeeJpaController = new EmployeeJpaController(view.LoginView.system.getPersistence_factory());
    private static MD5Security md5Security = new MD5Security();
}