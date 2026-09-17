/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
/**
 *
 * @author Student
 */
public class Login {
     public String FirstName;
     public String LastName;
     public String userName;
     public String password;
     public int CellPhoneNumber;
     
     private boolean isRegistered = false;
     
    public boolean checkUesrName(String UesrName){
         return UesrName.contains("_") && userName.length() <=5;
        
     }
      public boolean checkPasswordComplexity(String password){
        if(password.length ()< 8) return false;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);

        if (Character.isUpperCase(c)) {
            hasCapital = true;
        } else if (Character.isDigit(c)) {
            hasNumber = true;
        } else if (!Character.isLetterOrDigit(c)) {
            hasSpecial = true;
        }
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkPhoneNumber(String cellPhoneNumber) {
        if (!cellPhoneNumber.startsWith("+27")) {
        return false;
    }

    if (cellPhoneNumber.length() != 12) { // +27 plus 9 digits
        return false;
    }

    for (int i = 3; i < cellPhoneNumber.length(); i++) {
        if (!Character.isDigit(cellPhoneNumber.charAt(i))) {
            return false;
        }
    
    }
    return true;
    }
    public String registerUesr(String firstName, String lastName, String userName,
                                String password, String cellPhoneNumber) {

        StringBuilder message = new StringBuilder();
        boolean usernameOk = checkUesrName(userName);
        boolean passwordOk = checkPasswordComplexity(password);
        boolean phoneOk = checkPhoneNumber(cellPhoneNumber);

        if (usernameOk) {
            message.append("Username successfully captured.\n");
        } else {
            message.append("Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.\n");
        }

        if (passwordOk) {
            message.append("Password successfully captured.\n");
        } else {
            message.append("Password is not correctly formatted; please ensure that the password "
                    + "contains at least eight characters, a capital letter, a number, and a special character.\n");
        }

        if (passwordOk) {
            message.append("Password successfully captured.\n");
        } else {
            message.append("Password is not correctly formatted; please ensure that the password "
                    + "contains at least eight characters, a capital letter, a number, and a special character.\n");
        }

        if (phoneOk) {
            message.append("Cell phone number successfully added.\n");
        } else {
            message.append("Cell phone number incorrectly formatted or does not contain international code; "
                    + "please correct the number and try again.\n");
        }
         if (usernameOk && passwordOk && phoneOk) {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.userName = userName;
            this.password = password;
            this.CellPhoneNumber = CellPhoneNumber;
            this.isRegistered = true;
            message.append("User registered successfully.");
        }

        return message.toString();
    }
    public boolean loginUesr(String userName, String password) {
        if (!isRegistered) return false;
        return this.userName.equals(userName) && this.password.equals(password);
    }
    public String returnLoginStatus(String username, String password, String firstName, String lastName) {
        if (username.equals(this.userName) && password.equals(this.password)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
     }
     public String getFirstName(){
         return FirstName;
     }
     public String getLastName(){
         return LastName;
     }
     public String getuserName(){
         return  userName;
     }
     public String getPassword(){
         return password;
     }
     public int getCellPhoneNumber(){
         return CellPhoneNumber;

     }

    String RegisterUser(String kyle, String smith, String kyl_1, String pass123, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}