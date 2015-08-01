package notification;

public abstract class Message {	
	
	public static final String CUSTOMER = "Customer";
	public static final String DRIVER = "Driver";
	
	public enum MessageType {
		CUSTOMER_INFO_TO_DRIVER, 
		VEHICLE_INFO_TO_CUSTOMER, 
		VEHICLE_NOT_IMMEDIATELY_AVAILABLE, 
		VEHICLE_WAIT_30_MINUTES, 
		NO_VEHICLE_AVAILBLE,
		PAYMENT_INFO_TO_CUSTOMER,
		PAYMENT_INFO_TO_DRIVER,
		PERIODIC_BILLING_REPORT_TO_CUSTOMER
	}
	
	public abstract String createMessage (MessageType msg);
	
}
