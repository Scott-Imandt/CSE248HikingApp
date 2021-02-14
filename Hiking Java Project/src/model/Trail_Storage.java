package model;

import java.io.Serializable;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Trail_Storage implements Serializable{
	
	private TreeSet<Trail> trailStorage = new TreeSet<Trail>();

	public void putTrailStorage( Trail trail) {
		if(getComparator(trail.getTrailHead())) {
			
			System.out.println("Cannot Create new trail because trail already exist");
		}
		
		else trailStorage.add(trail);	

	}
		
	public List searchTrailStorage(String nameKey, String headKey,  String lengthKey, String elevationKey, String typeKey, String diffKey) {
			
		 List<Trail> returnValue = trailStorage.stream().filter(x -> x.startsWithName(nameKey) && x.startsWithHead(headKey) && x.startsWithLength(lengthKey) && x.startsWithElevation(elevationKey)&&
				 x.startsWithType(typeKey) && x.startsWithDiff(diffKey)).collect(Collectors.toList());
		 
		return returnValue;
	}
	
	public Trail getTrailStorage(List<Trail> result, int index) {
		return result.get(index);
	}
	
	
	public void removetrail(User user, Trail trail) {
		if(user.getAuthType().toString().equals("ADMIN")) {
			trailStorage.remove(trail);
			System.out.println("Trail Was removed");
		}
		else System.out.println("Unable to remove Trail Check Authentication or Trail");	
	}
	
	public boolean getComparator(String key) {
		Trail temp = new Trail("", key, 0, 0, "", "");
		return trailStorage.contains(temp);
		
		
	}
	
}
