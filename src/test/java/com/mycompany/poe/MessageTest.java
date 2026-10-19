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
public class MessageTest {
    
    // ===== RECIPIENT TESTS =====
    @Test
    public void testCheckRecipientCell_Success() {
        Message m = new Message(0, "+27789898989", "Hi there");
        String result = m.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    @Test
    public void testCheckRecipientCell_Fail_NoPlus() {
        Message m = new Message(0, "2789898989", "Hi there");
        String result = m.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted"));
    }

    @Test
    public void testCheckRecipientCell_Fail_TooLong() {
        Message m = new Message(0, "+2778989898912345", "Hi there");
        String result = m.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted"));
    }

    // ===== MESSAGE LENGTH TESTS =====
    @Test
    public void testCheckMessageLength_Success() {
        Message m = new Message(0, "+27789898989", "Hello world");
        assertEquals("Message ready to send.", m.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_Fail_Over250() {
        // create 251 character message
        String longMsg = "a".repeat(251);
        Message m = new Message(0, "+27789898989", longMsg);
        String result = m.checkMessageLength();
        assertTrue(result.contains("exceeds 250"));
        assertTrue(result.contains("by 1"));
    }

    @Test
    public void testCheckMessageLength_Exactly250() {
        String exactMsg = "a".repeat(250);
        Message m = new Message(0, "+27789898989", exactMsg);
        assertEquals("Message ready to send.", m.checkMessageLength());
    }

    // ===== MESSAGE ID TESTS =====
    @Test
    public void testCreateMessageID_Length() {
        Message m = new Message(1, "+27789898989", "Test");
        assertEquals(10, m.messageId.length());
        assertTrue(m.checkMessageID());
    }

    @Test
    public void testCreateMessageID_IsNumeric() {
        Message m = new Message(1, "+27789898989", "Test");
        // ID should only contain digits
        assertTrue(m.messageId.matches("\\d{10}"));
    }

    // ===== MESSAGE HASH TESTS =====
    @Test
    public void testCreateMessageHash_Format() {
        Message m = new Message(0, "+27789898989", "Hi Mike how are you");
        String hash = m.createMessageHash();
        // Format should be 00:0:HIMIKE or 00:0:HIYOU - uppercase, contains : :
        System.out.println("Generated Hash: " + hash);
        assertTrue(hash.contains(":"));
        assertTrue(hash.equals(hash.toUpperCase())); // must be uppercase
    }

    @Test
    public void testCreateMessageHash_FirstAndLastWord() {
        Message m = new Message(1, "+27789898989", "Hello world again");
        String hash = m.createMessageHash();
        // Should contain HELLO and AGAIN
        assertTrue(hash.contains("HELLO"));
        assertTrue(hash.contains("AGAIN"));
    }

    // ===== SENT MESSAGE TESTS =====
    @Test
    public void testSentMessage_Send() {
        Message.totalSent = 0; // reset
        Message.sentMessages = "";
        Message m = new Message(0, "+27789898989", "Test send");
        String result = m.sentMessage(1);
        assertEquals("Message successfully sent.", result);
        assertEquals(1, Message.returnTotalMessages());
    }

    @Test
    public void testSentMessage_Disregard() {
        Message m = new Message(0, "+27789898989", "Test disregard");
        String result = m.sentMessage(2);
        assertEquals("Press 0 to delete the message.", result);
    }

    @Test
    public void testSentMessage_Store() {
        Message m = new Message(0, "+27789898989", "Test store");
        String result = m.sentMessage(3);
        assertEquals("Message successfully stored.", result);
    }

    @Test
    public void testReturnTotalMessages() {
        Message.totalSent = 0;
        Message.sentMessages = "";
        Message m1 = new Message(0, "+27789898989", "One");
        Message m2 = new Message(1, "+27789898989", "Two");
        messa1.sentMessage(1);
        m2.sentMessage(1);
        assertEquals(2, Message.returnTotalMessages());
    }

    @Test
    public void testGetDetails_ContainsAll() {
        Message m = new Message(0, "+27789898989", "Hello there");
        String details = m.getDetails();
        assertTrue(details.contains("Message ID:"));
        assertTrue(details.contains("Message Hash:"));
        assertTrue(details.contains("Recipient:"));
        assertTrue(details.contains("Message:"));
        assertTrue(details.contains("+27789898989"));
    }
}
   
   


    
