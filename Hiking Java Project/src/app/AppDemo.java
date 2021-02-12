package app;

import model.Save_File;
import model.Trail;
import model.Trail_History;
import model.Trail_Storage;
import model.User;
import model.User_Storage;

public class AppDemo {

	public static void main(String[] args) {
		
		
		// Load instructions
		User_Storage us = new User_Storage();
		Trail_Storage ts = new Trail_Storage();
		Save_File sf = new Save_File(us, ts);
		sf = Save_File.loadData();
		us = (User_Storage) sf.getStoredData("A");
		ts = (Trail_Storage) sf.getStoredData("B");
		
		Trail t1 = new Trail("Name","123 bs bld",3,45,"LOOP","EASY");
		Trail t2 = new Trail("Name","231 bs bld",3,45,"LOOP","EASY");
		Trail t3 = new Trail("Name","yojo lane",3,45,"LOOP","EASY");
		
		ts.putTrailStorage(t1);
		ts.putTrailStorage(t2);
		ts.putTrailStorage(t3);
		
		System.out.println(ts.searchTrailStorage("bld"));
		t1 = ts.getTrailStorage(ts.searchTrailStorage("bld"), 0);
		System.out.println(t1);
		
		User u4 = us.createAccount("Scott", "Imandt", "Scooter", "12345");
		u4 = us.createAccount("Alex", "Imandt", "Alex123", "12345");
		u4 = us.createAccount("Susan", "Imandt", "SuSa", "12345");
		u4 = us.createAccount("Billy", "Imandt", "Billy123", "12345");
		u4 = us.signOut();	
			
		u4 = us.signIn("SuSa", "12345");
		System.out.println(u4.toString());
		Trail_History th = new Trail_History(t1,2021,1,11,3,00,"AM",2021,1,11,3,37,"PM",2);
		
		u4.addTrailHistory(th);
		
		System.out.println(u4.getTrailHistory());
		System.out.println(u4.toString());
		
		
			
						
		u4 = us.signOut();
		
		// Save instructions
		sf.setStoredData("A", us);
		sf.setStoredData("B", ts);
		sf.saveData(sf);
				
			
	}

}