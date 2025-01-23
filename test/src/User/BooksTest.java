package src.User;
import User.Books;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    private Books book;

    @BeforeEach
    void setUp() {
        // Initialize a sample book object for testing
        book = new Books("Sample Book", "Author Name", "Fiction", 10, 19.99);
    }

    @Test
    void testGetBookName() {
        // Check if the book name is retrieved correctly
        assertEquals("Sample Book", book.getBookName(), "Book name should be 'Sample Book'");
    }

    @Test
    void testSetBookName() {
        // Update the book name and verify the change
        book.setBookName("New Book Name");
        assertEquals("New Book Name", book.getBookName(), "Book name should be updated to 'New Book Name'");
    }

    @Test
    void testGetBookAuthor() {
        // Check if the book author is retrieved correctly
        assertEquals("Author Name", book.getBookAuthor(), "Author name should be 'Author Name'");
    }

    @Test
    void testSetBookAuthor() {
        // Update the book author and verify the change
        book.setBookAuthor("New Author");
        assertEquals("New Author", book.getBookAuthor(), "Author name should be updated to 'New Author'");
    }

    @Test
    void testGetBookCategory() {
        // Check if the book category is retrieved correctly
        assertEquals("Fiction", book.getBookCategory(), "Book category should be 'Fiction'");
    }

    @Test
    void testSetBookCategory() {
        // Update the book category and verify the change
        book.setBookCategory("Non-Fiction");
        assertEquals("Non-Fiction", book.getBookCategory(), "Book category should be updated to 'Non-Fiction'");
    }

    @Test
    void testGetBookQuantity() {
        // Check if the book quantity is retrieved correctly
        assertEquals(10, book.getBookQuantity(), "Book quantity should be 10");
    }

    @Test
    void testSetBookQuantity() {
        // Update the book quantity and verify the change
        book.setBookQuantity(20);
        assertEquals(20, book.getBookQuantity(), "Book quantity should be updated to 20");
    }

    @Test
    void testGetBookPrice() {
        // Check if the book price is retrieved correctly
        assertEquals(19.99, book.getBookPrice(), "Book price should be 19.99");
    }

    @Test
    void testSetBookPrice() {
        // Update the book price and verify the change
        book.setBookPrice(25.99);
        assertEquals(25.99, book.getBookPrice(), "Book price should be updated to 25.99");
    }
}
