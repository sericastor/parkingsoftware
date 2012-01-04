package controller.Administration;

import Entity.InfoParkway;
import controller.MainController;

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

    public static void updateInfoParway(String name, String address, String nit, String phone, String maxCapacity, double ivaPercent) {
        if (!validateNotEmptyFields(name, address, nit, phone, maxCapacity)) {
            MainController.adminView.showMessage("Error", "Todos los campos son obligatorios", 0);
        } else if (validateAll(name, address, nit, phone, maxCapacity)) {
            InfoParkway infoParkway = new InfoParkway();
            infoParkway.setId(idParkway);
            infoParkway.setName(name);
            infoParkway.setAddress(address);
            infoParkway.setNit(nit);
            infoParkway.setTelephone(phone);
            infoParkway.setMaxCapacity(Integer.parseInt(maxCapacity));
            infoParkway.setIVAPercent(ivaPercent);
            MainController.infoJpaController.edit(infoParkway, idParkway);
        } else {
            MainController.adminView.showMessage("Error", "Los datos ingresados no son válidos.", 0);
        }
    }

    //Reglas de Negocio
    public static boolean validateNotEmptyFields(String name, String address, String nit, String phone, String maxC) {
        if (name.isEmpty() || address.isEmpty() || nit.isEmpty() || phone.isEmpty() || maxC.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validateAll(String name, String address, String nit, String phone, String maxC) {
        if (validateName(name) && validateAddress(address) && validateNIT(nit) && validatePhone(phone) && validateMaxCapacity(maxC)) {
            return true;
        }
        return false;
    }

    public static boolean validateName(String Name) {
        if (Name.length() >= 7 && Name.length() <= 15) {
            return true;
        }
        return false;
    }

    public static boolean validateAddress(String address) {
        if (address.length() >= 5 && address.length() <= 25) {
            return true;
        }
        return false;
    }

    public static boolean validatePhone(String phone) {
        if (phone.length() >= 7) {
            return true;
        }
        return false;
    }

    public static boolean validateNIT(String nit) {
        if (nit.length() >= 5) {
            return true;
        }
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
        return false;
    }
    private static final long idParkway = 1;
}
