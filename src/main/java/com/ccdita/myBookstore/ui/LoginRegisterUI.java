package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Handles UI related to logging in and creating an account
 */
@Component
public class LoginRegisterUI {

    private UserInput userInput;

    /**
     * Constructs a LoginRegisterUI instance with constructor injection
     * @param userInput
     */
    @Autowired
    public LoginRegisterUI(UserInput userInput) {
        this.userInput = userInput;
    }

    /**
     * Logs the user in
     * @param scanner, Scanner object for user input
     * @return true if the user is successfully logged in, otherwise false
     */
    public boolean loginUser(Scanner scanner) {
        boolean isUserLoggedIn = false; // Initialize user log-in status to false
        // Prompt user for username and password
        String username = userInput.getUserString("Username:", scanner);
        String password = userInput.getUserString("Password:", scanner);
        return isUserLoggedIn;
    }

    /**
     * Registers the user
     * @param scanner, Scanner object for user input
     * @return true if the user is successfully registered, otherwise false
     */
    public boolean registerUser(Scanner scanner) {
        boolean isUserRegistered = false;
        // Prompt user for username and password
        String username = userInput.getUserString("Username:", scanner);
        String password = userInput.getUserString("Password:", scanner);
        return isUserRegistered;
    }
}
