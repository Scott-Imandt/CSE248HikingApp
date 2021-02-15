package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import app.AppDemo;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Trail;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Admin_Create extends AppDemo{

	@FXML Button SignOutButton;
	@FXML Button backButton;
	@FXML TextField nameTextField;
	@FXML TextField headTextField;
	@FXML TextField lengthTextField;
	@FXML TextField elevationTextField;
	@FXML Button createButton;
	@FXML ComboBox typeComboBox;
	@FXML ComboBox diffComboBox;
	@FXML Button browseButton;
	@FXML Label fileFoundLabel;
	
	static Path uploadLocation;
	static File nonLocalFile;
	
	
	@FXML public void initialize() {
		
		typeComboBox.getItems().add("LOOP");
		typeComboBox.getItems().add("OUTANDBACK");
		typeComboBox.getItems().add("POINTTOPOINT");
		
		
		diffComboBox.getItems().add("EASY");
		diffComboBox.getItems().add("MODERATE");
		diffComboBox.getItems().add("HARD");
		
		
	}
	
	@FXML public void goToWelcome(ActionEvent event) throws IOException {
		user = us.signOut();
		
		Parent welcome = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		Scene tableViewScene = new Scene(welcome);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
		
	}
	@FXML public void goToAdminView(ActionEvent event) throws IOException {
		
		Parent admin = FXMLLoader.load(getClass().getResource("../view/Admin_View.fxml"));
		Scene tableViewScene = new Scene(admin);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
		
		
	}
	@FXML public void createTrail(ActionEvent event) throws IOException {
		
		String name = nameTextField.getText();
		String head = headTextField.getText();
		int length = Integer.parseInt(lengthTextField.getText());
		int elevation = Integer.parseInt(elevationTextField.getText());
		String type =  (String) typeComboBox.getValue();
		String diff =  (String) diffComboBox.getValue();
		
		String upLocationString = null;
		String str = null;
		if(fileFoundLabel.getOpacity() == 1) {
			Path upLocation = copyFile(uploadLocation,nonLocalFile);
			 upLocationString = upLocation.toString();
			 
			 str = upLocationString.replace("\\", "/");
			 StringBuffer sb = new StringBuffer(str);
			 sb.deleteCharAt(0);
			 sb.deleteCharAt(0);
			 sb.deleteCharAt(0);
			 			 
			 str = sb.toString();
		 		 
			 System.out.println(str);
		 
		}
		
		Trail temp = new Trail(name,head,length,elevation,type,diff,upLocationString);
		
		ts.putTrailStorage(temp);
		
		Parent admin = FXMLLoader.load(getClass().getResource("../view/Admin_View.fxml"));
		Scene tableViewScene = new Scene(admin);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
		
		
		
		
		
	}
	@FXML public void browsetopic(ActionEvent event) throws IOException {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPEG Files", "*.jpg")
			    ,new FileChooser.ExtensionFilter("PNG Files", "*.png")				
		);
		
		
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		uploadLocation = selectedFile.toPath();
		
		nonLocalFile = selectedFile;
		
		fileFoundLabel.setOpacity(1); 
		
	}
	
	public static Path copyFile(Path uploadLocation, File selectedFile) throws IOException{
		
		Path dest = Paths.get("src/data/Hiking_Images/"+selectedFile.getName());
		int count = 0;		
		while(true) {
			try {
				
				Files.copy(uploadLocation, dest);
				break;
				
			} catch(Exception e) {
				//if(count < 3) {
				//	count++;
					//dest = Paths.get("src/data/Hiking_Images/"+ String.valueOf(count) + selectedFile.getName());
					continue;
				//}
				//else {
					//System.out.println(e);
				}
			//}
		}
		
		return dest;
		
	}

	@FXML public void goToSearch(ActionEvent event) {}

}
