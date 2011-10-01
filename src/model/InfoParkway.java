
package model;


public class InfoParkway {

    public InfoParkway() {
    }

    public InfoParkway(String name, String address, String nit, String telephone, int register,  int maxcCapacity) {
        this.name = name;
        this.address = address;
        this.nit = nit;
        this.telephone = telephone;
        this.register = register;
        this.maxCapacity = maxcCapacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getRegister() {
        return register;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    
    private String name;
    private String address;
    private String nit;
    private String telephone;
    private int register;
    private int maxCapacity;
    
}
