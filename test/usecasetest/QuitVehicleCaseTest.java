/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import Entity.InfoParkway;
import controller.MainController;
import Entity.Exits;
import controller.SystemSession;
import Entity.Employee;
import DAO.EmployeeJpaController;
import java.util.List;
import controller.AddVehicleController;
import java.util.Date;
import javax.persistence.Persistence;
import Entity.Entries;
import Entity.BandsRate;
import Entity.VehicleType;
import DAO.EntriesJpaController;
import javax.persistence.EntityManagerFactory;
import DAO.BandsRateJpaController;
import DAO.ExitsJpaController;
import DAO.VehicleTypeJpaController;
import controller.QuitVehicleController;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoAl
 * Test Case Number 3
 */
public class QuitVehicleCaseTest {
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        vehicleTypeJpaController = new VehicleTypeJpaController(persistence_factory);
        bandsRateJpaController = new BandsRateJpaController(persistence_factory);
        entriesJpaController = new EntriesJpaController(persistence_factory);
        exitJpaController = new ExitsJpaController(persistence_factory);
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
           
            date.setHours(13);
            date.setMinutes(45);
            Entries newEntry = new Entries();
            newEntry.setTicket("2");
            newEntry.setEntryDate(date);
            newEntry.setPlate("123");
            newEntry.setVehicleType(bicycle);
            newEntry.setEmployee(sessionEmployee);
            newEntry.setComentary("Bicicleta Roja en buen estado");
            newEntry.setTicketCodification(AddVehicleController.generateTicketCodification());
            entriesJpaController.create(newEntry);
        }
        
        if(entriesJpaController.findEntriesEntities(2, 2).isEmpty()){
            Date date = new Date(111, 11, 22, 15, 35, 00);
            VehicleType hovercraft = vehicleTypeJpaController.findVehicleType(Long.valueOf(2));
            
            Entries newEntry = new Entries();
            newEntry.setTicket("3");
            newEntry.setEntryDate(date);
            newEntry.setPlate("DSC889");
            newEntry.setVehicleType(hovercraft);
            newEntry.setEmployee(sessionEmployee);
            newEntry.setComentary("Aerodeslizador con radio");
            newEntry.setTicketCodification(AddVehicleController.generateTicketCodification());
            entriesJpaController.create(newEntry);
            
            VehicleType bus = new VehicleType();
            bus.setCodification("000111");
            bus.setName("Bus");
            bus.setPlaces(3);
            vehicleTypeJpaController.create(bus);
            
            BandsRate busRates = new BandsRate();
            busRates.setFromm(0);
            busRates.setToo(30);
            busRates.setUnits(1);
            busRates.setUnitValue(70.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
            
            busRates.setFromm(30);
            busRates.setToo(120);
            busRates.setUnits(2);
            busRates.setUnitValue(100.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
            
            busRates.setFromm(120);
            busRates.setToo(10000);
            busRates.setUnits(2);
            busRates.setUnitValue(90.0);
            busRates.setVehicletype(bus);
            bandsRateJpaController.create(busRates);
            
            Entries nEntry = new Entries();
            Date dat = new Date(111, 11, 22, 16, 00, 00);
            
            nEntry.setTicket("4");
            nEntry.setEntryDate(dat);
            nEntry.setPlate("456HGL");
            nEntry.setVehicleType(bus);
            nEntry.setEmployee(sessionEmployee);
            nEntry.setComentary("Bus con un vidrio roto");
            nEntry.setTicketCodification(AddVehicleController.generateTicketCodification());
            entriesJpaController.create(nEntry);
        }
    }

    @Test
    public void vehicleNotFound() {
        setPlate("QWE456");
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
    public void vehicleNotFound2(){
        setPlate("987");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertEquals(vehicleTypeJpaController.matchPlateType(codification).get(0).getName(),"Bicicleta");
        assertFalse(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_NOT_FOUND);
    }
    
    @Test
    public void vehicleFound(){
        setPlate("123");
        String codification = AddVehicleController.encodePlate(getPlate());
        
        assertEquals(codification,"000");
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).size()==1);
        assertTrue(vehicleTypeJpaController.matchPlateType(codification).get(0) instanceof VehicleType);
        assertEquals(vehicleTypeJpaController.matchPlateType(codification).get(0).getName(),"Bicicleta");
        assertTrue(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_FOUND);
    }
    
    @Test
    public void calculateCostVehicleFound(){
        setPlate("123");
        Date entryDate = new Date(111, 11, 22, 13, 45, 00);
        Date exitDate = new Date(111, 11, 22, 17, 00, 00);
        
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"123");
        assertEquals(nextExit.getVehicleType().getName(),"Bicicleta");
        assertEquals(nextExit.getEntryDate(),entryDate);
        assertEquals(nextExit.getComentary(),RED_VEHICLE);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 4900, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(3)));
        assertTrue(listBands.size()==1);
        assertEquals(listBands.get(0).getUnitValue(),25,0);
    }
    
    @Test
    public void quitVehicleFound(){
        setPlate("123");
        Date entryDate = new Date(111, 11, 22, 13, 45, 00);
        
        SystemSession.setEmployee(sessionEmployee);
        QuitVehicleController.changeStateOfVehicle(getPlate());
        
        Exits newExit = exitJpaController.findExits(Long.valueOf(1));
        
        assertNull(entriesJpaController.getEntriesByPlate(getPlate()));
        
        assertEquals(newExit.getEmployeeExit(),sessionEmployee);
        assertEquals(newExit.getEntryDate(), entryDate);
        assertEquals(newExit.getPlate(),getPlate());
        assertEquals(newExit.getVehicleType().getName(),"Bicicleta");
    }
    
    @Test
    public void vehicleFound2(){
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
    public void calculateCostVehicleFound2(){
        setPlate("ABC123");
        Date entryDate = new Date(111, 11, 22, 14, 00, 00);
        Date exitDate = new Date(111, 11, 22, 14, 55, 00);
        
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"ABC123");
        assertEquals(nextExit.getVehicleType().getName(),"Aerodeslizador");
        assertEquals(nextExit.getEntryDate(),entryDate);
        assertEquals(nextExit.getComentary(),VEHICLE_LINING);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 2750, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(2)));
        assertTrue(listBands.size()==2);
        assertEquals(listBands.get(0).getUnitValue(),50,0);
        assertEquals(listBands.get(1).getUnitValue(),90,0);
    }
    
    @Test
    public void quitVehicleFound2(){
        setPlate("ABC123");
        Date entryDate = new Date(111, 11, 22, 14, 00, 00);
        
        SystemSession.setEmployee(sessionEmployee);
        QuitVehicleController.changeStateOfVehicle(getPlate());
        
        Exits newExit = exitJpaController.findExits(Long.valueOf(2));
        
        assertNull(entriesJpaController.getEntriesByPlate(getPlate()));
        
        assertEquals(newExit.getEmployeeExit(),sessionEmployee);
        assertEquals(newExit.getEntryDate(), entryDate);
        assertEquals(newExit.getPlate(),getPlate());
        assertEquals(newExit.getVehicleType().getName(),"Aerodeslizador");
    }
    
    @Test
    public void vehicleFound3(){
        setPlate("DSC889");
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
    public void calculateCostVehicleFound3(){
        setPlate("DSC889");
        Date entryDate = new Date(111, 11, 22, 15, 35, 00);
        Date exitDate = new Date(111, 11, 22, 20, 55, 00);
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"DSC889");
        assertEquals(nextExit.getVehicleType().getName(),"Aerodeslizador");
        assertEquals(nextExit.getEntryDate(),entryDate);
        assertEquals(nextExit.getComentary(),VEHICLE_RADIO);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 14700, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(2)));
        assertTrue(listBands.size()==2);
        assertEquals(listBands.get(0).getUnitValue(),50,0);
        assertEquals(listBands.get(1).getUnitValue(),90,0);
    }
    
    @Test
    public void quitVehicleFound3(){
        setPlate("DSC889");
        Date entryDate = new Date(111, 11, 22, 15, 35, 00);
        
        SystemSession.setEmployee(sessionEmployee);
        QuitVehicleController.changeStateOfVehicle(getPlate());
        
        Exits newExit = exitJpaController.findExits(Long.valueOf(3));
        
        assertNull(entriesJpaController.getEntriesByPlate(getPlate()));
        
        assertEquals(newExit.getEmployeeExit(),sessionEmployee);
        assertEquals(newExit.getEntryDate(), entryDate);
        assertEquals(newExit.getPlate(),getPlate());
        assertEquals(newExit.getVehicleType().getName(),"Aerodeslizador");
    }
    
    @Test
    public void vehicleFound4(){
        setPlate("456HGL");
        String codification = AddVehicleController.encodePlate(getPlate());
        List<VehicleType> types = vehicleTypeJpaController.matchPlateType(codification);
        
        assertEquals(codification,"000111");
        assertTrue(types.size()==1);
        assertTrue(types.get(0) instanceof VehicleType);
        assertEquals(types.get(0).getName(),"Bus");
        assertTrue(AddVehicleController.verifyCarParked(getPlate()));
        assertEquals(AddVehicleController.verifyCarInParkway(getPlate()),VEHICLE_FOUND);
    }
    
    @Test
    public void calculateCostVehicleFound4(){
        setPlate("456HGL");
        Date entryDate = new Date(111, 11, 22, 16, 00, 00);
        Date exitDate = new Date(111, 11, 22, 23, 30, 00);
        Entries nextExit = entriesJpaController.getEntriesByPlate(getPlate());
        
        assertEquals(nextExit.getPlate(),"456HGL");
        assertEquals(nextExit.getVehicleType().getName(),"Bus");
        assertEquals(nextExit.getEntryDate(),entryDate);
        assertEquals(nextExit.getComentary(),VEHICLE_BROKEN);
        
        double cost = QuitVehicleController.calculateCost(entryDate, exitDate, nextExit.getVehicleType());
        assertEquals(cost, 20100, 0);
        
        List<BandsRate> listBands = bandsRateJpaController.queryByVehicleTypes(vehicleTypeJpaController.findVehicleType(Long.valueOf(4)));
        assertTrue(listBands.size()==3);
        assertEquals(listBands.get(0).getUnitValue(),70,0);
        assertEquals(listBands.get(1).getUnitValue(),100,0);
        assertEquals(listBands.get(2).getUnitValue(),90,0);
    }
    
    @Test
    public void quitVehicleFound4(){
        setPlate("456HGL");
        Date entryDate = new Date(111, 11, 22, 16, 00, 00);
        
        SystemSession.setEmployee(sessionEmployee);
        QuitVehicleController.changeStateOfVehicle(getPlate());
        
        Exits newExit = exitJpaController.findExits(Long.valueOf(4));
        
        assertNull(entriesJpaController.getEntriesByPlate(getPlate()));
        
        assertEquals(newExit.getEmployeeExit(),sessionEmployee);
        assertEquals(newExit.getEntryDate(), entryDate);
        assertEquals(newExit.getPlate(),getPlate());
        assertEquals(newExit.getVehicleType().getName(),"Bus");
    }
    
    // Class Variables, getters and setters methods

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    private String plate;
    private static Employee sessionEmployee;
    
    private static VehicleTypeJpaController vehicleTypeJpaController;
    private static BandsRateJpaController bandsRateJpaController;
    private static EntityManagerFactory persistence_factory;
    private static EntriesJpaController entriesJpaController;
    private static EmployeeJpaController employeeJpaController;
    private static ExitsJpaController exitJpaController;
    private final static Long ID_PARKWAY = new Long(1);  
    
    // Expected Constants
    private final String VEHICLE_NOT_FOUND = "Tipo de placa encontrado y vehículo no encontrado";
    private final String VEHICLE_FOUND = "Tipo de placa encontrado y vehículo encontrado";
    private final String VEHICLE_LINING = "Automovil con forro para lluvia";
    private final String RED_VEHICLE = "Bicicleta Roja en buen estado";
    private final String VEHICLE_RADIO = "Aerodeslizador con radio";
    private final String VEHICLE_BROKEN = "Bus con un vidrio roto"; 
}
