package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implements the UserDAO interface
 */
@Repository // Indicates that this class handles data persistence, retrieval, and manipulation with a data source
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    /**
     * Constructs a UserDAOImpl object
     * Auto-injects an EntityManager implementation into the entityManager field
     * @param entityManager, an intermediary between Java objects and the mySQL database
     */
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persists the given User object to the "user" mySQL table
     * @param user to persist
     */
    @Override
    @Transactional // Atomic operation; modifies the database
    public void save(User user) {
        entityManager.persist(user);
    }
}
