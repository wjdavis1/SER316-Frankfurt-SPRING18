package main.java.memoranda;
/**
 * File Name: RouteImpl.java
 * Description: Implementation of the Route Interface, used for 
 * storing Route data such as the destination, routeId, and the
 * start and end points
 * @author James Ortner
 * Date: Feb 21st, 2018
 */

/**
 * Class: RouteImpl
 * Description: SEE FILE DESCRIPTION ABOVE
 */
public class RouteImpl implements Route {
	
	private String destination;
	private String routeId;
	private String startPoint;
	private String endPoint;

	public RouteImpl() {
		destination = null;
		routeId = null;
		startPoint = null;
		endPoint = null;
	}
	
	public RouteImpl(String destination, String routeId, String startPoint, String endPoint) {
		this.destination = destination;
		this.routeId = routeId;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	/**
	 * Method: getDestination()
	 * Input: None
	 * Return: String
	 * Description: Gets the Destination
	 */
	@Override
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Method: getRouteId
	 * Input: None
	 * Return: String
	 * Description: Gets the Route's ID
	 */
	@Override
	public String getRouteId() {
		return routeId;
	}

	/**
	 * Method: getStartPoint
	 * Input: None
	 * Return: String
	 * Description: Gets the Start Point of the route
	 */
	@Override
	public String getStartPoint() {
		return startPoint;
	}
	
	/**
	 * Method: getEndPoint
	 * Input: None
	 * Return: String
	 * Description: Gets the End Point of the route
	 */
	@Override
	public String getEndPoint() {
		return endPoint;
	}
	

}
