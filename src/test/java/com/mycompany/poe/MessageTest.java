/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.poe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

public class MessageTest {

    // Reset arrays before every test
    @BeforeEach
    public void setUp() {

        message.totalSent = 0;

        message.sentMessages.clear();
        message.disregardedMessages.clear();
        message.storedMessages.clear();
        message.messageHashes.clear();
        message.messageIDs.clear();
        message.recipients.clear();
        message.senders.clear();
        message.fullMessages.clear();
        message.flags.clear();

        message.storedJson = "";
    }

    // ===== RECIPIENT TESTS =====

    @Test
    public void testCheckRecipientCell_Success() {

        message m = new message(0, "+27789898989", "Hi there");

        String result = m.checkRecipientCell();

        assertEquals("Cell phone number successfully captured.", result);
    }

    @Test
    public void testCheckRecipientCell_Fail_NoPlus() {

        message m = new message(0, "2789898989", "Hi there");

        String result = m.checkRecipientCell();

        assertTrue(result.contains("incorrectly formatted"));
    }

    @Test
    public void testCheckRecipientCell_Fail_TooLong() {

        message m = new message(0, "+2778989898912345", "Hi there");

        String result = m.checkRecipientCell();

        assertTrue(result.contains("incorrectly formatted"));
    }

    // ===== MESSAGE LENGTH TESTS =====

    @Test
    public void testCheckMessageLength_Success() {

        message m = new message(0, "+27789898989", "Hello world");

        assertEquals("Message ready to send.", m.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_Fail_Over250() {

        String longMsg = "a".repeat(251);

        message m = new message(0, "+27789898989", longMsg);

        String result = m.checkMessageLength();

        assertTrue(result.contains("exceeds 250"));
        assertTrue(result.contains("by 1"));
    }

    @Test
    public void testCheckMessageLength_Exactly250() {

        String exactMsg = "a".repeat(250);

        message m = new message(0, "+27789898989", exactMsg);

        assertEquals("Message ready to send.", m.checkMessageLength());
    }

    // ===== MESSAGE ID TESTS =====

    @Test
    public void testCreateMessageID_Length() {

        message m = new message(1, "+27789898989", "Test");

        assertEquals(10, m.getMessageId().length());

        assertTrue(m.checkMessageID());
    }

    @Test
    public void testCreateMessageID_IsNumeric() {

        message m = new message(1, "+27789898989", "Test");

        assertTrue(m.getMessageId().matches("\\d{10}"));
    }

    // ===== MESSAGE HASH TESTS =====

    @Test
    public void testCreateMessageHash_Format() {

        message m = new message(0, "+27789898989", "Hi Mike how are you");

        String hash = m.createMessageHash();

        System.out.println("Generated Hash: " + hash);

        assertTrue(hash.contains(":"));
        assertEquals(hash.toUpperCase(), hash);
    }

    @Test
    public void testCreateMessageHash_FirstAndLastWord() {

        message m = new message(1, "+27789898989", "Hello world again");

        String hash = m.createMessageHash();

        assertTrue(hash.contains("HELLO"));
        assertTrue(hash.contains("AGAIN"));
    }

    // ===== SENT MESSAGE TESTS =====

    @Test
    public void testSentMessage_Send() {

        message m = new message(0, "+27789898989", "Test send");

        String result = m.sentMessage(1);

        assertEquals("Message successfully sent.", result);

        assertEquals(1, message.returnTotalMessages());
    }

    @Test
    public void testSentMessage_Disregard() {

        message m = new message(0, "+27789898989", "Test disregard");

        String result = m.sentMessage(2);

        assertEquals("Message successfully disregarded.", result);
    }

    @Test
    public void testSentMessage_Store() {

        message m = new message(0, "+27789898989", "Test store");

        String result = m.sentMessage(3);

        assertEquals("Message successfully stored.", result);

        assertEquals(1, message.storedMessages.size());
    }

    // ===== TOTAL MESSAGES TEST =====

    @Test
    public void testReturnTotalMessages() {

        message m1 = new message(0, "+27789898989", "One");

        message m2 = new message(1, "+27789898989", "Two");

        m1.sentMessage(1);
        m2.sentMessage(1);

        assertEquals(2, message.returnTotalMessages());
    }

    // ===== GET DETAILS TEST =====

    @Test
    public void testGetDetails_ContainsAll() {

        message m = new message(0, "+27789898989", "Hello there");

        String details = m.getDetails();

        assertTrue(details.contains("Message ID:"));
        assertTrue(details.contains("Message Hash:"));
        assertTrue(details.contains("Recipient:"));
        assertTrue(details.contains("Message:"));
        assertTrue(details.contains("+27789898989"));
    }
}
