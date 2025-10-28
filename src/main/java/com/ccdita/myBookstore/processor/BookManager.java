package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.BookDAO;
import com.ccdita.myBookstore.datamanagement.entities.Book;
import org.springframework.stereotype.Component;

/**
 * Manages book-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Component
public class BookManager {

    /**
     * Creates a new book and persists the associated Book object to the database
     * @param bookDAO, DAO implementation for persisting given data
     * @param title of book
     * @param author of book
     * @param genre of book
     */
    public void addBook(BookDAO bookDAO, String title, String author, String genre) {
        // Instantiate a new Book object
        Book newBook = new Book(title, author, genre);
        // Persist the Book object to the database
        bookDAO.save(newBook);
    }
}
