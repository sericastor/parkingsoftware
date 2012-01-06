/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import Entity.CustomEntryTicket;
import Entity.InfoParkway;
import controller.MainController;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.PreviewEntryTicket;

/**
 *
 * @author Martin Kanayet
 */
public class CustomEntryTicketController {

    public CustomEntryTicketController() {
    }
    
    public static void previewEntryTicket(){
    
        PreviewEntryTicket entryTicket = new PreviewEntryTicket();
        ImageIcon img = new ImageIcon("src/images/parking1.gif");  
        JFrame frame = new JFrame();
        frame.setTitle("ParkQuick ~ Vista Previa Entrada");
        frame.setIconImage(img.getImage());
        CustomEntryTicket cet = new CustomEntryTicket();
        InfoParkway ip = new InfoParkway();
        if(MainController.customEntryJpaController.findCustomTicketEntities().isEmpty()){
            JOptionPane.showMessageDialog(null, "Configure los datos en la ventana de administracion, en la pestaña tiquetes","Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        cet = MainController.customEntryJpaController.findCustomTicketEntities().get(0);
        ip = MainController.infoJpaController.findInfoParkwayEntities().get(0);
     
 
        entryTicket.setTittleText(cet.getTittle());
        if(cet.isParkwayName()){
            entryTicket.setParkingName(ip.getName());
        }
        else{
            entryTicket.setVisibleName(false);
        }
        if(cet.isParkwayAddress()){
            entryTicket.setParkingAddress(ip.getAddress());
        }
        else{
            entryTicket.setVisibleAddress(false);
        }
        if(cet.isParkwayNit()){
            entryTicket.setNIT(ip.getNit());
        }
        else{
            entryTicket.setVisibleNIT(false);
        }
        entryTicket.setFootPage(cet.getFootPage());
        if(cet.isEntryEmployee()){
            entryTicket.setEmployee(MainController.system.sesionemployee.getName() + " " + MainController.system.sesionemployee.getLastName());
        }
        else{
            entryTicket.setVisibleEmployee(false);
        }
        if(cet.isBarcode()){
            entryTicket.setBarCode();
        }
        else{
            entryTicket.setVisibleBarCode(false);
        }
        entryTicket.setVisible(true);
        frame.add(entryTicket);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.repaint();
        frame.setVisible(true);
        }
        
        
    }
}
