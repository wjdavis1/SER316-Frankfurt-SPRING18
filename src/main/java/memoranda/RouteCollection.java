/**
 * File Name: RouteCollection.java
 * Author: James Ortner
 * Date: February 21st, 2018
 * 
 * Description: Holds a collection of routes, stores them into a file, and retrieves the file contents that holds driver
 * information. When the Route panel loads up, a table of routes will be listed.
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

import main.java.memoranda.RouteImpl;
import org.json.*;



/**
 * Class: RouteCollection
 * Description:  A class that holds a HashSet of Routes, organized by their ID and the Route Object.
 *
 */
public class RouteCollection implements JSONString, Serializable{
	
	private Map<String,Route> routeCollection;
	
	private String routeDataPath = "/data/routes/";
	private File routesFile;
	
	public RouteCollection(String fileName) {
		routeDataPath += fileName;
		System.out.println("[DEBUG]" +routeDataPath);
		routeDataPath = new HashMap<>();
		routesFile = new File(main.java.memoranda.ui.AppFrame.class.getResource(routeDataPath).getFile());
		if(routesFile.exists() && !routesFile.isDirectory()) {
			System.out.println("File Exists!");
		}else {
			routesFile = new File(this.routeDataPath + fileName);
			try {
				if(routesFile.createNewFile()) {
					System.out.println("Created: " + fileName + " Found in: " + routeDataPath);
				}
			}catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
	
	public RouteCollection(JSONObject obj) {
		
	}
	
	public boolean addDriver(RouteImpl newRoute) {
		
		for(String routeId : routeCollection.keySet()) {
			
			if(!newRoute.getRouteId().equals(routeId)) {
				routeCollection.put(newRoute.getRouteId(), newRoute);
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