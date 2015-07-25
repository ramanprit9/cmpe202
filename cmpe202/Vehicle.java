package cmpe202;

public abstract class Vehicle extends Transportation {
	
	Driver driver;
	int number;
	boolean isCurrentlyAvailable;
	String location;
	
	public void getTotalTransportation() {
		//Query the DB, get total number of Vehicles
	}
}
