package controller;


import DAO.EmployeeJpaController;
import DAO.EntriesJpaController;
import DAO.VehicleTypeJpaController;
import java.util.Calendar;
import Entity.Employee;
import controller.Administration.AdministrateVehicleTypeController;
import view.AboutParkQuickView;
import view.AddVehiclePanel;
import view.ManagerAccessView;
import view.MainView;
import view.AdministrationView;
import view.QuitVehiclePanel;

/**
 *
 * @author Martin Kanayet
 */
public class MainController {

    public MainController() {
    }

    public static AdministrationView getAdminView() {
        return adminView;
    }

    public static void verifyStatus(boolean isUser) {
        if (isUser) {
            setVisibleMainView(true);
        }
    }

    public static boolean verifyAdminAccess(String password) {
        for (Employee e : employeeJpaController.findEmployeeEntities(true, -1, -1)) {
            if (e.getPassword().equals(md5Security.MD5Security(password)) && e.isAdministrator() == true) {
                return true;
            }
        }
        return false;
    }

    public static void saveNewVehicleType(String plate, String example){
    
        if(!AdministrateVehicleTypeController.verifyTypePlate(plate)){
            adminView.showMessage("Error", "Nombre de Vehiculo vacio, por favor ingrese un nombre descriptivo", 0);
        }
        else if(!AdministrateVehicleTypeController.verifyExamplePlate(example)){
            adminView.showMessage("Error", "Ejemplo de placa vacio, por favor ingrese un ejemplo de la placa", 0);
       } else{
        
             
        
        }
        
    }
    
    public static void verifyCarInParkway(String p) {
        plate = p;
        if (p.equals("")) { return; }
        else{
            //entriesJpaController.getEntriesByPlate(p);
            System.out.println(employeeJpaController.findEmployeeByUser("martin"));
            /*for (Entries e : entriesJpaController.findEntriesEntities()) {
                if (e.getPlate().equals(p)) {
                    mainView.setAddOrQuitPanel(quitPanel);
                    return;
                }
            }*/
        }
        mainView.setAddOrQuitPanel(addPanel);
    }

    public static void setVisibleMainView(boolean isVisible) {
        mainView.setVisible(isVisible);
    }

    public static void setVisibleAdminAccessView(boolean isVisible) {
        adminAccessView.setVisible(isVisible);
    }
    
    public static void setVisibleAboutParkQuickView(boolean isVisible){
        aboutParkQuickView.setVisible(isVisible);
    }

    public static void updateClockInFrame() {
        mainView.updateFrame(Calendar.getInstance().getTime().toLocaleString());
    }

    public static void startClock() {
        mainView.run();
    }

    public static void setVisibleAdminView(boolean isVisible) {
        adminView.setVisible(isVisible);
    }
    private static String plate;
    private static MainView mainView = new MainView();
    public static SystemSession system = new SystemSession();
    private static AboutParkQuickView aboutParkQuickView = new AboutParkQuickView();
    public static LoginController loginController = new LoginController();
    private static ManagerAccessView adminAccessView = new ManagerAccessView();
    private static AdministrationView adminView = new AdministrationView();
    public static EmployeeJpaController employeeJpaController = new EmployeeJpaController(controller.MainController.system.getPersistence_factory());
    public static MD5Security md5Security = new MD5Security();
    public static EntriesJpaController entriesJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
    public static VehicleTypeJpaController vehicleTypeJpaController=new VehicleTypeJpaController(controller.MainController.system.getPersistence_factory());
    public static AddVehicleManagementController addVehicleManagementController = new AddVehicleManagementController();
    public static QuitVehiclePanel quitPanel = new QuitVehiclePanel();
    public static AddVehiclePanel addPanel = new AddVehiclePanel();
    
    
}
