package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implements the BookDAO interface
 */
@Repository // Indicates that this class handles data persistence, retrieval, and manipulation with a data source
public class BookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    /**
     * Constructs a BookDAOImpl object
     * Auto-injects an EntityManager implementation into the entityManager field
     * @param entityManager, an intermediary between Java objects and the mySQL database
     */
    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persists the given Book object to the "book" mySQL table
     * @param book to persist
     */
    @Override
    @Transactional // Atomic operation; modifies the database
    public void save(Book book) {
        entityManager.persist(book);
    }
}
