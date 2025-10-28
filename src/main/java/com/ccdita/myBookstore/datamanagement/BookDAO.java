package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.Book;

/**
 * Data Access Object with CRUD methods to be implemented by BookDAOImpl
 */
public interface BookDAO {

    // Persist data of the given Book object in the "book" mySQL table
    void save(Book book);
}
