package request;

import java.util.Date;

import main.Address;
import notification.Communication;

//Interface for Request and it follows the STATE pattern
public interface RequestInterface {

	public void receiveRequest();
	public void evaluateRequest();
	public void fullfillRequest();
	public Address getPickupLocation();

	public void setPickupLocation(Address pickupLocation);

	public Address getDestination();

	public void setDestination(Address destination);

	public int getNumOfPassengers();

	public void setNumOfPassengers(int numOfPassengers);

	public boolean isShareable();

	public void setShareable(boolean shareable);

	public String getCommType();

	public void setCommType(String commType);
	
	
	public int getNumOfLuggages();

	public void setNumOfLuggages(int numOfLuggages);

	public String getMemberID();

	public void setMemberID(String memberID);

	public int getRequestID();

	public void setRequestID(int requestID);

	public State getState();
	public void setState(State s);
	
	public Date getPickupTime();
	

	public void setPickupTime(Date pickupTime);

	public String getVehicleType();

	public void setVehicleType(String vehicleType);

	
}
