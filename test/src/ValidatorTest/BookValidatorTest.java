import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookValidatorTest {
    private final BookValidator validator = new BookValidator();

    @Test
    public void testValidPrice() {
        assertTrue(validator.isPriceValid(0.01));
        assertTrue(validator.isPriceValid(10.0));
    }

    @Test
    public void testInvalidPrice() {
        assertFalse(validator.isPriceValid(0.0));
        assertFalse(validator.isPriceValid(-5.0));
    }

    @Test
    public void testValidTitle() {
        assertTrue(validator.isTitleValid("A Good Book"));
        assertTrue(validator.isTitleValid("AB"));
    }

    @Test
    public void testInvalidTitle() {
        assertFalse(validator.isTitleValid(""));
        assertFalse(validator.isTitleValid(" "));
        assertFalse(validator.isTitleValid(null));
        assertFalse(validator.isTitleValid("A"));
    }

    @Test
    public void testValidAuthor() {
        assertTrue(validator.isAuthorValid("John Doe"));
        assertTrue(validator.isAuthorValid("AB"));
    }

    @Test
    public void testInvalidAuthor() {
        assertFalse(validator.isAuthorValid(""));
        assertFalse(validator.isAuthorValid(" "));
        assertFalse(validator.isAuthorValid(null));
        assertFalse(validator.isAuthorValid("A"));
    }

    @Test
    public void testValidBook() {
        assertTrue(validator.isBookValid("Effective Java", "Joshua Bloch", 45.0));
    }

    @Test
    public void testInvalidBook() {
        assertFalse(validator.isBookValid("A", "Joshua Bloch", 45.0));
        assertFalse(validator.isBookValid("Effective Java", "J", 45.0));
        assertFalse(validator.isBookValid("Effective Java", "Joshua Bloch", 0.0));
    }
}
