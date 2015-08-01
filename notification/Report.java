package notification;

import notification.Message.MessageType;

public abstract class Report {
	public String createMessage (MessageType msg){
		
		switch (msg) {
		case PERIODIC_BILLING_REPORT_TO_CUSTOMER:
			return "To Customer: Periodic Billing Report ";
		default:
			return "";
		}
		
	}

}
