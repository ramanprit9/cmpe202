package notification;

import notification.Message.MessageType;

public abstract class Report {
	
	String revenueStr;
	
	public String createMessage (MessageType msg){
		
		switch (msg) {
		case INTERNAL_YEARLY_REVENUE_REPORT:
			return "Internal Yearly Billing Report ";
		default:
			return "";
		}
		
	}

	public void printBilling() {
		System.out.println(" "+revenueStr);
	}
}
