package UserControll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import User.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookController {

    private ArrayList<Books> books;
    private File file;

    public BookController() throws ClassNotFoundException, IOException {
        books = new ArrayList<>();
        file = new File("books.bin");
        if (file.exists()) {
            books = readBooks();
        }
    }

    @SuppressWarnings("unchecked")
	private ArrayList<Books> readBooks() throws IOException, ClassNotFoundException {
        if (!((file.length()) == 0)) {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            books = (ArrayList<Books>) objectInput.readObject();
            fileInput.close();
            objectInput.close();
        }
        return books;
    }

    private void writeBooks() {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(books);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Books b) {
        books.add(b);
        writeBooks();
    }
    
    public boolean save(String bookName, String bookAuthor, String bookCategory, int bookQuantity, double bookPrice) throws ClassNotFoundException, IOException {
        int error = 0;
        
    	    if (bookName.equals("") || bookAuthor.equals("") || bookCategory.equals("") || bookQuantity <= 0 || bookPrice <= 0.0) {
    	        error = 1;
    	    }

    	    if (error == 0) {
    	        Books b1 = new Books(bookName, bookAuthor, bookCategory, bookQuantity, bookPrice);
    	        this.addBook(b1);
    	        writeBooks();
    	        return true;
    	    }
        return false;
    }

    public ObservableList<Books> getObservableBooks() {
        return FXCollections.observableArrayList(books);
    }

    public void print() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
    
    public void updateBookQuantity(String bookName, int quantitySold) {
        for (Books b : books) {
            if (b.getBookName().equals(bookName)) {
                int updatedQuantity = b.getBookQuantity() - quantitySold;
                b.setBookQuantity(updatedQuantity);
                writeBooks();
                break;
            }
        }
    }
}