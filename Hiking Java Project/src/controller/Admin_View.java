package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.AppDemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Trail;
import model.User;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Admin_View extends AppDemo {

	List<User> userList;
	User[] userArray;
	
	Object[] trailList;
	User selectedUser;
	Trail selectedTrail;
	
	@FXML TableView<User> userTableView;
	@FXML TableColumn<User, String> userNameColumn;
	@FXML TableColumn<User, String> firstNameColum;
	@FXML TableColumn<User, String> lastNameColumn;
	@FXML TableColumn<User, String> authtypeColumn;
	@FXML TableView<Trail> trailTableView;
	@FXML TableColumn<Trail, String> trailNameColum;
	@FXML TableColumn<Trail, String> headColumn;
	@FXML TableColumn<Trail, Integer> lengthColumn;
	@FXML TableColumn<Trail, Integer> elevationColumn;
	@FXML TableColumn<Trail, String> typwColumn;
	@FXML TableColumn<Trail, String> diffColumn;
	@FXML Button SignOutButton;
	@FXML Button backButton;
	@FXML Button createTrail;
	
	@FXML public void initialize() {
		
		generateUserTabelView();
		
		generateTrailTableView();
		
	}
	
	public void generateTrailTableView() {
		
		trailList = ts.getTreeSet().toArray();
		
		trailNameColum.setCellValueFactory(new PropertyValueFactory<Trail,String>("trailName"));
		headColumn.setCellValueFactory(new PropertyValueFactory<Trail,String>("trailHead"));
		lengthColumn.setCellValueFactory(new PropertyValueFactory<Trail,Integer>("trailLength"));
		elevationColumn.setCellValueFactory(new PropertyValueFactory<Trail,Integer>("elevation"));
		typwColumn.setCellValueFactory(new PropertyValueFactory<Trail,String>("trailTypeString"));
		diffColumn.setCellValueFactory(new PropertyValueFactory<Trail,String>("trailDiffString"));
		
		trailTableView.setItems(getTrail());
		
	}
	
	
	public void generateUserTabelView() {
		
		userList = new ArrayList<User>(us.getHashTable().values());
				
		userArray = new User[userList.size()];
		userArray = userList.toArray(userArray);
		
		userNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		firstNameColum.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("LastName"));
		authtypeColumn.setCellValueFactory(new PropertyValueFactory<User,String>("authTypeString"));
		userTableView.setItems(getUser());
		
	}

	private ObservableList<Trail> getTrail() {
		
		ObservableList<Trail> trails = FXCollections.observableArrayList();
		for(int i=0; i<trailList.length; i++) {
			trails.add((Trail)trailList[i]);
		}
		return trails;
		
	}

	public ObservableList<User> getUser() {
		
		ObservableList<User> users = FXCollections.observableArrayList();	
		for(int i=0; i<userList.size(); i++) {
			users.add(userArray[i]);
		}
		return users;	
	}
	
	public void getUserInfoCellEvent(CellEditEvent edditedCell) {
		selectedUser = userTableView.getSelectionModel().getSelectedItem();
	}
	
	public void getTrailInfoCellEvent(CellEditEvent edditedCell) {
		selectedTrail = trailTableView.getSelectionModel().getSelectedItem();
	}

	@FXML public void RemoveTrail() {
		ts.removetrail(user, selectedTrail);
		generateTrailTableView();

	}

	@FXML public void RemoveUser() {
		
		if(selectedUser.getUserName().equals("Admin") || selectedUser.getUserName().equals("Guest")) {
			generateUserTabelView();
		}
		else {
			us.removeUser(user, selectedUser.getUserName());
		}
		generateUserTabelView();
	}

	@FXML public void goToWelcome(ActionEvent event) throws IOException {
		user = us.signOut();
		
		Parent welcome = FXMLLoader.load(getClass().getResource("../view/Welcome_Login.fxml"));
		Scene tableViewScene = new Scene(welcome);
		
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

	@FXML public void goToCreate(ActionEvent event) throws IOException {
		
		Parent adminCreate = FXMLLoader.load(getClass().getResource("../view/Admin_Create.fxml"));
		Scene tableViewScene = new Scene(adminCreate);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
	}
}
