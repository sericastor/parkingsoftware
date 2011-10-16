/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.Employee;
import controller.MainController;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author r4wd3r
 */
public class AdministrateEmployeeController {
    public AdministrateEmployeeController(){}
    
    
    public static DefaultListModel TotalSearchOfEmployees(){
        DefaultListModel results = new DefaultListModel();
        employeeListTotal = MainController.employeeJpaController.findEmployeeEntities();
        employeeListSearch = employeeListTotal;
        for(Employee e : employeeListTotal){
            results.addElement(e.getId() +" "+ e.getUser());
        }
        return results;
    }
    
    public static DefaultListModel SearchOfEmployees (String searchString){
        DefaultListModel results = new DefaultListModel();
        employeeListSearch= MainController.employeeJpaController.findEmployeeEntities();
        for(Employee e : employeeListSearch){
            results.addElement(e.getId() +" "+ e.getUser());
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
