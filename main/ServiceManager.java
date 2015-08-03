package main;

import java.awt.Component;
import java.awt.Frame;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import request.Request;
import notification.Communication;
import notification.Email;
import notification.Notification;
import notification.Message;
import notification.Message.MessageType;
import notification.Phone;
import notification.Text;
import dispatcher.Dispatcher;

public class ServiceManager {


	public static final String CUSTOMER = "Customer";
	public static final String DRIVER = "Driver";
	public static final String TEXT_COMMUNICATION = "Text";
	public static final String PHONE_COMMUNICATION = "Phone";
	public static final String EMAIL_COMMUNICATION = "Phone";

	//Request queue to be validated and then sent to dispatcher
	Queue<Request> reqQueue = new LinkedList<Request>();
	
	DriverFrame frmDriver; 
	
	public enum VehicleAvailability {
		VEHICLE_IMMEDIATELY_AVAILABLE,
		VEHICLE_WAIT_30_MINS,
		VEHICLE_NOT_AVAILABLE_AT_ALL
	}

	public void createRequest(String member, Address pick, Address dest, int passengers, int luggages, 
			boolean share, Date reqtime, String vtype) {
		Request req = new Request(member, pick, dest, passengers, luggages, share, reqtime, vtype);
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
	
	
	/* Send appropriate messages to customer and driver */
	public void sendDispatchMessages (Request req, VehicleAvailability va){
		//System.out.println("ServiceManager: Send dispatch message");
		Message message = new Notification(req);
		Communication driverCommunication = new Text(message);
		Communication customerCommunication;
		String customerMsg;
		String driverMsg;
		
		//Get communication type to customer
		if (req.getCommType() == TEXT_COMMUNICATION) {
			customerCommunication = new Text(message);
		} else if (req.getCommType() == PHONE_COMMUNICATION) {
			customerCommunication = new Phone(message);
		}
		else {
			customerCommunication = new Email(message);
		}

		
		//Create message
		switch (va) {
		case VEHICLE_IMMEDIATELY_AVAILABLE:
			//System.out.println("ServiceManager: Send dispatch msg, Vehicle available immediately");
			customerMsg = customerCommunication.createMessage(MessageType.VEHICLE_INFO_TO_CUSTOMER);
			driverMsg = driverCommunication.createMessage(MessageType.REQUEST_INFO_TO_DRIVER);
			customerCommunication.sendNotification(CUSTOMER, customerMsg);
			driverCommunication.sendNotification(DRIVER, driverMsg);
			sendRequestInfoToDriver(req);
			break;
		case VEHICLE_WAIT_30_MINS:
			//System.out.println("ServiceManager: Send dispatch msg, Vehicle available in 30 minutes");
			customerMsg = customerCommunication.createMessage(MessageType.VEHICLE_WAIT_30_MINUTES);
			driverMsg = driverCommunication.createMessage(MessageType.REQUEST_INFO_TO_DRIVER);
			customerCommunication.sendNotification(CUSTOMER, customerMsg);
			driverCommunication.sendNotification(DRIVER, driverMsg);
			sendRequestInfoToDriver(req);
			break;

		case VEHICLE_NOT_AVAILABLE_AT_ALL:
			//System.out.println("ServiceManager: Send dispatch msg, Vehicle not available at all");
			customerMsg = customerCommunication.createMessage(MessageType.NO_VEHICLE_AVAILBLE);
			customerCommunication.sendNotification(CUSTOMER, customerMsg);
			break;
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
	
	//Start the Ride, set start time of ride
	public void startRide(Request req) {
		req.setStartRideTime(new Date());
	}
	
	//End the ride, set end time of ride, process Payment
	public void endRide(Request req) {
		Date endDateTime = new Date();
		long fifteenMins;
		
		//Since we r just simulating, add 15 minutes to the endRideTime
		//Java Date time is in milliseconds
		fifteenMins = 15 * 60000; //1 min = 60,000 milliseconds
		
		endDateTime.setTime(endDateTime.getTime() + fifteenMins);
		req.setEndRideTime(endDateTime);
		req.setMilesTravelled(calculateMilesTravelled(req));
		
		//Update Vehicle State
		String updateVehicle = "UPDATE vehicle SET vehicle_state='AVAILABLE' where request_id=" + req.getRequestID();
		DBHandler.updateDB(updateVehicle);

	}
	
	public double calculateMilesTravelled(Request req) {
		return 5.2;
	}
	
}
