package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.UserDAOImpl;
import com.ccdita.myBookstore.datamanagement.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for UserDAOImpl Repository class
 */
@DataJpaTest // Scan for entity classes and JPA repository classes
@Import(UserDAOImpl.class) // Import UserDAOImpl repository class
public class UserDAOImplTest {

    @Autowired
    private UserDAOImpl userDAOImpl; // Auto-inject UserDAOImpl
    private User testUser;

    /**
     * Perform setup operations before each test method, ensuring each test method runs in a clean and isolated
     * environment
     */
    @BeforeEach
    public void setUp() {
        testUser = new User("testUser", "testPassword");
        userDAOImpl.save(testUser);
    }

    /**
     * Perform teardown operations before each test method
     */
    @AfterEach
    public void tearDown() {
        userDAOImpl.delete(testUser);
    }

    @Test
    void testSaveUser() {
        // Test that save() properly saves the given user to the database
        int testId = testUser.getId();
        User savedUser = userDAOImpl.findById(testId);
        assertEquals(testUser, savedUser, "save() does not properly save the given User to the database.");
        assertEquals(testUser.getUsername(), savedUser.getUsername(), "save() does not properly save " +
                "the given User to the database.");
        assertEquals(testUser.getPassword(), savedUser.getPassword(), "save() does not properly save " +
                "the given User to the database.");
        assertEquals(testUser.getReaderCash(), savedUser.getReaderCash(), "save() does not properly save " +
                "the given User to the database.");
    }
}
