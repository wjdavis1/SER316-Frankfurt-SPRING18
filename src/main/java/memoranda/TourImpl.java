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
	//private CalendarDate date; 
	//private LocalTime time; 
	private String routeID;
	private String driverID;
	private String busID;
	
	
	public TourImpl() {
		tourID = "1";
		//date = new CalendarDate(1, 1, 1979);
		//time = LocalTime.NOON;
		routeID=null;
		driverID=null;
		busID=null;
	}
	
	public TourImpl(String tourID, String routeID, String driverID, String busID) {
		this.tourID = tourID;
		//this.date = date;
		//this.time = time;
		this.routeID=routeID;
		this.driverID=driverID;
		this.busID=busID;
	}
	
	public TourImpl(JSONObject obj) {
		tourID = obj.getString("tourID");
		routeID = obj.getString("routeID");
		driverID = obj.getString("driverID");
		busID = obj.getString("busID");
	}

	public String getTourID() {
		return tourID;
	}

	public void setTourID(String tourID) {
		this.tourID = tourID;
	}

	/*public CalendarDate getDate() {
		return date;
	}

	public void setDate(CalendarDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}*/

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
		return obj;	
	}
	
	public String toString() {
		String tourString = getTourID() + " " + getRouteID() + " " + getDriverID() + " " + getBusID();
		return tourString;
	}
	
	public boolean equals(TourImpl aTour) {
		if (this.tourID.equals(aTour.tourID) && this.routeID.equals(aTour.getRouteID()) &&
			this.driverID.equals(aTour.getDriverID()) && this.busID.equals(aTour.getBusID()))
			return true;
		return false;
	}
	
	
}
