package UserView;

import UserControll.BookController;
import UserControll.SellController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import User.Manager;

import java.io.IOException;

import User.Books;
import User.Sell;

public class ManagerHomeView {
    
	private Manager ManCurrentUser;
	private TableView<Books> tableView;
	private TableView<Sell> tableView2;
	public ManagerHomeView(Manager ManCurrentUser) {
		this.ManCurrentUser = ManCurrentUser;
	}
	
	public Scene showView(Stage stage) throws ClassNotFoundException, IOException {
		
		Pane p = new Pane();
		Font font = Font.font("Montserrat", 30);
		Font fontlabel = Font.font("Montserrat", 15);
		
		Text text = new Text("Add Book");
		text.setFont(font);
		text.setX(70);
		text.setY(70);
		p.getChildren().add(text);
		
		Label bname = new Label("Book Name");
		TextField bnamef = new TextField();
		bname.setLayoutX(70);
		bname.setLayoutY(110);
		bnamef.setLayoutX(180);
		bnamef.setLayoutY(110);
		bname.setFont(fontlabel);
		p.getChildren().add(bname);
		p.getChildren().add(bnamef);
		
		Label bauthor = new Label("Author");
		TextField bauthorf = new TextField();
		bauthor.setLayoutX(70);
		bauthor.setLayoutY(150);
		bauthorf.setLayoutX(180);
		bauthorf.setLayoutY(150);
		bauthor.setFont(fontlabel);
		p.getChildren().add(bauthor);
		p.getChildren().add(bauthorf);
		
		Label bcategory = new Label("Book Category");
		ComboBox<String> ctg = new ComboBox<String>();
		ctg.getItems().add("Fantasy");
		ctg.getItems().add("Science Fiction");
		ctg.getItems().add("Adventure");
		ctg.getItems().add("Romance");
		ctg.getItems().add("Mistery");
		ctg.getItems().add("Thriller");
		ctg.getItems().add("Children's Fiction");
		bcategory.setLayoutX(70);
		bcategory.setLayoutY(190);
		ctg.setLayoutX(180);
		ctg.setLayoutY(190);
		bcategory.setFont(fontlabel);
		p.getChildren().add(bcategory);
		p.getChildren().add(ctg);
		
		Label bquantity = new Label("Quantity");
		TextField bquantityf = new TextField();
		bquantity.setLayoutX(70);
		bquantity.setLayoutY(230);
		bquantityf.setLayoutX(180);
		bquantityf.setLayoutY(230);
		bquantity.setFont(fontlabel);
		p.getChildren().add(bquantity);
		p.getChildren().add(bquantityf);
		
		Label bprice = new Label("Price");
		TextField bpricef = new TextField();
		bprice.setLayoutX(70);
		bprice.setLayoutY(270);
		bpricef.setLayoutX(180);
		bpricef.setLayoutY(270);
		bprice.setFont(fontlabel);
		p.getChildren().add(bprice);
		p.getChildren().add(bpricef);
		
		Button savebt = new Button("   Add Book   ");
		savebt.setLayoutX(70);
		savebt.setLayoutY(310);
		savebt.setFont(fontlabel);
		p.getChildren().add(savebt);
		
		Button logoutbt = new Button("    Log out    ");
		logoutbt.setLayoutX(223);
		logoutbt.setLayoutY(310);
		logoutbt.setFont(fontlabel);
		p.getChildren().add(logoutbt);
		
		Text text2 = new Text("All Books");
		text2.setFont(font);
		text2.setX(360);
		text2.setY(70);
		p.getChildren().add(text2);
		
		booksTableView();
	    tableView.setLayoutX(360);
	    tableView.setLayoutY(110);
	    p.getChildren().add(tableView);
		
		Text text3 = new Text("All Sales");
		text3.setFont(font);
		text3.setX(70);
		text3.setY(400);
		p.getChildren().add(text3);
		
		sellsTableView();
	    tableView2.setLayoutX(70);
	    tableView2.setLayoutY(430);
	    p.getChildren().add(tableView2);
		
		BookController bc = new BookController();

		savebt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String bookName = bnamef.getText();
				String bookAuthor = bauthorf.getText();
				String bookCategory = ctg.getValue();
				int bookQuantity = Integer.parseInt(bquantityf.getText());
				double bookPrice = Double.parseDouble(bpricef.getText());

				boolean isRegistered = false;
				try {
					isRegistered = bc.save(bookName, bookAuthor, bookCategory, bookQuantity, bookPrice);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (!isRegistered) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Book is not added");
					errorAlert.setContentText("Please try again");
					errorAlert.show();

				} else {
					Alert successA = new Alert(AlertType.INFORMATION);
					successA.setHeaderText("Book added succefully!");
					successA.showAndWait();
					successA.close();
					ManagerHomeView mhv = new ManagerHomeView(ManCurrentUser);
					try {
						stage.setScene(mhv.showView(stage));
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					stage.show();
				}
				
				bc.print();
			}
		});
		
		logoutbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LogInView lg = new LogInView();
				stage.setScene(lg.showView(stage));
				stage.show();
			}
		});
		
		stage.setTitle("Home");
		Scene sc = new Scene(p, 830, 650);
		return sc;
	}
	
	@SuppressWarnings("unchecked")
	private void booksTableView() throws ClassNotFoundException, IOException {
	    tableView = new TableView<Books>();
	    tableView.setPrefSize(410, 300);
	    
	    BookController bookController = new BookController();

	    TableColumn<Books, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        nameColumn.setMinWidth(82);

        TableColumn<Books, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().bookAuthorProperty());
        authorColumn.setMinWidth(82);

        TableColumn<Books, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().bookCategoryProperty());
        categoryColumn.setMinWidth(82);

        TableColumn<Books, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().bookQuantityProperty().asObject());
        quantityColumn.setMinWidth(82);

        TableColumn<Books, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().bookPriceProperty().asObject());
        priceColumn.setMinWidth(82);

        tableView.getColumns().addAll(nameColumn, authorColumn, categoryColumn, quantityColumn, priceColumn);
        tableView.setItems(bookController.getObservableBooks());

	}
	
	
	@SuppressWarnings("unchecked")
	private void sellsTableView() throws ClassNotFoundException, IOException {
	    tableView2 = new TableView<>();
	    tableView2.setPrefSize(700, 170);

	    SellController sellController = new SellController();

	    TableColumn<Sell, String> nameColumn = new TableColumn<>("Name");
	    nameColumn.setCellValueFactory(cellData -> cellData.getValue().sellNameProperty());
	    nameColumn.setMinWidth(150);

	    TableColumn<Sell, String> clientNameColumn = new TableColumn<>("Client Name");
	    clientNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());
	    clientNameColumn.setMinWidth(150);

	    TableColumn<Sell, Integer> quantityColumn = new TableColumn<>("Quantity");
	    quantityColumn.setCellValueFactory(cellData -> cellData.getValue().sellQuantityProperty().asObject());
	    quantityColumn.setMinWidth(100);

	    TableColumn<Sell, Double> priceColumn = new TableColumn<>("Price");
	    priceColumn.setCellValueFactory(cellData -> cellData.getValue().sellPriceProperty().asObject());
	    priceColumn.setMinWidth(150);

	    tableView2.getColumns().addAll(nameColumn, clientNameColumn, quantityColumn, priceColumn);
	    tableView2.setItems(sellController.getObservableSells());
	}

}
