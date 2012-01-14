/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usecasetest;

import Entity.InfoParkway;
import controller.MainController;
import javax.persistence.Persistence;
import DAO.InfoParkwayJpaController;
import controller.Administration.ParkingManagementController;
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
 * Test Case Number 7
 */
public class ParkwayDataCaseTest {
    
    // Needs some refactory
    public ParkwayDataCaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
        infoParkwayJpaController = new InfoParkwayJpaController(persistence_factory);
        
        if(MainController.infoJpaController.findInfoParkway(idParkway)==null){
             InfoParkway parkway = new InfoParkway();
             parkway.setId(idParkway);
             parkway.setMaxCapacity(1);
             parkway.setIVAPercent(0.01);
             MainController.infoJpaController.create(parkway);
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        InfoParkway info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        info.setName("parquick");
        info.setAddress("Calle 123 45-67");
        info.setNit("123456789");
        info.setTelephone("1234567");
        info.setMaxCapacity(100);
        info.setIVAPercent(0.16);
        
        infoParkwayJpaController.edit(info, idParkway);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        InfoParkway info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        info.setName(null);
        info.setAddress(null);
        info.setNit(null);
        info.setTelephone(null);
        info.setMaxCapacity(1);
        info.setIVAPercent(0.01);
        
        infoParkwayJpaController.edit(info, idParkway);
    }
    
    @Test
    public void updateInfoParkwayForFirstTime() {
        InfoParkway info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        assertNull(info.getName());
        assertNull(info.getAddress());
        assertNull(info.getNit());
        assertNull(info.getTelephone());
        assertEquals(info.getMaxCapacity(),1);
        assertEquals(info.getIVAPercent(),0.01,0);
        
        setName("parquick");
        setAddress("Calle 123 45-67");
        setNit("123456789");
        setTelephone("1234567");
        setMaxCapacity(100);
        setIvaPercent(0.10);
        
        //assertTrue(ParkingManagementController.validateNotEmptyFields(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity())));
        //assertTrue(ParkingManagementController.validateAll(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity())));
        
        //ParkingManagementController.updateInfoParway(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity()),getIvaPercent());
        
        info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        assertEquals(info.getName(),"parquick");
        assertEquals(info.getAddress(), "Calle 123 45-67");
        assertEquals(info.getNit(), "123456789");
        assertEquals(info.getTelephone(), "1234567");
        assertEquals(info.getMaxCapacity(),100);
        assertEquals(info.getIVAPercent(),0.10,0);
    }
    
    @Test
    public void badUpdateForInfoParkway(){
        InfoParkway info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        assertNull(info.getName());
        assertNull(info.getAddress());
        assertNull(info.getNit());
        assertNull(info.getTelephone());
        assertEquals(info.getMaxCapacity(),1);
        assertEquals(info.getIVAPercent(),0.01,0);
        
        setName("ChiquiParking");
        setAddress("");
        setNit("");
        setTelephone("");
        setMaxCapacity(0);
        setIvaPercent(0.00);
        
        //assertFalse(ParkingManagementController.validateNotEmptyFields(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity())));
        
        //ParkingManagementController.updateInfoParway(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity()),getIvaPercent());
        
        info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        assertNull(info.getName());
        assertNull(info.getAddress());
        assertNull(info.getNit());
        assertNull(info.getTelephone());
        assertEquals(info.getMaxCapacity(),1);
        assertEquals(info.getIVAPercent(),0.01,0);
    }
    
    @Test
    public void updateInfoParkwayForSecondTime(){
        InfoParkway info = infoParkwayJpaController.findInfoParkway(idParkway);
        
        assertNull(info.getName());
        assertNull(info.getAddress());
        assertNull(info.getNit());
        assertNull(info.getTelephone());
        assertEquals(info.getMaxCapacity(),1);
        assertEquals(info.getIVAPercent(),0.01,0);
        
        setName("ExamplePark");
        setAddress("Calle 123 45-67");
        setNit("123456789");
        setTelephone("1234567");
        setMaxCapacity(70);
        setIvaPercent(0.16);
        
        //assertTrue(ParkingManagementController.validateNotEmptyFields(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity())));
        //assertTrue(ParkingManagementController.validateAll(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity())));
        
        //ParkingManagementController.updateInfoParway(getName(), getAddress(), getNit(), getTelephone(), String.valueOf(getMaxCapacity()),getIvaPercent());
        
        info = infoParkwayJpaController.findInfoParkway(idParkway);
       
        assertEquals(info.getName(),"ExamplePark");
        assertEquals(info.getAddress(), "Calle 123 45-67");
        assertEquals(info.getNit(), "123456789");
        assertEquals(info.getTelephone(), "1234567");
        assertEquals(info.getMaxCapacity(),70);
        assertEquals(info.getIVAPercent(), 0.16, 0);
    }
    
    // Class variables, getters and setters methods

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getIvaPercent() {
        return IvaPercent;
    }

    public void setIvaPercent(double IvaPercent) {
        this.IvaPercent = IvaPercent;
    }
    
    private String name;
    private String address;
    private String nit;
    private String telephone;
    private int maxCapacity;
    private double IvaPercent;
    
    private static EntityManagerFactory persistence_factory;
    private static InfoParkwayJpaController infoParkwayJpaController;
    
    public final static long idParkway = 1;
}
