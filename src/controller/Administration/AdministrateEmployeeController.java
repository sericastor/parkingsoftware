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

    public void searchEmployee(){
        MainController.adminView.getEmployeeList().removeAll();
        String searchText = MainController.adminView.getConsultEmployeeTextField();
        if(searchText.isEmpty()){
            MainController.adminView.getEmployeeList().setModel(totalSearchOfEmployees());
        }else{
            try{
                int searchInt = Integer.parseInt(searchText);
                if (searchInt > 0) {
                    if(searchOfEmployees(searchInt).isEmpty()){
                        MainController.adminView.showMessage("Advertencia", "No se encontraron usuarios con el ID: " + searchText, JOptionPane.WARNING_MESSAGE);
                        MainController.adminView.getEmployeeList().setModel(totalSearchOfEmployees());
                    }else{
                        MainController.adminView.getEmployeeList().setModel(searchOfEmployees(searchInt));
                    }
                } else {
                    MainController.adminView.showMessage("Advertencia", "No se permiten ID negativos", JOptionPane.WARNING_MESSAGE);
                }
            }catch(Exception ex){
                MainController.adminView.showMessage("Advertencia", "La busqueda debe hacerse por ID", JOptionPane.WARNING_MESSAGE);
            }
        }
        MainController.adminView.setConsultEmployeeTextField(null);
    }
    
    public void getEmployeeInfoForClickedList(){
        int employeeId;
        if(MainController.adminView.getEmployeeList().getSelectedValue() == null){
            employeeId = MainController.adminView.getEmployeeList().getSelectedIndex();
        }else{
            javax.swing.JList employeeList = MainController.adminView.getEmployeeList();
            employeeId = Integer.parseInt(employeeList.getSelectedValue().toString().substring(0, employeeList.getSelectedValue().toString().indexOf(" "))) - 1;
        }
        if(employeeId >= 0){
            Employee e = getEmployeeListSearch().get(employeeId);
            setTempEmployee(e);
            MainController.adminView.setIdEmployeeTextField(String.valueOf(e.getId()));
            MainController.adminView.setNameEmployeeTextField(e.getName());
            MainController.adminView.setLastNameEmployeeTextField(e.getLastName());
            MainController.adminView.setDocumentEmployeeTextField(e.getDocument());
            MainController.adminView.setSelectedActiveEmployeeCheckBox(e.isIsActive());
            MainController.adminView.setSelectedAdminEmployeeCheckBox(e.isAdministrator());
            MainController.adminView.setUserTextField(e.getUser());
        }
    }
    
    public void CreateEmployee() {
        if(MainController.adminView.getCreateEmployeeButton().equals("Crear Empleado")){
            MainController.adminView.setNullEmp();
            MainController.adminView.setEnabledEmp(true);
            MainController.adminView.setCreateEmployeeButton("Guardar Empleado");
            MainController.adminView.setEnabledUpdateEmployeeButton(false);
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
        emp.setIsActive(MainController.adminView.getIsisActiveEmployeeCheckBox());
        emp.setAdministrator(MainController.adminView.getIsAdminEmployeeCheckBox());
        String aux = MainController.adminView.getConfirmPasswordField();
        int option = MainController.adminView.askToAdmin("¿Está seguro de crear al empleado ");
            if (option == JOptionPane.OK_OPTION && verifyEmployeeData(emp, aux, lenPass, createAction)) {
                MainController.employeeJpaController.create(emp);
                MainController.adminView.showMessage("Exito", "Usuario: " + emp.getUser() + " creado.", JOptionPane.INFORMATION_MESSAGE);
                restartDataCreate();
            }
            if(option == JOptionPane.NO_OPTION){
                restartDataCreate();
            }
        }
    }
    
    public void restartDataCreate(){
        MainController.adminView.setNullEmp();
        MainController.adminView.setEnabledEmp(false);
        MainController.adminView.setEnabledUpdateEmployeeButton(true);
        MainController.adminView.searchButtonAction();
        MainController.adminView.setCreateEmployeeButton("Crear Empleado");
    }
    
    public void UpdateEmployee(){
        if (MainController.adminView.getIdEmployeeTextField().isEmpty()) {
            MainController.adminView.showMessage("Error", "Consulte el empleado a modificar", JOptionPane.WARNING_MESSAGE);
        } else {
            if (MainController.adminView.getUpdateEmployeeButton().equals("Actualizar Empleado")){
                MainController.adminView.setEnabledEmp(true);
                MainController.adminView.setUpdateEmployeeButton("Guardar Cambios");
                MainController.adminView.setEnabledCreateEmployeeButton(false);
            } else {
                long id = Long.parseLong(MainController.adminView.getIdEmployeeTextField());
                int lenPass=MainController.adminView.getLenghtOfPasswordTextField();
                Employee emp = new Employee();
                emp.setName(MainController.adminView.getNameEmployeeTextField());
                emp.setLastName(MainController.adminView.getLastNameEmployeeTextField());
                emp.setDocument(MainController.adminView.getDocumentEmployeeTextField());
                emp.setUser(MainController.adminView.getUserTextField());
                emp.setPassword(MainController.adminView.getPasswordField());
                emp.setIsActive(MainController.adminView.getIsisActiveEmployeeCheckBox());
                emp.setAdministrator(MainController.adminView.getIsAdminEmployeeCheckBox());
                String aux = MainController.adminView.getConfirmPasswordField();
                int option = MainController.adminView.askToAdmin("¿ Está seguro de modificar al empleado ");
                if (option == JOptionPane.OK_OPTION && verifyEmployeeData(emp, aux,lenPass, updateAction)) {
                    MainController.employeeJpaController.edit(emp, id);
                    MainController.adminView.showMessage("Exito", "Usuario: " + emp.getUser() + " modificado.", JOptionPane.INFORMATION_MESSAGE);
                    restartDataUpdate();
                }
                if(option == JOptionPane.NO_OPTION || (option == JOptionPane.OK_OPTION && verifyEmployeeData(emp, aux, lenPass, updateAction))){
                    restartDataUpdate();
                }
            }
        }
    }
    
    public void restartDataUpdate(){
        MainController.adminView.searchButtonAction();
        MainController.adminView.setUpdateEmployeeButton("Actualizar Empleado");
        MainController.adminView.setNullEmp();
        MainController.adminView.setEnabledEmp(false);
        MainController.adminView.setEnabledCreateEmployeeButton(true);
    }

    public boolean verifyEmployeeData(Employee emp,String aux, int lenPass, int action) {
        if (!emp.getPassword().equals(aux)) {
            MainController.adminView.confirmationMessages("Los campos Contraseña y Confirmar Contraseña deben ser iguales",
                    "Advertencia:",1);
            MainController.adminView.setPasswordField("");
            MainController.adminView.setConfirmPasswordField("");
            return false;
        }
        else if(lenPass<4||lenPass>10){
            MainController.adminView.confirmationMessages("El campo Contraseña debe poseer minimo 4 caracteres y maximo 10",
                    "Advertencia:",1);
            MainController.adminView.setPasswordField("");
            MainController.adminView.setConfirmPasswordField("");
            return false;
        }
       
        else if(emp.getName().length()<2||emp.getName().length()>25){
            MainController.adminView.confirmationMessages("El campo Nombres debe poseer minimo 2 caracteres y maximo 25",
                    "Advertencia:",1);
            MainController.adminView.setNameEmployeeTextField("");
            return false;
        }
        else if(emp.getLastName().length()<2||emp.getLastName().length()>25){
            MainController.adminView.confirmationMessages("El campo Apellidos debe poseer minimo 2 caracteres y maximo 25",
                    "Advertencia:",1);
            MainController.adminView.setLastNameEmployeeTextField("");
            return false;
        }
        else if(emp.getUser().length()<4&&emp.getUser().length()>10){
            MainController.adminView.confirmationMessages("El campo Usuario debe poseer minimo 4 caracteres y maximo 10",
                    "Advertencia:",1);
            MainController.adminView.setUserTextField("");
            return false;
        }
        else if(emp.getDocument().length()<6||emp.getDocument().length()>15){
            MainController.adminView.confirmationMessages("El campo Documento debe poseer minimo 6 caracteres y maximo 15",
                    "Advertencia:",1);
            MainController.adminView.setDocumentEmployeeTextField("");
            return false;
        }
        else{
            if(action==createAction){
                employeeListTotal=MainController.employeeJpaController.findEmployeeEntities();
                for (Employee e : employeeListSearch) {
                    if(e.getUser().equals(emp.getUser())){
                        MainController.adminView.confirmationMessages("El Usuario ya existe, porfavor digite otro",
                            "Advertencia:",1);
                        MainController.adminView.setUserTextField("");
                        return false;  
                    }
                    if(e.getDocument().equals(emp.getDocument())){
                        MainController.adminView.confirmationMessages("El Usuario ya existe, porfavor digite otro",
                            "Advertencia:",1);
                        MainController.adminView.setDocumentEmployeeTextField("");
                        return false;
                    }
                }
            }
        }
        try{
            Long.parseLong(emp.getDocument());
        }
        catch(Exception e){
            MainController.adminView.confirmationMessages("El campo Documento debe contener solo números",
                    "Advertencia:",1);
            MainController.adminView.setDocumentEmployeeTextField("");
            return false;
        }
        
        return true;
    }
    
    public static boolean quickValidatePassword(String password) {
        if (password.length() >= 4 && password.length() <= 10) {
            return true;
        }
        return false;
    }
    
    public static boolean quickValidateUser(String user){
        if(user.length() >=4 && user.length() <=10){
            return true;
        }
        return false;
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
    private static final int createAction = 0;
    private static final int updateAction = 1;
}
