package main.java.memoranda;

import java.sql.Date;
import java.util.Vector;

public class BusImpl implements Bus {
	
	private int id;
	private int numberOfSeats;
	public static Vector<Date> schedule = new Vector<Date>();
	
	public BusImpl() {
		id = 0;
		numberOfSeats = 0;
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
	public void addToSchedule(Date newSchedule) {
		schedule.add(newSchedule);
	}
	/*
	 * @see main.java.memoranda.Bus#removeFromSchedule(java.sql.Date)
	 */
	public void removeFromSchedule(Date schedule) {

	}
	/*
	 * @see main.java.memoranda.Bus#getSchedule()
	 */
	public Date getSchedule() {

		return new Date(0);
	}
	
}
