/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class QuickChat {
    public static void main(String[]args, boolean False, int numMessages){
        Scanner input = new Scanner (System.in);
        //Login in 
    System.out.print("Username: ");
        String user = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();

        if (!user.equals("user") || !pass.equals("pass")) {
            System.out.println("Login failed. You must log in to send messages.");
            return;
        }
        //Welcome message
        System.out.println();
            System.out.println("=====Welcome to QuickChat!=====");
            //number of messages
             System.out.print("How many messages do you wish to enter? ");
               int limit = Integer.parseInt(input.nextLine());
               boolean entered=false;
        int sent = 0;
        
        //Loop menu
         boolean running =true;
        while (running) {
            System.out.println("\n1) Send Messages");
            System.out.println("\n2 Show recently sent messages");
            System.out.println("\n3 Quit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(input.nextLine());
            if (choice == 1) {
                if (entered) {
                    System.out.println("You have already entered your messages.");
                } else {
                    // for loop: one pass per message, the counter is the message number
                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\nMessage " + (i + 1) + " of " + numMessages);
                        Message m();
                        while (true){
                          //Recipient validation  
                         System.out.print("Recipient cell number: ");
                                   String recipient = input.nextLine().trim();
                                   //message validation
                                   System.out.print("Message:");
                                   String message =input.nextLine();
                                    message = new Message (i, recipient, message);
                            String cellResult = m.checkRecipientCell();
                            String lengthResult = m.checkMessageLength();
                            System.out.println(cellResult);
                            System.out.println(lengthResult);

                            if (cellResult.startsWith("Cell phone number successfully")
                                    && lengthResult.equals("Message ready to send.")) {
                                break;
                            }
                        
                   if (!recipient.startsWith("+") || recipient.length() > 10) {
                        System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.");
                    } else {
                        System.out.print("Message: ");
                   }
                        if (message.length() > 250) {
                            System.out.println("Please enter a message of less than 250 characters.");
                            }else{
                      System.out.println("\n1) Send Message");
                        System.out.println("\n2) Disregard Message");
                        System.out.println("\n3) Store Message to send later");
                        System.out.println("\n4) Quit");
                        System.out.print("Choose an option: ");
                          int action = Integer.parseInt(input.nextLine());

                        System.out.println(message.sentmessage(action));

                        if (action == 1) {
                            System.out.println(message.getDetails());
                        } else if (action == 2) {
                            input.nextLine();
                        }
                    }
                    System.out.println("\nTotal messages sent: " + message.returnTotalMessages());
                    entered = true;
                        }
                    } else if (choice == 2) {
                System.out.println("Coming Soon.");
            } else if (choice == 3) {
                running = false;
                System.out.println("Goodbye.");
            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }
    }
}

    // Random 10-digit message ID
    public static String getMakeId() {
        Random rand = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) {
            id = id + rand.nextInt(10);
        }
        return id;
    }
     public static String makeHash(String id, int number, String message) {
        message = message.trim();

        int firstSpace = message.indexOf(' ');
        int lastSpace = message.lastIndexOf(' ');

        String firstWord = message;
        String lastWord = message;
        if (firstSpace != -1) {
            firstWord = message.substring(0, firstSpace);
            lastWord = message.substring(lastSpace + 1);
        }

        // Remove punctuation, e.g. "Hi," becomes "Hi"
        firstWord = firstWord.replaceAll("[^A-Za-z0-9]", "");
        lastWord = lastWord.replaceAll("[^A-Za-z0-9]", "");

        String hash = id.substring(0, 2) + ":" + number + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }
}