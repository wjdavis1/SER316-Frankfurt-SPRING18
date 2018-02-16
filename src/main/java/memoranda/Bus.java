/*
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * SPRING 2018
 * FRANKFURT
 * Interface for Bus Object
 */
package main.java.memoranda;

import java.sql.Date;

public interface Bus {
	
	public final int SPEEED = 30;		// Constant speed for all buses
	
	int getNumberOfSeats();				// Method to return number of seats in a bus
	int getId();							// Method to retun bus ID
	void setNumberOfSeats(int seats);				// Method to set number Of Seats in a bus
	void addToSchedule(Date schedule);				// Method to add a new schedule to bus schedule
	void removeFromSchedule(Date schedule);			// Method to remove schedule from bus schedule
	Date getSchedule();								// Method to return full schedule of bus
	
}
