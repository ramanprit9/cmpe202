
package dispatcher;

import main.DBHandler;
import main.ServiceManager;


import main.ServiceManager.VehicleAvailability;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import request.Request;
//Strategy pattern--This strategy to be used when no of passengers is more.
public class BusStrategy implements DispatchStrategy {
	boolean successFlag2miles;
	boolean successFlag5miles;
	public void findTransportation(Request r1)
	{
		//int rad = 2 ;
		boolean requestSatisfiedin2miles;
		boolean requestSatisfiedin5miles;
	   
		//Check if vehicle is available in 2miles
		requestSatisfiedin2miles=isBusavailablein2miles();
		if (requestSatisfiedin2miles == true){
			//send notification to customer saying that vehicle is available in 2miles
			ServiceManager custNotification = new ServiceManager();
			custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_IMMEDIATELY_AVAILABLE);
			
			//perform db operation to change the state of the vehicle BUS from AVAILABLE to INTRANSIT
			String sql = "select min(vehicle_id) veh_id from vehicle where vehicle_type='bus' and vehicle_state='AVAILABLE' and vehicle_avalible_2miles='Y' and vehicle_sharable='N'";
			ResultSet rs = DBHandler.queryDB(sql);
			setVehicleStatus(r1.getRequestID(),rs);
		
		}
		else
		{
			requestSatisfiedin5miles=isBusavailablein5miles();
			
			if (requestSatisfiedin5miles == true){
				//send notification to customer saying tht he needs to wait for more time
				ServiceManager custNotification = new ServiceManager();
				custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_WAIT_30_MINS);
				
				//perform db operation to change the state of the vehicle AVAILABLE to INTRANSIT
				String sql = "select min(vehicle_id) veh_id from vehicle where vehicle_type='bus' and vehicle_state='AVAILABLE' and vehicle_avalible_5miles='Y' and vehicle_sharable='N'";
				ResultSet rs = DBHandler.queryDB(sql);
				setVehicleStatus(r1.getRequestID(),rs);
			
			}
			else
			{
				//send notification to customer saying that there is no vehicle currently available in his location
				ServiceManager custNotification = new ServiceManager();
				custNotification.sendDispatchMessages(r1,VehicleAvailability.VEHICLE_NOT_AVAILABLE_AT_ALL);
				
			}
		}
	}


public boolean isBusavailablein2miles() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicle WHERE vehicle_type='bus' and vehicle_state = 'AVAILABLE' and vehicle_avalible_2miles='Y' and vehicle_sharable='N'";
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

//check availability of van within 5 miles
public boolean isBusavailablein5miles() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicle WHERE vehicle_type='bus' and vehicle_state='AVAILABLE' and vehicle_avalible_5miles='Y' and vehicle_sharable='N'";
	ResultSet rs = DBHandler.queryDB(sql);
	try {
		rs.next();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	try {
		rowCount = rs.getInt(1);
		//System.out.println("rowCount",rowCount);
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

public int setVehicleStatus(int reqID,ResultSet rs) {
	int vehID;
	try {
		rs.next(); //move to the next row
		vehID = Integer.parseInt(rs.getString("veh_id"));
		
		//update the vehicle stat

		String updateVehicleStat ="update vehicle set vehicle_state='INTRANSIT',request_id=" +reqID + " where vehicle_id ="+vehID;
		DBHandler.updateDB(updateVehicleStat);
		
		//update the request table for vehicle details
				String updateRequestTab ="update user_requests set vehicle_id=" +vehID+ ",vehicle_tye='van' where request_id=" +reqID;
				DBHandler.updateDB(updateRequestTab);
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	return reqID;
	}

}
	
	

