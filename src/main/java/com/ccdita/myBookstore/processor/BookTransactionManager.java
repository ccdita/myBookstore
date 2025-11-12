package com.ccdita.myBookstore.processor;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Manages transaction-related CRUD operations
 * Abstracts away specific implementations with communicating with the mySQL database
 */
@Component
public class BookTransactionManager {

    private BookManager bookManager;
    private UserManager userManager;

    @Autowired
    public BookTransactionManager(BookManager bookManager, UserManager userManager) {
        this.bookManager = bookManager;
        this.userManager = userManager;
    }

    /**
     * Sells a book with the given information and updates the database
     * @param user, the user currently logged in
     * @param title of book
     * @param author of book
     * @param genre of book
     * @returns the sold book
     */
    public Book sellBook(User user, String title, String author, String genre) {
        Book bookToSell = bookManager.addBook(title, author, genre);
        userManager.addReaderCash(user, bookToSell.getPrice());
        return bookToSell;
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
        Double remainingReaderCash = userManager.deductReaderCash(user, bookToBuy.getPrice());
        // If the user can't afford the book, return null
        if (remainingReaderCash == null) { return null; }
        // If the user can afford the book, update the user's ReaderCash and the book's forSale status
        bookManager.placeBookForSale(bookToBuy);
        return bookToBuy;
    }
}
