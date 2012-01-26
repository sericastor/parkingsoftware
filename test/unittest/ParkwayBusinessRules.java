/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import controller.Administration.ParkingManagementController;
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
public class ParkwayBusinessRules {
    
    public ParkwayBusinessRules() {
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
        String name = "Park";
        
        assertFalse(ParkingManagementController.validateName(name));
    }
    
    @Test
    public void validName(){
        String name = "Parquick";
        
        assertTrue(ParkingManagementController.validateName(name));
    }
    
    @Test
    public void invalidNameMaximumLength(){
        String name = "A";
        for(int i = 0; i <15; i++){
            name = name.concat("A");
        }
        
        assertFalse(ParkingManagementController.validateName(name));
    }
    
    @Test
    public void invalidAddressMinimumLength(){
        String address = "C";
        
        assertFalse(ParkingManagementController.validateAddress(address));
    }
    
    @Test
    public void validAddress(){
        String address = "Calle 123";
        
        assertTrue(ParkingManagementController.validateAddress(address));
    }
    
    @Test
    public void invalidAddressMaximunLength(){
        String address = "C";
        for(int i = 0; i < 25; i++){
            address = address.concat("C");
        }
        
        assertFalse(ParkingManagementController.validateAddress(address));
    }
    
    @Test
    public void invalidPhone(){
        String telephone = "12345";
        
        assertFalse(ParkingManagementController.validatePhone(telephone));
    }
    
    @Test
    public void validPhone(){
        String telephone = "1234567";
        
        assertTrue(ParkingManagementController.validatePhone(telephone));
    }
    
    @Test
    public void invalidNit(){
        String nit = "123";
        
        assertFalse(ParkingManagementController.validateNIT(nit));
    }
    
    @Test
    public void validNit(){
        String nit = "12345A";
        
        assertTrue(ParkingManagementController.validateNIT(nit));
    }
    
    @Test
    public void maxCapacityZero(){
        String maxCapacity = "0";
        
        assertFalse(ParkingManagementController.validateMaxCapacity(maxCapacity));
    }
    
    @Test
    public void maxCapacityPositive(){
        String maxCapacity = "10";
        
        assertTrue(ParkingManagementController.validateMaxCapacity(maxCapacity));
    }
    
    @Test
    public void maxCapacityNegative(){
        String maxCapacity = "-10";
        
        assertFalse(ParkingManagementController.validateMaxCapacity(maxCapacity));
    }
    
    @Test
    public void maxCapacityString(){
        String maxCapacity = "asd";
        
        assertFalse(ParkingManagementController.validateMaxCapacity(maxCapacity));
    }
    
}