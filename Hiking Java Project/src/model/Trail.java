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
	
	
	public Trail(String trailName, String trailHead, int trailLength, int elevation, String trailType, String trailDifficulty) {
		this.trailName = trailName;
		this.trailHead = trailHead;
		this.trailLength = trailLength;
		this.elevation = elevation;
		this.trailType = getTrailType(trailType);
		this.trailDifficulty = getTrailDifficulty(trailDifficulty);		
		
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

	public int getTrailLength() {
		return trailLength;
	}

	public void setTrailLength(int trailLength) {
		this.trailLength = trailLength;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public Type getTrailType() {
		return trailType;
	}

	public void setTrailType(String type) {
		this.trailType = getTrailType(type);
	}

	public Difficulty getTrailDifficulty() {
		return trailDifficulty;
	}

	public void setTrailDifficulty(String diff) {
		this.trailDifficulty = getTrailDifficulty(diff);
	}

	private Type getTrailType(String type) {
		if(type.equals("LOOP")) {
			return Type.LOOP;
		}
		if(type.equals("OUTANDBACK")) {
			return Type.OUTANDBACK;
		}
		if(type.equals("POINTTOPOINT")) {
			return Type.POINTTOPOINT;
		}
		return trailType;
	}
	
	private Difficulty getTrailDifficulty(String diff) {
		if(diff.equals("EASY")) {
			return Difficulty.EASY;
		}
		if(diff.equals("MODERATE")) {
			return Difficulty.MODERATE;
		}
		if(diff.equals("HARD")) {
			return Difficulty.HARD;
		}
		return trailDifficulty;
	}

	@Override
	public String toString() {
		return "TrailName=" + trailName + ", TrailHead=" + trailHead + ", TrailLength=" + trailLength
				+ ", Elevation=" + elevation + ", TrailType=" + trailType + ", TrailDifficulty=" + trailDifficulty;
	}

	public boolean startsWith(String key) {
		if(trailHead.contains(key)) {
			return true;
		}
		
		return false;
	}
	
		
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
