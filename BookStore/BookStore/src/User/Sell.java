package User;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sell implements Serializable {

    private static final long serialVersionUID = -3292385108400454436L;
    private transient StringProperty sellName;
    private transient IntegerProperty sellQuantity;
    private transient StringProperty clientName;
    private transient DoubleProperty sellPrice;

    public Sell(String sellName, int sellQuantity, String clientName, double sellPrice) {
        this.sellName = new SimpleStringProperty(sellName);
        this.sellQuantity = new SimpleIntegerProperty(sellQuantity);
        this.clientName = new SimpleStringProperty(clientName);
        this.sellPrice = new SimpleDoubleProperty(sellPrice);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(sellName.get());
        out.writeInt(sellQuantity.get());
        out.writeObject(clientName.get());
        out.writeDouble(sellPrice.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String name = (String) in.readObject();
        int quantity = in.readInt();
        String client = (String) in.readObject();
        double price = in.readDouble();

        sellName = new SimpleStringProperty(name);
        sellQuantity = new SimpleIntegerProperty(quantity);
        clientName = new SimpleStringProperty(client);
        sellPrice = new SimpleDoubleProperty(price);
    }

    public String getSellName() {
        return sellName.get();
    }

    public StringProperty sellNameProperty() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName.set(sellName);
    }

    public int getSellQuantity() {
        return sellQuantity.get();
    }

    public IntegerProperty sellQuantityProperty() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity.set(sellQuantity);
    }

    public String getClientName() {
        return clientName.get();
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public double getSellPrice() {
        return sellPrice.get();
    }

    public DoubleProperty sellPriceProperty() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice.set(sellPrice);
    }

    @Override
    public String toString() {
        return String.format("Sell [Name: %s, Quantity: %d, Client: %s, Price: %.2f]",
                sellName.get(), sellQuantity.get(), clientName.get(), sellPrice.get());
    }
}
