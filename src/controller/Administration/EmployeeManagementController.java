package controller.Administration;

import Entity.Employee;
import controller.MainController;

public class EmployeeManagementController {

    public EmployeeManagementController() {
    }

    // CRUD
    
    public static int getNextID() {
        return MainController.employeeJpaController.getEmployeeCount() + 1;
    }
    
    public static void saveNewEmployee(long id, String lastName, String name, String document, String user, String password, String confirmPass, boolean active, boolean administrator) {
        if (!EmployeeManagementController.validatePasswords(password, confirmPass)) {
            MainController.adminView.showMessage("Error", "Las contraseñas no coinciden", 0);
        } else if (!EmployeeManagementController.validateNotEmptyFields(lastName, name, document, user, password)) {
            MainController.adminView.showMessage("Error", "Todos los datos son obligatorios", 0);
        } else if (EmployeeManagementController.validateAll(lastName, name, document, user, password)) {
            Employee newEmployee = new Employee();
            newEmployee.setId(id);
            newEmployee.setLastName(lastName);
            newEmployee.setName(name);
            newEmployee.setDocument(document);
            newEmployee.setUser(user);
            newEmployee.setPassword(controller.MainController.md5Security.MD5Security(password));
            newEmployee.setAdministrator(administrator);
            newEmployee.setIsActive(active);
            MainController.employeeJpaController.create(newEmployee);
        } else {
            MainController.adminView.showMessage("Error", "Los datos ingresados no son válidos.", 0);
        }
    }
    
    public static void updateOldEmployee(long id, String lastName, String name, String document, String user, String password, String confirmPass, boolean active, boolean administrator) {
        if (!EmployeeManagementController.validatePasswords(password, confirmPass)) {
            MainController.adminView.showMessage("Error", "Las contraseñas no coinciden", 0);
        } else if (!EmployeeManagementController.validateNotEmptyFields(lastName, name, document, user, password)) {
            MainController.adminView.showMessage("Error", "Todos los datos son obligatorios", 0);
        } else if (EmployeeManagementController.validateAll(lastName, name, document, user, password)) {
            Employee oldEmployee = new Employee();
            oldEmployee.setId(id);
            oldEmployee.setLastName(lastName);
            oldEmployee.setName(name);
            oldEmployee.setDocument(document);
            oldEmployee.setUser(user);
            oldEmployee.setPassword(controller.MainController.md5Security.MD5Security(password));
            oldEmployee.setAdministrator(administrator);
            oldEmployee.setIsActive(active);
            System.out.println(oldEmployee.getName());
            try {
                MainController.employeeJpaController.edit(oldEmployee, id);
            } catch (Exception ex) {
                MainController.adminView.showMessage("Error", "No fue posible modificar a ".concat(oldEmployee.getName()), 0);
            }
        }
    }
    
    // Reglas de Negocio
    
    public static boolean validatePasswords(String pass, String confirm){
        if(pass.equals(confirm)){
            return true;
        }
        return false;
    }
    
    public static boolean validateNotEmptyFields(String lastName, String name, String document, String user, String password){
        if(lastName.isEmpty() || name.isEmpty() || document.isEmpty() || user.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }
    
    public static boolean validateAll(String lastName, String name, String document, String user, String password){
        if(validateLastName(lastName) && validateName(name) && validateDocument(document) && validateUser(user) && validatePassword(password)){
            return true;
        }
        return false;
    }
    
    public static boolean validateLastName(String lastName) {
        if (lastName.length() >= 2 && lastName.length() <= 25) {
            return true;
        }
        return false;
    }

    public static boolean validateName(String name) {
        if (name.length() > 1 && name.length() < 26) {
            return true;
        }
        return false;
    }

    public static boolean validateDocument(String document) {
        if (document.length() >= 6 && document.length() <= 15) {
            return true;
        }
        return false;
    }
    
    public static boolean validateUser(String user) {
        if (user.length() >= 6 && user.length() <= 10) {
            return true;
        }
        return false;
    }
    
    public static boolean validatePassword(String password) {
        if (password.length() >= 4 && password.length() <= 10) {
            return true;
        }
        return false;
    }
}
