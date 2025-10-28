package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.UserDAO;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.stereotype.Component;

/**
 * Manages user-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Component
public class UserManager {

    /**
     * Creates a new user and persists the associated User object to the database
     * @param userDAO, DAO implementation for persisting given data
     * @param username of user
     * @param password of user
     */
    public void createUser(UserDAO userDAO, String username, String password) {
        // Instantiate a new User object
        User newUser = new User(username, password);
        // Persist the User object to the database
        userDAO.save(newUser);
    }
}
