package User;

import javafx.beans.property.*;

import java.io.IOException;
import java.io.Serializable;

public class Books implements Serializable {

    private static final long serialVersionUID = -3292385108400454436L;
    private transient StringProperty bookName;
    private transient StringProperty bookAuthor;
    private transient StringProperty bookCategory;
    private transient IntegerProperty bookQuantity;
    private transient DoubleProperty bookPrice;

    public Books(String bookName, String bookAuthor, String bookCategory, int bookQuantity, double bookPrice) {
        this.bookName = new SimpleStringProperty(bookName);
        this.bookAuthor = new SimpleStringProperty(bookAuthor);
        this.bookCategory = new SimpleStringProperty(bookCategory);
        this.bookQuantity = new SimpleIntegerProperty(bookQuantity);
        this.bookPrice = new SimpleDoubleProperty(bookPrice);
    }
    
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(bookName.get());
        out.writeObject(bookAuthor.get());
        out.writeObject(bookCategory.get());
        out.writeInt(bookQuantity.get());
        out.writeDouble(bookPrice.get());
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String name = (String) in.readObject();
        String author = (String) in.readObject();
        String category = (String) in.readObject();
        int quantity = in.readInt();
        double price = in.readDouble();

        bookName = new SimpleStringProperty(name);
        bookAuthor = new SimpleStringProperty(author);
        bookCategory = new SimpleStringProperty(category);
        bookQuantity = new SimpleIntegerProperty(quantity);
        bookPrice = new SimpleDoubleProperty(price);
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public String getBookAuthor() {
        return bookAuthor.get();
    }

    public StringProperty bookAuthorProperty() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor.set(bookAuthor);
    }

    public String getBookCategory() {
        return bookCategory.get();
    }

    public StringProperty bookCategoryProperty() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory.set(bookCategory);
    }

    public int getBookQuantity() {
        return bookQuantity.get();
    }

    public IntegerProperty bookQuantityProperty() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity.set(bookQuantity);
    }

    public double getBookPrice() {
        return bookPrice.get();
    }

    public DoubleProperty bookPriceProperty() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice.set(bookPrice);
    }

    @Override
    public String toString() {
        return String.format("Books [Name: %s, Author: %s, Category: %s, Quantity: %d, Price: %.2f]",
                bookName.get(), bookAuthor.get(), bookCategory.get(), bookQuantity.get(), bookPrice.get());
    }
}
