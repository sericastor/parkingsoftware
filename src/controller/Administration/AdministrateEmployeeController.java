/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.Employee;
import controller.MainController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author r4wd3r
 */
public class AdministrateEmployeeController {

    public AdministrateEmployeeController() {
    }

    public void CreateEmployee() {
        if(MainController.adminView.getCreateEmployeeButton().equals("Crear Empleado")){
            MainController.adminView.setNullEmp();
            MainController.adminView.setEnabledEmp(true);
            MainController.adminView.setCreateEmployeeButton("Guardar Empleado");
            MainController.adminView.setIdEmployeeTextField(String.valueOf(MainController.employeeJpaController.getEmployeeCount() + 1));
        }
        else{
        int lenPass=MainController.adminView.getLenghtOfPasswordTextField();
        Employee emp = new Employee();
        emp.setName(MainController.adminView.getNameEmployeeTextField());
        emp.setLastName(MainController.adminView.getLastNameEmployeeTextField());
        emp.setDocument(MainController.adminView.getDocumentEmployeeTextField());
        emp.setUser(MainController.adminView.getUserTextField());
        emp.setPassword(MainController.adminView.getPasswordField());
        emp.setIsActive(MainController.adminView.getIsAdminEmployeeCheckBox());
        emp.setAdministrator(MainController.adminView.getIsisActiveEmployeeCheckBox());
        String aux = MainController.adminView.getConfirmPasswordField();
        int option = MainController.adminView.askToAdmin("¿Está seguro de crear al empleado ");
        if (option == JOptionPane.OK_OPTION && verifyEmployeeData(emp, aux,lenPass)) {
            MainController.employeeJpaController.create(emp);
            MainController.adminView.setNullEmp();
            MainController.adminView.setEnabledEmp(false);
            MainController.adminView.searchButtonAction();
            MainController.adminView.setCreateEmployeeButton("Crear Empleado");
        } 
        }

    }
    public void UpdateEmployee(){
        if(MainController.adminView.getCreateEmployeeButton().equals("Crear Empleado")){
            MainController.adminView.setNullEmp();
            MainController.adminView.setEnabledEmp(true);
            MainController.adminView.setCreateEmployeeButton("Guardar Empleado");
            MainController.adminView.setIdEmployeeTextField(String.valueOf(MainController.employeeJpaController.getEmployeeCount() + 1));
        }
    }

    public boolean verifyEmployeeData(Employee emp,String aux, int lenPass) {
        System.out.println("contr1 "+emp.getPassword());
        System.out.println("contr2 "+aux);
        if (!emp.getPassword().equals(aux)) {
            MainController.adminView.confirmationMessages("Los campos Contraseña y Confirmar Contraseña deben ser iguales",
                    "Advertencia:",1);
            MainController.adminView.setPasswordField("");
            MainController.adminView.setConfirmPasswordField("");
            return false;
        }
        else if(lenPass<5||lenPass>25){
             MainController.adminView.confirmationMessages("El campo Contraseña debe poseer minimo 5 caracteres y maximo 25",
                    "Advertencia:",1);
            MainController.adminView.setPasswordField("");
            return false;
        }
       
        else if(emp.getName().length()<3||emp.getName().length()>50){
            MainController.adminView.confirmationMessages("El campo Nombres debe poseer minimo 2 caracteres y maximo 50",
                    "Advertencia:",1);
            MainController.adminView.setNameEmployeeTextField("");
            return false;
        }
        else if(emp.getLastName().length()<3||emp.getLastName().length()>50){
            MainController.adminView.confirmationMessages("El campo Apellidos debe poseer minimo 2 caracteres y maximo 50",
                    "Advertencia:",1);
            MainController.adminView.setLastNameEmployeeTextField("");
            return false;
        }
        else if(emp.getUser().length()<5&&emp.getUser().length()>25){
            MainController.adminView.confirmationMessages("El campo Usuario debe poseer minimo 5 caracteres y maximo 25",
                    "Advertencia:",1);
            MainController.adminView.setUserTextField("");
            return false;
        }
        else if(emp.getDocument().length()<8||emp.getDocument().length()>12){
            MainController.adminView.confirmationMessages("El campo Documento debe poseer minimo 8 caracteres y maximo 11",
                    "Advertencia:",1);
            MainController.adminView.setDocumentEmployeeTextField("");
            return false;
        }
        else{
            employeeListTotal=MainController.employeeJpaController.findEmployeeEntities();
            for (Employee e : employeeListSearch) {
                if(e.getUser().equals(emp.getUser())){
                  MainController.adminView.confirmationMessages("El Usuario ya existe, porfavor digite otro",
                    "Advertencia:",1);
                MainController.adminView.setUserTextField("");
                return false;  
                }
            }
        }
        try{
            Integer.parseInt(emp.getDocument());
        }
        catch(Exception e){
            MainController.adminView.confirmationMessages("El campo Documento debe contener solo números",
                    "Advertencia:",1);
            MainController.adminView.setDocumentEmployeeTextField("");
            return false;
        }
        
        return true;
    }

    

    public static DefaultListModel totalSearchOfEmployees() {
        DefaultListModel results = new DefaultListModel();
        employeeListTotal = MainController.employeeJpaController.findEmployeeEntities();
        employeeListSearch = employeeListTotal;
        for (Employee e : employeeListTotal) {
            results.addElement(e.getId() + " " + e.getUser());
        }
        return results;
    }

    public static DefaultListModel searchOfEmployees(int search) {
        DefaultListModel results = new DefaultListModel();
        employeeListSearch = MainController.employeeJpaController.findEmployeeEntities();
        for (Employee e : employeeListSearch) {
            if (search == e.getId()) {
                results.addElement(e.getId() + " " + e.getUser());
            }
        }
        return results;
    }

    public static List<Employee> getEmployeeListSearch() {
        return employeeListSearch;
    }

    public static void setEmployeeListSearch(List<Employee> employeeListSearch) {
        AdministrateEmployeeController.employeeListSearch = employeeListSearch;
    }

    public static List<Employee> getEmployeeListTotal() {
        return employeeListTotal;
    }

    public static void setEmployeeListTotal(List<Employee> employeeListTotal) {
        AdministrateEmployeeController.employeeListTotal = employeeListTotal;
    }

    public static Employee getTempEmployee() {
        return tempEmployee;
    }

    public static void setTempEmployee(Employee tempEmployee) {
        AdministrateEmployeeController.tempEmployee = tempEmployee;
    }
    private static Employee tempEmployee = new Employee();
    private static List<Employee> employeeListSearch = null;
    private static List<Employee> employeeListTotal = null;
}
