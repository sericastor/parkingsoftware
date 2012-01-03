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
import controller.Administration.EmployeeManagementController;
import controller.MainController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 * Test Case Number 6
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
    public void createAValidEmployee(){
        setId(EmployeeManagementController.getNextID());
        setName("Miguel");
        setLastName("Diaz");
        setDocument("123456");
        setUser("mcdiaz");
        setPassword("parquick");
        setConfirmation("parquick");
        setAdministrator(false);
        setActive(true);
        
        assertEquals(getId(),4);
        
        EmployeeManagementController.saveNewEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertTrue(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        assertTrue(EmployeeManagementController.validateAll(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        Employee lastEmployee = employeeJpaController.findEmployee(Long.valueOf(id));
        
        assertEquals(lastEmployee.getId(),4);
        assertEquals(lastEmployee.getName(),"Miguel");
        assertEquals(lastEmployee.getLastName(),"Diaz");
        assertEquals(lastEmployee.getDocument(),"123456");
        assertEquals(lastEmployee.getUser(),"mcdiaz");
        assertEquals(lastEmployee.getPassword(),MainController.md5Security.MD5Security(getPassword()));
        assertFalse(lastEmployee.isAdministrator());
        assertTrue(lastEmployee.isIsActive());
    }
    
    @Test
    public void createAnEmployeeWithRepeatedUser(){
        setId(EmployeeManagementController.getNextID());
        setName("Felipe");
        setLastName("Castaño");
        setDocument("123456");
        setUser("srcastrot");
        setPassword("parquick");
        setConfirmation("parquick");
        setAdministrator(false);
        setActive(true);
        
        assertEquals(getId(),5);
        
        EmployeeManagementController.saveNewEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertTrue(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        assertTrue(EmployeeManagementController.validateAll(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        assertNull(employeeJpaController.findEmployee(Long.valueOf(id)));
    }
    
    @Test
    public void createAnEmployeeWithNotEqualsPasswords(){
        setId(EmployeeManagementController.getNextID());
        setName("Felipe");
        setLastName("Castaño");
        setDocument("789012");
        setUser("spipex");
        setPassword("superpip");
        setConfirmation("parquick");
        setAdministrator(false);
        setActive(true);
        
        assertEquals(getId(),5);
        
        EmployeeManagementController.saveNewEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertFalse(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        
        assertNull(employeeJpaController.findEmployee(Long.valueOf(id)));
    }
    
    @Test
    public void createAnEmployeeWithEmptyFields(){
        setId(EmployeeManagementController.getNextID());
        setName("Felipe");
        setLastName("");
        setDocument("");
        setUser("spipex");
        setPassword("parquick");
        setConfirmation("parquick");
        setAdministrator(false);
        setActive(true);
        
        assertEquals(getId(),5);
        
        EmployeeManagementController.saveNewEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertFalse(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        assertNull(employeeJpaController.findEmployee(Long.valueOf(id)));
    }
    
    @Test
    public void updateAnEmployeeSuccessful(){
        // New Data
        setName("Ricardo");
        setPassword("ingesoft");
        setConfirmation("ingesoft");
        setAdministrator(true);
        
        Employee updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
       
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Sebastian");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("castor"));
        assertFalse(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
        
        //Old Data
        setId(updateEmployee.getId());
        setLastName(updateEmployee.getLastName());
        setDocument(updateEmployee.getDocument());
        setUser(updateEmployee.getUser());
        setActive(updateEmployee.isIsActive());
        
        EmployeeManagementController.updateOldEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertTrue(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        assertTrue(EmployeeManagementController.validateAll(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
    }
    
    @Test
    public void updateAnEmployeeWithRepeatedUser(){
        //New Data
        setUser("mkanayet");
        setPassword("castor");
        setConfirmation("castor");
        
        Employee updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
        
        //Old Data
        setId(updateEmployee.getId());
        setName(updateEmployee.getName());
        setLastName(updateEmployee.getLastName());
        setDocument(updateEmployee.getDocument());
        setAdministrator(updateEmployee.isAdministrator());
        setActive(updateEmployee.isIsActive());
        
        EmployeeManagementController.updateOldEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertTrue(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        assertTrue(EmployeeManagementController.validateAll(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
    }
    
    @Test
    public void updateAnEmployeeWithNotEqualsPasswords(){
        //New Data
        setPassword("sericastor");
        setConfirmation("castor");
        
        Employee updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
        
        //Old Data
        setId(updateEmployee.getId());
        setName(updateEmployee.getName());
        setLastName(updateEmployee.getLastName());
        setDocument(updateEmployee.getDocument());
        setUser(updateEmployee.getUser());
        setAdministrator(updateEmployee.isAdministrator());
        setActive(updateEmployee.isIsActive());
        
        EmployeeManagementController.updateOldEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertFalse(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        
        updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
    }
    
    @Test
    public void updateAnEmployeeWithEmptyFields(){
        //New Data
        setLastName("");
        setPassword("castor");
        setConfirmation("castor");
        
        Employee updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
        
        // Old Data
        setId(updateEmployee.getId());
        setName(updateEmployee.getName());
        setDocument(updateEmployee.getDocument());
        setUser(updateEmployee.getUser());
        setAdministrator(updateEmployee.isAdministrator());
        setActive(updateEmployee.isIsActive());
        
        EmployeeManagementController.updateOldEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertFalse(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
    }
    
    @Test
    public void updateAnEmployeeInvalidatingRules(){
        //New Data
        setUser("Ingenieriadesoftware");
        setActive(false);
        setPassword("aponte");
        setConfirmation("aponte");
        
        Employee updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
        
        //Old Data
        setId(updateEmployee.getId());
        setName(updateEmployee.getName());
        setLastName(updateEmployee.getLastName());
        setDocument(updateEmployee.getDocument());
        setAdministrator(updateEmployee.isAdministrator());
        
        EmployeeManagementController.updateOldEmployee(getId(), getLastName(), getName(), getDocument(), getUser(), getPassword(), getConfirmation(), isActive(), isAdministrator());
        
        assertTrue(EmployeeManagementController.validatePasswords(getPassword(), getConfirmation()));
        assertTrue(EmployeeManagementController.validateNotEmptyFields(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        assertFalse(EmployeeManagementController.validateAll(getLastName(), getName(), getDocument(), getUser(), getPassword()));
        
        updateEmployee = employeeJpaController.findEmployee(Long.valueOf(3));
        
        assertEquals(updateEmployee.getId(),3);
        assertEquals(updateEmployee.getName(),"Ricardo");
        assertEquals(updateEmployee.getLastName(),"Castro");
        assertEquals(updateEmployee.getDocument(),"257833");
        assertEquals(updateEmployee.getUser(),"srcastrot");
        assertEquals(updateEmployee.getPassword(),MainController.md5Security.MD5Security("ingesoft"));
        assertTrue(updateEmployee.isAdministrator());
        assertTrue(updateEmployee.isIsActive());
    }
    
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

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    private long id;
    private String lastName;
    private String name;
    private String document;
    private String user;
    private String password;
    private String confirmation;
    private boolean administrator;
    private boolean active;
    
    private static EmployeeJpaController employeeJpaController;
    private static EntityManagerFactory persistence_factory;
}
