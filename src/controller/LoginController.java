package controller;

import model.Parkway;
import view.LoginView;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import DAO.EmployeeJpaController;
import Entity.Employee;
import java.util.List;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {

    public LoginController() {
        createPersistence();

    }

    public void createPersistence() {
        this.persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");

    }

    public boolean verifyUser(String user, String password) {
        EmployeeJpaController ctrlemployee = new EmployeeJpaController(persistence_factory);
        MD5Security security = new MD5Security();
        /* este codigo crea un nuevo usuario en la base de datos, 
         * desmarcarlo solo en caso que no se tengan usuarios creados con anterioridad
        Employee employee1=new Employee();
        employee1.setAdministrator(true);
        employee1.setDocument("123");
        employee1.setLastName("miguel");
        employee1.setName("miguel");
        employee1.setPassword(security("miguel"));
        employee1.setUser("miguel");
        ctrlemployee.create(employee1);*/
        List<Employee> listemployee = ctrlemployee.findEmployeeEntities();
        for (Employee employee : listemployee) {
            System.out.println("1. " + employee.getUser() + " // " + user + "\n");
            System.out.println("2. " + employee.getPassword() + " // " + security.MD5Security(password) + "\n");

            if (employee.getUser().equals(user) && employee.getPassword().equals(security.MD5Security(password))) {

                return true;
            }

        }
        return false;

    }

    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    private static EntityManagerFactory persistence_factory;
    private static LoginView loginView = new LoginView();
}