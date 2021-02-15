package model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Calendar_Trail implements Serializable{
	
	private Calendar cal = Calendar.getInstance();
		
	public Calendar_Trail( int iniYear, int iniMonth, int iniDate, int iniHour, int iniMin, String iniAmPm) {
		this.cal.set(iniYear, iniMonth, iniDate);
		setAmPm(cal, iniAmPm);
		setTime(cal, iniHour, iniMin);
	}
			
	public void setTime(Calendar cal, int hour, int min) {
		if(hour == 12) {
			hour = 0;
		}
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, 0);
	}
				
	public void setAmPm(Calendar cal, String AmPm) {
		if(AmPm.equals("AM")) {
			cal.set(Calendar.AM_PM,Calendar.AM);
		}
		
		if(AmPm.equals("PM")) {
			cal.set(Calendar.AM_PM,Calendar.PM);
		}
	}
	
	public Calendar getCalendar() {
		return cal;
	}
	
	public String getMin() {
		if(cal.get(Calendar.MINUTE) == 0) {
			return "00";
		}
		else return String.valueOf(cal.get(Calendar.MINUTE));
	}
	
	public String getHour() {
		if(cal.get(Calendar.HOUR) == 0) {
			return "12";
		}
		else return String.valueOf(cal.get(Calendar.HOUR));
	
	}
	
	
	public String toString() {
		return "Date: " + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR) +
				"Time: " + getHour() + ":" + getMin();
	}
	
	
	
	

}
