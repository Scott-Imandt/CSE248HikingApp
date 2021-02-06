package app;

import model.User;
import model.User_Storage;

public class AppDemo {

	public static void main(String[] args) {
		
		User u1 = new User("Scott", "Imandt", "Scooter", "12345");
		User u2 = new User("Alex", "Imandt", "Alex", "12345");
		
		User_Storage us = new User_Storage();
		
		us.putUserStorage(u1.getUserName(), u1);
		us.putUserStorage(u2.getUserName(), u2);
		
				
		System.out.println(us.getUserStorage("Scooter"));
		
		System.out.println(us.getUserStorage("Alex"));
		
		
		
		
		
	}

}
