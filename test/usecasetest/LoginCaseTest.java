/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import controller.Administration.EmployeeManagementController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 */
public class LoginCaseTest {
    
    public LoginCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void userAndPasswordInvalids() {
        setUser("usu");
        setPassword("12");
        
        assertFalse(EmployeeManagementController.validateUser(user));
        assertFalse(EmployeeManagementController.validatePassword(password));
    }
    
    @Test
    public void emptyCredentials(){
        setUser("");
        setPassword("");
        
        assertFalse(EmployeeManagementController.validateUser(user));
        assertFalse(EmployeeManagementController.validatePassword(password));
    }
    
    @Test
    public void validsCredentials(){
        setUser("Usuario");
        setPassword("1234567");
        
        assertTrue(EmployeeManagementController.validateUser(user));
        assertTrue(EmployeeManagementController.validateUser(user));
    }
    
    @Test
    public void userAndPasswordLimitExceeded(){
        setUser("UsuarioEjemplo");
        setPassword("12345678910");
        
        assertFalse(EmployeeManagementController.validateUser(user));
        assertFalse(EmployeeManagementController.validatePassword(password));
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

}
