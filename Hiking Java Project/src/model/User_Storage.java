package model;

import java.util.TreeMap;

public class User_Storage {
	
	private TreeMap<String, User> userStorage = new TreeMap<String, User>();
	
		
	public void putUserStorage(String key, User user) {
		userStorage.put(key, user);
	}
	
	public String getUserStorage(String key) {
		return userStorage.get(key).toString();
	}
	
	public String getComparator(String key) {
		return userStorage.comparator().toString();
	}
	
	
	

}