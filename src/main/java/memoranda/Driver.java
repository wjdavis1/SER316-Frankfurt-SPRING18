package main.java.memoranda;

import java.util.Date;
import main.java.memoranda.date.CalendarDate;


/**
 * FileName: Driver.java
 * Description: Interface for creating driver objects, any classes that are calling this interface need 
 * to implement interface.
 * @author wesleydavis
 *
 */

public interface Driver {

	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setDriverId(String id);
	void setAge(int age);
	
	String getFullName();
	String getDriverId();
	int getAge();
}
