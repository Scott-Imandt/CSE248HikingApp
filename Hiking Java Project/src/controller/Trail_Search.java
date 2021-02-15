package controller;

import java.io.IOException;
import java.util.List;

import app.AppDemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Trail;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class Trail_Search extends AppDemo {

	@FXML TextField searchBar;
	@FXML ComboBox<String> lengthBar;
	@FXML ComboBox<String> eleveationBar;
	@FXML ComboBox<String> typeBar;
	@FXML ComboBox<String> diffBar;
	@FXML Label nameLabel;
	@FXML Label headLabel;
	@FXML Label lengthLabel;
	@FXML Label elevationLabel;
	@FXML Label diffLabel;
	@FXML Label typeLabel;
	@FXML Label nameLabel1;
	@FXML Label headLabel1;
	@FXML Label lengthLabel1;
	@FXML Label elevationLabel1;
	@FXML Label diffLabel1;
	@FXML Label typeLabel1;
	@FXML Label nameLabel2;
	@FXML Label headLabel2;
	@FXML Label lengthLabel2;
	@FXML Label elevationLabel2;
	@FXML Label diffLabel2;
	@FXML Label typeLabel2;
	@FXML Label nameLabel3;
	@FXML Label headLabel3;
	@FXML Label lengthLabel3;
	@FXML Label elevationLabel3;
	@FXML Label diffLabel3;
	@FXML Label typeLabel3;
	@FXML Label nameLabel4;
	@FXML Label headLabel4;
	@FXML Label lengthLabel4;
	@FXML Label elevationLabel4;
	@FXML Label diffLabel4;
	@FXML Label typeLabel4;
	
	@FXML ImageView image = new ImageView();
	@FXML ImageView image1 = new ImageView();
	@FXML ImageView image2 = new ImageView();
	@FXML ImageView image3= new ImageView();
	@FXML ImageView image4 = new ImageView();
	@FXML AnchorPane ancherpane;
	@FXML AnchorPane ancherpane1;
	@FXML AnchorPane ancherpane2;
	@FXML AnchorPane ancherpane3;
	@FXML AnchorPane ancherpane4;
	
	static List result;
	
	//static Label[] nameArray= {nameLabel,nameLabel1,nameLabel2,nameLabel3,nameLabel4};
	
		
	@FXML public void initialize() {
		typeBar.getItems().add("All Types");
		typeBar.getItems().add("Loop");
		typeBar.getItems().add("OutAndBack");
		typeBar.getItems().add("PointToPoint");
		//
		diffBar.getItems().add("All Difficulties");
		diffBar.getItems().add("Easy");
		diffBar.getItems().add("Moderate");
		diffBar.getItems().add("Hard");
		//
		lengthBar.getItems().add("All Lengths");
		//
		eleveationBar.getItems().add("All Elevations");
		
		searchAction();
						
	}
	
		

	@FXML public void searchAction() {
		
		//System.out.println(ts.searchTrailStorage("A", "", "", "", "",""));
		
		String searchData = searchBar.getText().toString();
		
		if(typeBar.getValue() == null) {
			typeBar.setValue("All Types");
		}
		
		if(diffBar.getValue() == null) {
			diffBar.setValue("All Difficulties");
		}
		
		if(lengthBar.getValue() == null) {
			lengthBar.setValue("All Lengths");
		}
		
		if(eleveationBar.getValue() == null) {
			eleveationBar.setValue("All Elevations");
		}
		
		result = ts.searchTrailStorage(searchData, "", lengthBar.getValue(), eleveationBar.getValue(), typeBar.getValue(), diffBar.getValue());
						
		ancherpane.setOpacity(0);
		ancherpane1.setOpacity(0);
		ancherpane2.setOpacity(0);
		ancherpane3.setOpacity(0);
		ancherpane4.setOpacity(0);
				
		int count = 0;
		int total = result.size();
		
		if(count < total) {	
		
			nameLabel.setText(ts.getTrailStorage(result, 0).getTrailName());
			headLabel.setText(ts.getTrailStorage(result, 0).getTrailHead());
			lengthLabel.setText(ts.getTrailStorage(result, 0).getTrailLength());
			diffLabel.setText(ts.getTrailStorage(result, 0).getTrailDifficulty());
			elevationLabel.setText(ts.getTrailStorage(result, 0).getElevation());
			typeLabel.setText(ts.getTrailStorage(result, 0).getTrailType());
			
			Image imageobj = new Image(ts.getTrailStorage(result, 0).getImageLocation());
			image.setImage(imageobj);
			
			ancherpane.setOpacity(1);
			
			count++;
		}
		
		if(count < total) {		
			
			nameLabel1.setText(ts.getTrailStorage(result, 1).getTrailName());
			headLabel1.setText(ts.getTrailStorage(result, 1).getTrailHead());
			lengthLabel1.setText(ts.getTrailStorage(result, 1).getTrailLength());
			diffLabel1.setText(ts.getTrailStorage(result, 1).getTrailDifficulty());
			elevationLabel1.setText(ts.getTrailStorage(result, 1).getElevation());
			typeLabel1.setText(ts.getTrailStorage(result, 1).getTrailType());
			
			Image imageobj = new Image(ts.getTrailStorage(result, 1).getImageLocation());
			image1.setImage(imageobj);
			
			ancherpane1.setOpacity(1);
			
			count++;
		}
		if(count < total) {		
			
			nameLabel2.setText(ts.getTrailStorage(result, 2).getTrailName());
			headLabel2.setText(ts.getTrailStorage(result, 2).getTrailHead());
			lengthLabel2.setText(ts.getTrailStorage(result, 2).getTrailLength());
			diffLabel2.setText(ts.getTrailStorage(result, 2).getTrailDifficulty());
			elevationLabel2.setText(ts.getTrailStorage(result, 2).getElevation());
			typeLabel2.setText(ts.getTrailStorage(result, 2).getTrailType());
			
			Image imageobj = new Image(ts.getTrailStorage(result, 2).getImageLocation());
			image2.setImage(imageobj);
			
			ancherpane2.setOpacity(1);
			
			count++;
		}
		
		if(count < total) {			
			
			nameLabel3.setText(ts.getTrailStorage(result, 3).getTrailName());
			headLabel3.setText(ts.getTrailStorage(result, 3).getTrailHead());
			lengthLabel3.setText(ts.getTrailStorage(result, 3).getTrailLength());
			diffLabel3.setText(ts.getTrailStorage(result, 3).getTrailDifficulty());
			elevationLabel3.setText(ts.getTrailStorage(result, 3).getElevation());
			typeLabel3.setText(ts.getTrailStorage(result, 3).getTrailType());
			
			Image imageobj = new Image(ts.getTrailStorage(result, 3).getImageLocation());
			image3.setImage(imageobj);
			
			ancherpane3.setOpacity(1);
			
			count++;
		}

		if(count < total) {		
	
			nameLabel4.setText(ts.getTrailStorage(result, 4).getTrailName());
			headLabel4.setText(ts.getTrailStorage(result, 4).getTrailHead());
			lengthLabel4.setText(ts.getTrailStorage(result, 4).getTrailLength());
			diffLabel4.setText(ts.getTrailStorage(result, 4).getTrailDifficulty());
			elevationLabel4.setText(ts.getTrailStorage(result, 4).getElevation());
			typeLabel4.setText(ts.getTrailStorage(result, 4).getTrailType());
	
			Image imageobj = new Image(ts.getTrailStorage(result, 4).getImageLocation());
			image4.setImage(imageobj);
	
			ancherpane4.setOpacity(1);
			
			count++;
		}
		
		//for(int i=0; i<result.size(); i++) {
		//	nameArray[i].setText(ts.getTrailStorage(result, i).getTrailName());
		//}
						
		
		System.out.println("End");
	}



	@FXML public void goToTrailView(MouseEvent event) throws IOException {
		
		if(ancherpane.getOpacity() == 1.0 && user.getAuthType() != user.getRoleType("GUEST")) {
			trail = ts.getTrailStorage(result, 0);
			
			Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Trail_View.fxml"));
			Scene tableViewScene = new Scene(createAccount);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		}
		
	}

	@FXML public void signOut(ActionEvent event) throws IOException {
		user = us.signOut();
		
		Parent Trail_Search = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		Scene tableViewScene = new Scene(Trail_Search);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	
		
	}



	@FXML public void goToTrailView1(MouseEvent event) throws IOException {
		
		if(ancherpane.getOpacity() == 1.0 && user.getAuthType() != user.getRoleType("GUEST")) {
			trail = ts.getTrailStorage(result, 1);
			
			Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Trail_View.fxml"));
			Scene tableViewScene = new Scene(createAccount);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		}
		
	}

	

	@FXML public void goToTrailView2(MouseEvent event) throws IOException {
		
		if(ancherpane.getOpacity() == 1.0 && user.getAuthType() != user.getRoleType("GUEST")) {
			trail = ts.getTrailStorage(result, 2);
			
			Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Trail_View.fxml"));
			Scene tableViewScene = new Scene(createAccount);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		}
	}



	@FXML public void goToTrailView3(MouseEvent event) throws IOException {
		if(ancherpane.getOpacity() == 1.0 && user.getAuthType() != user.getRoleType("GUEST")) {
			trail = ts.getTrailStorage(result, 3);
			
			Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Trail_View.fxml"));
			Scene tableViewScene = new Scene(createAccount);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		}
	}



	@FXML public void goToTrailView4(MouseEvent event) throws IOException {
		if(ancherpane.getOpacity() == 1.0 && user.getAuthType() != user.getRoleType("GUEST")) {
			trail = ts.getTrailStorage(result, 4);
			
			Parent createAccount = FXMLLoader.load(getClass().getResource("../view/Trail_View.fxml"));
			Scene tableViewScene = new Scene(createAccount);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(tableViewScene);
			window.show();
		}
	}


	
	

}
