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


import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class DriverCollection implements JSONString, Serializable{
	
	private Map<String,Driver> driverCollection;
	
	private String driversDataPath = "/data/drivers/";
	private File driversFile;
	
	public DriverCollection(String fileName) {
		driversDataPath += fileName;
		System.out.println("[DEBUG]" +driversDataPath);
		driverCollection = new HashMap<>();
		driversFile = new File(main.java.memoranda.ui.AppFrame.class.getResource(driversDataPath).getFile());
		if(driversFile.exists() && !driversFile.isDirectory()) {
			System.out.println("File Exists!");
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
	
	public DriverCollection(JSONObject obj) {
		
	}
	
	public boolean addDriver(DriverImpl newDriver) {
		
		for(String driverID : driverCollection.keySet()) {
			
			if(!newDriver.getDriverId().equals(driverID)) {
				driverCollection.put(newDriver.getDriverId(), newDriver);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
