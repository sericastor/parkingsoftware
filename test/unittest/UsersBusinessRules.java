/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

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
public class UsersBusinessRules {
    
    public UsersBusinessRules() {
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
    public void invalidNameMinimumLength() {
        String name = "A";
        
        assertFalse(EmployeeManagementController.validateName(name));
    }
    
    @Test
    public void validName(){
        String name = "Usuario";
        
        assertTrue(EmployeeManagementController.validateName(name));
    }
    
    @Test
    public void invalidNameMaximumLength(){
        String name = "A";
        for(int i = 0; i < 25; i++){
            name = name.concat("A");
        }
        assertFalse(EmployeeManagementController.validateName(name));
    }
    
    @Test
    public void invalidLastNameMinimumLength(){
        String lastName = "B";
        
        assertFalse(EmployeeManagementController.validateLastName(lastName));
    }
    
    @Test
    public void validLastName(){
        String lastName = "Usuario";
        
        assertTrue(EmployeeManagementController.validateLastName(lastName));
    }
    
    @Test
    public void invalidLastNameMaximumLength(){
        String lastName = "B";
        for(int i = 0; i < 25; i++){
            lastName = lastName.concat("B");
        }
        assertFalse(EmployeeManagementController.validateLastName(lastName));
    }
    
    @Test
    public void invalidDocumentMinimumLength(){
        String document = "123";
        
        assertFalse(EmployeeManagementController.validateDocument(document));
    }
    
    @Test
    public void validDocument(){
        String document = "250000";
        
        assertTrue(EmployeeManagementController.validateDocument(document));
    }
    
    @Test
    public void invalidDocumentMaximumLenght(){
        String document = "1";
        for(int i = 0; i < 15; i++){
            document = document.concat("1");
        }
        assertFalse(EmployeeManagementController.validateDocument(document));
    }
    
    @Test
    public void invalidUserMinimumLength(){
        String user = "usu";
        
        assertFalse(EmployeeManagementController.validateUser(user));
    }
    
    @Test
    public void validUser(){
        String user = "Usuario";
        
        assertTrue(EmployeeManagementController.validateUser(user));
    }
    
    @Test
    public void invalidUserMaximumLength(){
        String user = "C";
        for(int i = 0; i < 10; i++){
            user = user.concat("C");
        }
        assertFalse(EmployeeManagementController.validateUser(user));
    }
    
    @Test
    public void invalidPasswordMinimunLength(){
        String password = "A1";
        
        assertFalse(EmployeeManagementController.validatePassword(password));
    }
    
    @Test
    public void validPassword(){
        String password = "Java";
        
        assertTrue(EmployeeManagementController.validatePassword(password));
    }
    
    @Test
    public void invalidPasswordMaximumLength(){
        String password = "A1";
        for(int i = 0; i < 5; i++){
            password = password.concat("A1");
        }
        assertFalse(EmployeeManagementController.validatePassword(password));
    }
    
}
