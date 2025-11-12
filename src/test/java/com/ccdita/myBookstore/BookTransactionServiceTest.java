package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.BookService;
import com.ccdita.myBookstore.processor.BookTransactionService;
import com.ccdita.myBookstore.processor.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class for BookTransactionService
 */
public class BookTransactionServiceTest {

    @Mock // Create a mock object of BookService
    private BookService mockedBookService;
    @Mock // Create a mock object of UserService
    private UserService mockedUserService;

    @InjectMocks // Inject the mocks into BookTransactionService
    private BookTransactionService bookTransactionService;

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
        // Specify return value of mock BookService object
        when(mockedBookService.addBook(title, author, genre)).thenReturn(bookToSell);
        Book bookSold = bookTransactionService.sellBook(user, title, author, genre);
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

        Book bookBought = bookTransactionService.buyBook(userOption, user, booksForSale);
        assertEquals(bookToBuy, bookBought, "buyBook() does not purchase the correct book.");
    }
}
