/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import javax.swing.table.DefaultTableModel;
import Entity.Employee;
import Entity.BandsRate;
import Entity.VehicleType;
import javax.persistence.Persistence;
import DAO.EmployeeJpaController;
import DAO.BandsRateJpaController;
import DAO.VehicleTypeJpaController;
import controller.Administration.AdministrateVehicleTypeController;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 * Test Case Number 8
 */
public class AdministrateVehicleTypeCaseTest {
    
    public AdministrateVehicleTypeCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        vehicleTypeJpaController = new VehicleTypeJpaController(persistence_factory);
        bandsRateJpaController = new BandsRateJpaController(persistence_factory);
        employeeJpaController = new EmployeeJpaController(persistence_factory);
        
        if(vehicleTypeJpaController.findVehicleTypeEntities(4, 2).isEmpty()){
            VehicleType oldCar = new VehicleType();
            oldCar.setCodification("111000");
            oldCar.setName("CarritoViejo");
            vehicleTypeJpaController.create(oldCar);
            
            VehicleType hovercraft = new VehicleType();
            hovercraft.setCodification("111000");
            hovercraft.setName("Aerodeslizador");
            vehicleTypeJpaController.create(hovercraft);
            
            BandsRate hovercraftRates = new BandsRate();
            hovercraftRates.setFromm(0);
            hovercraftRates.setToo(60);
            hovercraftRates.setUnits(1);
            hovercraftRates.setUnitValue(50.0);
            hovercraftRates.setVehicletype(hovercraft);
            bandsRateJpaController.create(hovercraftRates);
            
            hovercraftRates.setFromm(61);
            hovercraftRates.setToo(10000);
            hovercraftRates.setUnits(2);
            hovercraftRates.setUnitValue(90.0);
            hovercraftRates.setVehicletype(hovercraft);
            bandsRateJpaController.create(hovercraftRates);
            
            VehicleType bicycle = new VehicleType();
            bicycle.setCodification("000");
            bicycle.setName("Bicicleta");
            vehicleTypeJpaController.create(bicycle);
            
            BandsRate bicyclesRates = new BandsRate();
            bicyclesRates.setFromm(0);
            bicyclesRates.setToo(10000);
            bicyclesRates.setUnits(1);
            bicyclesRates.setUnitValue(25.0);
            bicyclesRates.setVehicletype(bicycle);
            bandsRateJpaController.create(bicyclesRates);
            
            VehicleType bus = new VehicleType();
            bus.setCodification("000111");
            bus.setName("Bus");
            vehicleTypeJpaController.create(bus);
            
            BandsRate busRates = new BandsRate();
            busRates.setFromm(0);
            busRates.setToo(30);
            busRates.setUnits(1);
            busRates.setUnitValue(70.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
            
            busRates.setFromm(31);
            busRates.setToo(120);
            busRates.setUnits(2);
            busRates.setUnitValue(100.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
            
            busRates.setFromm(121);
            busRates.setToo(10000);
            busRates.setUnits(2);
            busRates.setUnitValue(90.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
        }
        
        if(employeeJpaController.findEmployeeEntities(false, 1, 1).isEmpty()){
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
        }
        
        sessionEmployee = employeeJpaController.findEmployee(1);
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
    public void searchAllVehiclesTypes() {
        DefaultTableModel vehicleTypes = AdministrateVehicleTypeController.totalSearchOfVehicles();
        
        assertTrue(vehicleTypes.getRowCount()==5);
        
        // Row 1
        assertEquals(vehicleTypes.getValueAt(0, 0),"1");
        assertEquals(vehicleTypes.getValueAt(0, 1),"IName");
        System.out.println(String.valueOf(vehicleTypes.getValueAt(0, 2)));
        System.out.println((AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(0, 2)))));
        setExample(AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(0, 2))));
        assertEquals(getExample(),"0000000000000");// This have no sense
        
        // Row 2
        assertEquals(vehicleTypes.getValueAt(1, 0),"2");
        assertEquals(vehicleTypes.getValueAt(1, 1),"CarritoViejo");
        setExample(AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(1, 2))));
        assertEquals(getExample(),"111000");
        
        // Row 3
        assertEquals(vehicleTypes.getValueAt(2, 0),"3");
        assertEquals(vehicleTypes.getValueAt(2, 1),"Aerodeslizador");
        setExample(AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(2, 2))));
        assertEquals(getExample(),"111000");
        
        // Row 4
        assertEquals(vehicleTypes.getValueAt(3, 0),"4");
        assertEquals(vehicleTypes.getValueAt(3, 1),"Bicicleta");
        setExample(AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(3, 2))));
        assertEquals(getExample(),"000");
        
        // Row 5
        assertEquals(vehicleTypes.getValueAt(4, 0),"5");
        assertEquals(vehicleTypes.getValueAt(4, 1),"Bus");
        setExample(AdministrateVehicleTypeController.encodePlate(String.valueOf(vehicleTypes.getValueAt(4, 2))));
        assertEquals(getExample(),"000111");
    }
    
    @Test
    public void createAnInvalidVehicleType(){}
    
    @Test
    public void createAValidVehicleType(){}
    
    // This test cant be developed because there arent code implementation
    @Test
    public void updateAVehicleTypeWithInvalidParameters() {}
    
    // This test cant be developed because there arent code implementation
    @Test
    public void updateAVehicleTypeWithValidParameters() {}
    
    // Class variables, setters and getters methods

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private String name;
    private String example;
    private static Employee sessionEmployee;
    
    private static EntityManagerFactory persistence_factory;
    private static VehicleTypeJpaController vehicleTypeJpaController;
    private static BandsRateJpaController bandsRateJpaController;
    private static EmployeeJpaController employeeJpaController;
}
