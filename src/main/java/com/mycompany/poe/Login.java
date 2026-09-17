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
}