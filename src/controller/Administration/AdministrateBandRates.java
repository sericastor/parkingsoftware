/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import DAO.exceptions.NonexistentEntityException;
import Entity.BandsRate;
import Entity.Entries;
import Entity.VehicleType;
import controller.MainController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author miguel
 */
public class AdministrateBandRates {
    
    public static void deleteLastRate(){
        String id = (String) MainController.adminView.getVehicleTypeComboBox().getSelectedItem();
        int option = MainController.adminView.showOptionMessage("¿Está seguro de eliminar la última tarifa para el tipo de vehículo: " + id +"?");
        if(option == JOptionPane.OK_OPTION){
            deleteRateFromVehicleType(id);
            MainController.adminView.getRatesTable().setModel(getModelTable(getVehicleTypeSelected(id)));
            MainController.adminView.getRatesTable().updateUI();
        }
    }
    
    public static void getBandsRateFromVehicleType(){
        String id = (String) MainController.adminView.getVehicleTypeComboBox().getSelectedItem();
        MainController.adminView.getRatesTable().setModel(getModelTable(getVehicleTypeSelected(id)));
        MainController.adminView.getRatesTable().updateUI();
    }
    
    public static void saveChangesBandsRate(){
        String id = (String) MainController.adminView.getVehicleTypeComboBox().getSelectedItem();
        VehicleType vehicle = getVehicleTypeSelected(id);
        int option = MainController.adminView.showOptionMessage("¿Está seguro de modificar las tarifas para el tipo de vehículo: " + vehicle.getName() +"?");
        if(option == JOptionPane.OK_OPTION){
            if(MainController.adminView.getRatesTable().isEditing()){
                MainController.adminView.getRatesTable().getCellEditor().stopCellEditing();
            }
            javax.swing.JTable bandsRate = MainController.adminView.getRatesTable();
            for(int i = 0; i < bandsRate.getRowCount(); i++){
                rowIsEdited(i,
                    String.valueOf(bandsRate.getValueAt(i, 0)),
                    String.valueOf(bandsRate.getValueAt(i, 1)),
                    String.valueOf(bandsRate.getValueAt(i, 2)),
                    String.valueOf(bandsRate.getValueAt(i, 3)),
                    String.valueOf(bandsRate.getValueAt(i, 4)),
                    vehicle);
            }
            MainController.adminView.showMessage("Ok", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }else if(option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION){
            return;
        }
        MainController.adminView.getRatesTable().setModel(getModelTable(vehicle));
        MainController.adminView.getRatesTable().updateUI();
    } 

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

    public boolean isCellEditable(int rowIndex, int colIndex) {
        if (rowIndex == 0) {
            return false; //Disallow the editing of any cell
        } else {
            return true;
        }
    }

    public static void deleteRateFromVehicleType(String vehicleType) {
        VehicleType vt = new VehicleType();
        vt = getVehicleTypeSelected(vehicleType);
        try {
            modifyBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vt);
            if (modifyBandsRate.size() > 0 && verifyRateUse(vt)) {
                BandsRate toElimitate=modifyBandsRate.get(modifyBandsRate.size() - 1);
                MainController.bandsRateJpaController.destroy(toElimitate.getId());
                String action="Delete a Bandrate";
                String detail=" VehicleType:" + toElimitate.getVehicletype().getName()+
                        " From: " + toElimitate.getFromm() + 
                        " To:" + toElimitate.getToo() + 
                        " Frac:" + toElimitate.getUnits() + 
                        " Value:" + toElimitate.getUnitValue();
                MainController.system.NewLogAction(action, detail);
            }
            else if(modifyBandsRate.isEmpty()){
                MainController.adminView.confirmationMessages("Está vacia la lista de tarifas", "Error");
            }
        } catch (Exception e) {
            MainController.adminView.confirmationMessages("Está vacia la lista de tarifas", "Error");
        }
    }

    public static boolean verifyRateUse(VehicleType v){
        //TODO: hacer query elegante
        for (Entries entries : MainController.entriesJpaController.findEntriesEntities()) {
            if (entries.getVehicleType().equals(v)){
                MainController.adminView.showMessage("Error", "La tarifa esta asociada a una entrada", 0);
                return false;
            }
        }
        return true;
    }
    
    public static TableModel getModelTable(VehicleType vehicletype) {
        DefaultTableModel results = new DefaultTableModel() {

            public boolean isCellEditable(int rowIndex, int mColIndex) {
                if (mColIndex == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        AllBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vehicletype);
        results.addColumn("Identificador");
        results.addColumn("Desde (Minutos)");
        results.addColumn("Hasta (Minutos)");
        results.addColumn("Fracción (Minutos)");
        results.addColumn("Valor Fracción");
        for (BandsRate b : AllBandsRate) {
            results.addRow(new Object[]{b.getId(), b.getFromm(), b.getToo(), b.getUnits(), b.getUnitValue()});
        }
        results.addRow(new Object[]{"nueva regla -->", "", "", "", ""});
        return results;
    }

    public static void updateRow(int row, String id, String from, String to, String fraction, String value, VehicleType vehicletype) {
        AllBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vehicletype);//actualiza listado
        try {
            BandsRate aux = new BandsRate();
            aux.setFromm(Integer.parseInt(from));
            aux.setToo(Integer.parseInt(to));
            aux.setUnits(Integer.parseInt(fraction));
            aux.setUnitValue(Double.parseDouble(value));
            aux.setVehicletype(vehicleTypeIsSelected);
            aux.setId(Integer.parseInt(id));
            MainController.bandsRateJpaController.edit(aux);
            String action="Update a Bandrate";
            String detail = "VehicleType:" + AllBandsRate.get(row).getVehicletype()
                    + " From: " + AllBandsRate.get(row).getFromm() + " -> " + from
                    + " To:" + AllBandsRate.get(row).getToo() + " -> " + to
                    + " Frac:" + AllBandsRate.get(row).getUnits() + " -> " + fraction
                    + " Value:" + AllBandsRate.get(row).getUnitValue() + " -> " + value
                    ;
            MainController.system.NewLogAction(action, detail);
            AllBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vehicletype);
        } catch (NumberFormatException ex) {
            //error generado al tratar de hacer un parse con un string ""
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AdministrateBandRates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdministrateBandRates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createRow(int row, String from, String to, String fraction, String value, VehicleType vehicletype) {
        BandsRate aux = new BandsRate();
        aux.setFromm(Integer.parseInt(from));
        aux.setToo(Integer.parseInt(to));
        aux.setUnits(Integer.parseInt(fraction));
        aux.setUnitValue(Double.parseDouble(value));
        aux.setVehicletype(vehicleTypeIsSelected);
        MainController.bandsRateJpaController.create(aux);
        String action = "Create a Bandrate";
        String detail = "VehicleType: " + vehicletype.getName() + " From: " + from + " To:" + to + " Frac:" + fraction + " Value:" + value ;
        MainController.system.NewLogAction(action, detail);
        AllBandsRate = MainController.bandsRateJpaController.queryByVehicleTypes(vehicletype);
    }

    public static boolean Validations(int row, String id, String from, String to, String fraction, String value) {
        boolean consistency = true;
        try {//validaciones de tipo alfanumerico

            int ifrom = Integer.parseInt(from);
            int ito = Integer.parseInt(to);
            int ifrac = Integer.parseInt(fraction);
            float fval = Float.parseFloat(value);
            consistency = consistencyValidations(row, ifrom, ito, ifrac, fval);
        } catch (NumberFormatException e) {

            consistency = false;
            String message = "Se ha provocado un error en la fila " + (row + 1) + " por favor inserte valores numéricos.";
            String type = "Error!";
            MainController.adminView.confirmationMessages(message, type);
        }
        return consistency;
    }

    public static boolean consistencyValidations(int row, int from, int to, int fraction, float value) {
        String message = "";
        String type = "";
        if (from >= to) {
            type = "Error en la fila " + (row + 1);
            message = "El campo 'Desde' debe ser estrictamente menor que el campo 'Hasta'";
            MainController.adminView.confirmationMessages(message, type);
            return false;
        }
        if (AllBandsRate.isEmpty() && from != 0) {
            type = "Error en la fila " + (row + 1);
            message = "El campo 'Desde' debe empezar estrictamente en cero (0)";
            MainController.adminView.confirmationMessages(message, type);
            return false;
        }
        if (!AllBandsRate.isEmpty()) {
            boolean flag = false;
            boolean flag2 = false;
            for (BandsRate bandsRate : AllBandsRate) {
                if (bandsRate.getToo() == from) {
                    flag = true;
                } else if (bandsRate.getFromm() == from) {
                    flag2 = true;
                    break;
                }
            }
            if (flag == false) {
                type = "Error en la fila " + (row + 1);
                message = "El campo 'Desde' debe ser igual a alguno de los valores de la columna 'Hasta'";
                MainController.adminView.confirmationMessages(message, type);
                return false;
            } else if (flag2 == true) {
                type = "Error en la fila " + (row + 1);
                message = "La fila 'Desde' debe ser unica en cada caso";
                MainController.adminView.confirmationMessages(message, type);
                return false;
            }

        }

        return true;
    }

    public static void rowIsEdited(int row, String id, String from, String to, String fraction, String value, VehicleType vehicletype) {
        if (AllBandsRate.isEmpty() || AllBandsRate.size() <= row) {
            try {
                boolean flag = true;
                if (!from.equals("") && !to.equals("") && !fraction.equals("") && !value.equals("")) {
                    flag = Validations(row, id, from, to, fraction, value);
                }
                if (flag == true) {
                    createRow(row, from, to, fraction, value, vehicletype);
                }

            } catch (NumberFormatException e) {
                //error producido si se edito un campo y se dejo la ultima fila vacia
            } finally {
                return;
            }
        }

        if (!String.valueOf(AllBandsRate.get(row).getFromm()).equals(from)) {
            if (Validations(row, id, from, to, fraction, value)) {
                updateRow(row, id, from, to, fraction, value, vehicletype);
            }
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getToo()).equals(to)) {
            if (Validations(row, id, from, to, fraction, value)) {
                updateRow(row, id, from, to, fraction, value, vehicletype);
            }
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getUnits()).equals(fraction)) {
            if (Validations(row, id, from, to, fraction, value)) {
                updateRow(row, id, from, to, fraction, value, vehicletype);
            }
            return;
        } else if (!String.valueOf(AllBandsRate.get(row).getUnitValue()).equals(value)) {
            if (Validations(row, id, from, to, fraction, value)) {
                updateRow(row, id, from, to, fraction, value, vehicletype);
            }
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
    
    // this methods come from RatesManagementController an unused class that was been deleted
    // please Check out if this methods could be used for bussiness rules
    public static boolean validateName(String Name) {
        if (Name.length() >= 5 && Name.length() <= 15) {
            return true;
        }
        return false;
    }

    public static boolean validateFrom(String f, String t) {
        int from;
        int to;
        try {
            from = Integer.parseInt(f);
            to = Integer.parseInt(t);
            if (from >= 0 && to > from) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean validateUnitValue(String v) {
        try {
            int unitValue = Integer.parseInt(v);
            if(unitValue >= 0){
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean validateUnits(String u) {
        try {
            int units = Integer.parseInt(u);
            if (units > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }
    
    private static VehicleType vehicleTypeIsSelected = null;
    private static List<BandsRate> AllBandsRate = null;
    private static List<VehicleType> AllVehicleTypes = null;
    private static List<BandsRate> modifyBandsRate = null;
}
