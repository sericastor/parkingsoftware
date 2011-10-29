package controller;

import view.LoginView;
import Entity.Employee;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {

    

    public static boolean verifyUser(String user, String password) {
       
        
        /* este codigo crea un nuevo usuario en la base de datos, 
         * desmarcarlo solo en caso que no se tengan usuarios creados con anterioridad
        Employee employee1=new Employee();
        employee1.setAdministrator(true);
        employee1.setDocument("12356");
        employee1.setLastName("user");
        employee1.setName("user");
        employee1.setPassword(controller.MainController.md5Security.MD5Security("pass"));
        employee1.setUser("user");
        employee1.setIsActive(true);
        controller.MainController.employeeJpaController.create(employee1);*/
        /*generador de codigo de barras
         *bar.Create("introduzca un string")
         *el codigo de barras se guarda en la carpeta del proyecto
         *como barcode.jpg
         * nota: se debe realizar alguna clase de hashing para la placa
         * del vehiculo debido a que el metodo de generar el codigo
         * es un standard y puede ser falsificado un recibo con facilidad
         */

        BarCodeMaker bar = new BarCodeMaker();
        bar.Create("pruebacodigo 123456");
        Employee employee = MainController.employeeJpaController.findEmployeeByUser(user);
        if (employee==null){return false;}
        if (employee.getUser().equals(user) && employee.getPassword().equals(password) && employee.isIsActive()==true) {
            controller.MainController.system.setEmployee(employee);
            controller.MainController.system.Login();
            return true;
        }
        return false;

    }

    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    private static LoginView loginView = new LoginView();
}