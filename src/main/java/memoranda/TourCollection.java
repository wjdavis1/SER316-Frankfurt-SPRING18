package main.java.memoranda;
/**
+ * File Name: TourCollection.java
+ * Description: The class creates and populates a Vector of TourImpl objects by reading in a JSON file 
+ * 		parsing the data into separate TourImpl objects, as well as writing the Vector's TourImpl objects 
			back to the JSON file as a single JSONObject 
+ * Author: Jesse Sabbath
+ * Date: February 22, 2018
+ * 
+ */

import org.json.JSONObject;
import org.json.JSONTokener;
import main.java.memoranda.TourImpl;
import java.util.Vector;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;



public class TourCollection  {
	
	Vector<TourImpl> tourList;
	TourImpl tour;
	String tourCollectionFilePath = "src/main/resources/data/tours/tours.json";
	
	public TourCollection() {
		tourList = null;
		tour = null;
		
	}
	
	public TourCollection(String fileName){
		try{
	    	  
			 tourList = new Vector<TourImpl>();
			 FileInputStream in = new FileInputStream(tourCollectionFilePath);
			
		     JSONObject obj = new JSONObject(new JSONTokener(in));
		     String [] tours = JSONObject.getNames(obj);
		 
		     for (int i=0; i< tours.length; i++) {
		    	 tour = new TourImpl((JSONObject)obj.getJSONObject(tours[i]));
		     	 tourList.addElement(tour);
		     }
	
	         in.close();
	     }
		
	     catch (Exception ex) {
	         System.out.println("Exception importing from json: "+ex.getMessage());
	     }
	  }

	  public void addTour(TourImpl aTour) {
		  tourList.add(aTour);
	  }
	  
	  public void removeTour(Tour aTour) {
		  tourList.remove(aTour);
	  }
	  
	  public TourImpl getTour(String tourID) {
		  TourImpl aTour = new TourImpl();
		  for (int i = 0; i < tourList.size(); i++) {
			  if (tourList.elementAt(i).getTourID().equals(tourID))
				  aTour = tourList.elementAt(i);
		  }
		  return aTour;
	  }
	  
	/* public static void main(String[] args) {                                 //DEBUG
		 TourCollection thisCollection = new TourCollection("tours.json");
		 	 
	  }*/
}



