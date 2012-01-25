package controller;

import DAO.BandsRateJpaController;
import DAO.CustomEntryTicketJpaController;
import DAO.CustomExitTicketJpaController;
import DAO.EmployeeJpaController;
import DAO.EntriesJpaController;
import DAO.ExitsJpaController;
import DAO.FactureJpaController;
import DAO.FactureTurnJpaController;
import DAO.InfoParkwayJpaController;
import DAO.VehicleTypeJpaController;
import java.util.Calendar;
import Entity.Employee;
import Entity.VehicleType;
import controller.Administration.AdministrateEmployeeController;
import controller.Administration.AdministrateVehicleTypeController;
import controller.Administration.OtherOptionsController;
import java.util.Date;
import view.AboutParkQuickView;
import view.AddVehiclePanel;
import view.MainView;
import view.AdministrationView;

import view.BarCodePanel;
import view.FinishTurnView;
import view.ManagerAccessView;
import view.QuitVehiclePanel;

/**
 *
 * @author Martin Kanayet
 */
public class MainController {

    public MainController() {
    }

    public static void setVisibleAdminAccessView(boolean isVisible) {
        adminAccessView.setVisible(isVisible);
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
        if (AdministrateEmployeeController.quickValidatePassword(password)) {
            for (Employee e : employeeJpaController.findEmployeeEntities(true, -1, -1)) {
                if (e.getPassword().equals(md5Security.MD5Security(password))
                        && e.isAdministrator() == true && e.isIsActive() == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void loadTablesMainView() {
        mainView.setEntriesTableModel(AddVehicleController.TotalSearchOfEntries());
        mainView.setExitsTableModel(QuitVehicleController.TotalSearchOfExits());
        mainView.setFacturesTableModel(CloseTurnController.TotalSearchOfFactures());
        mainView.setFactureTurnTableModel(CloseTurnController.TotalSearchOfFactureTurn());
        mainView.setVehicleTypeTableModel(AdministrateVehicleTypeController.totalSearchOfVehicles());
    }

    public static void generateBarCode(String code) {
        BarCodeMaker bar = new BarCodeMaker();
        bar.Create(code);
    }

    public static void setVisibleMainView(boolean isVisible) {
        mainView.setVisible(isVisible);
        mainView.getUserLabel().setText(SystemSession.getSessionEmployee().getName().toUpperCase() + " "
                + SystemSession.getSessionEmployee().getLastName().toUpperCase());
    }

    public static void setVisibleAboutParkQuickView(boolean isVisible) {
        aboutParkQuickView.setVisible(isVisible);
    }

    public static void updateClockInFrame() {
        mainView.updateFrame(getSystemTime().toLocaleString());
    }
    //este metodo de ahora en adelante se usara para saber la fecha del sistema!

    public static Date getSystemTime() {
        return Calendar.getInstance().getTime();
    }

    public static void startClock() {

        Thread thread = new Thread();
        while (true) {
            try {
                thread.sleep(1000);
                updateClockInFrame();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void setVisibleAdminView(boolean isVisible) {
        adminView.setVisible(isVisible);
    }

    public static void setVisibleFinishTurnView(boolean isVisible) {
        finishTurnView.setVisible(isVisible);
    }

    public static void setQuitPanelParameters(String plate) {
        Date entryDate = addVehicleController.getEntryDateByPlate(plate);

        Date exitDate = MainController.getSystemTime();

        String rate = addVehicleController.getEntryRateByPlate(plate);

        String comentary = addVehicleController.getEntryComentaryByPlate(plate);

        VehicleType vehicleType = addVehicleController.getVehicleTypeByPlate(plate);
        quitPanel.setPanelParameters(plate, rate, entryDate.toLocaleString(), exitDate.toLocaleString(), comentary);
        quitPanel.setCostTextField(QuitVehicleController.calculateCost(entryDate, exitDate, vehicleType));
    }
    
    public static ManagerAccessView adminAccessView = new ManagerAccessView();
    public static OtherOptionsController otherOptionsController = new OtherOptionsController();
    public static OcupationController ocupationController = new OcupationController();
    public static BarCodePanel barCodePanel = new BarCodePanel();
    public static FinishTurnView finishTurnView = new FinishTurnView();
    public static MainView mainView = new MainView();
    public static SystemSession system = new SystemSession();
    public static AboutParkQuickView aboutParkQuickView = new AboutParkQuickView();
    public static LoginController loginController = new LoginController();
    public static AdministrationView adminView = new AdministrationView();
    public static BandsRateJpaController bandsRateJpaController = new BandsRateJpaController(SystemSession.getPersistence_factory());
    public static FactureTurnJpaController factureTurnJpaController = new FactureTurnJpaController(SystemSession.getPersistence_factory());
    public static FactureJpaController factureJpaController = new FactureJpaController(SystemSession.getPersistence_factory());
    public static EmployeeJpaController employeeJpaController = new EmployeeJpaController(SystemSession.getPersistence_factory());
    public static InfoParkwayJpaController infoJpaController = new InfoParkwayJpaController(SystemSession.getPersistence_factory());
    public static MD5Security md5Security = new MD5Security();
    public static EntriesJpaController entriesJpaController = new EntriesJpaController(SystemSession.getPersistence_factory());
    public static VehicleTypeJpaController vehicleTypeJpaController = new VehicleTypeJpaController(SystemSession.getPersistence_factory());
    public static AddVehicleController addVehicleController = new AddVehicleController();
    public static QuitVehicleController quitVehicleController = new QuitVehicleController();
    public static QuitVehiclePanel quitPanel = new QuitVehiclePanel();
    public static AddVehiclePanel addPanel = new AddVehiclePanel();
    public static ExitsJpaController exitsJpaController = new ExitsJpaController(SystemSession.getPersistence_factory());
    public static CustomEntryTicketJpaController customEntryJpaController = new CustomEntryTicketJpaController(SystemSession.getPersistence_factory());
    public static CustomExitTicketJpaController customExitJpaController = new CustomExitTicketJpaController(SystemSession.getPersistence_factory());
    public static AdministrateEmployeeController administrateEmployeeController = new AdministrateEmployeeController();
    public static CloseTurnController closeTurnController = new CloseTurnController();

}
