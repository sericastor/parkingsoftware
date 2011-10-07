
package model;

public class Exits {

    public Exits() {
    }

    public Exits(int ID, String plate, int ticket, String entryYear, String entryMonth, String entryDay, String entryHour, String exitYear, String exitMonth, String exitDay, String exitHour, int units, int rate, int employee, int facture, int vehicleType) {
        this.ID = ID;
        this.plate = plate;
        this.ticket = ticket;
        this.entryYear = entryYear;
        this.entryMonth = entryMonth;
        this.entryDay = entryDay;
        this.entryHour = entryHour;
        this.exitYear = exitYear;
        this.exitMonth = exitMonth;
        this.exitDay = exitDay;
        this.exitHour = exitHour;
        this.units = units;
        this.rate = rate;
        this.employee = employee;
        this.facture = facture;
        this.vehicleType = vehicleType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public String getEntryDay() {
        return entryDay;
    }

    public void setEntryDay(String entryDay) {
        this.entryDay = entryDay;
    }

    public String getEntryHour() {
        return entryHour;
    }

    public void setEntryHour(String entryHour) {
        this.entryHour = entryHour;
    }

    public String getEntryMonth() {
        return entryMonth;
    }

    public void setEntryMonth(String entryMonth) {
        this.entryMonth = entryMonth;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getExitDay() {
        return exitDay;
    }

    public void setExitDay(String exitDay) {
        this.exitDay = exitDay;
    }

    public String getExitHour() {
        return exitHour;
    }

    public void setExitHour(String exitHour) {
        this.exitHour = exitHour;
    }

    public String getExitMonth() {
        return exitMonth;
    }

    public void setExitMonth(String exitMonth) {
        this.exitMonth = exitMonth;
    }

    public String getExitYear() {
        return exitYear;
    }

    public void setExitYear(String exitYear) {
        this.exitYear = exitYear;
    }

    public int getFacture() {
        return facture;
    }

    public void setFacture(int facture) {
        this.facture = facture;
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

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
    
    private int ID;
    private String plate;
    private int ticket;
    private String entryYear;
    private String entryMonth;
    private String entryDay;
    private String entryHour;
    private String exitYear;
    private String exitMonth;
    private String exitDay;
    private String exitHour;
    private int units;
    private int rate;
    private int employee;
    private int facture;
    private int vehicleType;
    
    
            
    
    
            
    
}
