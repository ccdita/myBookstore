package com.ccdita.myBookstore;

import com.ccdita.myBookstore.util.UserInput;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    private UserInput userInput = new UserInput();

    @Test
    public void testGetUserOptionValidInput() {
        // Test that getUserOption() returns the user's input if it is a valid option
        String testInput = "1";
        Scanner scanner = new Scanner(testInput);
        assertEquals(1, userInput.getUserOption(3, scanner));
        scanner.close();

        testInput = "4";
        scanner = new Scanner(testInput);
        assertEquals(4, userInput.getUserOption(7, scanner));
        scanner.close();

        testInput = "7";
        scanner = new Scanner(testInput);
        assertEquals(7, userInput.getUserOption(7, scanner));
        scanner.close();
    }

    @Test
    public void testGetUserOptionWithWhitespace() {
        // Test that getUserOption() returns the cleaned input if it contains leading/trailing whitespace
        String testInput = "1  ";
        Scanner scanner = new Scanner(testInput);
        assertEquals(1, userInput.getUserOption(3, scanner));
        scanner.close();

        testInput = "     4";
        scanner = new Scanner(testInput);
        assertEquals(4, userInput.getUserOption(7, scanner));
        scanner.close();

        testInput = "  7       ";
        scanner = new Scanner(testInput);
        assertEquals(7, userInput.getUserOption(7, scanner));
        scanner.close();
    }

    @Test
    public void testGetUserStringValidInput() {
        // Test that getUserString() returns the user's input if it is a valid (non-empty String)
        String testInput = "testUser";
        Scanner scanner = new Scanner(testInput);
        assertEquals("testUser", userInput.getUserString("Username:", scanner));
        scanner.close();

        testInput = "testPassword";
        scanner = new Scanner(testInput);
        assertEquals("testPassword", userInput.getUserString("Password:", scanner));
        scanner.close();
    }

    @Test
    public void testGetUserStringInputWithWhitespace() {
        // Test that getUserString() returns the user's input if it contains whitespace
        String testInput = "testInput      ";
        Scanner scanner = new Scanner(testInput);
        assertEquals("testInput", userInput.getUserString("Prompt:", scanner));
        scanner.close();

        testInput = "    testInput";
        scanner = new Scanner(testInput);
        assertEquals("testInput", userInput.getUserString("Prompt:", scanner));
        scanner.close();

        testInput = "    testInput   ";
        scanner = new Scanner(testInput);
        assertEquals("testInput", userInput.getUserString("Prompt:", scanner));
        scanner.close();
    }
}
