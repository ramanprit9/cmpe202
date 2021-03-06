package main;

import java.awt.Component;
import java.awt.Frame;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import payment.Payment;
import payment.PaymentProcessor;
import request.Request;
import trasnportation.SJSUShuttle;
import trasnportation.Shuttle;
import trasnportation.Vehicle;
import member.Member;
import member.SilverMember;
import notification.Billing;
import notification.Client;
import notification.Communication;
import notification.Email;
import notification.Notification;
import notification.Message;
import notification.Message.MessageType;
import notification.Phone;
import notification.QuaterlyReport;
import notification.SharedVehicleReport;
import notification.Text;
import notification.UnsharedVehicleReport;
import notification.YearlyReport;
import dispatcher.Dispatcher;
import notification.Message.MessageType;

public class ServiceManager {

	public static final String CUSTOMER = "Customer";
	public static final String DRIVER = "Driver";
	public static final String TEXT_COMMUNICATION = "Text";
	public static final String PHONE_COMMUNICATION = "Phone";
	public static final String EMAIL_COMMUNICATION = "Phone";

	//Request queue to be validated and then sent to dispatcher
	static Queue<Request> reqQueue = new LinkedList<Request>();
	
	DriverFrame frmDriver; 
	//Request starts here
	public void createRequest(String member, Address pick, Address dest, int passengers, int luggages, 
			boolean share, Date reqtime, String vtype, int vehicleSpeed, String communication) {
		Request req = new Request(member, pick, dest, passengers, luggages, share, reqtime, vtype, vehicleSpeed, communication);
		reqQueue.add(req);
		processRequests();
	}
	
	/* Process the requests in the queue by going through the Request states */
	public void processRequests() {
		/* ServiceManager is the client for the Request and its states */
		Request req_local;
		req_local = reqQueue.poll();
		while(req_local != null) {
			req_local.receiveRequest(); 
			req_local.evaluateRequest();
			req_local.fullfillRequest();
			
			//Get next request in queue
			req_local = reqQueue.poll();
		}
	}
	
	
	/* Send appropriate messages to customer and driver
	 * Bridge Pattern being used for notification/communication
	 */
	public void sendDispatchMessages (Request req, MessageType msgType){
		//System.out.println("ServiceManager: Send dispatch message");
		Message notification = new Notification(req);
		Communication driverCommunication;
		Communication customerCommunication;
		
		//Get communication type for customer and send the message
		if (req.getCommType().equals(TEXT_COMMUNICATION)) {
			customerCommunication = new Text(notification, msgType);
		} else if (req.getCommType().equals(PHONE_COMMUNICATION)) {
			customerCommunication = new Phone(notification, msgType);
		}
		else {
			customerCommunication = new Email(notification, msgType);
		}
		customerCommunication.sendNotification(CUSTOMER);
		
		//Send the dispatch message to the driver if vehicle was ofund
		driverCommunication = new Text(notification, MessageType.REQUEST_INFO_TO_DRIVER);
		if (msgType != MessageType.NO_VEHICLE_AVAILBLE) {
			driverCommunication.sendNotification(DRIVER);
			sendRequestInfoToDriver(req);
		}
		
	}

	/* Dialog box for asking the customer if he can wait */
	public boolean canCustomerWait(Request req) {
		System.out.println("ServiceManager: Create Dialog. Can Customer Wait?");
		Message message = new Notification(req);
		String customerMsg = message.createMessage(MessageType.VEHICLE_NOT_IMMEDIATELY_AVAILABLE);
		
		Frame frame = new Frame();
		int n = JOptionPane.showConfirmDialog(
			    frame,
			    customerMsg + "\n\n" + req.getBasicRequestString() + "\n",
			    "Vehicle not immediately available",
			    JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			return true;
		}
		else {
			System.out.println("ServiceManager: Create Dialog. Customer can't wait.");
			return false;
		}
	}
	
	/* Send request info to driver */
	private void sendRequestInfoToDriver (Request req) {
		frmDriver = new DriverFrame(req);
		if (frmDriver.isVisible() == false ) {
			frmDriver.setVisible(true);
		}
	}

	/* process CRUD for Member and Vehicle*/
	public void crud(String sql) {
		
	}
	
	
	//Use Bridge design pattern for sending messages/notifications
	public static void sendRequestForPaymentProcessing(Request req, boolean isCashPayment) {
		PaymentProcessor payProcessor; 
		boolean paySuccess;
		MessageType msgType;
		Message billing;
		Communication text;
		
		//process payment
		payProcessor = new PaymentProcessor();
		if (isCashPayment == true) {
			paySuccess = payProcessor.handleRequestPayment(req, Payment.PAY_METHOD_CASH);
		}
		else {
			paySuccess = payProcessor.handleRequestPayment(req, req.getMember().getPaymentMethod(), 
					req.getMember().getPaymentCardNumber(), req.getMember().getPaymentCVSNumber());
		}
		
		//Send notification to driver and customer whether the payment was successful or not
		//The request will have ridePayStrategy string which will contain the payment strategy
		//(pay by minute or pay by mile) and total cost of the ride
		if (paySuccess) {
			msgType = MessageType.RIDE_PAYMENT_SUCCESS_INFO;
		}
		else {
			msgType = MessageType.RIDE_PAYMENT_FAILURE_INFO;
		}
		
		billing = new Billing(req);
		text = new Text(billing, msgType);
		text.sendNotification(CUSTOMER);
		text.sendNotification(DRIVER);
	}
		
	/*
	 * This functions demonstrates both Decorator and Observer Pattern
	 * Create a Shuttle (Decorator)
	 * Remove a shuttle stop, which will trigger notifications to all members (Observer)
	 */
	public static void demonstrateShuttle() {
		Vehicle bus = new Vehicle();
		//Decorator Pattern: Create a shuttle, Add stops to it
		SJSUShuttle shuttle = new SJSUShuttle(bus);
		Address addr1 = new Address("3003 Bunker Hill Lane", "Santa Clara", "CA", "95054");
		Address addr2 = new Address("4701 Great America Pkwy", "Santa Clara", "CA", "95054");
		Address addr3 = new Address("3000 Mission College Blvd", "Santa Clara", "CA", "95054");
		Address addr4 = new Address("2210 Tasman Dr", "Santa Clara", "CA", "95054");
		shuttle.addStop(addr1);
		shuttle.addStop(addr2);
		shuttle.addStop(addr3);
		shuttle.addStop(addr4);
		
		//Add members to the shuttle
		Member mem = new SilverMember("Jane", "Smith");
		shuttle.addMember(mem);
		mem = new SilverMember("Emily", "Jones");
		shuttle.addMember(mem);
		mem = new SilverMember("Jason", "Barr");
		shuttle.addMember(mem);

		//Remove a stop from shuttle.
		//Observer pattern: removing a stop will notify all the members registered for the shuttle about it
		shuttle.removeStop(addr3);
		
	}
	
	public void sendShuttleNotification(String member, String msg) {
		Message notification = new Notification(msg);
		Communication email = new Email(notification, MessageType.SHUTTLE_NOTIFICATION);
		email.sendNotification(member, msg);
	}	
	
	public static void demonstrateReport() {
		//To be implemented
		System.out.println("################# Demonstrate Report ################");
		
		
		// Code for setup of reports- composite pattern
		//Q1 Report
		SharedVehicleReport a = new SharedVehicleReport("200K");
		UnsharedVehicleReport b = new UnsharedVehicleReport("900K");
		QuaterlyReport q1 = new QuaterlyReport("Q1");
		q1.add(a);
		q1.add(b);
		
		//Q2 Report
		SharedVehicleReport d = new SharedVehicleReport("250K");
		UnsharedVehicleReport e = new UnsharedVehicleReport("800K");
		QuaterlyReport q2 = new QuaterlyReport("Q2");
		q2.add(d);
		q2.add(e);
		
		//Yearly
		YearlyReport y1 = YearlyReport.getYearlyReport("2015");
		y1.add(q1);
		y1.add(q2);
		
		//Initiate Client
		Client.report = y1;
		Client.doClientTasks();
	}
	
}
