package controller;

import java.io.IOException;

import app.AppDemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;

	

public class Welcome_Login_Controller extends AppDemo{
	 
		
	@FXML TextField userTextField;
	@FXML PasswordField PassTextField;
	@FXML Button loginButton;
	@FXML Label invalidLabel;
	@FXML Hyperlink createHyperlink;
	
	
	@FXML public void onClickLogin(ActionEvent event) throws IOException{
		
		String userName = userTextField.getText();
		String password = PassTextField.getText();
		
		if(us.signIn(userName, password) == null ) {
			System.out.println("Wrong User or pass");
			invalidLabel.setOpacity(1);
			userTextField.clear();
			PassTextField.clear();
		}
		else {
			System.out.println("You Did IT");
			user = us.signIn(userName, password);
			System.out.println(user.toString());
			
			Parent Trail_Search = FXMLLoader.load(getClass().getResource("../view/Trail_Search.fxml"));
			Scene tableViewScene = new Scene(Trail_Search);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		
			
			
			
		}
	}

	
	@FXML public void createAccount(ActionEvent event) throws IOException{
		
		Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Create_Login.fxml"));
		Scene tableViewScene = new Scene(createAccount);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	
		
	}

		
}
