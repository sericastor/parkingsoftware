/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EmployeeJpaController;
import DAO.LogJpaController;
import Entity.Employee;
import Entity.Log;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author miguel
 */
public class SystemSession {
    /*esta clase sera la encargada de controlar los datos en sesion, asi como
     * controlar la tabla del log de eventos
     */

    public SystemSession() {
        this.persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
    }
    
    private static EntityManagerFactory persistence_factory;
    private static Employee sesionemployee;

    public static EntityManagerFactory getPersistence_factory() {
        return persistence_factory;
    }

    public void Login() {
        //encargado de crear una entrada de login en la tabla log
        LogJpaController ctrllog = new LogJpaController(controller.MainController.system.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Login");
        log.setDate(Calendar.getInstance().getTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
    public void Logout(){
        LogJpaController ctrllog = new LogJpaController(controller.MainController.system.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Logout");
        log.setDate(Calendar.getInstance().getTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
    public void Close(){
        LogJpaController ctrllog = new LogJpaController(controller.MainController.system.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Close System");
        log.setDate(Calendar.getInstance().getTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
    public void AddPlate(String typeplate){
        LogJpaController ctrllog = new LogJpaController(controller.MainController.system.getPersistence_factory());            
        Log log = new Log();
        log.setAction("AddPlate: "+typeplate);
        log.setDate(Calendar.getInstance().getTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
        
    }
    
    public static void setEmployee(Employee employee) {
        SystemSession.sesionemployee = employee;
    }
    

    

   
}

    
