/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LogJpaController;
import Entity.Employee;
import Entity.Log;
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
        SystemSession.persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");
    }
    
    private static EntityManagerFactory persistence_factory;
    public static Employee sesionemployee;

    public static EntityManagerFactory getPersistence_factory() {
        return persistence_factory;
    }
    public void NewLogAction(String action,String detail){
        LogJpaController ctrllog = new LogJpaController(SystemSession.getPersistence_factory());            
        Log log = new Log();
        log.setAction(action);
        log.setDetail(detail);
        log.setDate(MainController.getSystemTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);

    }
    public void Login() {
        //encargado de crear una entrada de login en la tabla log
        LogJpaController ctrllog = new LogJpaController(SystemSession.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Login");
        log.setDetail(null);
        log.setDate(MainController.getSystemTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
    public void Logout(){
        LogJpaController ctrllog = new LogJpaController(SystemSession.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Logout");
        log.setDetail(null);
        log.setDate(MainController.getSystemTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
    public void Close(){
        LogJpaController ctrllog = new LogJpaController(SystemSession.getPersistence_factory());            
        Log log = new Log();
        log.setAction("Close System");
        log.setDetail(null);
        log.setDate(MainController.getSystemTime());
        log.setUser(sesionemployee.getUser());
        log.setName(sesionemployee.getName());
        log.setDocument(sesionemployee.getDocument());
        ctrllog.create(log);
    }
  
    
    public static void setEmployee(Employee employee) {
        SystemSession.sesionemployee = employee;
    }

    public static Employee getSessionEmployee() {
        return sesionemployee;
    }
    
    

    

   
}

    
