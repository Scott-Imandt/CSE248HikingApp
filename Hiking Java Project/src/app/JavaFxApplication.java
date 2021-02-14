package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application{
	
	@Override
	public void init() throws Exception {
		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent loginFormRoot  = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		
		Scene loginForm = new Scene(loginFormRoot);
		
		
		stage.setTitle("Trail Explorer");
		stage.setScene(loginForm);
		stage.show();
		
	}
	@Override
	public void stop() throws Exception{
		
	}
	
	

}
