package main;

import java.util.Date;

import request.ReceiveState;
import request.Request;

public class Driver {

	int driverID;
	String firstName;
	String lastName;
	
	//Start the Ride, set start time of ride
	public void startRide(Request req) {
		req.setStartRideTime(new Date());
		System.out.println("############ Starting ride at "+req.getStartRideTime());
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
		
		//Update Vehicle State 
		String updateVehicle = "UPDATE vehicle SET vehicle_state='AVAILABLE' where request_id=" + req.getRequestID();
		DBHandler.updateDB(updateVehicle);
		
		System.out.println("############ Ending ride at "+req.getEndRideTime());
		
		calculateTotalRideMiles(req);
		calculateTotalRideMinutes(req);
		
	}

	public void cancelRide(Request req, String reason) {
		req.setRideCancelReason(reason);
		//Change the request state to ReceiveState
		System.out.println("########## Ride cancelled: "+reason);
		req.setState(new ReceiveState(req));
	}
	
	public void calculateTotalRideMiles(Request req) {
		 req.setTotalRideMiles(5.2);
	}
	
	public void calculateTotalRideMinutes(Request req) {
		double durationMS; /* in milliseconds */
		double durationMinutes; /* in minutes */
		durationMS= req.getEndRideTime().getTime() - req.getStartRideTime().getTime();
		durationMinutes = durationMS/60000; 
		req.setTotalRideMinutes(durationMinutes);
	}

	public void cashPayment(Request req) {
		/* Set paidInCash to true */
		ServiceManager.sendRequestForPaymentProcessing(req, true);
	}

	public void cardOrMemberPayment(Request req) {
		/* Set paidInCash to false */
		ServiceManager.sendRequestForPaymentProcessing(req, false);
	}
	
	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
