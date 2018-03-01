package main.java.memoranda;

<<<<<<< HEAD
=======
import org.json.JSONObject;
>>>>>>> dev

/**
 * FileName: Driver.java
 * Description: Interface for creating driver objects, any classes that are calling this interface need 
 * to implement interface.
 * @author Wesley Davis
 * Date: Feb 18th, 2018
 *
 */

public interface Driver {

<<<<<<< HEAD
	String getFullName();
	String getDriverId();
	int getAge();
	String getPhoneNumber();
=======
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setPhoneNumber(String phoneNumber);
    void setAge(int age);
	String getFullName();
	String getFirstName();
	String getLastName();
	String getDriverId();
	int getAge();
	String getPhoneNumber();
	JSONObject toJsonObject();
>>>>>>> dev
	String toJSONString();
}
