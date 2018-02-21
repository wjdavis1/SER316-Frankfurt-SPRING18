package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;

import java.time.LocalTime;


public class TourImpl {
	private int tourID;
	private CalendarDate date; 
	private LocalTime time; 
	/*private Route route;
	private Driver driver;
	private Bus bus;*/
	
	
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

	/*public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	*/
	
	
}
