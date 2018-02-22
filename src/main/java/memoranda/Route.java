package main.java.memoranda;

/**
 * FileName: Route.java
 * Description: Interface for creating route objects, any classes that are calling this interface need 
 * to implement interface.
 * @author James Ortner
 * Date: Feb 21st, 2018
 *
 */

public interface Route {
	String getDestination();
	String getRouteId();
	String getStartPoint();
}