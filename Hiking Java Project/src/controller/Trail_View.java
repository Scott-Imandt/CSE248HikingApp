package controller;

import java.io.IOException;
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
	
	@FXML DatePicker startDatePicker;
	@FXML DatePicker endDatePicker;
	
	Trail_History th;
	@FXML TextField dissTextBar;
	
	@FXML public void initialize() {
		
		nameLabel.setText(trail.getTrailName());
		headLabel.setText(trail.getTrailHead());
		lengthLabel.setText(trail.getTrailLength());
		elevationLabel.setText(trail.getElevation());
		typeLabel.setText(trail.getTrailType());
		diffLabel.setText(trail.getTrailDifficulty());
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

	@FXML public void submitTrailHistory(ActionEvent event) {
		
		LocalDate startdate = startDatePicker.getValue();
		LocalDate enddate = endDatePicker.getValue();
		
		String[] startTime = startTimeTextField.getText().split(":");
		String[] endTime = endTimeTextField.getText().split(":");
		
		String startAmPm = startComboBox.getValue();
		String endAmPm = endComboBox.getValue();
		int disstence = Integer.parseInt(dissTextBar.getText());
		
		Calendar_Trail cal1 = new Calendar_Trail(startdate.getYear(),startdate.getMonthValue(),startdate.getDayOfMonth(),Integer.parseInt(startTime[0]),Integer.parseInt(startTime[1]),startAmPm);
		Calendar_Trail cal2 = new Calendar_Trail(enddate.getYear(),enddate.getMonthValue(),enddate.getDayOfMonth(),Integer.parseInt(endTime[0]),Integer.parseInt(endTime[1]),endAmPm);
		
		th = new Trail_History(trail,cal1,cal2,disstence);
		user.addTrailHistory(th);
		
		System.out.println(user.getTrailHistory());
		
		
	}
	
	
	
}
