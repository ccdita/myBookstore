package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.UserDAOImpl;
import com.ccdita.myBookstore.datamanagement.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UserDAOImpl Repository class
 */
@DataJpaTest // Scan for entity classes and JPA repository classes
@Import(UserDAOImpl.class) // Import UserDAOImpl repository class
public class UserDAOImplTest {

    @Autowired
    private EntityManager entityManager; // Auto-inject EntityManager
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
        entityManager.remove(testUser);
    }

    @Test
    public void testSaveUser() {
        // Test that save() properly saves the given user to the database
        int testId = testUser.getId();
        User savedUser = entityManager.find(User.class, testId);
        assertEquals(testUser, savedUser, "save() does not properly save the given User to the database.");
        assertEquals(testUser.getUsername(), savedUser.getUsername(), "save() does not properly save " +
                "the given User to the database.");
        assertEquals(testUser.getPassword(), savedUser.getPassword(), "save() does not properly save " +
                "the given User to the database.");
        assertEquals(testUser.getReaderCash(), savedUser.getReaderCash(), "save() does not properly save " +
                "the given User to the database.");
    }

    @Test
    public void testDeleteUser() {
        // Test that delete() properly removes the given user from the database
        User testUserToDelete = new User("testUserToDelete","testPassword");
        // Test that the user is not yet in the database
        assertNull(entityManager.find(User.class, testUserToDelete.getId()), "User is found in database " +
                "when it should not have yet been saved.");

        // Persist the user to the database
        entityManager.persist(testUserToDelete);
        // Test that the user is in the database
        assertNotNull(entityManager.find(User.class, testUserToDelete.getId()));

        userDAOImpl.delete(testUserToDelete); // Remove the user from the database

        // Test that the user is no longer in the database
        assertNull(entityManager.find(User.class, testUserToDelete.getId()), "User is found in database " +
                "it should have been removed.");
    }

    @Test
    public void testFindByUsername() {
        // Test that findByUsername() properly finds the user with the given username
        User foundUser = userDAOImpl.findByUsername("testUser");
        assertNotNull(foundUser, "findByUsername() does not properly find the user with the given username.");
        assertEquals(testUser.getPassword(), foundUser.getPassword(), "findByUsername() does not properly " +
                "find the user with the given username.");
        assertEquals(testUser.getId(), foundUser.getId(), "findByUsername() does not properly find the user " +
                "with the given username.");
    }

    @Test
    public void testFindById() {
        // Test that findById() properly finds the user with the given ID
        int testUserId = testUser.getId();
        User foundUser = userDAOImpl.findById(testUserId);
        assertNotNull(foundUser, "findById() does not properly find the user with the given ID.");
        assertEquals(testUser, foundUser, "findById() does not properly find the user with the given ID.");
        assertEquals(testUser.getPassword(), foundUser.getPassword(), "findById() does not properly find " +
                "the user with the given ID.");
    }

    @Test
    public void testUpdateUser() {
        // Test that update() properly updates the "user" table
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", "testUser");
        List<User> testUserResult = query.getResultList();
        assertEquals(1, testUserResult.size(), "There is no user to test in the database.");
        assertEquals(10.00, testUserResult.getFirst().getReaderCash());

        testUser.addReaderCash(20.00);
        userDAOImpl.update(testUser);

        assertEquals(30.00, testUser.getReaderCash(), "update() does not update the user in the " +
                "database.");
    }
}
