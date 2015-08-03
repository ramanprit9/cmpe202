package trasnportation;

import main.Driver;

public class Vehicle extends Transportation {
	
	int vehicleID;
	boolean isCurrentlyAvailable;
	String zipcode;
	int maxPassengers;
	boolean shareable;
	double costPerMile;
	double costPerMinute;
	double additionalCost;
	
	/* Get all the vehicles */
	public int getTotalTransporations(String zipcode) {
		//Query the DB, get total number of Vehicles
		return 1;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public boolean isCurrentlyAvailable() {
		return isCurrentlyAvailable;
	}

	public void setCurrentlyAvailable(boolean isCurrentlyAvailable) {
		this.isCurrentlyAvailable = isCurrentlyAvailable;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public boolean isShareable() {
		return shareable;
	}

	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}

	public double getCostPerMile() {
		return costPerMile;
	}

	public void setCostPerMile(double costPerMile) {
		this.costPerMile = costPerMile;
	}

	public double getCostPerMinute() {
		return costPerMinute;
	}

	public void setCostPerMinute(double costPerMinute) {
		this.costPerMinute = costPerMinute;
	}

	public double getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(double additionalCost) {
		this.additionalCost = additionalCost;
	}
	
}
