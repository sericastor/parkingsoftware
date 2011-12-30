/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import java.util.List;
import controller.AddOrQuitVehicleController;
import java.util.Date;
import javax.persistence.Persistence;
import Entity.Entries;
import Entity.BandsRate;
import Entity.VehicleType;
import DAO.EntriesJpaController;
import javax.persistence.EntityManagerFactory;
import DAO.BandsRateJpaController;
import DAO.VehicleTypeJpaController;
import controller.QuitVehicleController;
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
            
            Date date = new Date(111, 11, 22, 14, 00, 00);
            
            Entries vehicleParked = new Entries();
            vehicleParked.setEntryDate(date);
            vehicleParked.setPlate("ABC123");
            vehicleParked.setTicket(123);
            vehicleParked.setVehicleType(hovercraft);
            entriesJpaController.create(vehicleParked);
            
            date.setHours(13);
            date.setMinutes(45);
            Entries newEntry = new Entries();
            newEntry.setEmployee(null);
            newEntry.setEntryDate(date);
            newEntry.setPlate("123");
            newEntry.setTicket(123);
            newEntry.setVehicleType(bicycle);
            entriesJpaController.create(newEntry);
        }
        if(entriesJpaController.findEntriesEntities(2, 2).isEmpty()){
            Date date = new Date(111, 11, 22, 15, 35, 00);
            VehicleType hovercraft = vehicleTypeJpaController.findVehicleType(Long.valueOf(3));
            
            Entries newEntry = new Entries();
            newEntry.setEmployee(null);
            newEntry.setEntryDate(date);
            newEntry.setPlate("DSC889");
            newEntry.setTicket(123);
            newEntry.setVehicleType(hovercraft);
            entriesJpaController.create(newEntry);
            
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
            
            Entries nEntry = new Entries();
            Date dat = new Date(111, 11, 22, 16, 00, 00);
            
            nEntry.setEmployee(null);
            nEntry.setEntryDate(dat);
            nEntry.setPlate("456HGL");
            nEntry.setTicket(123);
            nEntry.setVehicleType(bus);
            entriesJpaController.create(nEntry);
            
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
    public void vehicleNotFound() {
        setPlate("QWE456");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"111000");
        assertTrue(types.size()==2);
        for(int i = 0; i<types.size(); i++){
            assertTrue(types.get(i) instanceof VehicleType);
        }
        assertEquals(types.get(0).getName(),"CarritoViejo");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertFalse(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleNotFound);
    }
    
    @Test
    public void vehicleNotFound2(){
        setPlate("987");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertEquals(vehicleTypeJpaController.matchPlateType(codification).get(0).getName(),"Bicicleta");
        assertFalse(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleNotFound);
    }
    
    @Test
    public void vehicleFound(){
        setPlate("123");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertEquals(vehicleTypeJpaController.matchPlateType(codification).get(0).getName(),"Bicicleta");
        assertTrue(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleFound);
    }
    
    // This method could be bigger or create the method calculateCostVehicleFound with actual code.
    @Test
    public void quitVehicleFound(){
        setPlate("123");
        Date entryDate = new Date(111, 11, 22, 13, 45, 00);
        Date exitDate = new Date(111, 11, 22, 17, 00, 00);
        
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"123");
        assertEquals(nextExit.getVehicleType().getName(),"Bicicleta");
        assertEquals(nextExit.getEntryDate(),entryDate);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 4900, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(4)));
        assertTrue(listBands.size()==1);
        assertEquals(listBands.get(0).getUnitValue(),25,0);
    }
    
    @Test
    public void vehicleFound2(){
        setPlate("ABC123");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"111000");
        for(int i = 0; i<types.size(); i++){
            assertTrue(types.get(i) instanceof VehicleType);
        }
        assertEquals(types.get(0).getName(),"CarritoViejo");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertTrue(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleFound);
    }
    
    // This method could be bigger or create the method calculateCostVehicleFound2 with actual code.
    @Test 
    public void quitVehicleFound2(){
        setPlate("ABC123");
        Date entryDate = new Date(111, 11, 22, 14, 00, 00);
        Date exitDate = new Date(111, 11, 22, 14, 55, 00);
        
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"ABC123");
        assertEquals(nextExit.getVehicleType().getName(),"Aerodeslizador");
        assertEquals(nextExit.getEntryDate(),entryDate);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 2750, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(3)));
        assertTrue(listBands.size()==2);
        assertEquals(listBands.get(0).getUnitValue(),50,0);
        assertEquals(listBands.get(1).getUnitValue(),90,0);
    }
    
    @Test
    public void vehicleFound3(){
        setPlate("DSC889");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"111000");
        for(int i = 0; i<types.size(); i++){
            assertTrue(types.get(i) instanceof VehicleType);
        }
        assertEquals(types.get(0).getName(),"CarritoViejo");
        assertEquals(types.get(1).getName(),"Aerodeslizador");
        assertTrue(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleFound);
    }
    
    // This method could be bigger or create the method calculateCostVehicleFound3 with actual code.
    @Test
    public void quitVehicleFound3(){
        setPlate("DSC889");
        Date entryDate = new Date(111, 11, 22, 15, 35, 00);
        Date exitDate = new Date(111, 11, 22, 20, 55, 00);
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"DSC889");
        assertEquals(nextExit.getVehicleType().getName(),"Aerodeslizador");
        assertEquals(nextExit.getEntryDate(),entryDate);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 14700, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(3)));
        assertTrue(listBands.size()==2);
        assertEquals(listBands.get(0).getUnitValue(),50,0);
        assertEquals(listBands.get(1).getUnitValue(),90,0);
    }
    
    @Test
    public void vehicleFound4(){
        setPlate("456HGL");
        String codification = AddOrQuitVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"000111");
        assertTrue(types.size()==1);
        assertTrue(types.get(0) instanceof VehicleType);
        assertEquals(types.get(0).getName(),"Bus");
        assertTrue(AddOrQuitVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddOrQuitVehicleController.verifyCarInParkway(getPlate()),plateOkVehicleFound);
    }
    
    // This method could be bigger or create the method calculateCostVehicleFound3 with actual code.
    @Test
    public void quitVehicleFound4(){
        setPlate("456HGL");
        Date entryDate = new Date(111, 11, 22, 16, 00, 00);
        Date exitDate = new Date(111, 11, 22, 23, 30, 00);
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"456HGL");
        assertEquals(nextExit.getVehicleType().getName(),"Bus");
        assertEquals(nextExit.getEntryDate(),entryDate);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 20050, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(5)));
        assertTrue(listBands.size()==3);
        assertEquals(listBands.get(0).getUnitValue(),70,0);
        assertEquals(listBands.get(1).getUnitValue(),100,0);
        assertEquals(listBands.get(2).getUnitValue(),90,0);
    }
    
    // Class Variables, getters and setters methods

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
    private final String plateOkVehicleNotFound = "Tipo de placa encontrado y vehículo no encontrado";
    private final String plateOkVehicleFound = "Tipo de placa encontrado y vehículo encontrado";
}
