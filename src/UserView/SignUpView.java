package UserView;

import UserControll.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SignUpView {

	public Scene showView(Stage stage) {
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));

		Label firstNameL = new Label("First Name");
		TextField firstNameField = new TextField();
		pane.add(firstNameL, 0, 0);
		pane.add(firstNameField, 1, 0);

		Label LastNameL = new Label("Last Name");
		TextField LastNameField = new TextField();
		pane.add(LastNameL, 0, 1);
		pane.add(LastNameField, 1, 1);

		Label EmailL = new Label("Email");
		TextField EmailField = new TextField();
		pane.add(EmailL, 0, 2);
		pane.add(EmailField, 1, 2);

		Label PasswordL = new Label("Password");
		PasswordField passF = new PasswordField();
		pane.add(PasswordL, 0, 3);
		pane.add(passF, 1, 3);

		Label VPasswordL = new Label("Verify Password");
		PasswordField VpassF = new PasswordField();
		pane.add(VPasswordL, 0, 4);
		pane.add(VpassF, 1, 4);

		ToggleGroup tg = new ToggleGroup();
		Label genderL = new Label("Gender");
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		RadioButton other = new RadioButton("Other");
		male.setToggleGroup(tg);
		female.setToggleGroup(tg);
		other.setToggleGroup(tg);

		pane.add(genderL, 0, 5);
		HBox b = new HBox();
		b.getChildren().addAll(male, female, other);
		pane.add(b, 1, 5);

		CheckBox remember = new CheckBox("Remember Me");
		pane.add(remember, 1, 8);

		Button button = new Button("Sign Up");
		pane.add(button, 1, 9);

		UserController uc = new UserController();

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String firstName = firstNameField.getText();
				String lastName = LastNameField.getText();
				String email = EmailField.getText();
				String passwordField = passF.getText();
				String verifyPassword = VpassF.getText();
				String gender = "";
				if (male.isSelected()) {
					gender = male.getText();
				} else if (female.isSelected()) {
					gender = female.getText();
				} else {
					gender = other.getText();
				}

				boolean isRemeberMe = remember.isSelected();

				boolean isRegistered = uc.signUp(firstName, lastName, email, passwordField, verifyPassword, gender,
						isRemeberMe);

				if (!isRegistered) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("There was an error");
					errorAlert.setContentText("Something dont match");
					errorAlert.show();

				} else {
					Alert successA = new Alert(AlertType.INFORMATION);
					successA.setHeaderText("Done");
					successA.showAndWait();
					// firstNameField.clear();
					LogInView lv = new LogInView();
					stage.setScene(lv.showView(stage));
					successA.close();

				}

				uc.print();

			}

		});
		
		stage.setTitle("Sign Up");
		Scene sc = new Scene(pane, 500, 350);
		return sc;
	}

}
