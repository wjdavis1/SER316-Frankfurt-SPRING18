package main.java.memoranda;
/**
+ * File Name: TourImpl.java
+ * Description: Implementation of the Tour.java interface. Creates TourImpl objects 
			with the ability to convert to and from JSON objects
+ * Author: Jesse Sabbath
+ * Date: February 22, 2018
+ * 
+ */

import main.java.memoranda.date.CalendarDate;
import java.time.LocalTime;
import java.io.Serializable;

import org.json.*;

public class TourImpl implements Tour, Serializable {
	
	private String tourID;
	private String date; 
	private String time; 
	private String routeID;
	private String driverID;
	private String busID;
	
	
	public TourImpl() {
		
		//Possible future date / time implementation .
		//date = new CalendarDate(1, 1, 1979);
		//time = LocalTime.NOON;
	    tourID = "1";
		date = "";
		time = "";
		routeID="";
		driverID="";
		busID="";
	}
	
	public TourImpl(String tourID, String routeID, String driverID, String busID, String time, String date) {
		this.tourID = tourID;
		this.date = date;
		this.time = time;
		this.routeID=routeID;
		this.driverID=driverID;
		this.busID=busID;
	}
	
	
	public TourImpl(JSONObject obj) {
		tourID = obj.getString("tourID");
		routeID = obj.getString("routeID");
		driverID = obj.getString("driverID");
		busID = obj.getString("busID");
		date = obj.getString("date");
		time = obj.getString("time");
		
	}

	//Mutators 
	public String getTourID() {
		return tourID;
	}

	public void setTourID(String tourID) {
		this.tourID = tourID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getBusID() {
		return busID;
	}

	public void setBusID(String busID) {
		this.busID = busID;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("tourID", tourID);
		obj.put("routeID", routeID);
		obj.put("driverID", driverID);
		obj.put("busID", busID);
		obj.put("date", date);
		obj.put("time", time);
		return obj;	
	}
	
	public String toString() {
		String tourString = getTourID() + " " + getRouteID() + " " + getDriverID() + " " + getBusID() 
		                + " " + getDate() + " " + getTime();
	
		return tourString;
	}
	
	public boolean equals(TourImpl aTour) {
		if (this.tourID.equals(aTour.tourID) && this.routeID.equals(aTour.getRouteID()) &&
			this.driverID.equals(aTour.getDriverID()) && this.busID.equals(aTour.getBusID()) &&
			this.date.equals(date) && this.time.equals(time))
			return true;
		return false;
	}
	
	
}
