package request;

import main.DBHandler;

public class FulfillState implements State{
	private Request req;
	
	public FulfillState(Request r){
		req=r;
	}

	public String receiveRequest(){
		return "ProcessingState:Will  the Request soon.";
	}
	
	public String evaluateRequest(){
		return "ProcessingState:Qualified request is in ";
	}
	
	public String fulfillRequest(){
		//This is the plcase wherethe user is taking a ride..
		//insert FINISH state in DB
		changeRequestStatinDB(req.requestID);
		//call the nxt state for finishing the request
		req.setState(new ReceiveState(req));
		return "FinishedState:Request is in Process";
	}

	public void changeRequestStatinDB(int reqID) {
		String updateRequest = "UPDATE user_requests SET request_state='ACCEPTED' where request_id=" + reqID;
		DBHandler.updateDB(updateRequest);
	}

}
