package main.java.memoranda;
/**
 * File Name: DriverImpl.java
 * Description: Implementation of the Driver Interface, used for 
 * storing Driver data such as name, age id if needed.
 * @author Wesley Davis
 *
 */

import nu.xom.Attribute;
import nu.xom.Element;

public class DriverImpl implements Driver {
	
	private String firstName;
	private String lastName;
	private String driverID;
	private String busID;
	private int age;
	
	public DriverImpl() {
		firstName = null;
		lastName = null;
		driverID = null;
		busID = null;
		age = 0;
	}
	
	public DriverImpl(String firstName, String lastName, String driverID, String busID,int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.driverID = driverID;
		this.busID = busID;
		this.age = age;
	}


	@Override
	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String getDriverId() {
		return driverID;
	}
	
	@Override
	public String getBusID() {
		return busID;
	}

	@Override
	public int getAge() {
		return age;
	}
	

}
