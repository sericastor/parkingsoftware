/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import java.util.List;
import DAO.BandsRateJpaController;
import DAO.EntriesJpaController;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import DAO.VehicleTypeJpaController;
import Entity.BandsRate;
import Entity.Entries;
import Entity.VehicleType;
import controller.AddOrQuitVehicleController;
import java.util.Calendar;
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
public class AddVehicleCaseTest {
    
    public AddVehicleCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        vehicleTypeJpaController = new VehicleTypeJpaController(persistence_factory);
        bandsRateJpaController = new BandsRateJpaController(persistence_factory);
        entriesJpaController = new EntriesJpaController(persistence_factory);
        
        if(vehicleTypeJpaController.findVehicleTypeEntities(3,2).isEmpty()){
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
            
            Entries vehicleParked = new Entries();
            vehicleParked.setEntryDate(Calendar.getInstance().getTime());
            vehicleParked.setPlate("ABC123");
            vehicleParked.setTicket(123);
            vehicleParked.setVehicleType(hovercraft);
            entriesJpaController.create(vehicleParked);
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
    public void notAlphanumericPlate(){
        setPlate("#@7/");
        
        assertEquals(AddOrQuitVehicleController.encodePlate(getPlate()),invalidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType(){
        setPlate("1");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType2(){
        setPlate("1234");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateOkVehicleNotFound(){
        setPlate("123");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertFalse(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleNotFound);
    }
    
    /*@Test
    public void addValidPlate(){
        setPlate("123");
        AddOrQuitVehicleController.setPlate(getPlate());
        String id = "Bicicleta";
        
        VehicleType cycle = new VehicleType();
        cycle.setCodification("000");
        cycle.setName(id);
        
        Entries entry = new Entries();
        entry.setEmployee(null);
        entry.setEntryDate(Calendar.getInstance().getTime());
        entry.setPlate(getPlate());
        entry.setTicket(123);
        entry.setVehicleType(cycle);
        
        AddOrQuitVehicleController.CreateVehicle(id);
        assertSame(entriesJpaController.findEntries(2), entry);
    }
    
    @Test
    public void plateOkVehicleFound(){
    }
    
    @Test
    public void plateWithoutVehicleType3(){
    }
    
    @Test
    public void plateWithoutVehicleType4(){
    }
    
    @Test
    public void plateWithoutVehicleType5(){
    }
    
    @Test
    public void addValidPlate2(){
    }
    
    @Test
    public void plateOkVehicleFoundWithoutBandsRate(){
    }*/

    // Class variables, getters and setters methods
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    private String plate;
    
    private static VehicleTypeJpaController vehicleTypeJpaController;
    private static BandsRateJpaController bandsRateJpaController;
    private static EntityManagerFactory persistence_factory;
    private static EntriesJpaController entriesJpaController;
    
    // Expected Constants
    private final String invalidPlate = "No es un tipo valido de placa";
    private final String insertValidPlate = "Inserte un tipo de placa valida";
    private final String plateOkVehicleNotFound = "Tipo de placa encontrado y vehículo no encontrado";
    private final String plateOkVehicleFound = "Tipo de placa encontrada y vehiculo encontrado";
}