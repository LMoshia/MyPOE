/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author Student
 */
public class JSON {
    static int totalSent = 0;
static String sentMessages = "";
static String storedJson = "";
String messageId;
int messageNumber;
String recipient;
String text;
String messageHash;
String getDetails;
String storeMessage;

public JSON (int messageNumber, String recipient, String text, String create) {
this.messageNumber = messageNumber;
this.recipient = recipient;
this.text = text;
this.messageId = createMessageID();
this.messageHash = createMessageHash();
}
public String createMessageID() {
Random rnd = new Random();
String digits = "";
for (int i = 0; i < 20; i++) {
digits = digits + rnd.nextInt(10);
}
return digits.substring(0, 10);
}
   public boolean checkMessageID() {
return messageId.length() <= 10;
   }
public String checkRecipientCell() {
if (recipient.startsWith("+") && recipient.length() <= 13) {
return "Cell phone number successfully captured.";
}
return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
}
     public String checkMessageLength() {
if (text.length() <= 250) {
return "Message ready to send.";
}
int over = text.length() - 250;
return "Message exceeds 250 characters by " + over + "; please reduce the size.";
}  
     public String createMessageHash() {
String t = text.trim();
int firstSpace = t.indexOf(' ');
int lastSpace = t.lastIndexOf(' ');
String first = t;
String last = t;
if (firstSpace != -1) {
first = t.substring(0, firstSpace);
last = t.substring(lastSpace + 1);
}
first = first.replaceAll("[^A-Za-z0-9]", "");
last = last.replaceAll("[^A-Za-z0-9]", "");
return (messageId.substring(0, 2) + ":" + messageNumber + ":" + first + last).toUpperCase();
}
     public String sentMessage(int choice) {
if (choice == 1) {
totalSent++;
sentMessages = "get details()" + sentMessages;

    return "Message successfully sent";
} else if (choice == 2) {
return "Press 0 to delete the message";
} else {
    storeMessage();
return "Message successfully stored";
}
     }

public static String printMessages(String sentMessages) {
return sentMessages;
}
public static int returnTotalMessages(int totalSent) {
return totalSent;
} 

    private void storeMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   
   
  
