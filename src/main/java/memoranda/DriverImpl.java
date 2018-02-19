package main.java.memoranda;
/**
 * File Name: DriverImpl.java
 * Description: Implementation of the Driver Interface, used for 
 * storing Driver data such as name, age id if needed.
 * @author Wesley Davis
 * Date: Feb 18th, 2018
 */

/**
 * Class: DriverImpl
 * Description: SEE FILE DESCRIPTION ABOVE
 */
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


	/**
	 * Method: getFullName
	 * Input: None
	 * Return: String
	 * Description: Gets the Drivers full name
	 */
	@Override
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Method: getDriverId()
	 * Input: None
	 * Return: String
	 * Description: Gets the Driver ID
	 */
	@Override
	public String getDriverId() {
		return driverID;
	}
	
	/**
	 * Method: getBusID
	 * Input: None
	 * Return: String
	 * Description: Gets the Bus Id of the bus the driver is driving
	 */
	@Override
	public String getBusID() {
		return busID;
	}

	/**
	 * Method: getAge
	 * Input: None
	 * Return: int
	 * Description: Gets the Age of the driver
	 */
	@Override
	public int getAge() {
		return age;
	}
	

}
