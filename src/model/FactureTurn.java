
package model;

import java.util.ArrayList;

public class FactureTurn {

    public FactureTurn() {
    }

    public FactureTurn(int ID, String day, String month, String year, String hour, int employee) {
        this.ID = ID;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.employee = employee;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Double> getIVA() {
        return IVA;
    }

    public void setIVA(ArrayList<Double> IVA) {
        this.IVA = IVA;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
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

    public ArrayList<String> getPlate() {
        return plate;
    }

    public void setPlate(ArrayList<String> plate) {
        this.plate = plate;
    }

    public ArrayList<Integer> getRate() {
        return rate;
    }

    public void setRate(ArrayList<Integer> rate) {
        this.rate = rate;
    }

    public ArrayList<Double> getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(ArrayList<Double> subtotal) {
        this.subtotal = subtotal;
    }

    public ArrayList<Integer> getTicket() {
        return ticket;
    }

    public void setTicket(ArrayList<Integer> ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Double> getTotal() {
        return total;
    }

    public void setTotal(ArrayList<Double> total) {
        this.total = total;
    }

    public ArrayList<Integer> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Integer> units) {
        this.units = units;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    private int ID;
    private String day;
    private String month;
    private String year;
    private String hour;
    private ArrayList<Integer> ticket = new ArrayList<Integer>();
    private ArrayList<Integer> rate = new ArrayList<Integer>();
    private ArrayList<Integer> units = new ArrayList<Integer>();
    private ArrayList<Double> subtotal = new ArrayList<Double>();
    private ArrayList<Double> IVA = new ArrayList<Double>();
    private ArrayList<Double> total = new ArrayList<Double>();
    private ArrayList<String> plate = new ArrayList<String>();
    private int employee;
            
}
