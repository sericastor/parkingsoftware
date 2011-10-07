package controller;


import model.Parkway;
import view.LoginView;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import DAO.EmployeeJpaController;
import Entity.Employee;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Martin Kanayet
 */
public class LoginController {

    public LoginController() {
        createPersistence();

    }

    public void createPersistence() {
        this.persistence_factory = Persistence.createEntityManagerFactory("ParkingSoftwarePU");

    }
    public static String byteArrToString(byte[] b){
   String res = null;
   StringBuffer sb = new StringBuffer(b.length * 2);
   for (int i = 0; i < b.length; i++){
      int j = b[i] & 0xff;
      if (j < 16) {
         sb.append('0');
      }
      sb.append(Integer.toHexString(j));
   }
   res = sb.toString();
   return res.toUpperCase();
}
    
    private String security(String password){
        try {
            String passMD5=null;
            byte[] passbyte=password.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
             
            md.update(passbyte);
            passMD5=byteArrToString(md.digest());
                       
            return passMD5;
        } catch (NoSuchAlgorithmException ex) {
            return "Error de seguridad, imposible converitr a MD5";
        }
        
    }
    

    public boolean verifyUser(String user, String password) {
        EmployeeJpaController ctrlemployee = new EmployeeJpaController(persistence_factory);
        /* este codigo crea un nuevo usuario en la base de datos, 
         * desmarcarlo solo en caso que no se tengan usuarios creados con anterioridad
        Employee employee1=new Employee();
        employee1.setAdministrator(true);
        employee1.setDocument("123");
        employee1.setLastName("miguel");
        employee1.setName("miguel");
        employee1.setPassword(security("miguel"));
        employee1.setUser("miguel");
        ctrlemployee.create(employee1);*/
        
         
        
        
        List<Employee> listemployee = ctrlemployee.findEmployeeEntities();
        for (Employee employee : listemployee) {
            System.out.println("1. "+employee.getUser()+" // "+user+"\n");
                System.out.println("2. "+employee.getPassword()+" // "+security(password)+"\n");
            
            if (employee.getUser().equals(user) && employee.getPassword().equals(security(password))) {
                
                return true;
            }

        }
        return false;

    }

    public static void setVisibleLoginView(boolean isVisible) {
        loginView.setVisible(isVisible);
    }
    private static EntityManagerFactory persistence_factory;
    private static LoginView loginView = new LoginView();
}