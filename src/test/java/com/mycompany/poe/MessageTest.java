/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
    public MessageTest() {
    
}  
     @Test
    public void messageLengthSuccess(String message1) {
          Message message;
        message = new Message(0, "+27718693002", message1);
        assertEquals("Message ready to send.", message.checkMessageLength());
    }
    @Test
    public void messageLengthFailure() {
        String longText = "a".repeat(260);
        Message message;
               message  = new Message(0, "+27718693002", longText);
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", message.checkMessageLength());
    }
    @Test
    public void recipientSuccess(String message1) {
        Message message;
                message = new Message(0, "+27718693002", message1);
        assertEquals("Cell phone number successfully captured.", message.checkRecipientCell());
    }
    @Test
    public void recipientFailure(String message2) {
        Message message;
        message = new Message(1, "08575975889", message2);
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                message.checkRecipientCell());
    }
    @Test
    public void messageIdIsTenCharacters(String message1) {
        Message message;
         message = new Message(0, "+27718693002", message1);
        assertEquals(10, message.messageId.length());
        assertTrue(message.checkMessageID());
    }
    @Test
    public void messageHashFormat(String message1) {
            Message message;
        message = new Message(0, "+27718693002", message1);
        String start = message.messageId.substring(0, 2) + ":0:";
        assertTrue(message.messageHash.startsWith(start));
        assertTrue(message.messageHash.endsWith("HITONIGHT"));
    }
     @Test
    public void sendMessageAddsToTotal(String message1) {
        Message message;
       message = new Message(0, "+27718693002", message1);
        assertEquals("Message successfully sent", message.sentMessage(1));
        assertEquals(1, message.returnTotalMessages());
    }
@Test
    public void discardMessageDoesNotAddToTotal() {
        Message message;
        Message message1 = new message(0, "+27718693002", message1);
        Message message2 = new Message(1, "08575975889", message2);
        message1.sentMessage(1);
        assertEquals("Press 0 to delete the message", message2.sentMessage(2));
        assertEquals(1, Message.returnTotalMessages());
    }
       @Test
    public void storeMessageText(String message1) {
        Message message;
        message = new Message(0, "+27718693002", message1);
        assertEquals("Message successfully stored", message.sentMessage(3));
    }
      @Test
    public void printMessagesContainsSentMessage(String message1) {
        Message message;
        message = new Message(0, "+27718693002", message1);
        message.sentMessage(1);
        assertTrue(Message.printMessages().contains(message1));
    }

    @Test
    public void storedMessageIsWrittenToJsonFile(String message1) throws IOException {
        Message message = new Message(0, "+27718693002", message1);
        message.sentMessage(3);
        String file = Files.readString(Paths.get("messages.json"));
        assertTrue(file.contains("\"messageHash\":\"" + message.messageHash + "\""));
        assertTrue(file.contains("\"recipient\":\"+27718693002\""));
    }

    private static class Message {

        private static Object printMessages() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static short returnTotalMessages() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String messageHash;
        
        private String printMessage;
        public Message(int par, String string, String longText) {
        }

        private Message(int i, String string, Message message2) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void sentMessage(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object checkMessageLength() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object checkRecipientCell() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean checkMessageID() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private class messageId {

            private static short length() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            private static String substring(int i, int i0) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            public messageId() {
            }
        }
    }
}


   


    
