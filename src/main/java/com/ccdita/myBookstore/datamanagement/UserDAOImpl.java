package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
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

    /**
     * Deletes the given User object from the table
     * @param user
     */
    @Override
    @Transactional
    public void delete(User user) {
        entityManager.remove(user);
    }

    /**
     * Finds the user based on the given username
     * @param username to query
     * @return User object, null if there are no/multiple users found
     */
    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch(NoResultException | NonUniqueResultException e) {
            return user;
        }
        return user;
    }

    /**
     * Finds the user based on the given ID
     * @param id to query
     * @return User object, null if there is no user with the given ID
     */
    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }
}
