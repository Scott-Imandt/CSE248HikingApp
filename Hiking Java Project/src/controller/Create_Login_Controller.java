package controller;

import java.io.IOException;

import app.AppDemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Create_Login_Controller extends AppDemo{

	@FXML Hyperlink backHyperlink;
	@FXML TextField userTextField;
	@FXML PasswordField PassTextField;
	@FXML Label invalidLabel;
	@FXML Button createButton;
	@FXML TextField firstTextField;
	@FXML TextField lastTextField;
	@FXML TextField teleTextField;
	

	
	
	@FXML public void onClickCreate() {
		
		String uName = userTextField.getText();
		String pass = PassTextField.getText();
		String fName = firstTextField.getText();
		String lName = lastTextField.getText();
		String tele = teleTextField.getText();
		
		if(us.createAccount(fName, lName, uName, pass, tele) == null) {
			invalidLabel.setOpacity(1);
			
		}
		else {
			user = us.signIn(uName, pass);
			System.out.println("User Created and loged in");
			System.out.println(user.toString());
		}
		
		
		
		
		
		
	}

	@FXML public void backLoginScreen(ActionEvent event) throws IOException {
		
		Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		Scene tableViewScene = new Scene(createAccount);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	}

}
