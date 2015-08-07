package dispatcher;

import java.util.LinkedList;
import java.util.Queue;

import request.Request;
import request.RequestInterface;
import main.ServiceManager;
//This the context class for strategy pattern
public class Dispatcher {

	private DispatchStrategy ds;
	
	//Find transportation for the request
	public boolean findTransportation(Request req) {
		ds = setDispatchStrategy(req);
		return ds.findTransportation(req);
		
	}
	
	
	public DispatchStrategy setDispatchStrategy(Request req) {
		
		if (req.getNumOfPassengers() <= 3 && req.getNumOfLuggages() <= 3 && req.isShareable() == false)
			{
				ds = new SedanStrategy();
				}
		
		
		else if (req.getNumOfPassengers() <= 5 && req.getNumOfLuggages() <= 5 && req.isShareable() == false)
		{
			ds = new VanStrategy();
			}
		else if (req.getNumOfPassengers() > 5 && req.getNumOfLuggages() <= 10 && req.isShareable() == false)
		{
			ds = new BusStrategy();
		}
		else if (req.getNumOfPassengers() == 1 && req.getNumOfLuggages() <=1 && req.isShareable() == true)
		{
			ds = new SharedRideStrategy();
		}
		
	return ds;
}
}