package controller;

import DAO.BandsRateJpaController;
import DAO.EmployeeJpaController;
import DAO.EntriesJpaController;
import DAO.VehicleTypeJpaController;
import java.util.Calendar;
import Entity.Employee;
import controller.Administration.AdministrateBandRates;
import controller.Administration.AdministrateVehicleTypeController;
import controller.Administration.EmployeeManagementController;
import view.AboutParkQuickView;
import view.AddVehiclePanel;
import view.ManagerAccessView;
import view.MainView;
import view.AdministrationView;

import view.BarCodePanel;
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
 public static void saveNewEmployee(long id,String lastName, String name, String document, String user, String password, String confirmPass, boolean active, boolean administrator){
        if(!EmployeeManagementController.validatePasswords(password, confirmPass)){
            adminView.showMessage("Error", "Las contraseñas no coinciden", 0);
        }else if(!EmployeeManagementController.validateNotEmptyFields(lastName, name, document, user, password)){
            adminView.showMessage("Error", "Todos los datos son obligatorios", 0);
        }else if(EmployeeManagementController.validateAll(lastName, name, document, user, password)){
            Employee newEmployee = new Employee();
            newEmployee.setId(id);
            newEmployee.setLastName(lastName);
            newEmployee.setName(name);
            newEmployee.setDocument(document);
            newEmployee.setUser(user);
            newEmployee.setPassword(controller.MainController.md5Security.MD5Security(password));
            newEmployee.setAdministrator(administrator);
            newEmployee.setIsActive(active);
            System.out.println(newEmployee);
            employeeJpaController.create(newEmployee);
        }
    }
  public static int getNextID(){
	        return employeeJpaController.getEmployeeCount() +1;
	    }
    
    public static void saveNewVehicleType(String plate, String example) {
        if (!AdministrateVehicleTypeController.verifyTypePlate(plate)) {
            adminView.showMessage("Error", "Nombre de Vehiculo vacio, por favor ingrese un nombre descriptivo", 0);
        } else if (!AdministrateVehicleTypeController.verifyExamplePlate(example)) {
            adminView.showMessage("Error", "Ejemplo de placa vacio, por favor ingrese un ejemplo de la placa", 0);
        } else {
            int confirm = adminView.showOptionMessage("Esta seguro crear un nuevo tipo de placa? ("
                    + plate + ")");
            if (confirm == 0) {
                String state = AdministrateVehicleTypeController.SavePlate(plate, example);
                if (state.equals("Failure")) {
                    adminView.showMessage("Error", "Solo se permiten valores alfa-numericos en la placa", 0);
                } else {
                    adminView.showMessage("Se ha creado un nuevo tipo de placa", "Se ha creado exitosamente el tipo de placa " + plate, 1);
                    adminView.setPlatesTableModel(AdministrateVehicleTypeController.TotalSearchOfVehicles());
                    adminView.updatePlatesTable();
                    adminView.setVehicleTypeComboBoxModel(AdministrateBandRates.AllVehicleTypes());
                    adminView.updateVehicleTypeComboBox();
                }
            }
        }

    }
    public static void generateBarCode(String plate){
        BarCodeMaker bar = new BarCodeMaker();
        bar.Create(plate);
    }

    public static void setVisibleMainView(boolean isVisible) {
        mainView.setVisible(isVisible);
    }

    public static void setVisibleAdminAccessView(boolean isVisible) {
        adminAccessView.setVisible(isVisible);
    }

    public static void setVisibleAboutParkQuickView(boolean isVisible) {
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
    public static BarCodePanel barCodePanel=new BarCodePanel();
    public static MainView mainView = new MainView();
    public static SystemSession system = new SystemSession();
    private static AboutParkQuickView aboutParkQuickView = new AboutParkQuickView();
    public static LoginController loginController = new LoginController();
    private static ManagerAccessView adminAccessView = new ManagerAccessView();
    private static AdministrationView adminView = new AdministrationView();
    public static BandsRateJpaController bandsRateJpaController = new BandsRateJpaController(controller.MainController.system.getPersistence_factory());
    public static EmployeeJpaController employeeJpaController = new EmployeeJpaController(controller.MainController.system.getPersistence_factory());
    public static MD5Security md5Security = new MD5Security();
    public static EntriesJpaController entriesJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
    public static VehicleTypeJpaController vehicleTypeJpaController = new VehicleTypeJpaController(controller.MainController.system.getPersistence_factory());
    public static AddOrQuitVehicleController addVehicleController = new AddOrQuitVehicleController();
    public static QuitVehiclePanel quitPanel = new QuitVehiclePanel();
    public static AddVehiclePanel addPanel = new AddVehiclePanel();
  
}
