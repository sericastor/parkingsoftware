/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import Entity.BandsRate;
import Entity.Employee;
import Entity.FactureTurn;
import Entity.VehicleType;
import controller.InitializeController;
import controller.MainController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author r4wd3r
 */
public class eParking {

    public static void main(String args[]) throws ClassNotFoundException {
        try
{
   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch (Exception e)
{
   e.printStackTrace();
}/*
        try {
            
            //nuevo look and feel modificable!!!
            UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(eParking.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
        //////////////////////////Inicializar Tablas////////////////////////
        try {
            Employee employee = MainController.employeeJpaController.findEmployeeByUser("user");
            VehicleType vehicle = MainController.vehicleTypeJpaController.findVehicleType(Long.valueOf(1));
            BandsRate bandsRate = MainController.bandsRateJpaController.findBandsRate(Long.valueOf(1));
            //FactureTurn factureTurn = MainController.FactureTurnJpaController.
            if (employee == null && vehicle == null && bandsRate == null) {

                new InitializeController();
                
            }

        } catch (Exception e) {
            System.out.println("Pues ocurrio un error creando las condenadas tablas iniciales" + e.getMessage());
        }

        //////////////////////////Inicializar Tablas///////////////////////////////

        new MainController();
        MainController.startClock();


    }
}
