package notification;

import request.Request;
import notification.Message.MessageType;
import notification.Message.Recipient;

public class DispatchingMessage extends Message {

	private Request request;
	
	public DispatchingMessage (Request req) {
		request = req;
	}
	
	public String createMessage (MessageType msgType)
	{
		switch (msgType) {
		case CUSTOMER_INFO_TO_DRIVER:
			return "Request ID: " + request.getRequestID() + "\nPickup Location: " + request.getPickupLocation() + 
					"\n Destination: " + request.getDestination();
		case VEHICLE_INFO_TO_CUSTOMER:
			return "Vehicle Available. It will arrive at your location in 10 minutes";
		case VEHICLE_NOT_IMMEDIATELY_AVAILABLE:
			return "Vehicle is not immediately available. Would you like to wait?";
		case NO_VEHICLE_AVAILBLE:
			return "No Vehicle Available. Request can't be fulfilled at this moment";
		default:
			return "";
		}
	}
}
