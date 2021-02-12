package model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;


public class Trail_History implements Serializable{
	
	private Trail trail;
	private String trailName;
	private Calendar dateStart = Calendar.getInstance();
	private Calendar dateEnd = Calendar.getInstance();
	private int distenceHiked;
	private double duration;
	private double averagepace;

	
	public Trail_History(Trail trail, int iniYear, int iniMonth, int iniDate, int iniHour, int iniMin,  String iniAmPm,
			int aftYear, int aftMonth, int aftDate, int aftHour, int aftMin, String aftAmPm, int distence) {
		this.trail = trail;
		this.trailName = trail.getTrailName();
		
		this.dateStart.set(iniYear, iniMonth, iniDate);
		setAmPm(dateStart, iniAmPm);
		setTime(dateStart, iniHour, iniMin);
		this.dateEnd.set(aftYear, aftMonth, aftDate);
		setAmPm(dateEnd, aftAmPm);
		setTime(dateEnd, aftHour, aftMin);
		this.distenceHiked = distence;
		this.duration = calcDuration(dateStart,dateEnd);
		this.averagepace = setPace((double)distenceHiked,duration);
	}
	public double setPace(double distence,double duration) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		return Double.parseDouble(df.format(distence/duration));	
	}
			
	public void setTime(Calendar cal, int hour, int min) {
		if(hour == 12) {
			hour = 0;
		}
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, min);
	}
	
	public double calcDuration(Calendar iniCal,Calendar aftCal) {
		long iniCalTime = iniCal.getTimeInMillis();
		long aftCalTime= aftCal.getTimeInMillis();
		double timeDiff;
						
		timeDiff = aftCalTime - iniCalTime;
		
		timeDiff = timeDiff/60000;	
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		timeDiff = timeDiff/60;		
		timeDiff = Double.parseDouble(df.format(timeDiff));
		return timeDiff;
	}
		
	public void setAmPm(Calendar cal, String AmPm) {
		if(AmPm.equals("AM")) {
			cal.set(Calendar.AM_PM,Calendar.AM);
		}
		
		if(AmPm.equals("PM")) {
			cal.set(Calendar.AM_PM,Calendar.PM);
		}
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


	public Calendar getDateStart() {
		return dateStart;
	}


	public void setDateStart(Calendar dateStart) {
		this.dateStart = dateStart;
	}


	public Calendar getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
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
		return "Trail_History Trail= " + trail +", dateStart= " + dateStart.getTime() + ", dateEnd= "
				+ dateEnd.getTime() + ", distenceHiked= " + distenceHiked+" Miles" + ", duration= " + duration+" Hours" + ", averagepace= "
				+ averagepace + " Miles/Hour";
	}
	
	
	
}
