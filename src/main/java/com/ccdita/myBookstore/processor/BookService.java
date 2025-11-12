package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.BookDAO;
import com.ccdita.myBookstore.datamanagement.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Manages book-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Service
public class BookService {

    private BookDAO bookDAO;

    /**
     * Constructs a BookService instance with constructor injection
     * @param bookDAO, implementation of the BookDAO interface
     */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * Creates a new book and persists the associated Book object to the database
     * @param title of book
     * @param author of book
     * @param genre of book
     * @return the new book
     */
    public Book addBook(String title, String author, String genre) {
        // Instantiate a new Book object
        Book newBook = new Book(title, author, genre);
        // Persist the Book object to the database
        bookDAO.save(newBook);
        return newBook;
    }

    /**
     * Finds and returns a list of all books with the given forSale status
     * @param status of book; true if it is for sale, false if it is sold
     * @return a list of books with the given status
     */
    public List<Book> findBooksByStatus(boolean status) {
        return bookDAO.findByStatus(status);
    }

    /**
     * Sets the book's forSale status to true and updates the database
     * @param bookToBuy, book to update
     */
    public void placeBookForSale(Book bookToBuy) {
        bookToBuy.setStatus(false); // Set the book's forSale status to false
        bookDAO.update(bookToBuy); // Update the Book object, with the new status, in the database
    }
}
