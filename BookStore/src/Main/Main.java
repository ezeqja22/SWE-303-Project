package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import UserView.LogInView;

public class Main extends Application {

	@Override
	public void start(Stage s) throws Exception {
		LogInView lg = new LogInView();
		s.setTitle("Log In");
		s.setScene(lg.showView(s));
		s.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
