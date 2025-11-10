package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.BookDAO;
import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for BookManager
 */
public class BookManagerTest {

    @Mock // Create a mock object of BookDAO
    private BookDAO mockedBookDAO;

    @InjectMocks // Inject the mock object into BookManager
    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mock injection
    }

    @Test
    public void testBuyBook() {
        // Test that buyBook() properly handles purchasing a book
        ArrayList<Book> booksForSale = new ArrayList<>();
        booksForSale.add(new Book("Abracadabra", "Abraham", "Action"));
        Book bookToBuy = new Book("Benelux", "Bob", "Action");
        booksForSale.add(bookToBuy);
        booksForSale.add(new Book("Catharsis", "Catherine", "Comedy"));

        int userOption = 2;

        User user = new User("testUser1", "testPassword1");

        Book bookBought = bookManager.buyBook(userOption, user, booksForSale);
        assertEquals(bookToBuy, bookBought, "buyBook() does not purchase the correct book.");
    }
}
