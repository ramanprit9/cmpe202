package notification;

import notification.Message.MessageType;

public class Billing {

	private double payAmount;
	
	public Billing (double pay) {
		payAmount = pay;
	}
	
	public String createMessage (MessageType msgType)
	{
		switch (msgType) {
		case PAYMENT_INFO_TO_CUSTOMER:
			return "To Customer: You have been charged " + payAmount;
		case PAYMENT_INFO_TO_DRIVER:
			return "To Driver: Customer has been charged  " + payAmount;
		default:
			return "";
		}
	}

}
