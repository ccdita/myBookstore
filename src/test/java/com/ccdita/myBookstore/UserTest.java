package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    private String username = "Test User";
    private String password = "testpass123";
    User testUser1;

    @BeforeEach
    public void setUp() {
        testUser1 = new User(username, password);
    }

    @Test
    public void testUserBasic() {
        // Test that User() properly constructs User objects
        assertEquals(username, testUser1.getUsername(), "Username " + username +
                " does not match testUser1's username");
        assertEquals(10.00, testUser1.getReaderCash(), "testUser1 does not have the correct initial " +
                "ReaderCash amount: $10.00");
    }

    @Test
    public void testDeductReaderCashValidAmount() {
        /*
         * Test that deductReaderCash() properly deducts the given amount if it is less than the user's ReaderCash
         * amount
         */
        double amountToDeduct = 10.00 ;
        Double remainingReaderCash = testUser1.deductReaderCash(amountToDeduct);
        assertEquals(0.00, remainingReaderCash, 0.00, "deductReaderCash() does not properly " +
                "deduct the given amount from the user's ReaderCash amount.");
    }

    @Test
    public void testDeductReaderCashGreaterAmount() {
        // Test that deductReaderCash() returns null if the given amount is greater than the user's ReaderCash amount
        double amountToDeduct = 20.00 ;
        assertNull(testUser1.deductReaderCash(amountToDeduct), "deductReaderCash() does not return null " +
                "if the given amount is greater than the user's ReaderCash amount.");
        assertEquals(10.00, testUser1.getReaderCash(), "deductReaderCash() should not modify the " +
                "user's current ReaderCash amount if the given amount is greater.");
    }
}
