package request;

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
				+ "'', " 
				+ "'" + req.isShareable() + "', "
				+ "'', " 
				+ "'', " 
				+ "'', " 
				+ req.getNumOfPassengers() + ", "
				+ req.getNumOfLuggages() + ", "
				+ "'Y')";
		System.out.println(str);
		
		DBHandler.updateDB(str); //Add the request record in user_requests table
	
	}

}