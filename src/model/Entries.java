/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin Kanayet
 */
public class Entries {

    public Entries() {
    }

    public Entries(int order, String year, String month, String day, String hour, String plate, int rate, int ticket, int EmployeeID, int vehicleType) {
        this.order = order;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.plate = plate;
        this.rate = rate;
        this.ticket = ticket;
        this.EmployeeID = EmployeeID;
        this.vehicleType = vehicleType;
    }

   
    
    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
    private int order;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String plate;
    private int rate;
    private int ticket;
    private int EmployeeID;
    private int vehicleType;

    
               
            
}
