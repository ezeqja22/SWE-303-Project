package UserView;

import UserControll.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import User.User;

import java.io.IOException;

import User.Manager;

public class LogInView {

    public Scene showView(Stage stage) {
        
    	Pane pane = new Pane();
    	
    	Font font = Font.font("Arial", FontWeight.BOLD, 16);
    	Text ctext = new Text("Seller");
    	ctext.setFont(font);
    	ctext.setX(200);
    	ctext.setY(50);
    	Label email = new Label("Email");
    	TextField emailf = new TextField();
    	email.setLayoutX(100);
    	email.setLayoutY(100);
    	emailf.setLayoutX(160);
    	emailf.setLayoutY(95);
    	pane.getChildren().add(email);
    	pane.getChildren().add(emailf);
    	pane.getChildren().add(ctext);
    	
    	Label pass = new Label("Password");
    	PasswordField passw = new PasswordField();
    	pass.setLayoutX(100);
    	pass.setLayoutY(140);
    	passw.setLayoutX(160);
    	passw.setLayoutY(135);
    	pane.getChildren().add(pass);
    	pane.getChildren().add(passw);
    	
    	
    	Button login = new Button("Log in");
    	login.setLayoutX(170);
    	login.setLayoutY(170);
    	pane.getChildren().add(login);
    	
    	Button signup = new Button("Sign Up");
    	signup.setLayoutX(240);
    	signup.setLayoutY(170);
    	pane.getChildren().add(signup);
    	
    	Line line = new Line(400, 50, 400, 220);
    	pane.getChildren().add(line);
    	
    	Label manid = new Label("Manager ID");
    	TextField manidf = new TextField();
    	manid.setLayoutX(460);
    	manid.setLayoutY(100);
    	manidf.setLayoutX(580);
    	manidf.setLayoutY(95);
    	pane.getChildren().add(manid);
    	pane.getChildren().add(manidf);
    	
    	Text mtext = new Text("Manager");
    	mtext.setFont(font);
    	mtext.setX(550);
    	mtext.setY(50);
    	Label manpass = new Label("Manager Password");
    	PasswordField manpassw = new PasswordField();
    	manpass.setLayoutX(460);
    	manpass.setLayoutY(140);
    	manpassw.setLayoutX(580);
    	manpassw.setLayoutY(135);
    	pane.getChildren().add(manpass);
    	pane.getChildren().add(manpassw);
    	pane.getChildren().add(mtext);
    	
    	Button manlogin = new Button("       Log In       ");
    	manlogin.setLayoutX(610);
    	manlogin.setLayoutY(170);
    	pane.getChildren().add(manlogin);
    	
        login.setOnAction(e -> {
            UserController uc = new UserController();
            User user = uc.login(emailf.getText(), passw.getText());
            if (user != null) {
                SellerHomeView hv = new SellerHomeView(user);
                try {
					stage.setScene(hv.showView(stage));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Enter the correct email or password");
                al.showAndWait();
            }
        });

        signup.setOnAction(e -> {
            SignUpView sv = new SignUpView();
            stage.setScene(sv.showView(stage));
        });
        
        manlogin.setOnAction(e -> {
            Manager man = new Manager("1212", "admin");
            if (manidf.getText().equals(man.getManagerId()) && manpassw.getText().equals(man.getManagerPassword())) {
                ManagerHomeView mhv = new ManagerHomeView(man);
                try {
					stage.setScene(mhv.showView(stage));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Enter the correct Manager ID or Manager Password");
                al.showAndWait();
            }
        });
        
        stage.setTitle("Log In");
        Scene sc = new Scene(pane, 800, 300);

        return sc;
    }
}