package controller;

import java.util.Calendar;
import model.Employee;
import model.Parkway;
import view.ManagerAccessView;
import view.MainView;

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
        for (Employee e : Parkway.getStaff()) {
            if (e.getPassword().equals(password) && e.isAdmin() == true) {
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
    
    private static MainView mainView = new MainView();
    private static LoginController loginController = new LoginController();
    private static ManagerAccessView adminAccessView = new ManagerAccessView();
}