package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserBasic() {
        // Test that User() properly constructs User objects
        String username = "Test User";
        String password = "testpass123";

        User testUser1 = new User(username, password);

        assertEquals(username, testUser1.getUsername(), "Username " + username +
                " does not match testUser1's username");
        assertEquals(0.00, testUser1.getReaderCash(), "testUser1 does not have the correct initial " +
                "ReaderCash amount: $0.00");
    }
}
