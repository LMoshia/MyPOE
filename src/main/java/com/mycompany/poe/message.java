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

public class message{
 
    static int totalSent = 0;
    static String sentMessages = "";
    static String storedJson = "";

    String messageId;
    int messageNumber;
    String recipient;
    String text;
    String messageHash;

    public message(int messageNumber, String recipient, String text) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.text = text;
        this.messageId = createMessageID();
        this.messageHash = createMessageHash();
    }

    public String createMessageID() {
        Random rand = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) {
            id += rand.nextInt(10);
        }
        return id;
    }

    public boolean checkMessageID() {
        return messageId.length() == 10;
    }

    public String checkRecipientCell() {
        if (recipient == null) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        if (recipient.startsWith("+") && recipient.length() <= 13 && recipient.length() >= 10) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String checkMessageLength() {
        if (text.length() <= 250) {
            return "Message ready to send.";
        }
        int over = text.length() - 250;
        return "Message exceeds 250 characters by " + over + ", please reduce size.";
    }

    public String createMessageHash() {
        String t = text.trim();
        String first = t;
        String last = t;

        int firstSpace = t.indexOf(' ');
        int lastSpace = t.lastIndexOf(' ');

        if (firstSpace != -1) {
            first = t.substring(0, firstSpace);
            last = t.substring(lastSpace + 1);
        }

        first = first.replaceAll("[^A-Za-z0-9]", "");
        last = last.replaceAll("[^A-Za-z0-9]", "");

        String idPart = messageId.substring(0, 2);
        return (idPart + ":" + messageNumber + ":" + first + last).toUpperCase();
    }

    public String sentMessage(int choice) {
        if (choice == 1) {
            totalSent++;
            sentMessages += getDetails() + "\n\n";
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            storeMessage();
            return "Message successfully stored.";
        } else {
            return "Invalid option.";
        }
    }

    public static String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }
        return sentMessages;
    }

    public static int returnTotalMessages() {
        return totalSent;
    }

    public String getDetails() {
        return "Message ID: " + messageId + "\n"
             + "Message Hash: " + messageHash + "\n"
             + "Recipient: " + recipient + "\n"
             + "Message: " + text;
    }

    public void storeMessage() {
        String safeText = text.replace("\\", "\\\\").replace("\"", "\\\"");

        if (storedJson.length() > 0) {
            storedJson += ",\n";
        }

        storedJson += "  {\"messageId\":\"" + messageId + "\","
                + "\"messageHash\":\"" + messageHash + "\","
                + "\"recipient\":\"" + recipient + "\","
                + "\"message\":\"" + safeText + "\"}";

        try {
            FileWriter writer = new FileWriter("messages.json");
            writer.write("[\n" + storedJson + "\n]");
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not save messages.json");
        }
    }
}
