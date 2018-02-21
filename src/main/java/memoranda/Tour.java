package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;

import java.time.LocalTime;


public interface Tour {

	public int getTourID();
	public void setTourID(int tourID);
	public CalendarDate getDate();
	public void setDate(CalendarDate date);
	public LocalTime getTime();
	public void setTime(LocalTime time);
	/*public Route getRoute();
	public void setRoute(Route route);
	public Driver getDriver();
	public void setDriver(Driver driver);
	public Bus getBus();
	public void setBus(Bus bus);
	*/
	
}
