package controller.Administration;

import Entity.InfoParkway;
import controller.MainController;
import javax.swing.JOptionPane;

public class ParkingManagementController {

    public ParkingManagementController() {
    }

    // CRUD
    public static InfoParkway getInfo() {
        if (MainController.infoJpaController.findInfoParkway(idParkway) == null) {
            InfoParkway infop = new InfoParkway();
            infop.setAddress("InitialAdress 34324");
            infop.setMaxCapacity(50);
            infop.setName("InitialName");
            infop.setNit("123456");
            infop.setRegister(1);
            infop.setTelephone("6666666");
            infop.setCapacityStatus(0);
            MainController.infoJpaController.create(infop);
        }
        return MainController.infoJpaController.findInfoParkway(idParkway);
    }

    public static String getName() {
        return getInfo().getName();
    }

    public static String getAddress() {
        return getInfo().getAddress();
    }

    public static String getNit() {
        return getInfo().getNit();
    }

    public static String getPhone() {
        return getInfo().getTelephone();
    }

    public static String getMaxCapacity() {
        return String.valueOf(getInfo().getMaxCapacity());
    }

    public static double getIVAPercent() {
        return getInfo().getIVAPercent();
    }
    
    public static void updateInfoParkway(){
        if(MainController.adminView.getSaveParkwayChangesButton().equals("Cambiar Datos")){
            MainController.adminView.setSaveParkwayChangesButton("Guardar Cambios");
            MainController.adminView.setEnableParkway(true);
        }else{
            int maxCapacity;
            try{
                maxCapacity = Integer.parseInt(MainController.adminView.getMaxCapacityPark());
            }catch(Exception ex){
                maxCapacity = -1;
            }
            InfoParkway infoParkway = new InfoParkway();
            infoParkway.setId(idParkway);
            infoParkway.setName(MainController.adminView.getNamePark());
            infoParkway.setAddress(MainController.adminView.getAddressPark());
            infoParkway.setNit(MainController.adminView.getNitPark());
            infoParkway.setTelephone(MainController.adminView.getPhonePark());
            infoParkway.setMaxCapacity(maxCapacity);
            infoParkway.setIVAPercent(MainController.adminView.getIvaPercentPark());
            int option = MainController.adminView.askToParkway();
            if(option == JOptionPane.OK_OPTION && validateAll(infoParkway,MainController.adminView.getMaxCapacityPark())){
                MainController.infoJpaController.edit(infoParkway, idParkway);
                MainController.ocupationController.recalculateStatus(infoParkway.getMaxCapacity());
                MainController.adminView.showMessage("Exito", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                restartData();
            }
            if(option == JOptionPane.NO_OPTION){
                restartData();
            }
        }
    }
    
    public static void restartData(){
        MainController.adminView.getInfoParkway();
        MainController.adminView.setSaveParkwayChangesButton("Cambiar Datos");
        MainController.adminView.setEnableParkway(false);
    }

    //Reglas de Negocio
    public static boolean validateAll(InfoParkway info, String maxCapacity) {
        if (validateName(info.getName()) && validateAddress(info.getAddress()) && validateNIT(info.getNit()) && validatePhone(info.getTelephone()) && validateMaxCapacity(maxCapacity)) {
            return true;
        }
        return false;
    }

    public static boolean validateName(String Name) {
        if (Name.length() >= 7 && Name.length() <= 15) {
            return true;
        }
        MainController.adminView.confirmationMessages("El campo Nombre debe poseer minimo 7 caracteres y maximo 15",
                    "Advertencia:",1);
        MainController.adminView.setNamePark("");
        return false;
    }

    public static boolean validateAddress(String address) {
        if (address.length() >= 5 && address.length() <= 25) {
            return true;
        }
        MainController.adminView.confirmationMessages("El campo Dirección debe poseer minimo 5 caracteres y maximo 25",
                    "Advertencia:",1);
        MainController.adminView.setAddressPark("");
        return false;
    }

    public static boolean validatePhone(String phone) {
        if (phone.length() >= 7) {
            return true;
        }
        MainController.adminView.confirmationMessages("El campo Teléfono debe poseer minimo 7 caracteres",
                    "Advertencia:",1);
        MainController.adminView.setPhonePark("");
        return false;
    }

    public static boolean validateNIT(String nit) {
        if (nit.length() >= 5) {
            return true;
        }
        MainController.adminView.confirmationMessages("El campo Nombre debe poseer minimo 5 caracteres",
                    "Advertencia:",1);
        MainController.adminView.setNitPark("");
        return false;
    }

    public static boolean validateMaxCapacity(String mc) {
        int maxCapacity;
        try {
            maxCapacity = Integer.parseInt(mc);
            if (maxCapacity > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        MainController.adminView.confirmationMessages("El campo Capacidad Máxima debe poseer un número mayor que cero",
                    "Advertencia:",1);
        MainController.adminView.setMaxCapacityPark("");
        return false;
    }
    
    private static final long idParkway = 1;
}
