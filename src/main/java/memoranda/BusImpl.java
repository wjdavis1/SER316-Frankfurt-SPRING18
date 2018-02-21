/*
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * SPRING 2018
 * FRANKFURT
 * Bus implememntation
 */
package main.java.memoranda;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import org.json.*;

public class BusImpl implements Bus {
	
	private int id;
	private int numberOfSeats;
	public static Vector<Date> schedule = new Vector<Date>();
	private final String dataStorage = "../../resources/data/buses/buses.json";
	
	public BusImpl() {
		id = 0;
		numberOfSeats = 0;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public BusImpl(int id, int seats) {
		this.id = id;
		this.numberOfSeats = seats;
	}
	
	/*
	 * @see main.java.memoranda.Bus#getNumberOfSeats()
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/*
	 * @see main.java.memoranda.Bus#getId()
	 */
	public int getId() {
		
		return id;
	}
	/*
	 * @see main.java.memoranda.Bus#setNumberOfSeats()
	 */
	public void setNumberOfSeats(int seats) {
		numberOfSeats = seats;
	}
	/*
	 * @see main.java.memoranda.Bus#addToSchedule(java.sql.Date)
	 */
	public void addToSchedule(Date scheduleDate, Time scheduleTime) {
		schedule.add(scheduleDate);
	}
	/*
	 * @see main.java.memoranda.Bus#removeFromSchedule(java.sql.Date)
	 */
	public void removeFromSchedule(Date scheduleDate, Time scheduleTime) {

	}
	/*
	 * @see main.java.memoranda.Bus#getSchedule()
	 */
	public Vector<Date> getSchedule() {

		return schedule;
	}
	
	/*
	 * (non-Javadoc)
	 * @see main.java.memoranda.Bus#saveBus()
	 */
	public void saveBus() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see main.java.memoranda.Bus#readBusData()
	 */
	public JSONObject readBusData() {
		return new JSONObject();
	}
	
}
