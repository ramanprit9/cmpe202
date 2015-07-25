package cmpe202;

import notification.*;

public class Request {
	Address pickupLocation;
	Address destination;
	int numOfPassengers;
	boolean shareable;
	boolean customerIsMember;
	Communication commType;
	
	public Request (Address pick, Address dest, int passengers, boolean share, 
			boolean member, Communication comm) {
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
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
	
	
}
