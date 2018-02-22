package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;

import java.time.LocalTime;
import java.io.Serializable;

public interface Tour extends Serializable {

	public int getTourID();
	public void setTourID(int tourID);
	public CalendarDate getDate();
	public void setDate(CalendarDate date);
	public LocalTime getTime();
	public void setTime(LocalTime time);
	public String getRouteID();
	public void setRouteID(String routeID);
	public String getDriverID();
	public void setDriverID(String driverID);
	public String getBusID();
	public void setBus(String busID);
	
	
}
