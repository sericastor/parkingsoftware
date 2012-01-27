/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import controller.LoginController;
import javax.persistence.EntityManagerFactory;
import DAO.EmployeeJpaController;
import Entity.Employee;
import controller.Administration.AdministrateEmployeeController;
import controller.MainController;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 * Test Case Number 1
 */
public class LoginCaseTest {
    
    public LoginCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        employeeJpaController = new EmployeeJpaController(persistence_factory);
        
        if(employeeJpaController.findEmployeeEntities(false, 2, 1).isEmpty()){
            
            Employee dasalgadoc = new Employee();
            dasalgadoc.setId(1);
            dasalgadoc.setLastName("Salgado");
            dasalgadoc.setName("Diego");
            dasalgadoc.setDocument("257889");
            dasalgadoc.setUser("dasalgadoc");
            dasalgadoc.setPassword(controller.MainController.md5Security.MD5Security("pass"));
            dasalgadoc.setAdministrator(true);
            dasalgadoc.setIsActive(true);
            dasalgadoc.setTheme(0);
            employeeJpaController.create(dasalgadoc);
            
            Employee mkanayet = new Employee();
            mkanayet.setId(2);
            mkanayet.setLastName("Kanayet");
            mkanayet.setName("Martin");
            mkanayet.setDocument("257875");
            mkanayet.setUser("mkanayet");
            mkanayet.setPassword(controller.MainController.md5Security.MD5Security("word"));
            mkanayet.setAdministrator(true);
            mkanayet.setIsActive(false);
            mkanayet.setTheme(0);
            employeeJpaController.create(mkanayet);
        }
    }
 
    @Test
    public void userAndPasswordInvalids() {
        setUser("usu");
        setPassword("12");
        
        assertFalse(AdministrateEmployeeController.quickValidateUser(getUser()));
        assertFalse(AdministrateEmployeeController.quickValidatePassword(getPassword()));
    }
    
    @Test
    public void emptyCredentials(){
        setUser("");
        setPassword("");
        
        assertFalse(AdministrateEmployeeController.quickValidateUser(getUser()));
        assertFalse(AdministrateEmployeeController.quickValidatePassword(getPassword()));
    }
    
    @Test
    public void validsCredentials(){
        setUser("Usuario");
        setPassword("1234567");
        
        assertTrue(AdministrateEmployeeController.quickValidateUser(getUser()));
        assertTrue(AdministrateEmployeeController.quickValidatePassword(getPassword()));
    }
    
    @Test
    public void userAndPasswordLimitExceeded(){
        setUser("UsuarioEjemplo");
        setPassword("12345678910");
        
        assertFalse(AdministrateEmployeeController.quickValidateUser(getUser()));
        assertFalse(AdministrateEmployeeController.quickValidatePassword(getPassword()));
    }
    
    @Test
    public void employeeNotFound(){
        setUser("parquick");
        setPassword("parking");
        
        MainController.loginController.getLoginView().getUserTextField().setText(getUser());
        MainController.loginController.getLoginView().getPasswordField().setText(getPassword());
        
        LoginController.startLogin();
    }
    
    @Test
    public void employeeNotActive(){
        setUser("mkanayet");
        setPassword("word");
        
        MainController.loginController.getLoginView().getUserTextField().setText(getUser());
        MainController.loginController.getLoginView().getPasswordField().setText(getPassword());
        
        LoginController.startLogin();
    }
    
    @Test
    public void loginSuccessful(){
        setUser("dasalgadoc");
        setPassword("pass");
        
        MainController.loginController.getLoginView().getUserTextField().setText(getUser());
        MainController.loginController.getLoginView().getPasswordField().setText(getPassword());
        
        LoginController.startLogin();
    }

    // Class variables, getters and setters methods
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    private String user;
    private String password;
    private static EmployeeJpaController employeeJpaController;
    private static EntityManagerFactory persistence_factory;
}
