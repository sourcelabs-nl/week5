package nl.sourcelabs.se.week5.monday.assignment1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static nl.sourcelabs.se.week5.monday.assignment1.PasswordValidator.isValid;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Jarno Walgemoed (Sourcelabs.nl)
 */
public class PasswordValidatorTest {

    // Valid test cases
    private static final List<String> validPasswords = Arrays.asList(
            "@1Abcdefgsadaskjalsd",     // Maximum length
            "1@xUuuuu",                 // Exactly long enough
            "@@@@@1xX"                  // Exactly long enough and many weird characters
    );

    // Invalid test cases
    private static final List<String> invalidPasswords = Arrays.asList(
            "onlylowercase",            // Only lowercase
            "ONLYUPPERCASE",            // Only uppercase
            "1ONLYUPPER",               // Number only uppercase
            "1UPPERlower",              // Number lower and uppercase
            "1@xU",                     // valid but too short
            "@1Abcdefgsadaskjalsdd"     // Valid, but too long
    );

    @Test
    public void testValidPasswords() {
        for (final String password : validPasswords) {
            assertTrue(password + " is not a valid password.", isValid(password));
        }
    }

    @Test
    public void testInvalidPasswords() {
        for (final String password : invalidPasswords) {
            assertFalse(password + " is a valid password.", isValid(password));
        }
    }

    @Test
    public void testEmptyPassword() {
        assertFalse("Empty passwords are supposed to be invalid.", isValid(""));
    }

    @Test
    public void testNullPassword() {
        assertFalse("Null passwords are supposed to be invalid.", isValid(null));
    }
}