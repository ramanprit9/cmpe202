package request;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.DBHandler;

public class ReceiveState implements State {
	private Request req;
	
	public ReceiveState(Request r){
		req=r;
	}

	public String receiveRequest(){
		insertRequestinDB();
		req.setState(new EvaluatingState(req));
		return "Received a Request.";
	}
	
	public String evaluateRequest(){
		return "Must receive a receive first";
	}
	
	public String fulfillRequest(){
		return "Must receive a request first";
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
				+ "'" + req.getMemberID() + "', " 
				+ "'" + req.getPickupLocation() + "', " 
				+ "'" + req.getPickupTime() + "', "
				+ "'" + req.getDestination() + "', "
				+ "'Received', " 
				+ "'" + req.isShareable() + "', "
				+ "'', " 
				+ "'', " 
				+ "'', " 
				+ req.getNumOfPassengers() + ", "
				+ req.getNumOfLuggages() + ", "
				+ "'Y')";
		System.out.println(str);
		
		DBHandler.updateDB(str); //Add the request record in user_requests table
		System.out.println("Request added in DB");
	
		//Get the request ID from DB
		int id = findRequestIDinDB();
		
		//Set the request ID in the Request object
		req.setRequestID(id);
		System.out.println("********* Request ID = "+ id);
		
		//Request ID retrieved. Change the flag to 'N' for request_flag
		changeRequestFlaginDB(id);
	}
	
	/* The request will flag 'Y' is the newely added request 
	 * After getting the id of that request, change the flag to 'N'
	 * The purpose of the flag is to get the ID of the request that just got created
	 */
	public int findRequestIDinDB() {
		String sql = "Select request_id from user_requests WHERE request_flag='Y'";
		ResultSet rs = DBHandler.queryDB(sql);
		int reqID = 0;
		try {
			rs.next(); //Move to the first row of the result
			reqID = Integer.parseInt(rs.getString("request_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return reqID;
	}

	public void changeRequestFlaginDB(int reqID) {
		String sql = "UPDATE user_requests SET request_flag='N' where request_id=" + reqID;
		DBHandler.updateDB(sql);
	}
}