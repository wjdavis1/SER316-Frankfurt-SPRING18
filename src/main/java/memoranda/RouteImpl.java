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

	public RouteImpl() {
		destination = null;
		routeId = null;
		startPoint = null;
	}
	
	public RouteImpl(String destination, String routeId, String startPoint, String endPoint) {
		this.destination = destination;
		this.routeId = routeId;
		this.startPoint = startPoint;
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
     * Method: setDestination()
     * Input: destination
     * Return: none
     * Description: Sets the Destination
     */
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    /**
     * Method: setRouteId()
     * Input: routeId
     * Return: none
     * Description: Sets the Route ID
     */
    @Override
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
    /**
     * Method: setStartPoint()
     * Input: startPoint
     * Return: none
     * Description: Sets the route's start point
     */
    @Override
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
    
    /**
     * Method: toJsonObject
     * Input: None
     * Return: JSONObject
     * Description: Returns a JSONObject of the Route class.
     */
    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();
        obj.put("destination", destination);
        obj.put("routeId", routeId);
        obj.put("startPoint", startPoint);
        return obj;
    }
    
    /**
     * Method: toJSONString
     * Input: None
     * Return: None
     * 
     * Description: Converts the JSONObject of this class into a string
     */
    public String toJSONString() {
        String jsonString;
        jsonString = toJsonObject().toString();
        return jsonString;
    }
}
