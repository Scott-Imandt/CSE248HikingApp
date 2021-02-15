package model;

import java.io.Serializable;
import java.util.LinkedList;

public class User implements Comparable<User>, Serializable{
	
	enum role{
		GUEST, USER, ADMIN;
	}
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String phoneNumber;
	private role authType;
	
	LinkedList<Trail_History> trailHistory = new LinkedList<Trail_History>();
	
	
	public User() {
		this.firstName = "Guest";
		this.lastName = "Guest";
		this.userName = "Guest";
		this.password = "Guest";
		authType = role.GUEST;
		
	}
	
	
	public User(String firstName, String lastName, String userName, String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		authType = role.USER;
		
	}
	
	public User(String firstName, String lastName, String userName, String password, String permission, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		authType = getRoleType(permission);
		
	}
		
	public LinkedList<Trail_History> getTrailHistory() {
		return trailHistory;
	}
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void addTrailHistory(Trail_History trailHistory) {
		this.trailHistory.addFirst(trailHistory);
	}

	public String getFirstName() {
		return firstName;
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;	
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	private void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	public role getAuthType() {
		return authType;
	}
	
	public role getRoleType(String permission) {
		if(permission.equals("ADMIN")) {
			return role.ADMIN;
		}
		if(permission.equals("GUEST")) {
			return role.GUEST;
		}
		if(permission.equals("USER")) {
			return role.USER;
		}
		return authType;
	}
	
	public void setAuthType(String authType , User User) {
		if(getAuthType() == role.ADMIN) {
			User.authType = getRoleType(authType);
		}
							
	}
		
	public int compareTo(User aKey) {
		
		int compareResult = this.userName.compareTo(aKey.userName);
		
		if(compareResult == 0) {
			return 0;
		}
		
		if(compareResult < 1) {
			return -1;
		}
		
		if(compareResult > 1) {
			return 1;
		}
		
		else {
			return compareResult;
		}
		
	}
	
	public String toString() {
		/*if(User.this == null) {
			return "No user is signed in";
		}*/
		
		return "Name:" + firstName + '\t' + "Last:" +lastName + '\t' + "User:" +userName + '\t' + "Pass:" +password + '\t' + "Auth:" +authType;
	}

}
