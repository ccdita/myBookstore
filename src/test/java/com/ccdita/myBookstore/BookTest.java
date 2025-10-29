package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    @Test
    public void testBookBasic() {
        // Test that Book() properly constructs Book objects
        String title = "Test Title";
        String author = "Test Author";
        String genre = "Test";

        Book testBook1 = new Book(title, author, genre);

        assertEquals(title, testBook1.getTitle(), "Title " + title + " does not match testBook1's title");
        assertEquals(author, testBook1.getAuthor(), "Author " + author + " does not match testBook1's author");
        assertEquals(genre, testBook1.getGenre(), "Genre " + genre + " does not match testBook1's genre");
        assertEquals(10.00, testBook1.getPrice(), "Price $10.00 does not match testBook1's price");
        assertTrue(testBook1.getStatus(), "testBook1's forSale status is not initialized to true");
    }

    @Test
    public void testToString() {
        // Test that toString() returns a proper String representation of a Book object
        String title = "Test Title";
        String author = "Test Author";
        String genre = "Test";

        Book testBook1 = new Book(title, author, genre);

        String expectedString = "Book:\n" +
                "Title: Test Title\n" +
                "Author: Test Author\n" +
                "Genre: Test\n" +
                "Price: $10.00\n" +
                "For Sale? true";

        String testBookInfo1 = testBook1.toString();

        assertEquals(expectedString, testBookInfo1, "testBookInfo1's String representation does not match the" +
                " expected string");
    }
}
