package dispatcher;

import java.util.LinkedList;
import java.util.Queue;

import request.Request;
import request.RequestInterface;
import main.ServiceManager;
import main.ServiceManager.VehicleAvailability;

public class Dispatcher {

	private DispatchStrategy ds;
	
	//Find transportation for the request
	public void findTransportation(Request req) {
		//ServiceManager serviceManager = new ServiceManager();
		
		System.out.println("Dispatcher: find transportation, requestID = "+req.getRequestID());
		ds = setDispatchStrategy(req);
	//	ds.findTransportation(req);
		
	}
	
	
	public DispatchStrategy setDispatchStrategy(Request req) {
		
		if (req.getNumOfPassengers() <= 3 && req.getNumOfLuggages() <= 3)
			{
				ds = new SedanStrategy();
				}
		
		
		else if (req.getNumOfPassengers() <= 5 && req.getNumOfLuggages() <= 5)
		{
			ds = new VanStrategy();
			}
		else 
			ds = new BusStrategy();
	
	return ds;
}
}