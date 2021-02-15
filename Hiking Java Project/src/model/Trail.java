package model;

import java.io.Serializable;

import model.User.role;

public class Trail implements Comparable<Trail>, Serializable{
	
	enum Type{
		LOOP, OUTANDBACK, POINTTOPOINT;
	}
	enum Difficulty{
		EASY, MODERATE, HARD;
	}
	
	
	private String trailName;
	private String trailHead;
	private int trailLength;
	private int elevation;
	private Type trailType;
	private Difficulty trailDifficulty;
	private String imageLocation;
	
	
	public Trail(String trailName, String trailHead, int trailLength, int elevation, String trailType, String trailDifficulty, String imageLocation) {
		this.trailName = trailName;
		this.trailHead = trailHead;
		this.trailLength = trailLength;
		this.elevation = elevation;
		this.trailType = getTrailType(trailType);
		this.trailDifficulty = getTrailDifficulty(trailDifficulty);
		setImageLocation(imageLocation);
		
	}
	
	
	
	public String getImageLocation() {
		return imageLocation;
	}



	public void setImageLocation(String imageLoaction) {
		if(imageLoaction == null) {
			this.imageLocation = "/data/Hiking_Images/Default.jpg";
		}
		else this.imageLocation = imageLoaction;
	}



	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public String getTrailHead() {
		return trailHead;
	}

	public void setTrailHead(String trailHead) {
		this.trailHead = trailHead;
	}

	public String getTrailLength() {
		return String.valueOf(trailLength);
	}

	public void setTrailLength(int trailLength) {
		this.trailLength = trailLength;
	}

	public String getElevation() {
		
		return String.valueOf(elevation);
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public String getTrailType() {
		return trailType.toString();
	}

	public void setTrailType(String type) {
		this.trailType = getTrailType(type);
	}

	public String getTrailDifficulty() {
		return trailDifficulty.toString();
	}

	public void setTrailDifficulty(String diff) {
		this.trailDifficulty = getTrailDifficulty(diff);
	}

	private Type getTrailType(String type) {
		if(type.equalsIgnoreCase("LOOP")) {
			return Type.LOOP;
		}
		if(type.equalsIgnoreCase("OUTANDBACK")) {
			return Type.OUTANDBACK;
		}
		if(type.equalsIgnoreCase("POINTTOPOINT")) {
			return Type.POINTTOPOINT;
		}
		return trailType;
	}
	
	private Difficulty getTrailDifficulty(String diff) {
		if(diff.equalsIgnoreCase("EASY")) {
			return Difficulty.EASY;
		}
		if(diff.equalsIgnoreCase("MODERATE")) {
			return Difficulty.MODERATE;
		}
		if(diff.equalsIgnoreCase("HARD")) {
			return Difficulty.HARD;
		}
		return trailDifficulty;
	}

	@Override
	public String toString() {
		return "TrailName=" + trailName + ", TrailHead=" + trailHead + ", TrailLength=" + trailLength
				+ ", Elevation=" + elevation + ", TrailType=" + trailType + ", TrailDifficulty=" + trailDifficulty;
	}


	public boolean startsWithName(String nameKey) {
		if(this.getTrailName().toLowerCase().startsWith(nameKey.toLowerCase())) {
			return true;
		}
		
		return false;
	}
	public boolean startsWithHead(String headKey) {
		if(this.getTrailHead().toLowerCase().startsWith(headKey.toLowerCase())) {
			return true;
		}
		
		return false;
	}
	public boolean startsWithLength(String lengthKey) {
		if(lengthKey.equals("") || lengthKey.contentEquals("All Lengths")) {
			return true;
		}
				
		if(trailLength == Integer.parseInt(lengthKey)) {
			return true;
		}
		
		return false;
	}
	public boolean startsWithElevation(String elevationKey) {
		if(elevationKey.equals("") || elevationKey.equals("All Elevations")) {
			return true;
		}
		
		if(elevation == Integer.parseInt(elevationKey)) {
			return true;
		}
		
		return false;
	}
	public boolean startsWithDiff(String diffKey) {
		
		if(trailDifficulty == getTrailDifficulty(diffKey)|| trailType.equals("All Difficulties")) {
			return true;
		}
		
		return false;
	}
	public boolean startsWithType(String typeKey) {
		if(trailType == getTrailType(typeKey)|| trailType.equals("All Types")) {
			return true;
		}
		
		return false;
	}
	
	//public boolean startsWithType(String typeKey) {
	//	if( trailType.toString().equalsIgnoreCase(typeKey) || trailType.equals("All Types")) {
	//		return true;
	//	}
	//	
	//	return false;
	//}
	
		
	@Override
	public int compareTo(Trail aKey) {
		
		int compareResult = this.trailHead.compareTo(aKey.trailHead);
		
		if(compareResult == 0) {
			return 0;
		}
		
		if(compareResult < 1) {
			return -1;
		}
		
		if(compareResult > 1) {
			return 1;
		}
		
		else {
			return compareResult;
		}
		
	}


}
