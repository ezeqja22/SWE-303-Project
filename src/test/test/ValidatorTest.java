package test;

import static org.junit.jupiter.api.Assertions.*;

import User.Validator;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testAgeBelowLowerBoundary() {
        assertFalse(Validator.isValidAge(17));
    }

    @Test
    public void testAgeAtLowerBoundary() {
        assertTrue(Validator.isValidAge(18));
    }

    @Test
    public void testAgeAboveLowerBoundary() {
        assertTrue(Validator.isValidAge(19));
    }

    @Test
    public void testAgeBelowUpperBoundary() {
        assertTrue(Validator.isValidAge(59));
    }

    @Test
    public void testAgeAtUpperBoundary() {
        assertTrue(Validator.isValidAge(60));
    }

    @Test
    public void testAgeAboveUpperBoundary() {
        assertFalse(Validator.isValidAge(61));
    }

    @Test
    public void testUsernameBelowLowerBoundary() {
        assertFalse(Validator.isValidUsername("abcd"));
    }

    @Test
    public void testUsernameAtLowerBoundary() {
        assertTrue(Validator.isValidUsername("abcde"));
    }

    @Test
    public void testUsernameAboveLowerBoundary() {
        assertTrue(Validator.isValidUsername("abcdef"));
    }

    @Test
    public void testUsernameBelowUpperBoundary() {
        assertTrue(Validator.isValidUsername("abcdefghijklmno"));
    }

    @Test
    public void testUsernameAtUpperBoundary() {
        assertTrue(Validator.isValidUsername("abcdefghijklmno"));
    }

    @Test
    public void testUsernameAboveUpperBoundary() {
        assertFalse(Validator.isValidUsername("abcdefghijklmnop"));
    }

    @Test
    public void testTransactionBelowLowerBoundary() {
        assertFalse(Validator.isValidTransactionAmount(9.99));
    }

    @Test
    public void testTransactionAtLowerBoundary() {
        assertTrue(Validator.isValidTransactionAmount(10));
    }

    @Test
    public void testTransactionAboveLowerBoundary() {
        assertTrue(Validator.isValidTransactionAmount(10.01));
    }

    @Test
    public void testTransactionBelowUpperBoundary() {
        assertTrue(Validator.isValidTransactionAmount(9999.99));
    }

    @Test
    public void testTransactionAtUpperBoundary() {
        assertTrue(Validator.isValidTransactionAmount(10000));
    }

    @Test
    public void testTransactionAboveUpperBoundary() {
        assertFalse(Validator.isValidTransactionAmount(10000.01));
    }
}
