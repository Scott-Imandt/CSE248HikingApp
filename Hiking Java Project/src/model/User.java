package model;

public class User implements Comparable<User>{
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int authType = 0;
	
	
	public User() {
		this.firstName = "Guest";
		this.lastName = "Guest";
		this.userName = "Guest";
		this.password = "Guest";
	}
	
	
	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
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
	
	private String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	public int getAuthType() {
		return authType;
	}
	
	private void setAuthType(int authType) {
		if(authType == 0 || authType ==1) {
			this.authType = authType;
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
		return "Name:" + firstName + '\t' + "Last:" +lastName + '\t' + "User:" +userName + '\t' + "Pass:" +password + '\t' + "Auth:" +authType;
	}

}
