package notification;

public abstract class Message {

	public enum Recipient {CUSTOMER, DRIVER}	
	public enum MessageType {
		CUSTOMER_INFO_TO_DRIVER, 
		VEHICLE_INFO_TO_CUSTOMER,
		VEHICLE_NOT_IMMEDIATELY_AVAILABLE,
		NO_VEHICLE_AVAILBLE,
		PAYMENT_INFO_TO_CUSTOMER,
		PERIODIC_BILLING_REPORT_TO_CUSTOMER
	}
	
	public abstract String createMessage (MessageType msgType);
}
