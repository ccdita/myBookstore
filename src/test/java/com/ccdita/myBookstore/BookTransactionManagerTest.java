package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.BookManager;
import com.ccdita.myBookstore.processor.BookTransactionManager;
import com.ccdita.myBookstore.processor.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class for BookTransactionManager
 */
public class BookTransactionManagerTest {

    @Mock // Create a mock object of BookManager
    private BookManager mockedBookManager;
    @Mock // Create a mock object of UserManager
    private UserManager mockedUserManager;

    @InjectMocks // Inject the mocks into BookTransactionManager
    private BookTransactionManager bookTransactionManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mock injection
    }

    @Test
    public void testSellBook() {
        // Test that sellBook() properly handles selling a book
        String title = "Benelux";
        String author = "Bob";
        String genre = "Action";
        Book bookToSell = new Book(title, author, genre);
        User user = new User("testUser1", "testPassword1");
        // Specify return value of mock BookManager object
        when(mockedBookManager.addBook(title, author, genre)).thenReturn(bookToSell);
        Book bookSold = bookTransactionManager.sellBook(user, title, author, genre);
        assertEquals(bookToSell, bookSold, "sellBook() does not sell the correct book.");
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

        Book bookBought = bookTransactionManager.buyBook(userOption, user, booksForSale);
        assertEquals(bookToBuy, bookBought, "buyBook() does not purchase the correct book.");
    }
}
