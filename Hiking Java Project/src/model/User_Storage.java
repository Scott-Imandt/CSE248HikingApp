package model;

import java.io.Serializable;
import java.util.Hashtable;


public class User_Storage implements Serializable{
	
	private Hashtable<String, User> userStorage = new Hashtable<String, User>(50000);
	
	
		
	public void putUserStorage(String key, User user) {
		userStorage.put(key, user);
	}
	
	public User getUserStorage(String key) {
		return userStorage.get(key);
	}
	
	public void removeUser(User user, String key) {
		if(user.getAuthType().toString().equals("ADMIN") && getComparator(key)) {
			userStorage.remove(key);
			System.out.println("User Was removed");
		}
		else System.out.println("Unable to remove User Check Authentication or User Key");
		
	}
	
	public boolean getComparator(String key) {
		return userStorage.containsKey(key);
	}
	
	public User signIn(String username, String password) {
		User atempSignIn = new User(null, null, username, password);
		User storedUser = getUserStorage(username);
		
		if(storedUser == null) {
			System.out.println("No Account Found With That Username");
			return storedUser;
		}
			
		int compareResult = atempSignIn.getUserName().compareTo(storedUser.getUserName());
		
		if(compareResult == 0) {
			if(atempSignIn.getPassword().compareTo(storedUser.getPassword()) == 0) {
				System.out.println("Login was a success");
				return storedUser;
			}
		}
		
		storedUser = null;
		System.out.println("The Username or password was incorrect");
		return storedUser;
					
	}
	
	public User signOut() {
		User temp = null;
		System.out.println("User has Signed out");
		return temp;
	}
	
	
	public User createAccount(String firstName, String lastName, String userName, String password) {
		User temp = null;
		if(getComparator(userName)) {
			System.out.println("Username is already in use");
			return temp;
		}
		temp = new User(firstName, lastName, userName, password);
		
		putUserStorage(temp.getUserName(), temp);
		System.out.println("User account created");
		return signIn(userName, password);
		
	}
	
	

}
