package UserControll;

import User.Sell;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SellControllerTest {

    private SellController sellController;
    private final String filePath = "sell.bin";

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        sellController = new SellController();
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
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertNotNull(sells);
        assertTrue(sells.isEmpty());
    }

    @Test
    public void testAddSell() {
        Sell sell = new Sell("Item1", 5, "Client1", 99.99);
        sellController.addSell(sell);
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertEquals(1, sells.size());
        assertEquals(sell, sells.get(0));
    }

    @Test
    public void testSellWithValidInput() throws IOException, ClassNotFoundException {
        boolean result = sellController.sell("Item2", 10, "Client2", 49.99);
        assertTrue(result);
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertEquals(1, sells.size());
        assertEquals("Item2", sells.get(0).getSellName());
    }

    @Test
    public void testSellWithInvalidInput() throws IOException, ClassNotFoundException {
        boolean result = sellController.sell("", 0, "Client3", 49.99);
        assertFalse(result);
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertTrue(sells.isEmpty());
    }

    @Test
    public void testGetObservableSells() throws IOException, ClassNotFoundException {
        sellController.sell("Item3", 15, "Client4", 59.99);
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertEquals(1, sells.size());
        assertEquals("Item3", sells.get(0).getSellName());
    }

    @Test
    public void testPrint() throws IOException, ClassNotFoundException {
        sellController.sell("Item4", 20, "Client5", 79.99);
        ObservableList<Sell> sells = sellController.getObservableSells();
        assertEquals(1, sells.size());
        assertEquals("Item4", sells.get(0).getSellName());
    }
}
