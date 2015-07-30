package request;

public class ProcessingState {
private RequestInterface req;
	
	public ProcessingState(RequestInterface r){
		req=r;
	}

	public String receiveRequest(){
		
		return "ProcessingState:Will  the Request soon.";
	}
	
	public String qualifyRequest(){
		return "ProcessingState:Qualified request is in ";
	}
	
	public String processRequest(){
		//This is the plcase wherethe user is taking a ride..
		//insert processing state in DB
		//call the nxt state for finishing the request
		req.setState(new FinishedState(req));
		return "FinishedState:Request is in Process";
	}



}
