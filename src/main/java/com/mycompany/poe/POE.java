/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class POE {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Login login= new Login();
       
       System.out.println("Enter FirstName");
          String FirstName =  input.nextLine();
          
          System.out.println("Enter LastName");
          String LastName =  input.nextLine();
          
            System.out.println("Enter  userName");
          String  userName =  input.nextLine();
          
          System.out.println("Enter passowrd (8 characters, capital, Number, special):");
          String Password =  input.nextLine();
          
            System.out.println("Enter SA phonenumber (e.g + 27978463221");
          String phonenumber =  input.nextLine();
        
          
            if (login.checkUesrName(userName) && login.checkPasswordComplexity(Password) && login.checkPhoneNumber(phonenumber)) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            System.out.println(login.returnLoginStatus(loginUser, loginPass, FirstName, LastName));
            }else{
                System.out.println("Registration failed. Please check your username, paasword or phonenumber");
        }
     
    }
}

               
  

                                                             



     

