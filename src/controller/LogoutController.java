/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Martin Kanayet
 */
public class LogoutController {

    public LogoutController() {
    }
    
    public static void logout(int logout){
    
        if(logout==0){
            System.out.println("yes");
            MainController.setVisibleMainView(false);
            LoginController.setVisibleLoginView(true);
        }
        else{
            System.out.println("no");
        }
    }
}
