package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.UserDAO;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manages user-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Component
public class UserManager {

    private UserDAO userDAO;

    /**
     * Constructs a UserManager instance with constructor injection
     * @param userDAO, implementation of the UserDAO interface
     */
    @Autowired
    public UserManager(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Creates a new user and persists the associated User object to the database
     * @param username of user
     * @param password of user
     */
    public void createUser(String username, String password) {
        // Instantiate a new User object
        User newUser = new User(username, password);
        // Persist the User object to the database
        userDAO.save(newUser);
    }

    /**
     * Finds the user based on the given username
     * @param username to query
     * @return User object, null if there are no/multiple users found
     */
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
