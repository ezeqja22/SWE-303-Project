package UserControll;

import User.Books;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {

    private BookController bookController;
    private final String filePath = "books.bin";

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        bookController = new BookController();
    }

    @AfterEach
    public void cleanUp() {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testConstructorWhenFileDoesNotExist() {
        ObservableList<Books> books = bookController.getObservableBooks();
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }

    @Test
    public void testAddBook() {
        Books book = new Books("Book1", "Author1", "Category1", 10, 99.99);
        bookController.addBook(book);
        ObservableList<Books> books = bookController.getObservableBooks();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    public void testSaveWithValidInput() throws IOException, ClassNotFoundException {
        boolean result = bookController.save("Book2", "Author2", "Category2", 5, 49.99);
        assertTrue(result);
        ObservableList<Books> books = bookController.getObservableBooks();
        assertEquals(1, books.size());
        assertEquals("Book2", books.get(0).getBookName());
    }

    @Test
    public void testSaveWithInvalidInput() throws IOException, ClassNotFoundException {
        boolean result = bookController.save("", "Author3", "Category3", 5, 49.99);
        assertFalse(result);
        ObservableList<Books> books = bookController.getObservableBooks();
        assertTrue(books.isEmpty());
    }

    @Test
    public void testUpdateBookQuantity() throws IOException, ClassNotFoundException {
        bookController.save("Book3", "Author3", "Category3", 10, 59.99);
        bookController.updateBookQuantity("Book3", 3);
        ObservableList<Books> books = bookController.getObservableBooks();
        assertEquals(7, books.get(0).getBookQuantity());
    }

    @Test
    public void testGetObservableBooks() throws IOException, ClassNotFoundException {
        bookController.save("Book4", "Author4", "Category4", 15, 79.99);
        ObservableList<Books> books = bookController.getObservableBooks();
        assertEquals(1, books.size());
        assertEquals("Book4", books.get(0).getBookName());
    }
}
