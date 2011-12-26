/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import javax.persistence.Persistence;
import java.util.Calendar;
import Entity.Entries;
import Entity.BandsRate;
import Entity.VehicleType;
import DAO.EntriesJpaController;
import javax.persistence.EntityManagerFactory;
import DAO.BandsRateJpaController;
import DAO.VehicleTypeJpaController;
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
public class QuitVehicleCaseTest {
    
    
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
    public void vehicleNotFound() {}
    
    @Test
    public void vehicleNotFound2(){}
    
    @Test
    public void vehicleFound(){}
    
    @Test
    public void quitVehicleFound(){}
    
    @Test
    public void vehicleFound2(){}
    
    @Test
    public void quitVehicleFound2(){}
    
    @Test
    public void vehicleFound3(){}
    
    @Test
    public void quitVehicleFound3(){}
    
    // Class Variables, getters and setters methods
    private static VehicleTypeJpaController vehicleTypeJpaController;
    private static BandsRateJpaController bandsRateJpaController;
    private static EntityManagerFactory persistence_factory;
    private static EntriesJpaController entriesJpaController;
}
