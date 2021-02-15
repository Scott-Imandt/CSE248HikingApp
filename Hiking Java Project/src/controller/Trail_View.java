package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import app.AppDemo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Calendar_Trail;
import model.Trail_History;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class Trail_View extends AppDemo{

	
	@FXML Label nameLabel;
	@FXML Label headLabel;
	@FXML Label lengthLabel;
	@FXML Label elevationLabel;
	@FXML Label typeLabel;
	@FXML Label diffLabel;
	@FXML Button backButton;
	@FXML ImageView picImageView = new ImageView();
	@FXML Button submitButton;
	@FXML TextField startTimeTextField;
	@FXML TextField endTimeTextField;
	@FXML ComboBox<String> endComboBox;
	@FXML ComboBox<String> startComboBox;
	@FXML TextField dissTextBar;
	
	@FXML DatePicker startDatePicker;
	@FXML DatePicker endDatePicker;
	
	Trail_History th;
	static Path uploadLocation;
	static File nonLocalFile; 
	@FXML Label fileFoundLabel;
	
	
	@FXML public void initialize() {
		
		nameLabel.setText("Name:  "+ trail.getTrailName());
		headLabel.setText("Head:  "+ trail.getTrailHead());
		lengthLabel.setText("Length:  "+ trail.getTrailLength());
		elevationLabel.setText("Elevation:  "+ trail.getElevation());
		typeLabel.setText("Type:  "+ trail.getTrailType());
		diffLabel.setText("Difficulty:  "+ trail.getTrailDifficulty());
		fileFoundLabel.setOpacity(0);
		Image imageobj = new Image(trail.getImageLocation());
		picImageView.setImage(imageobj);
		
		startComboBox.getItems().add("AM");
		startComboBox.getItems().add("PM");
		
		endComboBox.getItems().add("AM");
		endComboBox.getItems().add("PM");
							
	}

	@FXML public void goBackToSearch(ActionEvent event) throws IOException {
		trail = null;
		
		Parent Trail_Search = FXMLLoader.load(getClass().getResource("../view/Trail_Search.fxml"));
		Scene tableViewScene = new Scene(Trail_Search);
		
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
		
		Path dest = Paths.get("src/data/Hiking_User_Images/"+ user.getUserName()+"_"+ trail.getTrailName()+"_"+trail.getTrailHead()+"_"+selectedFile.getName());
		int count = 0;		
		while(true) {
			try {
				
				Files.copy(uploadLocation, dest);
				break;
				
			} catch(Exception e) {
				if(count < 3) {
					count++;
					dest = Paths.get("src/data/Hiking_User_Images/"+ String.valueOf(count) +user.getUserName()+"_"+ trail.getTrailName()+"_"+trail.getTrailHead()+"_"+selectedFile.getName());
					continue;
				}
				else {
					throw e;
				}
			}
		}
		
		return dest;
		
	}
	

	@FXML public void submitTrailHistory(ActionEvent event) throws IOException {
		
		LocalDate startdate = startDatePicker.getValue();
		LocalDate enddate = endDatePicker.getValue();
		
		String[] startTime = startTimeTextField.getText().split(":");
		String[] endTime = endTimeTextField.getText().split(":");
		
		String startAmPm = startComboBox.getValue();
		String endAmPm = endComboBox.getValue();
		int disstence = Integer.parseInt(dissTextBar.getText());
		
		Calendar_Trail cal1 = new Calendar_Trail(startdate.getYear(),startdate.getMonthValue(),startdate.getDayOfMonth(),Integer.parseInt(startTime[0]),Integer.parseInt(startTime[1]),startAmPm);
		Calendar_Trail cal2 = new Calendar_Trail(enddate.getYear(),enddate.getMonthValue(),enddate.getDayOfMonth(),Integer.parseInt(endTime[0]),Integer.parseInt(endTime[1]),endAmPm);
		
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
		
		th = new Trail_History(trail,cal1,cal2,disstence,str);
		user.addTrailHistory(th);
		

		Parent profile = FXMLLoader.load(getClass().getResource("../view/Profile_Info.fxml"));
		Scene tableViewScene = new Scene(profile);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
		
		}		
	
	
		@FXML public void goToProfile(ActionEvent event) throws IOException {
		
			if( user.getAuthType() != user.getRoleType("GUEST")) {
							
				Parent profile = FXMLLoader.load(getClass().getResource("../view/Profile_Info.fxml"));
				Scene tableViewScene = new Scene(profile);
			
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
				window.setScene(tableViewScene);
				window.show();
			}
		}
}

