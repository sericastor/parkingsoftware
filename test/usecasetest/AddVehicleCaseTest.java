/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import Entity.InfoParkway;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 * Test Case Number 2
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
            dasalgadoc.setTheme(0);
            employeeJpaController.create(dasalgadoc);
        }
        
        if(MainController.infoJpaController.findInfoParkway(ID_PARKWAY)==null){
             InfoParkway parkway = new InfoParkway();
             parkway.setId(ID_PARKWAY);
             parkway.setName("ParkQuick");
             parkway.setAddress("---");
             parkway.setNit("---");
             parkway.setTelephone("---");
             parkway.setRegister(0);
             parkway.setMaxCapacity(100);
             parkway.setIVAPercent(0.01);
             parkway.setRountTo(50);
             parkway.setTicketCount("1");
             MainController.infoJpaController.create(parkway);
        }
        
        sessionEmployee = employeeJpaController.findEmployee(1);
        SystemSession.setEmployee(sessionEmployee);
        
        if(vehicleTypeJpaController.findVehicleTypeEntities(3,1).isEmpty()){
            VehicleType car = new VehicleType();
            car.setCodification("111000");
            car.setName("Carro Particular");
            car.setPlaces(1);
            vehicleTypeJpaController.create(car);
            
            VehicleType hovercraft = new VehicleType();
            hovercraft.setCodification("111000");
            hovercraft.setName("Aerodeslizador");
            hovercraft.setPlaces(1.5);
            vehicleTypeJpaController.create(hovercraft);
            
            BandsRate hovercraftRates = new BandsRate();
            hovercraftRates.setFromm(0);
            hovercraftRates.setToo(60);
            hovercraftRates.setUnits(1);
            hovercraftRates.setUnitValue(50.0);
            hovercraftRates.setVehicletype(hovercraft);
            bandsRateJpaController.create(hovercraftRates);
            
            hovercraftRates.setFromm(60);
            hovercraftRates.setToo(10000);
            hovercraftRates.setUnits(2);
            hovercraftRates.setUnitValue(90.0);
            hovercraftRates.setVehicletype(hovercraft);
            bandsRateJpaController.create(hovercraftRates);
            
            VehicleType bicycle = new VehicleType();
            bicycle.setCodification("000");
            bicycle.setName("Bicicleta");
            bicycle.setPlaces(0.3);
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
            vehicleParked.setTicket("1");
            vehicleParked.setEntryDate(date);
            vehicleParked.setPlate("ABC123");
            vehicleParked.setVehicleType(hovercraft);
            vehicleParked.setEmployee(sessionEmployee);
            vehicleParked.setComentary("Automovil con forro para lluvia");
            vehicleParked.setTicketCodification(AddVehicleController.generateTicketCodification());
            entriesJpaController.create(vehicleParked);
        }
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        entriesJpaController = new EntriesJpaController(persistence_factory);
        vehicleTypeJpaController = new VehicleTypeJpaController(persistence_factory);
        
        Long id = new Long(3);
        Date date = new Date(111, 11, 22, 13, 45, 00);
        VehicleType bicycle = vehicleTypeJpaController.findVehicleType(id);

        Entries newEntry = new Entries();
        newEntry.setTicket("2");
        newEntry.setEntryDate(date);
        newEntry.setPlate("123");
        newEntry.setVehicleType(bicycle);
        newEntry.setEmployee(sessionEmployee);
        newEntry.setComentary("Bicicleta Roja en buen estado");
        newEntry.setTicketCodification(AddVehicleController.generateTicketCodification());
        entriesJpaController.edit(newEntry, 2);
    }
    
    @Test
    public void notAlphanumericPlate(){
        setPlate("#@7/");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,INVALID_PLATE);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
    }
    
    @Test
    public void plateWithoutVehicleType(){
        setPlate("1");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
    }
    
    @Test
    public void plateWithoutVehicleType2(){
        setPlate("1234");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"0000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
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
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_NOT_FOUND);
    }
    
    @Test
    public void addValidPlate(){
        setPlate("123");
        setComentary("Bicicleta Roja en buen estado");
        String id = "Bicicleta";
        List<VehicleType> list = MainController.vehicleTypeJpaController.matchPlateType("000");

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
        assertEquals(types.get(0).getName(),"Carro Particular");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertTrue(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_FOUND);
    }
    
    @Test
    public void plateWithoutVehicleType3(){
        setPlate("123BC");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"00011");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
    }
    
    @Test
    public void plateWithoutVehicleType4(){
        setPlate("B1C1Z2");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"101010");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
    }
    
    @Test
    public void plateWithoutVehicleType5(){
        setPlate("BPD");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"111");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).isEmpty());
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),INVALID_PLATE1);
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
        assertEquals(types.get(0).getName(),"Carro Particular");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertFalse(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_NOT_FOUND);
    }
    
    @Test
    public void plateOkVehicleFoundWithoutBandsRate(){
        setPlate("PQR200");
        setComentary("Aerodelizador Azul, con rayones en la puerta");
        String id = "Carro Particular";
        List<VehicleType> list = MainController.vehicleTypeJpaController.matchPlateType("111000");
        
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
    private final static String INVALID_PLATE = "No es un tipo valido de placa";
    private final static String INVALID_PLATE1 = "Inserte un tipo de placa valida";
    private final static String VEHICLE_NOT_FOUND = "Tipo de placa encontrado y vehículo no encontrado";
    private final static String VEHICLE_FOUND = "Tipo de placa encontrado y vehículo encontrado";
    private final static Long ID_PARKWAY = new Long(1);
}