package main;

import notification.*;

public class Request {
	Address pickupLocation;
	Address destination;
	int numOfPassengers;
	int numOfLuggages;
	boolean shareable;
	boolean customerIsMember;
	Communication commType;
	
	public Request (Address pick, Address dest, int passengers, int luggages, 
			boolean share, boolean member, Communication comm) {
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		customerIsMember = member;
		commType = comm;
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
	
	public String toString() {
		String comm; 
		if (commType.equals(Text.class)) { comm = "Text";}
		else if (commType.equals(Phone.class)) { comm = "Phone"; }
		else { comm = "Email"; }
		
		return "Pickup Address: " + pickupLocation + " \nDestination Address: " + destination
				+ "\nPassengers: " + numOfPassengers + "   Luggauges: " + numOfLuggages + 
				"   Shareable: " + shareable + "   Communication Method: " + comm;
	}
	
}
