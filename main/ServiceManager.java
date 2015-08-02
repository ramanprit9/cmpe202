package main;

import java.awt.Component;
import java.awt.Frame;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import request.Request;
import notification.Communication;
import notification.Notification;
import notification.Message;
import notification.Message.MessageType;
import dispatcher.Dispatcher;

public class ServiceManager {

	Communication comm;
	
	//Request queue to be validated and then sent to dispatcher
	Queue<Request> reqQueue = new LinkedList<Request>();
	
	public enum VehicleAvailability {
		VEHICLE_IMMEDIATELY_AVAILABLE,
		VEHICLE_WAIT_30_MINS,
		VEHICLE_NOT_AVAILABLE_AT_ALL
	}

	public void createRequest(String member, Address pick, Address dest, int passengers, int luggages, 
			boolean share, Date reqtime, String vtype) {
		Request req = new Request(member, pick, dest, passengers, luggages, share, reqtime, vtype);
		reqQueue.add(req);
		System.out.println("ServiceManager: Request queued to be processed");
		processRequests();
	}
	
	/* Process the requests in the queue by going through the Request states */
	public void processRequests() {
		/* ServiceManager is the client for the Request and its states */
		Request req_local;
		req_local = reqQueue.poll();
		while(req_local != null) {
			System.out.println("ServiceManager: Request processed");
			req_local.receiveRequest(); 
			req_local.evaluateRequest();
			req_local.fullfillRequest();
			
			//Get next request in queue
			req_local = reqQueue.poll();
		}
	}
	
	
	/* Send appropriate messages to customer and driver */
	public void sendDispatchMessages (Request req, VehicleAvailability va){
		System.out.println("ServiceManager: Send dispatch message");
		Message message = new Notification(req);
		String customerMsg;
		String driverMsg;
		
		switch (va) {
		case VEHICLE_IMMEDIATELY_AVAILABLE:
			System.out.println("ServiceManager: Send dispatch msg, Vehicle available immediately");
			customerMsg = message.createMessage(MessageType.VEHICLE_INFO_TO_CUSTOMER);
			sendCustomerMessageNoResponse(req, "Vehicle Available", customerMsg);
			driverMsg = message.createMessage(MessageType.CUSTOMER_INFO_TO_DRIVER);
			sendRequestInfoToDriver(req);
			break;
		case VEHICLE_WAIT_30_MINS:
			System.out.println("ServiceManager: Send dispatch msg, Vehicle available in 30 minutes");
			customerMsg = message.createMessage(MessageType.VEHICLE_INFO_TO_CUSTOMER);
			sendCustomerMessageNoResponse(req, "Vehicle Available", customerMsg);
			driverMsg = message.createMessage(MessageType.CUSTOMER_INFO_TO_DRIVER);
			sendRequestInfoToDriver(req);
			break;

		case VEHICLE_NOT_AVAILABLE_AT_ALL:
			System.out.println("ServiceManager: Send dispatch msg, Vehicle not available at all");
			customerMsg = message.createMessage(MessageType.NO_VEHICLE_AVAILBLE);
			sendCustomerMessageNoResponse(req, "No Vehicle Available", customerMsg);
			break;
		}
	}

	private void sendCustomerMessageNoResponse(Request req, String windowTitle, String message) {
		System.out.println("ServiceManager: Create Dialog. No Customer Reponse Required");
		Frame frame = new Frame();
		JOptionPane.showMessageDialog(frame,
			    message + "\n\n" + req.getBasicRequestString() + "\n",
			    windowTitle,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
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
		
	}

	/* process CRUD */
	public void crud(String sql) {
		
	}
}
