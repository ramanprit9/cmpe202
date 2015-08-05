package notification;

import request.Request;
import notification.Message.MessageType;

public class Billing extends Message {

	private Request req;
	
	//Billing for request
	public Billing (Request r1) {
		req = r1;
	}
	
	public String createMessage (MessageType msgType)
	{
		switch (msgType) {
		case RIDE_PAYMENT_SUCCESS_INFO:
			return "Payment succesfully processed for request: " + req.getRequestID() + 
					"\n " + req.getRidePayStrategy();
		case RIDE_PAYMENT_FAILURE_INFO:
			return "Unable to process payment for request: " + req.getRequestID() + 
					"\n " + req.getRidePayStrategy();
		default:
			return "";
		}
	}

}
