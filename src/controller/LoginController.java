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


    }


    public boolean verifyUser(String user, String password) {
        EmployeeJpaController ctrlemployee = new EmployeeJpaController(view.LoginView.system.getPersistence_factory());
        MD5Security security = new MD5Security();
        /* este codigo crea un nuevo usuario en la base de datos, 
         * desmarcarlo solo en caso que no se tengan usuarios creados con anterioridad
        Employee employee1=new Employee();
        employee1.setAdministrator(true);
        employee1.setDocument("12356");
        employee1.setLastName("user");
        employee1.setName("user");
        employee1.setPassword(security.MD5Security("pass"));
        employee1.setUser("user");
        ctrlemployee.create(employee1);*/
        /*generador de codigo de barras
         *bar.Create("introduzca un string")
         *el codigo de barras se guarda en la carpeta del proyecto
         *como barcode.jpg
         * nota: se debe realizar alguna clase de hashing para la placa
         * del vehiculo debido a que el metodo de generar el codigo
         * es un standard y puede ser falsificado un recibo con facilidad
         */
        
        BarCodeMaker bar=new BarCodeMaker();
        bar.Create("pruebacodigo 123456");
        List<Employee> listemployee = ctrlemployee.findEmployeeEntities();
        for (Employee employee : listemployee) {
            System.out.println("1. " + employee.getUser() + " // " + user + "\n");
            System.out.println("2. " + employee.getPassword() + " // " + security.MD5Security(password) + "\n");

            if (employee.getUser().equals(user) && employee.getPassword().equals(security.MD5Security(password))) {
                view.LoginView.system.setEmployee(employee);
                view.LoginView.system.Login();         
                return true;
            }

        }
        return false;
    }
    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    private static LoginView loginView = new LoginView();
}