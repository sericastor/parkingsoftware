package controller;

public class EmployeeManagementController {

    public EmployeeManagementController() {
    }

    public static boolean validatePasswords(String pass, String confirm){
        if(pass.equals(confirm)){
            return true;
        }
        return false;
    }
    
    public static boolean validateNotEmptyFields(String lastName, String name, String document, String user, String password){
        if(lastName.isEmpty() || name.isEmpty() || document.isEmpty() || user.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }
    
    public static boolean validateAll(String lastName, String name, String document, String user, String password){
        if(validateLastName(lastName) && validateName(name) && validateDocument(document) && validateUser(user) && validatePassword(password)){
            return true;
        }
        return false;
    }
    
    public static boolean validateLastName(String lastName) {
        if (lastName.length() >= 2 && lastName.length() <= 25) {
            return true;
        }
        return false;
    }

    public static boolean validateName(String name) {
        if (name.length() > 1 && name.length() < 26) {
            return true;
        }
        return false;
    }

    public static boolean validateDocument(String document) {
        if (document.length() >= 6 && document.length() <= 15) {
            return true;
        }
        return false;
    }
    
    public static boolean validateUser(String user) {
        if (user.length() >= 6 && user.length() <= 10) {
            return true;
        }
        return false;
    }
    
    public static boolean validatePassword(String password) {
        if (password.length() >= 4 && password.length() <= 10) {
            return true;
        }
        return false;
    }
    
    
}