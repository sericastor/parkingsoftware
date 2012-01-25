/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import Entity.BandsRate;
import Entity.Employee;
import Entity.FactureTurn;
import Entity.VehicleType;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import controller.Administration.OtherOptionsController;
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
        try {
                //entorno por defecto del SO
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        new MainController() ;
//        //////////////////////////Inicializar Tablas////////////////////////
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
        
        
        MainController.startClock();
    }
}
