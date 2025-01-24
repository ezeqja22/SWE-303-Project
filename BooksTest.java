package User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    private Books book;

    @BeforeEach
    void setUp() {

        book = new Books("Sample Book", "Author Name", "Fiction", 10, 19.99);
    }

    @Test
    void testGetBookName() {

        assertEquals("Sample Book", book.getBookName(), "Book name should be 'Sample Book'");
    }

    @Test
    void testSetBookName() {

        book.setBookName("New Book Name");
        assertEquals("New Book Name", book.getBookName(), "Book name should be updated to 'New Book Name'");
    }

    @Test
    void testGetBookAuthor() {

        assertEquals("Author Name", book.getBookAuthor(), "Author name should be 'Author Name'");
    }

    @Test
    void testSetBookAuthor() {

        book.setBookAuthor("New Author");
        assertEquals("New Author", book.getBookAuthor(), "Author name should be updated to 'New Author'");
    }

    @Test
    void testGetBookCategory() {

        assertEquals("Fiction", book.getBookCategory(), "Book category should be 'Fiction'");
    }

    @Test
    void testSetBookCategory() {

        book.setBookCategory("Non-Fiction");
        assertEquals("Non-Fiction", book.getBookCategory(), "Book category should be updated to 'Non-Fiction'");
    }

    @Test
    void testGetBookQuantity() {

        assertEquals(10, book.getBookQuantity(), "Book quantity should be 10");
    }

    @Test
    void testSetBookQuantity() {

        book.setBookQuantity(20);
        assertEquals(20, book.getBookQuantity(), "Book quantity should be updated to 20");
    }

    @Test
    void testGetBookPrice() {

        assertEquals(19.99, book.getBookPrice(), "Book price should be 19.99");
    }

    @Test
    void testSetBookPrice() {

        book.setBookPrice(25.99);
        assertEquals(25.99, book.getBookPrice(), "Book price should be updated to 25.99");
    }
}
