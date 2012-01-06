/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.CustomExitTicket;
import Entity.InfoParkway;
import controller.MainController;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.PreviewExitTicket;

/**
 *
 * @author Martin Kanayet
 */
public class CustomExitTicketController {

    public CustomExitTicketController() {
    }
    
    public static void previewExitTicket(){
    
        PreviewExitTicket exitTicket = new PreviewExitTicket();
        ImageIcon img = new ImageIcon("src/images/parking1.gif");  
        JFrame frame = new JFrame();
        frame.setTitle("ParkQuick ~ Vista Previa Entrada");
        frame.setIconImage(img.getImage());
        CustomExitTicket cet = new CustomExitTicket();
        InfoParkway ip = new InfoParkway();
        if(MainController.customExitJpaController.findCustomExitTicketEntities().isEmpty()){
            JOptionPane.showMessageDialog(null, "Configure los datos en la ventana de administracion, en la pestaña tiquetes","Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        cet = MainController.customExitJpaController.findCustomExitTicketEntities().get(0);
        ip = MainController.infoJpaController.findInfoParkwayEntities().get(0);
        //Obligatorios
        
        //Opcionales
        exitTicket.setTittleText(cet.getTittle());
        if(cet.isParkwayName()){
            exitTicket.setParkingName(ip.getName());
        }
        else{
            exitTicket.setVisibleName(false);
        }
        if(cet.isParkwayAddress()){
            exitTicket.setParkingAddress(ip.getAddress());
        }
        else{
            exitTicket.setVisibleAddress(false);
        }
        if(cet.isParkwayNit()){
            exitTicket.setNIT(ip.getNit());
        }
        else{
            exitTicket.setVisibleNIT(false);
        }
        exitTicket.setFootPage(cet.getFootPage());
        if(cet.isExitEmployee()){
            exitTicket.setEmployee(MainController.system.sesionemployee.getName() + " " + MainController.system.sesionemployee.getLastName());
        }
        else{
            exitTicket.setVisibleEmployee(false);
        }
        exitTicket.setVisible(true);
        frame.add(exitTicket);
        frame.setPreferredSize(new Dimension(420,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.repaint();
        frame.setVisible(true);
        }
    } 
}
