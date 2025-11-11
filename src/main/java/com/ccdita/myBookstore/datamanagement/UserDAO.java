package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.User;

/**
 * Data Access Object with CRUD methods to be implemented by UserDAOImpl
 */
public interface UserDAO {

    // Persist data of the given User object in the mySQL "user" table
    void save(User user);

    // Delete the user from the database
    void delete(User user);

    // Find the user based on the given username
    User findByUsername(String username);

    // Find the user based on the given ID
    User findById(int id);

    // Update the given User object
    void update(User user);
}
