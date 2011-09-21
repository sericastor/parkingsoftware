package model;

import java.util.ArrayList;

/**
 *
 * @author Martin Kanayet
 */
public class Parkway {

    public Parkway() {
        initialize();
    }

    public static ArrayList<Employee> getStaff() {
        return staff;
    }

    public static void setStaff(ArrayList<Employee> employee) {
        Parkway.staff = employee;
    }
    
    public static void initialize(){    
        Employee employee1 = new Employee();
        employee1.setPassword("pass");
        employee1.setUser("user");
        employee1.setAdmin(true);
        staff.add(employee1);
    }
    private static ArrayList<Employee> staff = new ArrayList<Employee>();     
}
