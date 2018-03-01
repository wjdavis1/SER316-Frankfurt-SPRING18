/*
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * SPRING 2018
 * FRANKFURT
 * Bus implememntation
 */
package main.java.memoranda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import org.json.*;

import main.java.memoranda.ui.App;

public class BusImpl implements Bus {
    
    private int id;
    private String name;
    private int numberOfSeats;
    public static Vector<Date> schedule = new Vector<Date>();
    private final String dataStorageFile = "/data/buses/buses.json";
    FileInputStream dataIn = null;
    FileOutputStream dataOut = null;
    JSONObject dataObj = null;
    private File busesFile;
    
    public BusImpl() {
        id = 0;
        numberOfSeats = 0;
        dataObj = new JSONObject();
        readFile();
    }
    
    public void setID(int id) {
        this.id = id;
    }
    public BusImpl(int id, String name,int seats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = seats;
    }
    
	/*
	 * (non-Javadoc)
	 * @see main.java.memoranda.Bus#setName()
	 */
	public void setName(String name) {
		this.name = name;
	}
	
    /*
     * (non-Javadoc)
     * @see main.java.memoranda.Bus#getname()
     */
	public String getName() {
		
		return name;
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
    public void saveBus(int id, String name, int numSeats) {
        JSONObject bus = new JSONObject();
        bus.put("name", name);
        bus.put("id", id);
        bus.put("seats", numSeats);
        String newBusId = id+"";
        dataObj.put(newBusId, bus);
        writeToFile();
    }
    
    /*
     * (non-Javadoc)
     * @see main.java.memoranda.Bus#readBusData()
     */
    public JSONObject readBusData() {
        JSONObject bus = null;
        readFile();
        bus = (JSONObject) dataObj.get(name);
        return bus;
    }
    
    // Method to read data file
    private void readFile() {
    		busesFile = new File(App.class.getResource(dataStorageFile).getFile());
    		try {
				dataIn = new FileInputStream(busesFile);
				dataObj = new JSONObject(new JSONTokener(dataIn));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    // Method to write data to file
    private void writeToFile() {
    		busesFile = new File(App.class.getResource(dataStorageFile).getFile());
        try {
            dataOut = new FileOutputStream(busesFile);
            dataOut.write(dataObj.toString().getBytes());
            System.out.println(dataObj.toString(2));
            //populatePoints();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
