package dispatcher;

import main.DBHandler;
import main.ServiceManager;


import main.ServiceManager.VehicleAvailability;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import request.Request;
//Strategy pattern--This strategy to be used when no of passengers is very few.
public class SedanStrategy implements DispatchStrategy {
	boolean successFlag2miles;
	boolean successFlag5miles;
	public void findTransportation(Request r1)
	{
		//int rad = 2 ;
		boolean requestSatisfiedin2miles;
		boolean requestSatisfiedin5miles;
	   /* try {
			zipcodes = getZipcodes2miles(rad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Check if vehicle is available in 2miles
		requestSatisfiedin2miles=isSedanavailablein2miles();
		if (requestSatisfiedin2miles = true){
			//send notification to customer saying that vehicle is available in 2miles
			ServiceManager custNotification = new ServiceManager();
			custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_IMMEDIATELY_AVAILABLE);
			//perform db operation to change the state of the vehicle(sedan) from AVAILABLE to INTRANSIT
			setVehicleStatus(r1.getRequestID());
		}
		else
		{
			requestSatisfiedin5miles=isSedanavailablein5miles();
			
			if (requestSatisfiedin5miles = true){
				//send notification to customer saying tht he needs to wait for more time
				ServiceManager custNotification = new ServiceManager();
				custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_WAIT_30_MINS);
				
				//perform db operation to change the state of the vehicle(sedan) from START,FINISH to RUNNING

			}
			else
			{
				//send notification to customer saying that there is no vehicle currently available in his location
				ServiceManager custNotification = new ServiceManager();
				custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_NOT_AVAILABLE_AT_ALL);
				
			}
		}
	}


public boolean isSedanavailablein2miles() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicles WHERE vehicle_type='sedan' and vehicle_state = 'AVAILABLE' and vehicle_avalible_2miles='Y'";
	ResultSet rs = DBHandler.queryDB(sql);
	try {
		rs.next();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	//int rowCount;
	try {
		rowCount = rs.getInt(1);
		if (rowCount >= 1){
			successFlag2miles = true;
		}
		else
		{
			successFlag2miles = false;

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return successFlag2miles;
	
	}

//check availability of sedan within 5 miles
public boolean isSedanavailablein5miles() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicles WHERE vehicle_type='sedan' and vehicle_state='AVAILABLE' and vehicle_avalible_5miles='Y'";
	ResultSet rs = DBHandler.queryDB(sql);
	try {
		rs.next();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	try {
		rowCount = rs.getInt(1);
		if (rowCount >= 1){
			successFlag5miles = true;
		}
		else
		{
			successFlag5miles = false;

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return successFlag5miles;
	
	}

public int setVehicleStatus(int reqID) {
	String sql = "select min(vehicle_id) veh_id from vehicle where vehicle_type='sedan' and vehicle_state='AVAILABLE' and vehicle_avalible_2miles='Y'";
	ResultSet rs = DBHandler.queryDB(sql);
	int vehID;
	try {
		
		vehID = Integer.parseInt(rs.getString("veh_id"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return reqID;
}
	
/*public void setVehicleStatus(int reqID){
//	String sql = "UPDATE user_requests SET request_state='FINISH' where request_id=" + reqID;
	String sql = "update vehicle set vehicle_state='INTRANSIT', request_id="+reqID+ " and vehicle_id in ";
	DBHandler.updateDB(sql);
}
*/
}
}
	
