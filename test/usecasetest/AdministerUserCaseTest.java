/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import javax.swing.DefaultListModel;
import java.util.List;
import Entity.Employee;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import DAO.EmployeeJpaController;
import controller.Administration.AdministrateEmployeeController;
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
public class AdministerUserCaseTest {
    
    public AdministerUserCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        employeeJpaController = new EmployeeJpaController(persistence_factory);
        
        if(employeeJpaController.findEmployeeEntities(false, 3, 1).isEmpty()){
            
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
    // Thanks to bad initialization, this test must be changed
    public void searchAllEmployees() {
        DefaultListModel allEmployees = AdministrateEmployeeController.totalSearchOfEmployees();
        
        assertTrue(allEmployees.size()==3);
        assertNotNull(allEmployees.get(0));
        assertNotNull(allEmployees.get(1));
        assertNotNull(allEmployees.get(2));
        
        assertEquals(allEmployees.get(0), "1 dasalgadoc");
        assertEquals(allEmployees.get(1), "2 mkanayet");
        assertEquals(allEmployees.get(2), "3 srcastrot");
    }
    
    @Test
    public void searchAnExistingEmployee(){
        DefaultListModel employeeTwo = AdministrateEmployeeController.searchOfEmployees(2);
        
        assertTrue(employeeTwo.size()==1);
        assertNotNull(employeeTwo.get(0));
        
        assertEquals(employeeTwo.get(0), "2 mkanayet");
    }
    
    @Test
    public void searchANotExistingEmployee(){
        DefaultListModel employeeFour = AdministrateEmployeeController.searchOfEmployees(4);
        
        assertTrue(employeeFour.isEmpty());
    }
    
    @Test
    public void createAValidEmployee(){}
    
    @Test
    public void createAnEmployeeWithRepeatedUser(){}
    
    @Test
    public void createAnEmployeeWithNotEqualsPasswords(){}
    
    @Test
    public void createAnEmployeeWithEmptyFields(){}
    
    @Test
    public void updateAnEmployeeSuccessful(){}
    
    @Test
    public void updateAnEmployeeWithRepeatedUser(){}
    
    @Test
    public void updateAnEmployeeWithNotEqualsPasswords(){}
    
    @Test
    public void updateAnEmployeeWithEmptyFields(){}
    
    @Test
    public void updateAnEmployeeInvalidatingRules(){}
    
    // Class variables, getters and setters methods
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private long id;
    private String lastName;
    private String name;
    private String document;
    private String password;
    private boolean administrator;
    private boolean active;
    
    private static EmployeeJpaController employeeJpaController;
    private static EntityManagerFactory persistence_factory;
}
