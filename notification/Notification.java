package notification;

import request.Request;
import notification.Message.MessageType;

public class Notification extends Message {

	private Request request;
	
	public Notification (Request req) {
		request = req;
	}
	
	public String createMessage (MessageType msgType)
	{
		switch (msgType) {
		case REQUEST_INFO_TO_DRIVER:
			return "Request ID: " + request.getRequestID() + "\n Pickup Location: " + request.getPickupLocation() + 
					"\n Destination: " + request.getDestination();
		case VEHICLE_INFO_TO_CUSTOMER:
			return "Vehicle Available. It will arrive at your location in 10 minutes";
		case VEHICLE_NOT_IMMEDIATELY_AVAILABLE:
			return "Vehicle is not immediately available. Would you like to wait?";
		case VEHICLE_WAIT_30_MINUTES:
			return "Vehicle will arrive at your location in 30 minutes";
		case NO_VEHICLE_AVAILBLE:
			return "No Vehicle Available. Request can't be fulfilled at this moment";
		default:
			return "";
		}
	}
}
