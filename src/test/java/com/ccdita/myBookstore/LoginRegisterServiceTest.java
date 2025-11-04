package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.processor.LoginRegisterService;
import com.ccdita.myBookstore.processor.UserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Test class for LoginRegisterServiceTest
 */
public class LoginRegisterServiceTest {
    // Use mockito to test business logic in isolation, removing any direct interactions with the database layer
    UserManager mockedUserManager = mock(UserManager.class); // Create a mock of UserManager
    // Manually inject the mock object into LoginRegisterService
    LoginRegisterService loginRegisterService = new LoginRegisterService(mockedUserManager);

    @Test
    public void testCheckCredentials() {
        // Test that checkCredentials() returns true if given valid credentials
        String testUsername = "testUsername";
        String testPassword = "testPassword";
        User testUser = new User(testUsername, testPassword);
        when(mockedUserManager.findUserByUsername(testUsername)).thenReturn(testUser); // Using a mock UserManager object
        boolean userFound = loginRegisterService.checkCredentials(testUsername, testPassword);

        assertTrue(userFound, "The given credentials should be correct.");
        verify(mockedUserManager).findUserByUsername(testUsername);
    }
}
