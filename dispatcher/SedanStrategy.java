package dispatcher;

import main.DBHandler;
import main.Driver;
import main.ServiceManager;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import request.Request;
import trasnportation.Sedan;
import trasnportation.Vehicle;
import notification.Message;
import notification.Message.MessageType;

//Strategy pattern--This strategy to be used when no of passengers is very few.
public class SedanStrategy implements DispatchStrategy {
	boolean successFlag2miles;
	boolean successFlag5miles;
	public boolean findTransportation(Request r1)
	{
		boolean requestSatisfiedin2miles;
		boolean requestSatisfiedin5miles;
	  
		//Check if vehicle is available in 2miles
		requestSatisfiedin2miles=isSedanavailablein2miles();
		
		if (requestSatisfiedin2miles == true){
			//send notification to customer saying that vehicle is available in 2 miles
			ServiceManager custNotification = new ServiceManager();
			custNotification.sendDispatchMessages(r1,MessageType.VEHICLE_INFO_TO_CUSTOMER);
			
			//perform db operation to change the state of the vehicle(sedan) from AVAILABLE to INTRANSIT
			String sql = "select min(vehicle_id) veh_id from vehicle where vehicle_type='sedan' and vehicle_state='AVAILABLE' and vehicle_avalible_2miles='Y' and vehicle_shareable='N' and vehicle_active='Y'";
			ResultSet rs = DBHandler.queryDB(sql);
			
			setVehicleStatus(r1.getRequestID(),rs);
			
			//Create the vehicle and set it in the request
			Vehicle sedan = new Sedan();
			r1.setVehicle(sedan);
			Driver d1 = new Driver();
			sedan.setDriver(d1);

			return true;
		}
		else
		{
			requestSatisfiedin5miles = isSedanavailablein5miles();
			
			if (requestSatisfiedin5miles == true){
				ServiceManager custNotification = new ServiceManager();
				
				//Ask if customer can wait, if not, return false
				if (custNotification.canCustomerWait(r1) == false) { return false; }
				
				//send notification to customer saying tht he needs to wait for more time
				custNotification.sendDispatchMessages(r1,MessageType.VEHICLE_WAIT_30_MINUTES);
				
				//perform db operation to change the state of the vehicle(sedan) from AVAILABLE to INTRANSIT
				String sql = "select min(vehicle_id) veh_id from vehicle where vehicle_type='sedan' and vehicle_state='AVAILABLE' and vehicle_avalible_5miles='Y' and vehicle_shareable='N' and vehicle_active='Y' ";
				ResultSet rs = DBHandler.queryDB(sql);
				setVehicleStatus(r1.getRequestID(),rs);
				
				//Create the vehicle and set it in the request
				Vehicle sedan = new Sedan();
				r1.setVehicle(sedan);
				Driver d1 = new Driver();
				sedan.setDriver(d1);

				return true;
			}
			else
			{
				//send notification to customer saying that there is no vehicle currently available in his location
				ServiceManager custNotification = new ServiceManager();
				custNotification.sendDispatchMessages(r1,MessageType.NO_VEHICLE_AVAILBLE);
				return false;
				
			}
		}
	}


public boolean isSedanavailablein2miles() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicle WHERE vehicle_type='sedan' and vehicle_state = 'AVAILABLE' and vehicle_avalible_2miles='Y' and vehicle_shareable='N' and vehicle_active='Y'";
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
	String sql = "Select Count(*) from vehicle WHERE vehicle_type='sedan' and vehicle_state='AVAILABLE' and vehicle_avalible_5miles='Y' and vehicle_shareable='N' and vehicle_active='Y'";
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

public int setVehicleStatus(int reqID,ResultSet rs) {
	int vehID;
	try {
		rs.next(); //move to the next row
		vehID = Integer.parseInt(rs.getString("veh_id"));
		String updateVehicleStat ="update vehicle set vehicle_state='INTRANSIT',request_id=" +reqID + " where vehicle_id ="+vehID;
		DBHandler.updateDB(updateVehicleStat);
		
		String updateRequestTab ="update user_requests set vehicle_id=" +vehID+ ",vehicle_type='sedan' where request_id=" +reqID;
		DBHandler.updateDB(updateRequestTab);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	return reqID;
	}
	
}

	
