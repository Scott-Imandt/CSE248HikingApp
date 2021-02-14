package controller;

import java.util.List;

import app.AppDemo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class Trail_Search extends AppDemo {

	@FXML TextField searchBar;
	@FXML ComboBox<String> lengthBar;
	@FXML ComboBox<String> eleveationBar;
	@FXML ComboBox<String> typeBar;
	@FXML ComboBox<String> diffBar;
	@FXML Label nameLabel = new Label();
	@FXML Label headLabel = new Label();;
	@FXML Label lengthLabel = new Label();;
	@FXML Label elevationLabel = new Label();;
	@FXML Label diffLabel = new Label();;
	@FXML Label typeLabel = new Label();;
	@FXML Label nameLabel1= new Label();
	@FXML Label headLabel1 = new Label();;
	@FXML Label lengthLabel1 = new Label();;
	@FXML Label elevationLabel1 = new Label();;
	@FXML Label diffLabel1 = new Label();;
	@FXML Label typeLabel1 = new Label();;
	@FXML Label nameLabel2 = new Label();
	@FXML Label headLabel2 = new Label();;
	@FXML Label lengthLabel2 = new Label();;
	@FXML Label elevationLabel2 = new Label();;
	@FXML Label diffLabel2 = new Label();;
	@FXML Label typeLabel2 = new Label();;
	
		
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
		
		List result = ts.searchTrailStorage(searchData, "", lengthBar.getValue(), eleveationBar.getValue(), typeBar.getValue(), diffBar.getValue());
		
		nameLabel.setText("");
		headLabel.setText("");
		lengthLabel.setText("");
		diffLabel.setText("");
		elevationLabel.setText("");
		typeLabel.setText("");
		
		nameLabel1.setText("");
		headLabel1.setText("");
		lengthLabel1.setText("");
		diffLabel1.setText("");
		elevationLabel1.setText("");
		typeLabel1.setText("");
		
		nameLabel2.setText("");
		headLabel2.setText("");
		lengthLabel2.setText("");
		diffLabel2.setText("");
		elevationLabel2.setText("");
		typeLabel2.setText("");
				
		
		int count = 0;
		int total = result.size();
		
		if(count < total) {
		
			nameLabel.setText(ts.getTrailStorage(result, 0).getTrailName());
			headLabel.setText(ts.getTrailStorage(result, 0).getTrailHead());
			lengthLabel.setText(ts.getTrailStorage(result, 0).getTrailLength());
			diffLabel.setText(ts.getTrailStorage(result, 0).getTrailDifficulty());
			elevationLabel.setText(ts.getTrailStorage(result, 0).getElevation());
			typeLabel.setText(ts.getTrailStorage(result, 0).getTrailType());
			
			count++;
		}
		
		if(count < total) {
			
			nameLabel1.setText(ts.getTrailStorage(result, 1).getTrailName());
			headLabel1.setText(ts.getTrailStorage(result, 1).getTrailHead());
			lengthLabel1.setText(ts.getTrailStorage(result, 1).getTrailLength());
			diffLabel1.setText(ts.getTrailStorage(result, 1).getTrailDifficulty());
			elevationLabel1.setText(ts.getTrailStorage(result, 1).getElevation());
			typeLabel1.setText(ts.getTrailStorage(result, 1).getTrailType());
			
			count++;
		}
		if(count < total) {
			
			nameLabel2.setText(ts.getTrailStorage(result, 2).getTrailName());
			headLabel2.setText(ts.getTrailStorage(result, 2).getTrailHead());
			lengthLabel2.setText(ts.getTrailStorage(result, 2).getTrailLength());
			diffLabel2.setText(ts.getTrailStorage(result, 2).getTrailDifficulty());
			elevationLabel2.setText(ts.getTrailStorage(result, 2).getElevation());
			typeLabel2.setText(ts.getTrailStorage(result, 2).getTrailType());
			
			count++;
		}
		
				
		
		System.out.println("End");
	}

	

}
