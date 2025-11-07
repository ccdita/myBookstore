package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.BookDAOImpl;
import com.ccdita.myBookstore.datamanagement.entities.Book;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for BookDAOImpl Repository class
 */
@DataJpaTest // Scan for entity classes and JPA repository classes
@Import(BookDAOImpl.class) // Import BookDAOImpl repository class
public class BookDAOImplTest {

    @Autowired
    private EntityManager entityManager; // Auto-inject EntityManager
    @Autowired
    private BookDAOImpl bookDAOImpl; // Auto-inject BookDAOImpl
    private Book testBook;

    /**
     * Perform setup operations before each test method, ensuring each test method runs in a clean and isolated
     * environment
     */
    @BeforeEach
    public void setUp() {
        testBook = new Book("testTitle", "testAuthor", "testGenre");
        bookDAOImpl.save(testBook);
    }

    /**
     * Perform teardown operations before each test method
     */
    @AfterEach
    public void tearDown() {
        entityManager.remove(testBook);
    }

    @Test
    public void testSaveBook() {
        // Test that save() properly saves the given book to the database
        int testId = testBook.getId();
        Book savedBook = entityManager.find(Book.class, testId);
        assertEquals(testBook, savedBook, "save() does not properly save the given Book to the database.");
        assertEquals(testBook.getGenre(), savedBook.getGenre(), "save() does not properly save " +
                "the given Book to the database.");
        assertEquals(testBook.getPrice(), savedBook.getPrice(), "save() does not properly save the given " +
                "Book to the database.");
        assertEquals(testBook.getStatus(), savedBook.getStatus(), "save() does not properly save the " +
                "given Book to the database.");
    }

    @Test
    public void testDeleteBook() {
        // Test that delete() properly deletes the given book from the database
        Book testBookToDelete = new Book("testTitleToDelete", "testAuthorToDelete",
                "testGenreToDelete");
        // Test that the book is not yet in the database
        assertNull(entityManager.find(Book.class, testBookToDelete.getId()), "Book is found in database " +
                "when it should not have yet been saved.");

        // Persist the book to the database
        entityManager.persist(testBookToDelete);
        // Test that the book is in the database
        assertNotNull(entityManager.find(Book.class, testBookToDelete.getId()));

        bookDAOImpl.delete(testBookToDelete); // Remove the book from the database

        // Test that the book is no longer in the database
        assertNull(entityManager.find(Book.class, testBookToDelete.getId()), "Book is found in database " +
                "it should have been removed.");
    }

    @Test
    public void testFindByStatus() {
        Book testBook2 = new Book("Abracadabra", "Arthur", "Action");
        Book testBook3 = new Book("Boring!", "Ben", "Action");
        Book testBook4 = new Book("Cats and Dogs", "Chris", "Comedy");
        Book testBook5 = new Book("Donkeys", "Daryll", "Comedy");
        // Set two books' forSale statuses to false
        testBook2.setStatus(false);
        testBook3.setStatus(false);
        // Add books to the database
        entityManager.persist(testBook2);
        entityManager.persist(testBook3);
        entityManager.persist(testBook4);
        entityManager.persist(testBook5);
        // Find books for sale and books sold
        List<Book> booksForSale = bookDAOImpl.findByStatus(true);
        List<Book> booksSold = bookDAOImpl.findByStatus(false);

        assertEquals(3, booksForSale.size(), "List of books for sale is not correct.");
        assertEquals(2, booksSold.size(), "List of books sold is not correct.");
        assertEquals(testBook, booksForSale.get(0), "List of books for sale is not correct.");
        assertEquals(testBook4, booksForSale.get(1), "List of books for sale is not correct.");
        assertEquals(testBook5, booksForSale.get(2), "List of books for sale is not correct.");
        assertEquals(testBook2, booksSold.get(0), "List of books sold is not correct.");
        assertEquals(testBook3, booksSold.get(1), "List of books sold is not correct.");
        // Remove books from the database
        entityManager.remove(testBook2);
        entityManager.remove(testBook3);
        entityManager.remove(testBook4);
        entityManager.remove(testBook5);
    }
}
