/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import javax.persistence.Persistence;
import Entity.Employee;
import javax.persistence.EntityManagerFactory;
import DAO.EmployeeJpaController;
import controller.MainController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class SystemSetupCaseTest {
    
    public SystemSetupCaseTest() {
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
            employeeJpaController.create(mkanayet);
        }
        
        if(employeeJpaController.findEmployee(3)==null){
            Employee srcastrot = new Employee();
            srcastrot.setId(3);
            srcastrot.setLastName("Castro");
            srcastrot.setName("Sebastian");
            srcastrot.setDocument("257833");
            srcastrot.setUser("srcastrot");
            srcastrot.setPassword(controller.MainController.md5Security.MD5Security("castor"));
            srcastrot.setAdministrator(false);
            srcastrot.setIsActive(true);
            employeeJpaController.create(srcastrot);
        }
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
    public void administratorPasswordNotFound() {
        setPassword("123");
        
        assertFalse(MainController.verifyAdminAccess(getPassword()));
    }
    
    @Test
    public void administratorPasswordNotFound2() {
        setPassword("parquick");
        
        assertFalse(MainController.verifyAdminAccess(getPassword()));
    }
    
    @Test
    public void administratorPasswordNotFound3() {
        setPassword("universidad");
        
        assertFalse(MainController.verifyAdminAccess(getPassword()));
    }
    
    @Test
    public void administratorPasswordFound(){
        setPassword("pass");
        
        assertTrue(MainController.verifyAdminAccess(getPassword()));
    }
    
    @Test
    public void inactiveAdministratorPasswordFound(){
        setPassword("word");
        
        assertFalse(MainController.verifyAdminAccess(getPassword()));
    }
    
    @Test
    public void employeePasswordFound(){
        setPassword("castor");
        
        assertFalse(MainController.verifyAdminAccess(getPassword()));
    }

    // Class variables, getters and setters methods
    public void setPasswordMD5(String password){
        this.password = controller.MainController.md5Security.MD5Security(password);
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String password;
    private static EmployeeJpaController employeeJpaController;
    private static EntityManagerFactory persistence_factory;
}
