package request;

public class FulfillState {
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
		//insert processing state in DB
		//call the nxt state for finishing the request
		req.setState(new ReceiveState(req));
		return "FinishedState:Request is in Process";
	}



}
