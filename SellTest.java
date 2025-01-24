package User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SellTest {

    @Test
    public void testSellConstructorAndGetters() {
        // Arrange
        String expectedSellName = "Laptop";
        int expectedSellQuantity = 10;
        String expectedClientName = "John Doe";
        double expectedSellPrice = 1500.99;


        Sell sell = new Sell(expectedSellName, expectedSellQuantity, expectedClientName, expectedSellPrice);


        assertEquals(expectedSellName, sell.getSellName(), "Sell name should match the constructor input");
        assertEquals(expectedSellQuantity, sell.getSellQuantity(), "Sell quantity should match the constructor input");
        assertEquals(expectedClientName, sell.getClientName(), "Client name should match the constructor input");
        assertEquals(expectedSellPrice, sell.getSellPrice(), "Sell price should match the constructor input");
    }

    @Test
    public void testSetSellName() {

        Sell sell = new Sell("Laptop", 10, "John Doe", 1500.99);
        String newSellName = "Smartphone";

        sell.setSellName(newSellName);


        assertEquals(newSellName, sell.getSellName(), "Sell name should update correctly");
    }

    @Test
    public void testSetSellQuantity() {

        Sell sell = new Sell("Laptop", 10, "John Doe", 1500.99);
        int newQuantity = 20;


        sell.setSellQuantity(newQuantity);


        assertEquals(newQuantity, sell.getSellQuantity(), "Sell quantity should update correctly");
    }

    @Test
    public void testSetClientName() {

        Sell sell = new Sell("Laptop", 10, "John Doe", 1500.99);
        String newClientName = "Jane Smith";


        sell.setClientName(newClientName);


        assertEquals(newClientName, sell.getClientName(), "Client name should update correctly");
    }

    @Test
    public void testSetSellPrice() {
        // Arrange
        Sell sell = new Sell("Laptop", 10, "John Doe", 1500.99);
        double newPrice = 999.99;


        sell.setSellPrice(newPrice);


        assertEquals(newPrice, sell.getSellPrice(), "Sell price should update correctly");
    }

    @Test
    public void testToString() {

        Sell sell = new Sell("Laptop", 10, "John Doe", 1500.99);
        String expectedString = "Sell [Name: Laptop, Quantity: 10, Client: John Doe, Price: 1500.99]";


        String actualString = sell.toString();


        assertEquals(expectedString, actualString, "toString output should match the expected format");
    }
}
