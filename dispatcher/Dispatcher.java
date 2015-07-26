package dispatcher;

import java.util.LinkedList;
import java.util.Queue;

import main.Request;
import main.ServiceManager;
import main.ServiceManager.VehicleAvailability;

public class Dispatcher {

	Queue<Request> reqQueue = new LinkedList<Request>();
	
	/* Add the request to the queue, which is processed by the Dispatcher */
	public void submitRequest (Request req) {
		System.out.println("Dispatcher: request queued");
		reqQueue.add(req);
		processRequests();
	}
	
	//Process the requests in the queue
	private void processRequests() {
		System.out.println("Dispatcher: processing requests");
		Request req = reqQueue.poll();
		while (req != null) {
			System.out.println("Dispatcher: processing request, requestID = "+req.getRequestID());
			findTransportation(req);
			req = reqQueue.poll();
		}
	}
	
	//Find transportation for the request
	private void findTransportation(Request req) {
		ServiceManager serviceManager = new ServiceManager();
		
		System.out.println("Dispatcher: find transportation, requestID = "+req.getRequestID());
		/* If Transportation is found, create a new instance of it. 
		 * Send appropriate message to customer and driver through ServiceManager.
		 */
		//serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_IMMEDIATELY_AVAILABLE);
		
		/* Transportation not found within 2 mile radius. Search withing 5 mies */
		serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_NOT_IMMEDIATELY_AVAILABLE);
		
		/* No Transporation found */
		//serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_NOT_AVAILABLE_AT_ALL);
		
	}
	
	
}
