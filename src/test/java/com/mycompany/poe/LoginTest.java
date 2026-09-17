/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
 @Test
    public void testCheckUserNameValid() {
        Login login = new Login();
           boolean result = login.checkUesrName("kyl_1");
          assertTrue(result);
        
    }
     @Test
    public void testCheckUserNameInvalid() {
        Login login = new Login();
        boolean result = login.checkUesrName("kyle!!!!!!");
        assertFalse(result);
    }

     @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("Pass123!");
        assertTrue(result);
    }
     @Test
    public void testCheckPasswordComplexityInvalid() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }
    @Test
    public void testCheckPhoneNumberValid() {
        Login login = new Login();
        boolean result = login.checkPhoneNumber("+27838968976");
        assertTrue(result);
    }
    @Test
    public void testCheckPhoneNumberInvalid() {
        Login login = new Login();
        boolean result = login.checkPhoneNumber("08966553");
        assertFalse(result);
    }
     @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.userName = "kyl_1";
        login.password = "Pass123!";
        login.FirstName = "Kyle";
        login.LastName = "Smith";
        String result = login.returnLoginStatus("kyl_1", "Pass123!", "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", result);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        login.userName = "kyl_1";
        login.password = "Pass123!";
        login.FirstName = "Kyle";
        login.LastName = "Smith";

        String result = login.returnLoginStatus("wrongUser", "wrongPassword", "Kyle", "Smith");
        assertEquals("Username or password incorrect, please try again.", result);
    }
    @Test
    public void testRegisterUesrSuccess() {
        Login login = new Login();
        String result = login.registerUesr("Kyle", "Smith", "kyl_1", "Pass123!", "+27838968976");
        assertTrue(result.contains("User registered successfully."));
    }

    @Test
    public void testRegisterUserInvalidUesrname() {
        Login login = new Login();
        String result = login.registerUesr("Kyle", "Smith", "kyle!!!!!!", "Pass123!", "+27838968976");
        assertTrue(result.contains("Username is not correctly formatted"));
    }
    @Test
    public void testLoginUserSuccessful() {
        Login login = new Login();
        login.registerUesr("Kyle", "Smith", "kyl_1", "Pass123!", "+27838968976");
        assertTrue(login.loginUesr("kyl_1", "Pass123!"));
    }

    @Test
    public void testLoginUesrFailed() {
        Login login = new Login();
        login.registerUesr("Kyle", "Smith", "kyl_1", "Pass123!", "+27838968976");
        assertFalse(login.loginUesr("kyl_1", "wrongPassword"));
    }

    
}