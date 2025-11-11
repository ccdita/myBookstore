package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private String title = "Test Title";
    private String author = "Test Author";
    private String genre = "Test";
    private Book testBook1;

    /**
     * Perform setup operations before each test method, ensuring each test method runs in a clean and isolated
     * environment
     */
    @BeforeEach
    public void setUp() {
        testBook1 = new Book(title, author, genre);
    }

    @Test
    public void testBookBasic() {
        // Test that Book() properly constructs Book objects
        testBook1 = new Book(title, author, genre);

        assertEquals(title, testBook1.getTitle(), "Title " + title + " does not match testBook1's title");
        assertEquals(author, testBook1.getAuthor(), "Author " + author + " does not match testBook1's author");
        assertEquals(genre, testBook1.getGenre(), "Genre " + genre + " does not match testBook1's genre");
        assertEquals(10.00, testBook1.getPrice(), "Price $10.00 does not match testBook1's price");
        assertTrue(testBook1.getStatus(), "testBook1's forSale status is not initialized to true");
    }

    @Test
    public void testToString() {
        // Test that toString() returns a proper String representation of a Book object
        testBook1 = new Book(title, author, genre);

        String expectedString = "Test Title by Test Author | Genre: Test | Price: $10.00";

        String testBookInfo1 = testBook1.toString();

        assertEquals(expectedString, testBookInfo1, "testBookInfo1's String representation does not match the" +
                " expected string");
    }

    @Test
    public void testEqualsIdenticalBooks() {
        // Test that equals() returns true for identical Books
        String title = "testTitle";
        String author = "testAuthor";
        String genre = "testGenre";
        Book otherBook = new Book(title, author, genre);
        Book thisBook = new Book(title, author, genre);

        boolean result = thisBook.equals(otherBook);
        assertTrue(result, "Both books are not considered equal even though they are the same book.");
    }

    @Test
    public void testEqualsNonIdenticalBooks() {
        // Test that equals() returns false for non-identical Books
        Book otherBook = new Book("testTitle", "testAuthor", "testGenre");
        Book thisBook = new Book("test", "testAuthor", "testGenre");

        boolean result = thisBook.equals(otherBook);
        assertFalse(result, "Both books are considered equal even though they are different books.");
    }
}
