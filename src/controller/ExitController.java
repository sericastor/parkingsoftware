/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Martin Kanayet
 */
public class ExitController {

    public ExitController() {
    }
    //asdasd
    
    public static void exit(int exit){
    
        if(exit==0){
            System.out.println("yes");
            System.exit(exit);
        }
        else{
            System.out.println("no");
        }
    }
    
}
