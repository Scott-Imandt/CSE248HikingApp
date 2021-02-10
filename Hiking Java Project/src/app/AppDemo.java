package app;

import model.Save_File;
import model.User;
import model.User_Storage;

public class AppDemo {

	public static void main(String[] args) {
		
		
		// Load instructions
		User_Storage us = new User_Storage();
		Save_File sf = new Save_File(us);
		sf = Save_File.loadData();
		us = (User_Storage) sf.getStoredData("A");
			
		User u4 = us.createAccount("Scott", "Imandt", "Scooter", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex123", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy123", "12345");
		u4 = us.signOut();	
				
		u4 = us.signIn("Admin", "Admin");
		System.out.println(u4.toString());
		u4 = us.signOut();
		
		u4 = us.signIn("SuSa", "12345");
		System.out.println(u4.toString());
		us.removeUser(u4, "SuSa");
		System.out.println(u4.toString());
		u4 = us.signOut();
		
		u4 = us.signIn("Admin", "Admin");
		us.removeUser(u4, "SuSa");
		
		System.out.println(u4.toString());
				
		u4 = us.signOut();
		
		// Save instructions
		sf.setStoredData("A", us);
		sf.saveData(sf);
				
			
	}

}