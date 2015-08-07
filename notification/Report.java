package notification;

import notification.Message.MessageType;
//import main.ServiceManager;

public abstract class Report extends Message {
	
	String revenueStr;
	String value = "not assigned yet";
	String title = "not assigned yet";
	
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
	
	public void printRevenue(){
		System.out.println(title + " " + value);
	}
}
