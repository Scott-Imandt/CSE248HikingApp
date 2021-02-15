package model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;


public class Trail_History implements Serializable{
	
	private Trail trail;
	private String trailName;
	private int distenceHiked;
	private double duration;
	private double averagepace;
	private Calendar_Trail dateStart;
	private Calendar_Trail dateEnd;
	private String uploadFile;
	private String date;

	
	public Trail_History(Trail trail,Calendar_Trail dateStart,Calendar_Trail dateEnd, int distence, String uploadFile) {
		this.trail = trail;
		this.trailName = trail.getTrailName();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.distenceHiked = distence;
		this.duration = calcDuration(dateStart.getCalendar(),dateEnd.getCalendar());
		this.averagepace = setPace((double)distenceHiked,duration);
		setImageLocation(uploadFile);
		setDate();
				
	}
	
	public void setImageLocation(String imageLocation) {
		if(imageLocation == null) {
			this.uploadFile = null;
		}
		else this.uploadFile = imageLocation;
	}
	
	public String getImageLocation() {
		return uploadFile;
	}
	
	public double calcDuration(Calendar iniCal,Calendar aftCal) {
		long iniCalTime = iniCal.getTimeInMillis();
		long aftCalTime= aftCal.getTimeInMillis();
		double timeDiff;
						
		timeDiff = aftCalTime - iniCalTime;
		
		timeDiff = timeDiff/60000;	
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		timeDiff = timeDiff/60;		
		timeDiff = Double.parseDouble(df.format(timeDiff));
		return timeDiff;
	}
	
	public double setPace(double distence,double duration) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		
		return Double.parseDouble(df.format(distence/duration));	
	}
	
	public void setDate() {
		
		String result = dateEnd.getCalendar().get(Calendar.MONTH) + "/" + dateEnd.getCalendar().get(Calendar.DATE) + "/" + dateEnd.getCalendar().get(Calendar.YEAR);
		
		this.date = result;
	}
	
	public String getDate() {
		return date;
	}
	
	
	
	public Trail getTrail() {
		return trail;
	}


	public void setTrail(Trail trail) {
		this.trail = trail;
	}


	public String getTrailName() {
		return trailName;
	}


	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

		
	public int getDistenceHiked() {
		return distenceHiked;
	}


	public void setDistenceHiked(int distenceHiked) {
		this.distenceHiked = distenceHiked;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getAveragepace() {
		return averagepace;
	}


	public void setAveragepace(int averagepace) {
		this.averagepace = averagepace;
	}
	
	
	@Override
	public String toString() {
		return "Trail_History Trail= " + trail +", dateStart= " + dateStart.toString() + ", dateEnd= "
				+ dateEnd.toString() + ", distenceHiked= " + distenceHiked+" Miles" + ", duration= " + duration+ " Hours" + ", averagepace= "
				+ averagepace + " Miles/Hour" + "UploadFile= " + uploadFile;
	}
	
	
	
}
