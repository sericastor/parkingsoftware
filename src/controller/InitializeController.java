/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BandsRateJpaController;
import Entity.BandsRate;
import Entity.Exits;
import Entity.Facture;
import Entity.FactureTurn;
import java.sql.Date;

/**
 *
 * @author Martin Kanayet
 */
public class InitializeController {

    public InitializeController() {
        initialize();
    }

    public void initialize() {
        
        //TODO: Create tables. Thanks.
        
        //Creacion de tabla bandsrate
        BandsRate br = new BandsRate();
        br.setFromm(1);
        br.setToo(5);
        br.setId(Long.valueOf(1));
        br.setUnitValue(1500);
        br.setUnits(3);
        brJpaController.create(br);
        //Creacion de tabla exits
        Exits exits = new Exits();
        //exits.set
        
        //Creacion de tabla factureTurn
        FactureTurn ft = new FactureTurn();
        Date date = new Date(Long.valueOf(0));
        ft.setActualDate(date);
        ft.setIVA(200);
        ft.setId(Long.valueOf(1));
        ft.setSubtotal(100);
        ft.setTotal(100);
        //Creacion de tabla Facture
        Facture facture = new Facture();
        facture.setActualDate(date);
        facture.setId(Long.valueOf(1));
        facture.setIva(2000);
        facture.setSubtotal(100);
        facture.setTotal(2000);

    }
    public static BandsRateJpaController brJpaController = new BandsRateJpaController(controller.MainController.system.getPersistence_factory());
}
