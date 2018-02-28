/*
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * SPRING 2018
 * FRANKFURT
 * Bus implememntation
 */
package main.java.memoranda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import org.json.*;

public class BusImpl implements Bus {
    
    private int id;
    private String name;
    private int numberOfSeats;
    public static Vector<Date> schedule = new Vector<Date>();
    private final String dataStorageFile = "../../resources/data/buses/buses.json";
    FileInputStream dataIn = null;
    FileOutputStream dataOut = null;
    JSONObject dataObj = null;
    
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
    public void saveBus(int id, String name, int numSeats) {
        JSONObject bus = new JSONObject();
        bus.put("name", name);
        bus.put("id", id);
        bus.put("seats", numSeats);
        
        dataObj.put("id", bus);
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
        try {
            dataIn = new FileInputStream(dataStorageFile);
            dataObj = new JSONObject(new JSONTokener(dataIn));
            System.out.println(dataObj.toString(2));
            //populatePoints();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Method to write data to file
    private void writeToFile() {
        try {
            dataOut = new FileOutputStream(dataStorageFile);
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
