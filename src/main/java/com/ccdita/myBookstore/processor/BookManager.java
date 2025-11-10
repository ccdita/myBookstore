package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.BookDAO;
import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages book-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Component
public class BookManager {

    private BookDAO bookDAO;

    /**
     * Constructs a BookManager instance with constructor injection
     * @param bookDAO, implementation of the BookDAO interface
     */
    @Autowired
    public BookManager(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * Creates a new book and persists the associated Book object to the database
     * @param title of book
     * @param author of book
     * @param genre of book
     */
    public void addBook(String title, String author, String genre) {
        // Instantiate a new Book object
        Book newBook = new Book(title, author, genre);
        // Persist the Book object to the database
        bookDAO.save(newBook);
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
     * Gets the book the user wishes to buy and updates the database with its new forSale status
     * @param userOption, the user's input for the book they would like to buy from a given list
     * @param user, the current user logged in
     * @param booksForSale, the list of books for sale
     * @return the purchased book, otherwise null (if the user cannot afford the book)
     */
    public Book buyBook(int userOption, User user, List<Book> booksForSale) {
        Book bookToBuy = booksForSale.get(userOption - 1); // Get the object of the book the user wants to buy
        Double remainingReaderCash = user.deductReaderCash(bookToBuy.getPrice());
        // If the user can't afford the book, return null
        if (remainingReaderCash == null) { return null; }
        // If the user can afford the book, update the user's ReaderCash and the book's forSale status
        bookToBuy.setStatus(false); // Set the book's forSale status to false
        bookDAO.update(bookToBuy); // Update the Book object, with the new status, in the database
        return bookToBuy;
    }
}
