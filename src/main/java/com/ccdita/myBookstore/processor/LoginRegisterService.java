package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles business logic for logging in and creating an account
 */
@Service
public class LoginRegisterService {

    private UserService userService;

    /**
     * Constructs a LoginRegisterService instance with constructor injection
     * @param userService, UserService instance for interacting with the database
     */
    @Autowired
    public LoginRegisterService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Checks if the given username and password are correct for an existing user
     * @param username of user
     * @param password of user
     * @return true if the credentials are correct, otherwise false
     */
    public boolean checkCredentials(String username, String password) {
        boolean credentialsMatch = false; // Initialize to false before checks
        // Find the user in the database. If the user exists, check if the passwords match
        User user = userService.findUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                credentialsMatch = true;
            }
        }
        return credentialsMatch;
    }

    /**
     * Checks if a user with the given username exists
     * @param username to check
     * @return true if a user exists with the given username, otherwise false
     */
    public boolean checkUserExists(String username) {
        boolean userExists = false;
        User user = userService.findUserByUsername(username);
        if (user != null) { // If a user exists, return true
            userExists = true;
        }
        return userExists;
    }

    /**
     * Calls UserService's creatUser() method to create a new User object/account and save it to the database
     * @param username of new account
     * @param password of new account
     */
    public void registerAccount(String username, String password) {
        userService.createUser(username, password);
    }
}
