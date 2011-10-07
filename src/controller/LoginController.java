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
        /* este codigo crea un nuevo usuario en la base de datos, 
         * desmarcarlo solo en caso que no se tengan usuarios creados con anterioridad
        Employee employee=new Employee();
        employee.setAdministrator(true);
        employee.setDocument("123");
        employee.setLastName("admin");
        employee.setName("admin");
        employee.setPassword("pass");
        ctrlemployee.create(employee);*/
        List<Employee> listemployee = ctrlemployee.findEmployeeEntities();
        for (Employee employee : listemployee) {
            if (employee.getName().equals(user) && employee.getPassword().equals(password)) {
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
