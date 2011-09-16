/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eParking;

import controller.LoginController;
import controller.MainController;
import model.Parkway;
import view.LoginView;

/**
 *
 * @author r4wd3r
 */
public class eParking{
    public eParking(){}
    private static Parkway parkway = new Parkway();
    public static void main(String args[]){        
        MainController mainController = new MainController();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);        
        loginView.setVisible(true);
    }
}
