package UserView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import User.Books;
import User.User;
import UserControll.BookController;
import UserControll.SellController;

public class SellerHomeView {

	private TableView<Books> tableView;

	public SellerHomeView(User currentUser) {
	}

	public Scene showView(Stage stage) throws ClassNotFoundException, IOException {

		Pane p = new Pane();
		Font font = Font.font("Montserrat", 30);
		Font fontlabel = Font.font("Montserrat", 15);
		
		Text text = new Text("Sell Book");
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
		
		Label bquantity = new Label("Quantity");
		TextField bquantityf = new TextField();
		bquantity.setLayoutX(70);
		bquantity.setLayoutY(150);
		bquantityf.setLayoutX(180);
		bquantityf.setLayoutY(150);
		bquantity.setFont(fontlabel);
		p.getChildren().add(bquantity);
		p.getChildren().add(bquantityf);
		
		Label cname = new Label("Client Name");
		TextField cnamef = new TextField();
		cname.setLayoutX(70);
		cname.setLayoutY(190);
		cnamef.setLayoutX(180);
		cnamef.setLayoutY(190);
		cname.setFont(fontlabel);
		p.getChildren().add(cname);
		p.getChildren().add(cnamef);
		
		Label bprice = new Label("Price");
		TextField bpricef = new TextField();
		bprice.setLayoutX(70);
		bprice.setLayoutY(230);
		bpricef.setLayoutX(180);
		bpricef.setLayoutY(230);
		bprice.setFont(fontlabel);
		p.getChildren().add(bprice);
		p.getChildren().add(bpricef);
		
		Button sellbt = new Button("        Sell        ");
		sellbt.setLayoutX(70);
		sellbt.setLayoutY(275);
		sellbt.setFont(fontlabel);
		p.getChildren().add(sellbt);
		
		Button logoutbt = new Button("      Log out      ");
		logoutbt.setLayoutX(207);
		logoutbt.setLayoutY(275);
		logoutbt.setFont(fontlabel);
		p.getChildren().add(logoutbt);
		
		Text text2 = new Text("Bill");
		text2.setFont(font);
		text2.setX(360);
		text2.setY(70);
		p.getChildren().add(text2);
		
		TextArea billTextArea = new TextArea();
        billTextArea.setEditable(false);
        billTextArea.setWrapText(true);
        billTextArea.setPrefSize(410, 200);
        billTextArea.setLayoutX(360);
        billTextArea.setLayoutY(110);
        p.getChildren().add(billTextArea);
	    
	    Text text3 = new Text("Book");
		text3.setFont(font);
		text3.setX(70);
		text3.setY(350);
		p.getChildren().add(text3);
		
		createTableView();
	    tableView.setLayoutX(70);
	    tableView.setLayoutY(380);
	    p.getChildren().add(tableView);
	    
	    SellController scr = new SellController();

		sellbt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sellName = bnamef.getText();
				int sellQuantity = Integer.parseInt(bquantityf.getText());
				String clientName = cnamef.getText();
				double sellPrice = Double.parseDouble(bpricef.getText());

				boolean isRegistered = false;
				try {
					isRegistered = scr.sell(sellName, sellQuantity, clientName, sellPrice);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (!isRegistered) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Book is not sell");
					errorAlert.setContentText("Please try again");
					errorAlert.show();

				} else {
					Alert successA = new Alert(AlertType.INFORMATION);
					successA.setHeaderText("Book sold successfully!");
					successA.showAndWait();
					successA.close();
					
					String billInfo = String.format("Book: %s, Quantity: %d, Client: %s, Price: %.2f\n",
		                    sellName, sellQuantity, clientName, sellPrice);
		            billTextArea.appendText(billInfo);

		            bnamef.clear();
		            bquantityf.clear();
		            cnamef.clear();
		            bpricef.clear();

		            try {
		                createTableView();
		            } catch (ClassNotFoundException | IOException e) {
		                e.printStackTrace();
		            }
				}
				
				scr.print();
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
		
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	        if (newSelection != null) {
	            bnamef.setText(newSelection.getBookName());
	            bpricef.setText(String.valueOf(newSelection.getBookPrice()));
	        }
	    });
		
		stage.setTitle("Home");
		Scene sc = new Scene(p, 830, 650);
		return sc;
	}
	
	@SuppressWarnings("unchecked")
	private void createTableView() throws ClassNotFoundException, IOException {
	    tableView = new TableView<>();
	    tableView.setPrefSize(700, 200);

	    BookController bookController = new BookController();

	    TableColumn<Books, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        nameColumn.setMinWidth(150);

        TableColumn<Books, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().bookAuthorProperty());
        authorColumn.setMinWidth(150);

        TableColumn<Books, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().bookCategoryProperty());
        categoryColumn.setMinWidth(150);

        TableColumn<Books, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().bookQuantityProperty().asObject());
        quantityColumn.setMinWidth(100);

        TableColumn<Books, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().bookPriceProperty().asObject());
        priceColumn.setMinWidth(150);

        tableView.getColumns().addAll(nameColumn, authorColumn, categoryColumn, quantityColumn, priceColumn);
        tableView.setItems(bookController.getObservableBooks());
        
	}

}
