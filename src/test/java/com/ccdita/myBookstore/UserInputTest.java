package com.ccdita.myBookstore;

import com.ccdita.myBookstore.util.UserInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    UserInput userInput = new UserInput();

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
}
