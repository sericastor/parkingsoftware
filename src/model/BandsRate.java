
package model;

/**
 *
 * @author Martin Kanayet
 */
public class BandsRate {

    public BandsRate() {
    }

    public BandsRate(int rate, int from, int to, double unitValue, int units) {
        this.rate = rate;
        this.from = from;
        this.to = to;
        this.unitValue = unitValue;
        this.units = units;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    
    private int rate;
    private int from;
    private int to;
    private double unitValue;
    private int units;
}

