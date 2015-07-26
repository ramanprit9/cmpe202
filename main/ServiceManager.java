package main;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceManager {
	
	Queue<Request> reqQ = new LinkedList<Request>();
	
	public void receiveRequest(Request req) {
		reqQ.add(req);
		validateRequest();
	}
	
	public void validateRequest() {
		Request req_local;
		req_local = reqQ.remove();
		while(req_local != null) {
			//Validate and send to dispatcher
			
			
			//Get next request in queue
			req_local = reqQ.remove();
		}
	}
	
	
}
