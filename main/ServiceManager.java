package main;

import java.awt.Component;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import request.Request;
import notification.Communication;
import notification.DispatchingMessage;
import notification.Message;
import notification.Message.MessageType;
import dispatcher.Dispatcher;

public class ServiceManager {

	Communication comm;
	
	//Request queue to be validated and then sent to dispatcher
	Queue<Request> reqQueue = new LinkedList<Request>();
	
	public enum VehicleAvailability {
		VEHICLE_IMMEDIATELY_AVAILABLE,
		VEHICLE_NOT_IMMEDIATELY_AVAILABLE,
		VEHICLE_NOT_AVAILABLE_AT_ALL
	}

	public void receiveRequest(Request req) {
		reqQueue.add(req);
		System.out.println("ServiceManager: Request queued to be validated");
		validateRequest();
	}
	
	public void validateRequest() {
		Dispatcher dispatcher = new Dispatcher();
		Request req_local;
		req_local = reqQueue.poll();
		while(req_local != null) {
			System.out.println("ServiceManager: Request validated");
			//Validate and submit request to dispatcher
			dispatcher.submitRequest(req_local);
			
			//Get next request in queue
			req_local = reqQueue.poll();
		}
	}
	
	
	/* Send appropriate messages to customer and driver */
	public void sendDispatchMessages (Request req, VehicleAvailability va){
		System.out.println("ServiceManager: Send dispatch message");
		Message message = new DispatchingMessage(req);
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
		case VEHICLE_NOT_IMMEDIATELY_AVAILABLE:
			System.out.println("ServiceManager: Send dispatch msg, Vehicle not available immediately");
			customerMsg = message.createMessage(MessageType.VEHICLE_NOT_IMMEDIATELY_AVAILABLE);
			sendCustomerMessageNeedResponse(req, "Vehicle Not Immediately Available", customerMsg);
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
	
	private void sendCustomerMessageNeedResponse(Request req, String windowTitle, String message) {
		System.out.println("ServiceManager: Create Dialog. Customer Response Required");
		Frame frame = new Frame();
		int n = JOptionPane.showConfirmDialog(
			    frame,
			    message + "\n\n" + req.getBasicRequestString() + "\n",
			    "An Inane Question",
			    JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			sendRequestInfoToDriver(req);
		}
		else {
			System.out.println("ServiceManager: Create Dialog. Customer answered No");
		}
	}
	
	/* Send request info to driver */
	private void sendRequestInfoToDriver (Request req) {
		
	}

}
