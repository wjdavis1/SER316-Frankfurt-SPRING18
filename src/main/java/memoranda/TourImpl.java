package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;

import java.time.LocalTime;
import java.io.Serializable;

public class TourImpl implements JSONString, Serializable {
	private int tourID;
	private CalendarDate date; 
	private LocalTime time; 
	private String routeID;
	private String driverID;
	private String busID;
	
	
	public TourImpl() {
		tourID = 1;
		date = new CalendarDate(1, 1, 1979);
		time = LocalTime.NOON;
		
	}
	
	public TourImpl(int tourID, CalendarDate date, LocalTime time) {  //Route, Drive, and Bus Fields to be added later
		this.tourID = tourID;
		this.date = date;
		this.time = time;
	}

	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public CalendarDate getDate() {
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
	
	
	
}
