package request;

import main.Address;
import notification.*;

public class Request {
	Address pickupLocation;
	Address destination;
	int numOfPassengers;
	int numOfLuggages;
	boolean shareable;
	boolean customerIsMember;
	String memberID; /*memberID is "guest" if not member */
	Communication commType;
	int requestID;
	
	public Request (Address pick, Address dest, int passengers, int luggages, 
			boolean share, boolean member, Communication comm) {
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		customerIsMember = member;
		commType = comm;
		requestID = 2;
	}
	
	//Constructor without Communication type. Need to fist create a Request before creating Communcation
	public Request (Address pick, Address dest, int passengers, int luggages, 
			boolean share, boolean member) {
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		customerIsMember = member;
		requestID = 2;
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

	public boolean isCustomerIsMember() {
		return customerIsMember;
	}

	public void setCustomerIsMember(boolean customerIsMember) {
		this.customerIsMember = customerIsMember;
	}

	public Communication getCommType() {
		return commType;
	}

	public void setCommType(Communication commType) {
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
