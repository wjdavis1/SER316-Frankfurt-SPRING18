/*
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * SPRING 2018
 * FRANKFURT
 * Interface for Bus Object
 */
package main.java.memoranda;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;

public interface Bus {
	
	public final int SPEEED = 30;		// Constant speed for all buses
	
	void setID(int id);						// Method to set Bus ID
	int getNumberOfSeats();				// Method to return number of seats in a bus
	int getId();							// Method to retun bus ID
	void setNumberOfSeats(int seats);				// Method to set number Of Seats in a bus
	void addToSchedule(Date scheduleDate, Time scheduleTime);				// Method to add a new schedule to bus schedule
	void removeFromSchedule(Date scheduleDate, Time scheduleTime);			// Method to remove schedule from bus schedule
	Vector<Date> getSchedule();								// Method to return full schedule of bus
	
}
