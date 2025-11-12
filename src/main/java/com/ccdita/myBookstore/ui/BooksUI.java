package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.BookManager;
import com.ccdita.myBookstore.processor.TransactionManager;
import com.ccdita.myBookstore.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Handles UI related to displaying, buying, and selling books
 */
@Component
public class BooksUI {

    private UserInput userInput;
    private BookManager bookManager;
    private TransactionManager transactionManager;

    /**
     * Constructs a BooksUI instance with constructor injection
     * @param userInput, instance of UserInput for getting user's input
     * @param bookManager, instance of BookManager
     * @param transactionManager, instance of TransactionManager
     */
    @Autowired
    public BooksUI (UserInput userInput, BookManager bookManager, TransactionManager transactionManager) {
        this.userInput = userInput;
        this.bookManager = bookManager;
        this.transactionManager = transactionManager;
    }

    /**
     * Handles UI related to buying a book
     * @param scanner, Scanner object for user input
     * @param user, the user currently logged in
     */
    public void buyBook(Scanner scanner, User user) {
        List<Book> booksForSale = bookManager.findBooksByStatus(true); // Get a list of all the books for sale
        displayBooksForSale(booksForSale); // Display the books for sale
        if (booksForSale.isEmpty()) { return; } // Exit the method if there are no books for sale

        Book bookToBuy = null;
        // Have the user choose a book to purchase, and re-prompt them if they cannot afford the book
        while (bookToBuy == null) {
            // Ask the user which book they would like to buy
            int userOption = userInput.getUserOption(booksForSale.size(), scanner);
            if (userOption == 0) { return; } // Return to user menu if user's input is 0
            bookToBuy = transactionManager.buyBook(userOption, user, booksForSale); // Buy the chosen book
            if (bookToBuy == null) {
                System.out.println("You do not have enough ReaderCash to buy this book. Please choose another book " +
                        "or enter '0' to exit.");
            }
        }
        System.out.println("You have purchased: " + bookToBuy.getTitle() + " by " + bookToBuy.getAuthor());
    }

    /**
     * Displays books for sale
     * @param booksForSale, a list of books for sale
     */
    private void displayBooksForSale(List<Book> booksForSale) {
        if (booksForSale.isEmpty()) {
            System.out.println("There are no books for sale at this time.");
        }
        int optionNumber;
        for (int i = 0; i < booksForSale.size(); i++) {
            optionNumber = i + 1;
            System.out.println(optionNumber + ". " + booksForSale.get(i).toString());
        }
    }

    /**
     * Handles UI related to selling a book
     * @param scanner, Scanner object for user input
     * @param user, the user currently logged in
     */
    public void sellBook(Scanner scanner, User user) {
        System.out.println("Please enter the following information. Enter 'exit' at any time to exit.");
        String title = userInput.getUserString("Title: ", scanner);
        if (title.equals("exit")) { return; }
        String author = userInput.getUserString("Author: ", scanner);
        if (author.equals("exit")) { return; }
        String genre = userInput.getUserString("Genre: ", scanner);
        if (genre.equals("exit")) { return; }

        Book bookToSell = transactionManager.sellBook(user, title, author, genre);
        System.out.println(bookToSell.getTitle() + " by " + bookToSell.getAuthor() + " is now for sale. Thank you!");
    }
}
