package com.ccdita.myBookstore.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Gets user input
 */
@Component
public class UserInput {

    /**
     * Gets the user's input for a given list of options
     * Useful for choosing from a menu of options
     * @param numOptions, number of options the user can choose from
     * @param scanner, Scanner object for user input
     * @return user's input
     */
    public int getUserOption(int numOptions, Scanner scanner) {
        System.out.println("Select an option:"); // Display the prompt
        // Initialize the following variables since there is no input yet
        String userInput = "";
        int intUserInput = -1; // Parse userInput into integer type
        boolean isValidOption = false;

        // Keep prompting the user until they enter a valid option
        while (!isValidOption) {
            // Re-prompt the user if their input cannot be cast into an integer
            userInput = scanner.nextLine().strip();
            try {
                intUserInput = Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Please enter an integer input.");
                continue;
            }
            // If the user's input can be cast into an integer, check that it is a valid option
            if (intUserInput < 1 || intUserInput > numOptions) {
                System.out.println("Please enter a valid option from the list.");
                continue;
            }
            isValidOption = true; // If the user's input passes all checks
        }
        return intUserInput;
    }

    /**
     * Gets a String input from the user
     * @param prompt to ask the user
     * @param scanner, Scanner object for user input
     * @return user's String input
     */
    public String getUserString(String prompt, Scanner scanner) {
        String userInput = "";
        do { // Prompt the user until they enter non-empty input
            System.out.println(prompt);
            userInput = scanner.nextLine().strip();
        } while(userInput.isEmpty());
        return userInput;
    }
}
