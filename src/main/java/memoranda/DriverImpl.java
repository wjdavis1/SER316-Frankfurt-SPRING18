package main.java.memoranda;
/**
 * File Name: DriverImpl.java
 * Description: Implementation of the Driver Interface, used for 
 * storing Driver data such as name, age id if needed.
 * @author wesleydavis
 *
 */

import nu.xom.Attribute;
import nu.xom.Element;

public class DriverImpl implements Driver {
	
	private String firstName;
	private String lastName;
	private String driverID;
	private int age;
	
	// This variable is used when creating an XML document for storing Driver information.
	private Element _elem = null;
	
	
	public DriverImpl() {
		firstName = null;
		lastName = null;
		driverID = null;
		age = 0;
	}
	
	public DriverImpl(String firstName, String lastName, String driverID, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.driverID = driverID;
		this.age = age;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	@Override
	public void setDriverId(String id) {
		// TODO Auto-generated method stub
		this.driverID = id;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
		
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}

	@Override
	public String getDriverId() {
		// TODO Auto-generated method stub
		return driverID;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	

}
