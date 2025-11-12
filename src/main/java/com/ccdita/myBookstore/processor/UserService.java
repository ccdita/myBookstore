package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.UserDAO;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Manages user-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Service
public class UserService {

    private UserDAO userDAO;

    /**
     * Constructs a UserService instance with constructor injection
     * @param userDAO, implementation of the UserDAO interface
     */
    @Autowired
    public UserService(UserDAO userDAO) {
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

    /**
     * Adds the given amount to the user's ReaderCash and updates the given user in the "user" table
     * @param user to update
     */
    public void addReaderCash(User user, Double amountToAdd) {
        user.addReaderCash(amountToAdd);
        userDAO.update(user);
    }

    /**
     * Deducts the given amount from the user's ReaderCash and updates the given user in the "user" table
     * @param user to update
     * @returns the updated ReaderCash amount, otherwise null if the transaction cannot be made (amountToDeduct is
     * greater than user's ReaderCash amount)
     */
    public Double deductReaderCash(User user, Double amountToDeduct) {
        Double remainingReaderCash = user.deductReaderCash(amountToDeduct);
        userDAO.update(user);
        return remainingReaderCash;
    }
}
