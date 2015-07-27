package request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import main.Address;
import main.DBHandler;
import notification.*;

public class Request {
	int requestID;
	String  memberID; /*memberID is "guest" if not member */
	Address pickupLocation;
	Date pickupTime;
	Address destination;
	String state;
	boolean shareable;
	String vehicleType;
	int numOfPassengers;
	int numOfLuggages;
	Communication commType;
	
	//Constructor without Communication type. Need to fist create a Request before creating Communication
	public Request (String member, Address pick, Address dest, int passengers, int luggages, 
			boolean share) {
		memberID = member;
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		requestID = 2;
		
		insertRequestinDB();
	}

	private void insertRequestinDB() {
		String str = "INSERT INTO user_requests "
				+ "(member_id, request_pickup_loc, "
				+ "request_pickup_time, request_destination, "
				+ "request_state, request_shareable, "
				+ "request_type, request_sub_type, "
				+ "request_vehicle_type, request_no_passengers_travelling, "
				+ "request_no_luggages, request_flag) " 
				+ "VALUES ("  
				+ "'" + memberID + "', " 
				+ "'" + pickupLocation + "', " 
				+ "'" + pickupTime + "', "
				+ "'" + destination + "', "
				+ "'', " 
				+ "'" + shareable + "', "
				+ "'', " 
				+ "'', " 
				+ "'', " 
				+ numOfPassengers + ", "
				+ numOfLuggages + ", "
				+ "'Y')";
		System.out.println(str);
		
		DBHandler.updateDB(str); //Add the request record in user_requests table
		
//		//Set the requestID by retrieving it from database
//		ResultSet rs = DBHandler.queryDB("Select request_id from user_requests where request_flag='Y'");
//		try {
//			rs.next();
//			requestID = rs.getInt("request_id");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//After request ID is retrieved, change the flag to 'N'
//		DBHandler.updateDB("UPDATE user_requests SET request_flag='N' WHERE request_flag='Y'");
		
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
