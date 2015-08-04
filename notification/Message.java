package notification;

public abstract class Message {	
	
	public enum MessageType {
		REQUEST_INFO_TO_DRIVER, 
		VEHICLE_INFO_TO_CUSTOMER,
		VEHICLE_NOT_IMMEDIATELY_AVAILABLE, 
		VEHICLE_WAIT_30_MINUTES, 
		NO_VEHICLE_AVAILBLE,
		PAYMENT_INFO_TO_CUSTOMER,
		PAYMENT_INFO_TO_DRIVER,
		SHUTTLE_NOTIFICATION,
		PERIODIC_BILLING_REPORT_TO_CUSTOMER
	}
	
	public abstract String createMessage (MessageType msg);
	
}
