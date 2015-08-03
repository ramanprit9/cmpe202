package request;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.DBHandler;
import main.ServiceManager;

import java.util.ArrayList;

//import javax.swing.JOptionPane;



import dispatcher.Dispatcher;


public class EvaluatingState implements State{
	private Request req;
	
	public EvaluatingState(Request r){
		req = r;
	}
	
 public String receiveRequest(){
	 return "Request has to be recieved first";
 }
 
 
 public String evaluateRequest(){
	 ServiceManager serviceManager = new ServiceManager(); //need ServiceManager for communication/notifications
	 Dispatcher dispatcher = new Dispatcher();
	 boolean transportationFound; 
	 
	 transportationFound = dispatcher.findTransportation(req);
	 
	 //If transportation is found, move to FulfillState, else move to ReceiveState
	 if (transportationFound == true) {
		 req.setState(new FulfillState(req));
		 return "Request acceepted";
	 }
	 else {
		 req.setState(new ReceiveState(req));
		 changeRequestStateinDB(req.getRequestID());
		 return "Request declined";
		 
	 }
	 
	 
		/* Check DB for available Vehicle.  
		 * Send appropriate message to customer and driver through ServiceManager.
		 * 3 scenarios: vehicle immediately available (within 2 mile radius), not immed avail, not avail at all
		 * Scenario 1:
		 * 		serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_IMMEDIATELY_AVAILABLE);
		 * 		change request to FulFilledState
		 * Scenario 2:
		 * 		serviceManager.canCustomerWait(Request req)  <== this will return true or false
		 * 		if true, move to fulfilled state and call serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_WAIT_30_MINS);
		 * 		if false, change request to ReceiveState
		 * Scenario 3:
		 * 		serviceManager.sendDispatchMessages(req, VehicleAvailability.VEHICLE_NOT_AVAILABLE_AT_ALL);
		 * 		change request to ReceiveState
		 */
 }
 
 public String fulfillRequest(){
	 return "Request Needs to be evaluated first";
 }
 
	public void changeRequestStateinDB(int reqID) {
		String updateRequest = "UPDATE user_requests SET request_state='DECLINED' where request_id=" + reqID;
		DBHandler.updateDB(updateRequest);
	}


}
/* public String getZipcodes2miles() throws ClientProtocolException, IOException{
	 HttpClient client = new DefaultHttpClient();

	  HttpGet request = new HttpGet("https://www.zipcodeapi.com/rest/eDbmqjrpB9Ziykq6xUcTqTVeSlkpt2FIGQ469wvLGv4ePuknowhPqd4iypI2roK7/radius.csv/95131/2/mile");

	  HttpResponse response = client.execute(request);

	  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
	  String zipcodes;
	  String line = " ";
	  int ctr = 0;
	  while ((line = rd.readLine()) != null) {

		if (ctr != 0) {
	    //System.out.println(line.split(",")[0]);
			zipcodes = (line.split(",")[0]);
			
		}
		ctr++;
	  
	}
	  
	  return zipcodes;
 }
}*/

