package controller;


import model.Parkway;
import view.LoginView;
import view.MainView;

/**
 *
 * @author Martin Kanayet
 */
public class MainController {
    
    public MainController(){
        
    }
    public void verifyStatus(boolean x){
        if (x){
            MainView mainView = new MainView();
            mainView.setVisible(true);            
        }
    }
}