package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.LoginRegisterService;
import com.ccdita.myBookstore.processor.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Test class for LoginRegisterServiceTest
 */
public class LoginRegisterServiceTest {
    // Use mockito to test business logic in isolation, removing any direct interactions with the database layer
    @Mock // Create a mock object of UserService
    private UserService mockedUserService;
    // Manually inject the mock object into LoginRegisterService
    @InjectMocks // Inject mockedUserService dependency
    private LoginRegisterService loginRegisterService;

    private String testUsername = "testUsername";
    private String testPassword = "testPassword";
    private User testUser;

    /**
     * Perform setup operations before each test method, ensuring each test method runs in a clean and isolated
     * environment
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mock injection
        testUser = new User(testUsername, testPassword);
    }

    @Test
    public void testCheckCredentials() {
        // Test that checkCredentials() returns true if given valid credentials
        // Using a mock UserService object
        when(mockedUserService.findUserByUsername(testUsername)).thenReturn(testUser);
        boolean userFound = loginRegisterService.checkCredentials(testUsername, testPassword);

        assertTrue(userFound, "The given credentials should be correct.");
        verify(mockedUserService).findUserByUsername(testUsername);
    }

    @Test
    public void testCheckUserExists() {
        // Test that checkUserExists() returns true if given a username that is already taken
        when(mockedUserService.findUserByUsername(testUsername)).thenReturn(testUser);
        boolean userFound = loginRegisterService.checkUserExists(testUsername);

        assertTrue(userFound, "The given username should be taken.");
        verify(mockedUserService).findUserByUsername(testUsername);
    }
}
