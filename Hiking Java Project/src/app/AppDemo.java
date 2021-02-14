package app;

import javafx.application.Application;
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
	
	
	public static void main(String[] args) {
		
		
		// Load instructions
		
		sf = Save_File.loadData();
		us = (User_Storage) sf.getStoredData("A");
		ts = (Trail_Storage) sf.getStoredData("B");
		
		
		
		Application.launch(JavaFxApplication.class, args);
		
		
		/*
		Trail t1 = new Trail("Adam","6 bs bld",3,45,"LOOP","EASY");
		Trail t2 = new Trail("Betty","5 bs bld",4,55,"OUTANDBACK","MODERATE");
		Trail t3 = new Trail("Carl","4 lane",4,65,"POINTTOPOINT","HARD");
		Trail t4 = new Trail("David","3 bs bld",3,45,"LOOP","EASY");
		Trail t5 = new Trail("Eurl","2 bs bld",4,55,"OUTANDBACK","MODERATE");
		Trail t6 = new Trail("Frank","1 lane",4,65,"POINTTOPOINT","HARD");
		
		ts.putTrailStorage(t1);
		ts.putTrailStorage(t2);
		ts.putTrailStorage(t3);
		ts.putTrailStorage(t4);
		ts.putTrailStorage(t5);
		ts.putTrailStorage(t6);
						
		System.out.println(ts.searchTrailStorage("Adam", "", "", "", "",""));
		//t1 = ts.getTrailStorage(ts.searchTrailStorage("",filter), 0);
		//System.out.println(t1);
		
		User u4 = us.createAccount("Scott", "Imandt", "Scooter", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex123", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy123", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex1232", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa2", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy1232", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex1233", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa3", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy1233", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex12323", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa23", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy12323", "12345");
		
		
		
		
		u4 = us.signOut();	
			
		u4 = us.signIn("SuSa", "12345");
		System.out.println(u4.toString());
		Trail_History th = new Trail_History(t1,2021,1,11,3,00,"AM",2021,1,11,3,37,"PM",2);
		
		u4.addTrailHistory(th);
		
		System.out.println(u4.getTrailHistory());
		System.out.println(u4.toString());
		
		
			
		*/				
		//u4 = us.signOut();
		
		// Save instructions
		sf.setStoredData("A", us);
		sf.setStoredData("B", ts);
		sf.saveData(sf);
				
			
	}

}