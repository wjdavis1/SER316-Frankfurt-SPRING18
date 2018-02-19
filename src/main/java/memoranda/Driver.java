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

	String getFullName();
	String getDriverId();
	String getBusID();
	int getAge();
}
