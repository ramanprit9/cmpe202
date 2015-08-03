package request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import trasnportation.Vehicle;
import main.Address;
import main.DBHandler;
import notification.*;

public class Request implements RequestInterface {
	State state;
	int requestID;
	String  memberID; /*memberID is "guest" if not member */
	Address pickupLocation;
	Date pickupTime;
	Address destination;
	boolean shareable;
	String vehicleType;
	int numOfPassengers;
	int numOfLuggages;
	String commType;
	Vehicle vehicle;
	Date startRideTime;
	Date endRideTime;
	double totalRideMinutes; 
	double totalRideMiles;
	double rideSpeed;
	double milesTravelled;
	
	//Constructor without Communication type. Need to fist create a Request before creating Communication
	public Request (String member, Address pick, Address dest, int passengers, int luggages, 
			boolean share, Date reqtime, String vtype) {
		memberID = member;
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		requestID = 2;
		pickupTime = reqtime;
		vehicleType = vtype;
		
		state = new ReceiveState(this);
	}
	
	public void receiveRequest(){
		state.receiveRequest();
	}
	
	public void evaluateRequest(){
		state.evaluateRequest();
	}
	
	public void fullfillRequest(){
		state.fulfillRequest();
	}
	
	
	public void setState(State s){
		state = s;
	}
	
	public State getState(){
		return state;
	}
	
	public Address getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Address pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public boolean isShareable() {
		return shareable;
	}

	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}

	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}
	
	
	public int getNumOfLuggages() {
		return numOfLuggages;
	}

	public void setNumOfLuggages(int numOfLuggages) {
		this.numOfLuggages = numOfLuggages;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	
	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	
	public Date getStartRideTime() {
		return startRideTime;
	}

	public void setStartRideTime(Date startRideTime) {
		this.startRideTime = startRideTime;
	}

	public Date getEndRideTime() {
		return endRideTime;
	}

	public void setEndRideTime(Date endRideTime) {
		this.endRideTime = endRideTime;
	}

	public double getTotalRideTime() {
		return totalRideMinutes;
	}

	public void setTotalRideTime(double totalRideMinutes) {
		this.totalRideMinutes = totalRideMinutes;
	}

	public double getTotalRideMiles() {
		return totalRideMiles;
	}

	public void setTotalRideMiles(double totalRideMiles) {
		this.totalRideMiles = totalRideMiles;
	}

	public double getRideSpeed() {
		return rideSpeed;
	}

	public void setRideSpeed(double rideSpeed) {
		this.rideSpeed = rideSpeed;
	}

	
	public double getMilesTravelled() {
		return milesTravelled;
	}

	public void setMilesTravelled(double milesTravelled) {
		this.milesTravelled = milesTravelled;
	}

	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getTotalRideMinutes() {
		return totalRideMinutes;
	}

	public void setTotalRideMinutes(double totalRideMinutes) {
		this.totalRideMinutes = totalRideMinutes;
	}

	public String toString() {
		String comm; 
		if (commType.equals(Text.class)) { comm = "Text";}
		else if (commType.equals(Phone.class)) { comm = "Phone"; }
		else { comm = "Email"; }
		
		return "Pickup Address: " + pickupLocation + " \nDestination Address: " + destination
				+ "\nPassengers: " + numOfPassengers + "   Luggauges: " + numOfLuggages + 
				"   Shareable: " + shareable + "   Communication Method: " + comm;
	}
	
	public String getBasicRequestString() {
		return "Request ID: " + requestID + "\nPickup Location: " + pickupLocation + 
				"\n Destination: " + destination;
	}
}
