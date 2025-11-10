package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.LoginRegisterService;
import com.ccdita.myBookstore.processor.UserManager;
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
    private UserManager userManager;

    /**
     * Constructs a LoginRegisterUI instance with constructor injection
     * @param userInput, instance of UserInput for getting user's input
     * @param loginRegisterService, instance of LoginRegisterService
     * @param userManager, instance of UserManager
     */
    @Autowired
    public LoginRegisterUI(UserInput userInput, LoginRegisterService loginRegisterService, UserManager userManager) {
        this.userInput = userInput;
        this.loginRegisterService = loginRegisterService;
        this.userManager = userManager;
    }

    /**
     * Logs the user in
     * @param scanner, Scanner object for user input
     * @return the User that is logged in
     */
    public User loginUser(Scanner scanner) {
        User loggedInUser = null;
        while (loggedInUser == null) {
            // Prompt user for username and password
            String username = userInput.getUserString("Username:", scanner);
            String password = userInput.getUserString("Password:", scanner);
            // Check if the given credentials are correct
            boolean credentialsMatch = loginRegisterService.checkCredentials(username, password);
            if (credentialsMatch) {
                loggedInUser = userManager.findUserByUsername(username);
            } else {
                System.out.println("Wrong username and/or password. Please try again.");
            }
        }
        return loggedInUser;
    }

    /**
     * Registers the user
     * @param scanner, Scanner object for user input
     * @return true if the user is successfully registered, otherwise false
     */
    public boolean registerUser(Scanner scanner) {
        boolean isUserRegistered = false;
        while (!isUserRegistered) {
            // Prompt user for username and password
            String username = userInput.getUserString("Username:", scanner);
            String password = userInput.getUserString("Password:", scanner);
            // Check if a user with the given username exists
            boolean userExists = loginRegisterService.checkUserExists(username);
            // If a user with the username exists, re-prompt the user until they enter a username that is available
            if (userExists) {
                System.out.println("Username " + username + " is taken. Please try again.");
            } else {
                // If the username is available, register the account
                loginRegisterService.registerAccount(username, password);
                isUserRegistered = true;
                System.out.println("Your account has been registered! Please log in with your new account.");
            }
        }
        return isUserRegistered;
    }
}
