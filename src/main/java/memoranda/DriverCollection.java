/**
 * File Name: DriverCollection.java
 * Author: Wesley Davis
 * Date: February 19th, 2018
 * 
 * Description: Holds a collection of drivers, stores them into a file, and retrieves the file contents that holds driver
 * information. When the Driver panel loads up, a table of drivers will be listed.
 * 
 */
package main.java.memoranda;



import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.File;

import main.java.memoranda.DriverImpl;
import org.json.*;



/**
 * Class: DriverCollection
 * Description:  A class that holds a HashSet of Drivers, organized by their ID and the Driver Object.
 *
 */
public class DriverCollection implements  Serializable{
	
	private Map<String,Driver> driverCollection;
	private Set<String> driverIDs;
	
	private String driversDataPath = "/data/drivers/";
	private File driversFile;
	private FileInputStream in;
	private String fileName;
	
	public DriverCollection(String fileName) {
		driversDataPath += fileName;
		System.out.println("[DEBUG]" +driversDataPath);
		driverCollection = new HashMap<>();
		//driverIDs = new HashSet<>();
		//driverIDs = driverCollection.keySet();
		this.fileName = fileName;
		readFromFile();
	}
	/**
	 * Method: addDriver
	 * 
	 * Input: Driver Object 
	 * Return: Boolean
	 * Description: Adds a new driver to the DriverCollection HashMap, checks to see
	 * if the driver is already in the set by driver id. If the driver is not in the system,
	 * the method adds it in and returns true, else false. The boolean return is for GUI
	 * purposes
	 */
	public boolean addDriver(DriverImpl newDriver) {
		boolean canAdd = false;
		
		if(!driverCollection.containsKey(newDriver.getDriverId())) {
			driverCollection.put(newDriver.getDriverId(), newDriver);
			canAdd = true;
		}
		
		return canAdd;
		
	}
	
	/**
	 * Method: removeDriver
	 * 
	 * Input: DriverID
	 * Return: Boolean
	 * 
	 * Description: Looks for 
	 */
	public boolean removeDriver(String driverID) {
	    boolean canRemove = false;
	    HashMap<String,Driver> drivers = getDrivers();
	    
	    if(drivers.containsKey(driverID)) {
	        drivers.remove(driverID, drivers.get(driverID));
	        canRemove = true;
	    }
	    return canRemove;
	}
	/**
	 * Method saveToFile
	 * 
	 * Input: None
	 * Return: None
	 * @throws IOException
	 * Description: Converts the DriverCollection into a string and writes it to the JSONFile
	 */
	public void saveToFile() throws IOException {
		FileWriter out = new FileWriter(driversFile);
		JSONObject obj = new JSONObject();
		for(String driverID : driverCollection.keySet()) {
			obj.put(driverID, driverCollection.get(driverID).toJsonObject());
		}
		out.write(obj.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * Method: readFromFile
	 * Input: None
	 * Return: None
	 * Description: Reads in the JSON Objects from the file and converts them into the DriverCollection
	 */
	public void readFromFile() {
		driversFile = new File(main.java.memoranda.ui.AppFrame.class.getResource(driversDataPath).getFile());
		if(driversFile.exists() && !driversFile.isDirectory()) {
			System.out.println("[DEBUG] File Exists!");
			try {
				in = new FileInputStream(driversFile);
				JSONObject obj = new JSONObject(new JSONTokener(in));
				
				if(obj.length() == 0) {
					
					System.out.println("[DEBUG] No Drivers Available");

				}else {
					String[] driverIDs = JSONObject.getNames(obj);
					for(int i = 0; i < driverIDs.length; i++) {
						System.out.println("[DEBUG] " + driverIDs[i]);
						Driver driver = new DriverImpl((JSONObject)obj.getJSONObject(driverIDs[i]));
						driverCollection.put(driverIDs[i], driver);
					}
				}
				
				in.close();
				
				for(String driverID: driverCollection.keySet()) {
					System.out.println("[DEBUG] " +driverID + " Driver Name: " + driverCollection.get(driverID).getFullName()); 
				}
			}catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}else {
			driversFile = new File(this.driversDataPath + fileName);
			try {
				if(driversFile.createNewFile()) {
					System.out.println("Created: " + fileName + " Found in: " + driversDataPath);
				}
			}catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
		
	}
	
	/**
	 * Method: getDrivers
	 * Input: None
	 * Return: HashMap with driver ids and information
	 * Description: Static method that creates a new HashMap Drivers to be used with other panels
	 * and other classes for data retrieval.
	 */
	public static HashMap<String,Driver> getDrivers(){
		Map<String, Driver> drivers = new HashMap<String, Driver>();
		String filePath = "/data/drivers/drivers.json";
		File file = new File(main.java.memoranda.ui.AppFrame.class.getResource(filePath).getFile());
		
		try {
			FileInputStream in = new FileInputStream(file);
			JSONObject obj = new JSONObject(new JSONTokener(in));
			
			String[] ids = JSONObject.getNames(obj);
			for(int i = 0; i < ids.length; i++) {
				Driver newDriver = new DriverImpl((JSONObject)obj.getJSONObject(ids[i]));
				drivers.put(ids[i], newDriver);
			}
			
			in.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return (HashMap<String,Driver>)drivers;
	}

}
