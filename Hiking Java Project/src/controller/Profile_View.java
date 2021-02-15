package controller;

import java.io.IOException;
import java.util.LinkedList;

import app.AppDemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Trail_History;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

public class Profile_View extends AppDemo{

	@FXML TableView<Trail_History> trailHistoryColumn;
	@FXML TableColumn<Trail_History, String> dateColumn;
	@FXML TableColumn<Trail_History, String> trailColumn;
	@FXML TableColumn<Trail_History, String> DistenceColumn;
	@FXML TableColumn<Trail_History, String> avgColumn;
	
	Trail_History[] trailArray = new Trail_History[user.getTrailHistory().size()];
		
	
	@FXML Button backButton;
	@FXML ImageView picImageView = new ImageView();
	@FXML Label nameLabel;
	@FXML Label userLabel;
	@FXML Label lastLabel;
	@FXML Label phoneLabel;
	@FXML Label distanceLabel;
	@FXML Label eleLabel;
	@FXML Label diffLabel;
	@FXML Label typeLabel;
	@FXML ImageView trailImageView = new ImageView();
	@FXML Label headLabel;
	@FXML Label dHikedLabel;
	@FXML Label avgPaceLabel;
	@FXML Label dateLabel;
	@FXML ImageView historyImageView = new ImageView();
	@FXML Label durationLabel;
	@FXML Label nameTrailLabel;
	
	
	@FXML public void initialize() {
		
		nameLabel.setText(user.getFirstName());
		lastLabel.setText(user.getLastName());
		userLabel.setText(user.getUserName());
		phoneLabel.setText(user.getPhoneNumber());
		
		Image imageobj = new Image(user.getImage());
		picImageView.setImage(imageobj);

				
		LinkedList<Trail_History> trailLinked = user.getTrailHistory();
		
		for(int i=0; i<trailArray.length; i++) {
			trailArray[i] = trailLinked.get(i);
		}
				
		dateColumn.setCellValueFactory(new PropertyValueFactory<Trail_History,String>("date"));
		trailColumn.setCellValueFactory(new PropertyValueFactory<Trail_History,String>("trailName"));
		DistenceColumn.setCellValueFactory(new PropertyValueFactory<Trail_History,String>("distenceHiked"));
		avgColumn.setCellValueFactory(new PropertyValueFactory<Trail_History,String>("averagepace"));
		
		trailHistoryColumn.setItems(getTrailHistory());
		trailHistoryColumn.setEditable(true);
		
		
		
	}
	
	public void getInfoCellEvent(CellEditEvent edditedCell) {
		
		Trail_History ts =  trailHistoryColumn.getSelectionModel().getSelectedItem();
		System.out.println(ts);
		
		nameTrailLabel.setText(ts.getTrailName());
		headLabel.setText(ts.getTrail().getTrailHead());
		typeLabel.setText(ts.getTrail().getTrailType());
		distanceLabel.setText(ts.getTrail().getTrailLength());
		eleLabel.setText(ts.getTrail().getElevation());
		diffLabel.setText(ts.getTrail().getTrailDifficulty());
		dHikedLabel.setText(String.valueOf(ts.getDistenceHiked()));
		avgPaceLabel.setText(String.valueOf(ts.getAveragepace()));
		dateLabel.setText(ts.getDate());
		durationLabel.setText(String.valueOf(ts.getDuration()));
		
		Image imageobj = new Image(ts.getTrail().getImageLocation());
		trailImageView.setImage(imageobj);
		
		Image imageobj1 = new Image(ts.getImageLocation());
		historyImageView.setImage(imageobj1);
		
	}
	
	

	public ObservableList<Trail_History> getTrailHistory() {
		
		ObservableList<Trail_History> trailsH = FXCollections.observableArrayList();
		
		for(int i=0; i<trailArray.length; i++) {
			trailsH.add(trailArray[i]);
		}
		return trailsH;
	}

	@FXML public void signOut(ActionEvent event) throws IOException {
		user = us.signOut();
		
		Parent Trail_Search = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		Scene tableViewScene = new Scene(Trail_Search);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML public void goToSearch(ActionEvent event) throws IOException {
		
		Parent Trail_Search = FXMLLoader.load(getClass().getResource("../view/Trail_Search.fxml"));
		Scene tableViewScene = new Scene(Trail_Search);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	}
	
	
	
	
	
	
	
	
}

