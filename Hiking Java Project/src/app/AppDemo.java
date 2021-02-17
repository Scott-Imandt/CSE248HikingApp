package app;

import javafx.application.Application;
import model.Calendar_Trail;
import model.Save_File;
import model.Trail;
import model.Trail_History;
import model.Trail_Storage;
import model.User;
import model.User_Storage;

public class AppDemo {
	
	protected static User_Storage us = new User_Storage();
	protected static Trail_Storage ts = new Trail_Storage();
	protected static Save_File sf = new Save_File(us, ts);
	protected static User user;
	protected static Trail trail;
		
	public static void main(String[] args) {
		
		
		// Load instructions
		
		sf = Save_File.loadData();
		us = (User_Storage) sf.getStoredData("A");
		ts = (Trail_Storage) sf.getStoredData("B");
		
		
		
		
		//System.out.println(ts.searchTrailStorage("", "", "All Lengths", "", "",""));
		
		//System.out.println(user.toString());
		
				
		//user = us.signIn("Scooter", "12345");
		//System.out.println(user.toString());
		
		//Calendar_Trail cal1 = new Calendar_Trail(2021,1,11,3,00,"AM");
		//Calendar_Trail cal2 = new Calendar_Trail(2021,1,11,4,00,"AM");
		
		//Trail_History th = new Trail_History(t1, cal1, cal2,2);
		
		//System.out.println(th.toString());
		
		Application.launch(JavaFxApplication.class, args);
		
		
	
		Trail t1 = new Trail("Adam's Trail","2 bs blvd",3,45,"LOOP","EASY","/data/Hiking_Images/Adam.jpg");
		Trail t2 = new Trail("Betty's Park","1 bs blvd",4,55,"OUTANDBACK","MODERATE","/data/Hiking_Images/Betty.jpg");
		Trail t3 = new Trail("Carl's Park","5 lane",4,65,"POINTTOPOINT","HARD",null);
		Trail t4 = new Trail("David Pond","3 bs blvd",3,45,"LOOP","EASY",null);
		Trail t5 = new Trail("Eurl Nature Trail","4 bs blvd",4,55,"OUTANDBACK","MODERATE",null);
		Trail t6 = new Trail("Frank Pond","4 Lane",4,65,"POINTTOPOINT","HARD","/data/Hiking_Images/Frank.jpg");
		
		ts.putTrailStorage(t1);
		ts.putTrailStorage(t2);
		ts.putTrailStorage(t3);
		ts.putTrailStorage(t4);
		ts.putTrailStorage(t5);
		ts.putTrailStorage(t6);
		
		
		/*				
		System.out.println(ts.searchTrailStorage("Adam", "", "", "", "",""));
		//t1 = ts.getTrailStorage(ts.searchTrailStorage("",filter), 0);
		//System.out.println(t1);
		
		User u4 = us.createAccount("Scott", "Imandt", "Scooter", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex123", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy123", "12345");

		
			
		*/				
		//u4 = us.signOut();
		
		// Save instructions
		sf.setStoredData("A", us);
		sf.setStoredData("B", ts);
		sf.saveData(sf);
				
			
	}

}