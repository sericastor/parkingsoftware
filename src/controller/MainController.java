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
    public void verifyStatus(boolean isUser){
        if (isUser){
            mainView.setVisible(true);            
        }
    }
    
    public static void setVisibleMainView(boolean isVisible){
           mainView.setVisible(isVisible); 
    }
    
    private static MainView mainView = new MainView();
    private static LoginController loginController = new LoginController();
}