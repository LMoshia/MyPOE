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
        Login login = new Login();

        System.out.println("Enter FirstName");
        String firstName = input.nextLine();

        System.out.println("Enter LastName");
        String lastName = input.nextLine();

        System.out.println("Enter userName");
        String userName = input.nextLine();

        System.out.println("Enter password (8 characters, capital, Number, special):");
        String password = input.nextLine();

        System.out.println("Enter SA phonenumber (e.g +27978463221)");
        String phoneNumber = input.nextLine();

        if (login.checkUesrName(userName) && login.checkPasswordComplexity(password) && login.checkPhoneNumber(phoneNumber)) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            System.out.println(login.returnLoginStatus(loginUser, loginPass, firstName, lastName));
        } else {
            System.out.println("Registration failed. Please check your username, password or phonenumber");
        }

        System.out.println();
        System.out.println("=====Welcome to QuickChat!=====");

        System.out.print("How many messages do you wish to enter? ");
        int limit = Integer.parseInt(input.nextLine());

        boolean entered = false;
        boolean running = true;

        while (running) {
            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 1) {
                if (entered) {
                    System.out.println("You have already entered your messages.");
                } else {
                    for (int i = 0; i < limit; i++) {
                        System.out.println("\nMessage " + (i + 1) + " of " + limit);

                        message m;
                        while (true) {
                            System.out.print("Recipient cell number: ");
                            String recipient = input.nextLine().trim();
                            System.out.print("Message: ");
                            String msgText = input.nextLine();

                            m = new message(i, recipient, msgText);

                            String cellResult = m.checkRecipientCell();
                            String lengthResult = m.checkMessageLength();

                            System.out.println(cellResult);
                            System.out.println(lengthResult);

                            if (cellResult.startsWith("Cell phone number successfully")
                                    && lengthResult.equals("Message ready to send.")) {
                                break;
                            }
                        }

                        System.out.println("\n1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message to send later");
                        System.out.print("Choose an option: ");
                        int msgChoice = Integer.parseInt(input.nextLine());

                        if (msgChoice == 1) {
                            System.out.println(m.sentMessage(1));
                            System.out.println(m.getDetails());
                        } else if (msgChoice == 2) {
                            System.out.println(m.sentMessage(2));
                        } else if (msgChoice == 3) {
                            System.out.println(m.sentMessage(3));
                        } else {
                            System.out.println("Message not received");
                        }

                        System.out.println("\nTotal messages sent: " + message.returnTotalMessages());
                    }
                    entered = true;
                }

            } else if (choice == 2) {
                System.out.println("Coming Soon.");
                System.out.println(message.printMessages());

            } else if (choice == 3) {
                running = false;
                System.out.println("Goodbye.");

            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }

        input.close();
    }
}
