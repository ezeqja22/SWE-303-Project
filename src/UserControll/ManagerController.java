package UserControll;

public class ManagerController {
	
	

	import User.Books;
	import User.Sell;
	import User.Manager;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;

	import java.io.IOException;
	import java.util.List;

	public class ManagerController {
	    private Manager manager;
	    private BookController bookController;
	    private SellController sellController;

	    public ManagerController(Manager manager) {
	        this.manager = manager;
	        this.bookController = new BookController();
	        this.sellController = new SellController();
	    }

	    public boolean addBook(String name, String author, String category, int quantity, double price) throws IOException, ClassNotFoundException {
	        return bookController.save(name, author, category, quantity, price);
	    }

	    public ObservableList<Books> getAllBooks() throws IOException, ClassNotFoundException {
	        return bookController.getObservableBooks();
	    }

	    public ObservableList<Sell> getAllSales() throws IOException, ClassNotFoundException {
	        return sellController.getObservableSells();
	    }
	}

}
