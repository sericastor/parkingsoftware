
package controller;

import DAO.BandsRateJpaController;
import DAO.EmployeeJpaController;
import DAO.EntriesJpaController;
import DAO.ExitsJpaController;
import DAO.FactureJpaController;
import DAO.FactureTurnJpaController;
import DAO.InfoParkwayJpaController;
import DAO.VehicleTypeJpaController;
import Entity.BandsRate;
import Entity.Employee;
import Entity.Entries;
import Entity.Facture;
import Entity.FactureTurn;
import Entity.VehicleType;
import Entity.Exits;
import Entity.InfoParkway;
import java.sql.Date;


public class InitializeController {

    public InitializeController() {
        initialize();
    }

    public static void initialize() {

        
        Integer employeecount=-1;
        employeecount=MainController.employeeJpaController.getEmployeeCount();
        
        if(employeecount != -1 && employeecount != null){
            
            //Creacion de la tabla Employee
        Employee em = new Employee();
        em.setId(MainController.employeeJpaController.getEmployeeCount());
        em.setLastName("ILastName");
        em.setIsActive(true);
        em.setAdministrator(true);
        em.setName("IName");
        em.setDocument("1");
        em.setPassword(controller.MainController.md5Security.MD5Security("Ipass"));
        em.setAdministrator(true);
        em.setUser("IUser");
        emJpaController.create(em);
        //controller.MainController.employeeJpaController.create(em);


        //Creacion de la tabla VehicleType
        VehicleType vt = new VehicleType();
        vt.setCodification("ICodification");
        vt.setName("IName");
        vt.setNumber(MainController.vehicleTypeJpaController.getVehicleTypeCount());
        vtJpaController.create(vt);


        //Creacion de tabla bandsrate
        BandsRate br = new BandsRate();
        br.setFromm(1);
        br.setToo(5);
        br.setId(MainController.bandsRateJpaController.getBandsRateCount());
        br.setUnitValue(1500);
        br.setUnits(3);
        br.setVehicletype(vt);
        brJpaController.create(br);

/*
        //Creacion de tabla factureTurn
        FactureTurn ft = new FactureTurn();
        Date date = new Date(Long.valueOf(0));
        ft.setActualDate(date);
        ft.setIVA(200);
        ft.setId(Long.valueOf(1));
        ft.setSubtotal(100);
        ft.setTotal(100);
        ftJpaController.create(ft);


        //Creacion de tabla Facture
        Facture facture = new Facture();
        facture.setActualDate(date);
        facture.setId(Long.valueOf(1));
        facture.setIva(2000);
        facture.setSubtotal(100);
        facture.setTotal(2000);
        factureJpaController.create(facture);


        //Creacion de la tabla Entries
        Entries entrie = new Entries();
        entrie.setEmployee(em);
        entrie.setEntryDate(date);
        entrie.setId(Long.valueOf(1));
        entrie.setPlate("InitialPlate");
        //entrie.setRate(parkingrate);
        entrie.setTicket(1);
        entrie.setVehicleType(vt);
        entrieJpaController.create(entrie);

        //Creacion de la tabla Exits
        Exits exit = new Exits();
        exit.setEmployee(1);
        exit.setEntry(entrie);
        exit.setIVA(0.0);
        exit.setId(Long.valueOf(1));
        exit.setPlate("InitialPlate");
        exit.setRate(1);
        exit.setSubtotal(0.0);
        exit.setTicket(1);
        exit.setTotal(0.0);
        exit.setTurn(ft);
        exit.setUnits(1);
        exit.setVehicleType(1);
        exitJpaController.create(exit);

        //Creacion de la tabla InfoParkway
        InfoParkway infop = new InfoParkway();
        infop.setAddress("InitialAdress");
        infop.setId(Long.valueOf(1));
        infop.setMaxCapacity(100);
        infop.setName("InitialName");
        infop.setNit("InitialNit");
        infop.setRegister(1);
        infop.setTelephone("1");
        infopJpaController.create(infop);
        
*/
        }
        

    }
    public static BandsRateJpaController brJpaController = new BandsRateJpaController(controller.MainController.system.getPersistence_factory());
    public static EmployeeJpaController emJpaController = new EmployeeJpaController(controller.MainController.system.getPersistence_factory());
    public static VehicleTypeJpaController vtJpaController = new VehicleTypeJpaController(controller.MainController.system.getPersistence_factory());
    public static FactureTurnJpaController ftJpaController = new FactureTurnJpaController(controller.MainController.system.getPersistence_factory());
    public static FactureJpaController factureJpaController = new FactureJpaController(controller.MainController.system.getPersistence_factory());
    public static EntriesJpaController entrieJpaController = new EntriesJpaController(controller.MainController.system.getPersistence_factory());
    public static ExitsJpaController exitJpaController = new ExitsJpaController(controller.MainController.system.getPersistence_factory());
    public static InfoParkwayJpaController infopJpaController = new InfoParkwayJpaController(controller.MainController.system.getPersistence_factory());
}
