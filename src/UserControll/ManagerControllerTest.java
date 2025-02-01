package UserControll;

import User.Books;
import User.Sell;
import User.Manager;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ManagerControllerTest {
    private ManagerController managerController;
    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager("admin", "password");
        managerController = new ManagerController(manager);
    }

    @Test
    void testAddBook() throws IOException, ClassNotFoundException {
        boolean isAdded = managerController.addBook("Test Book", "Author", "Fantasy", 10, 15.99);
        assertTrue(isAdded);
    }

    @Test
    void testGetAllBooks() throws IOException, ClassNotFoundException {
        ObservableList<Books> books = managerController.getAllBooks();
        assertNotNull(books);
    }

    @Test
    void testGetAllSales() throws IOException, ClassNotFoundException {
        ObservableList<Sell> sales = managerController.getAllSales();
        assertNotNull(sales);
    }
}


