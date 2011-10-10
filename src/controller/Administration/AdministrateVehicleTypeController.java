/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author miguel
 */
import Entity.VehicleType;
import controller.MainController;
import java.util.List;
import java.util.Random;

public class AdministrateVehicleTypeController {

    public static DefaultTableModel TotalSearchOfVehicles() {
        DefaultTableModel results = new DefaultTableModel();
        AllVehiclesTypes=MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        results.addColumn("Identificador");
        results.addColumn("Tipo de Vehiculo");
        results.addColumn("Ejemplo de Placa");
        
        for (VehicleType e : AllVehiclesTypes) {
            results.addRow( new Object []{String.valueOf(e.getNumber()), e.getName(), decodePlate(e.getCodification())});
        }
        return results;
    }
    public static String encodePlate(String plate){
         String code="";
         for(int i=0;i<plate.length();i++){
             if(Character.isLetter(plate.charAt(i))){
                 code=code+"1";}
             else if(Character.isDigit(plate.charAt(i))){
                 code=code+"0";}
             else{
                 return "No es un tipo valido de placa";
             }
         }
         return code;
     }
    public static String decodePlate(String code){
        String decode="";
        for(int i=0;i<code.length();i++){
            
            Random rnd = new Random();
            if(code.charAt(i)==49){
            int n=rnd.nextInt(25)+65;
            decode=decode+Character.toString((char)n);
            }
            else{
            int n=rnd.nextInt(9);
            decode=decode+String.valueOf(n);
            }
        }
        return decode;
    }
    
    public static String SavePlate(String Name, String Plate){
       String code=encodePlate(Plate);
       if(!code.equals("No es un tipo valido de placa")){
           VehicleType v=new VehicleType();
           v.setCodification(code);
           v.setName(Name);
           MainController.vehicleTypeJpaController.create(v);
           MainController.system.AddPlate(Name);
           return "Succes";
       }
       return "Failure";
    }
    private static List<VehicleType> AllVehiclesTypes=null;
}
