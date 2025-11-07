package com.ccdita.myBookstore.datamanagement;

import com.ccdita.myBookstore.datamanagement.entities.Book;

import java.util.List;

/**
 * Data Access Object with CRUD methods to be implemented by BookDAOImpl
 */
public interface BookDAO {

    // Persist data of the given Book object in the "book" mySQL table
    void save(Book book);

    // Delete the given book from the mySQL table
    void delete(Book book);

    // Finds all the books with the given sale status
    List<Book> findByStatus(boolean status);

    // Update the given Book object
    void update(Book book);
}
