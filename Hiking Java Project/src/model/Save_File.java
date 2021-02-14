package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;


public class Save_File implements Serializable{
	
	private static final String dataPath = "src/data/HikingSaveInfo.dat";
	private HashMap<String, Object> storedData = new HashMap<String, Object>(3);
	private final String  userDataKey = "A";
	private final String  trailDataKey = "B";
	
	
	
	public Save_File() {
		
	}
	
	public Save_File(User_Storage userStorage, Trail_Storage trailStorage) {
		storedData.put(userDataKey, userStorage);
		storedData.put(trailDataKey, trailStorage);
		
	}
	
	private static boolean dataFileExists() {
		File file = new File(dataPath);
		return file.exists();
	}
	
	public static Save_File loadData() {
		if (!dataFileExists()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath));) {		
				Save_File sf = new Save_File();
		         oos.writeObject(sf);
		    }
		    catch(Exception e) {
		    	//System.out.println("Unable to create file");
		    	System.out.println(e);
		    }
		}
		
		// 2 load file and rebuild instance
        Save_File sf = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataPath))) {
        	sf = (Save_File)(ois.readObject());
        }
        catch (Exception e){
            //System.out.println("Unable to load File");
        	System.out.println(e);
        }
        return sf;
		
	}
	
	public static boolean saveData(Save_File sf){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath));) {
            oos.writeObject(sf);
        }
        catch(Exception e){
            //System.out.println("Unable to save File");
        	System.out.println(e);
        }
        return true;
    }
	
	public void setStoredData(String key, Object o) {
		storedData.put(key, o);
		
	}
	
	public Object getStoredData(String key) {
		Object o = storedData.get(key);
		
		if(o == null && key.equals("A") ) {
			User_Storage us = new User_Storage();
			User u1 = new User();
			User u2 = new User("Admin", "Admin", "Admin", "Admin", "ADMIN","ADMIN");
			us.putUserStorage(u1.getUserName(), u1);
			us.putUserStorage(u2.getUserName(), u2);
			return us;
		}
		if(o == null && key.equals("B") ) {
			Trail_Storage ts = new Trail_Storage();						
			return ts;
		}
		
		return o;
		
	}


}
