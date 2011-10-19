/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import DAO.exceptions.NonexistentEntityException;
import Entity.BandsRate;
import Entity.VehicleType;
import controller.MainController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author miguel
 */
public class AdministrateBandRates {

    public static DefaultComboBoxModel AllVehicleTypes() {
        //actualiza el combo box con la informacion de la base de datos
        //de vehicletype
        DefaultComboBoxModel results = new DefaultComboBoxModel();
        AllVehicleTypes = MainController.vehicleTypeJpaController.findVehicleTypeEntities();
        for (VehicleType e : AllVehicleTypes) {
            results.addElement(e.getName());
        }
        return results;
    }

    public static TableModel getModelTable(VehicleType vehicletype) {
        DefaultTableModel results = new DefaultTableModel();
        AllBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vehicletype);
        //AllBandsRate = MainController.bandsRateJpaController.findBandsRateEntities();
        results.addColumn("Identificador");
        results.addColumn("Desde (Minuto)");
        results.addColumn("Hasta (Minuto)");
        results.addColumn("Fracción");
        results.addColumn("Valor Fracción");
        for (BandsRate b : AllBandsRate) {
            if(b.getVehicletype().getName().equals(vehicletype.getName()))
                {
            results.addRow(new Object[]{b.getId(), b.getFromm(), b.getToo(), b.getUnits(), b.getUnitValue()});
            }
        }
        results.addRow(new Object[]{"nueva regla -->", "", "", "", ""});
        return results;
    }

    public static void updateRow(int row, String id, String from, String to, String fraction, String value,VehicleType vehicletype) {
        AllBandsRate = MainController.bandsRateJpaController.findBandsRateEntities();//actualiza listado
        try {
        BandsRate aux = new BandsRate();
        aux.setFromm(Integer.parseInt(from));
        aux.setToo(Integer.parseInt(to));
        aux.setUnits(Integer.parseInt(fraction));
        aux.setUnitValue(Double.parseDouble(value));
        aux.setVehicletype(vehicleTypeIsSelected);
        aux.setId(Integer.parseInt(id));
        
            MainController.bandsRateJpaController.edit(aux);
            String description = "from: " + AllBandsRate.get(row).getFromm() + " -> " + from
                    + " to:" + AllBandsRate.get(row).getToo() + " -> " + to
                    + " frac:" + AllBandsRate.get(row).getUnits() + " -> " + fraction
                    + " value:" + AllBandsRate.get(row).getUnitValue() + " -> " + value;
            MainController.system.UpdateBandRate(aux.getId(), description);
            AllBandsRate = MainController.bandsRateJpaController.findBandsRateEntities();
        } 
        catch(NumberFormatException ex){
            //error generado al tratar de hacer un parse con un string ""
        }catch (NonexistentEntityException ex) {
            Logger.getLogger(AdministrateBandRates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdministrateBandRates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createRow(int row, String from, String to, String fraction, String value,VehicleType vehicletype) {
        BandsRate aux = new BandsRate();
        aux.setFromm(Integer.parseInt(from));
        aux.setToo(Integer.parseInt(to));
        aux.setUnits(Integer.parseInt(fraction));
        aux.setUnitValue(Double.parseDouble(value));
        aux.setVehicletype(vehicleTypeIsSelected);
        MainController.bandsRateJpaController.create(aux);
        String description = "from: " + from + " to:" + to + " frac:" + fraction + " value:" + value;
        MainController.system.AddBandRate(aux.getId(), description);
        AllBandsRate = MainController.bandsRateJpaController.findBandsRateEntities();

    }

    public static void rowIsEdited(int row, String id,String from, String to, String fraction, String value,VehicleType vehicletype) {
        if (AllBandsRate.isEmpty() || AllBandsRate.size() <= row) {
            try {
                createRow(row, from, to, fraction, value, vehicletype);
            } catch (NumberFormatException e) {
                //error producido si se edito un campo y se dejo la ultima fila vacia
            } finally {
                return;
            }
        }
        if (!String.valueOf(AllBandsRate.get(row).getFromm()).equals(from)) {
            updateRow(row, id, from, to, fraction, value, vehicletype);
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getToo()).equals(to)) {
            updateRow(row, id, from, to, fraction, value, vehicletype);
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getUnits()).equals(fraction)) {
            updateRow(row, id, from, to, fraction, value, vehicletype);
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getUnitValue()).equals(value)) {
            updateRow(row, id,  from, to, fraction, value, vehicletype);
            return;
        }


    }

    public static VehicleType getVehicleTypeSelected(String vehicletype) {
        for (VehicleType v : AllVehicleTypes) {
            if (v.getName().equals(vehicletype)) {
                vehicleTypeIsSelected = v;
                return v;
            }
        }
        return null;
    }
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<BandsRate> AllBandsRate = null;
    private static List<VehicleType> AllVehicleTypes = null;
}
