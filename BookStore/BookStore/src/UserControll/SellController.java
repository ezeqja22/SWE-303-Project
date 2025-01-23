package UserControll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import User.Sell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SellController {

	private ArrayList<Sell> sell;
	private File file;

	public SellController() throws ClassNotFoundException, IOException {
		sell = new ArrayList<>();
		file = new File("sell.bin");
		if (file.exists()) {
			ReadSells();
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Sell> ReadSells() throws IOException, ClassNotFoundException {
        if (!((file.length()) == 0)) {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            sell = (ArrayList<Sell>) objectInput.readObject();
            fileInput.close();
            objectInput.close();
        }
        return sell;
    }

    private void writeSell() {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(sell);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSell(Sell s) {
        sell.add(s);
        writeSell();
    }

	public boolean sell(String sellName, int sellQuantity, String clientName, double sellPrice) throws ClassNotFoundException, IOException {
	    int error = 0;
	    
			if (sellName.equals("") || sellQuantity <= 0 || clientName.equals("") || sellPrice <= 0.0) {
		        error = 1;
		    }
	
		    if (error == 0) {
		        Sell s = new Sell(sellName, sellQuantity, clientName, sellPrice);
		        BookController bookController = new BookController();
                bookController.updateBookQuantity(sellName, sellQuantity);
		        this.addSell(s);
		        writeSell();
		        return true;
		    }
	    return false;
	}

	public ObservableList<Sell> getObservableSells() {
        return FXCollections.observableArrayList(sell);
    }

    public void print() {
        for (int i = 0; i < sell.size(); i++) {
            System.out.println(sell.get(i));
        }
    }
}