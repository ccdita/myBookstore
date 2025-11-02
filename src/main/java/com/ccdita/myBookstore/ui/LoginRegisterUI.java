package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.processor.LoginRegisterService;
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
    private LoginRegisterService loginRegisterService;

    /**
     * Constructs a LoginRegisterUI instance with constructor injection
     * @param userInput, instance of UserInput for getting user's input
     * @param loginRegisterService, instance of LoginRegisterService
     */
    @Autowired
    public LoginRegisterUI(UserInput userInput, LoginRegisterService loginRegisterService) {
        this.userInput = userInput;
        this.loginRegisterService = loginRegisterService;
    }

    /**
     * Logs the user in
     * @param scanner, Scanner object for user input
     * @return true if the user is successfully logged in, otherwise false
     */
    public boolean loginUser(Scanner scanner) {
        // Prompt user for username and password
        String username = userInput.getUserString("Username:", scanner);
        String password = userInput.getUserString("Password:", scanner);
        // Check if the given credentials are correct
        // Return true if the user has entered the correct username and password, otherwise false
        return loginRegisterService.checkCredentials(username, password);
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
