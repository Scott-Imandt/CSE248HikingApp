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
			
		
		//User u1 = new User("Scott", "Imandt", "Scooter", "12345"); 
		//User u2 = new User("Susan", "Imandt", "SuSu", "12345");
		//User u3 = new User("Susan", "Imandt", "SuSa", "12345");
		
		
		//System.out.println(us.getUserStorage("Scooter"));
		
		//us.putUserStorage(u1.getUserName(), u1);
		//us.putUserStorage(u2.getUserName(), u2);
		//us.putUserStorage(u3.getUserName(), u3);
		
		System.out.println(us.getUserStorage("SuSu"));
		
		
		
		// Save instructions
		sf.setStoredData("A", us);
		sf.saveData(sf);
				
		
		
		//System.out.println(us.getUserStorage("Alex"));
		
		
		
		
		
	}

}
