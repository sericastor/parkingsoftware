/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import DAO.EmployeeJpaController;
import controller.MainController;
import java.util.List;
import DAO.BandsRateJpaController;
import DAO.EntriesJpaController;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import DAO.VehicleTypeJpaController;
import Entity.BandsRate;
import Entity.Employee;
import Entity.Entries;
import Entity.VehicleType;
import controller.AddVehicleController;
import controller.SystemSession;
import java.util.Date;
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
        employeeJpaController = new EmployeeJpaController(persistence_factory);
        
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
            
            Date date = new Date(111, 11, 22, 14, 00, 00);
            
            Entries vehicleParked = new Entries();
            vehicleParked.setEntryDate(date);
            vehicleParked.setPlate("ABC123");
            vehicleParked.setTicket(123);
            vehicleParked.setVehicleType(hovercraft);
            vehicleParked.setComentary("Automovil con forro para lluvia");
            entriesJpaController.create(vehicleParked);
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
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        entriesJpaController = new EntriesJpaController(persistence_factory);
        vehicleTypeJpaController = new VehicleTypeJpaController(persistence_factory);
        
        Long id = new Long(4);
        Date date = new Date(111, 11, 22, 13, 45, 00);
        VehicleType bicycle = vehicleTypeJpaController.findVehicleType(id);

        Entries newEntry = new Entries();
        newEntry.setEmployee(null);
        newEntry.setEntryDate(date);
        newEntry.setPlate("123");
        newEntry.setTicket(123);
        newEntry.setVehicleType(bicycle);
        newEntry.setComentary("Bicicleta Roja en buen estado");
        entriesJpaController.edit(newEntry, 2);
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
        
        assertEquals(AddVehicleController.encodePlate(getPlate()),invalidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType(){
        setPlate("1");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType2(){
        setPlate("1234");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateOkVehicleNotFound(){
        setPlate("123");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertEquals(vehicleTypeJpaController.matchPlateType(codification).get(0).getName(),"Bicicleta");
        assertFalse(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleNotFound);
    }
    
    @Test
    public void addValidPlate(){
        setPlate("123");
        setComentary("Bicicleta Roja en buen estado");
        String id = "Bicicleta";
        List<VehicleType> list = MainController.vehicleTypeJpaController.matchPlateType("000");
        
        SystemSession.setEmployee(sessionEmployee);
        AddVehicleController.setAllVehicleTypes(list);
        AddVehicleController.setPlate(getPlate());
        
        AddVehicleController.CreateVehicle(id,getComentary());
        assertEquals(entriesJpaController.findEntries(2).getPlate(),getPlate());
    }
    
    @Test
    public void plateOkVehicleFound(){
        setPlate("ABC123");
        String codification = AddVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"111000");
        assertTrue(types.size()==2);
        for(int i = 0; i<types.size(); i++){
            assertTrue(types.get(i) instanceof VehicleType);
        }
        assertEquals(types.get(0).getName(),"CarritoViejo");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertTrue(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleFound);
    }
    
    @Test
    public void plateWithoutVehicleType3(){
        setPlate("123BC");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"00011");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType4(){
        setPlate("B1C1Z2");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"101010");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void plateWithoutVehicleType5(){
        setPlate("BPD");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"111");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),insertValidPlate);
    }
    
    @Test
    public void addValidPlate2(){
        setPlate("PQR200");
        String codification = AddVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"111000");
        assertTrue(types.size()==2);
        for(int i = 0; i<types.size(); i++){
            assertTrue(types.get(i) instanceof VehicleType);
        }
        assertEquals(types.get(0).getName(),"CarritoViejo");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertFalse(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleNotFound);
    }
    
    @Test
    public void plateOkVehicleFoundWithoutBandsRate(){
        setPlate("PQR200");
        setComentary("Aerodelizador Azul, con rayones en la puerta");
        String id = "CarritoViejo";
        List<VehicleType> list = MainController.vehicleTypeJpaController.matchPlateType("111000");
        
        SystemSession.setEmployee(sessionEmployee);
        AddVehicleController.setAllVehicleTypes(list);
        AddVehicleController.setPlate(getPlate());
        
        AddVehicleController.CreateVehicle(id, getComentary());
        
        assertNull(entriesJpaController.findEntries(3));
    }

    // Class variables, getters and setters methods
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }
    
    private String plate;
    private String comentary;
    private static Employee sessionEmployee;
    
    private static VehicleTypeJpaController vehicleTypeJpaController;
    private static BandsRateJpaController bandsRateJpaController;
    private static EntityManagerFactory persistence_factory;
    private static EntriesJpaController entriesJpaController;
    private static EmployeeJpaController employeeJpaController;
    
    // Expected Constants
    private final String invalidPlate = "No es un tipo valido de placa";
    private final String insertValidPlate = "Inserte un tipo de placa valida";
    private final String plateOkVehicleNotFound = "Tipo de placa encontrado y vehículo no encontrado";
    private final String plateOkVehicleFound = "Tipo de placa encontrado y vehículo encontrado";
}