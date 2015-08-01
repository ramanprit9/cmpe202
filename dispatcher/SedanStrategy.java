package dispatcher;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.DBHandler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import org.apache.http.client.ClientProtocolException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import request.Request;
//Strategy pattern--This strategy to be used when no of passengers is very few.
public class SedanStrategy implements DispatchStrategy {
	boolean successFlag;

	public void findTransportation(Request r1)
	{
		int rad = 2 ;
		boolean requestSatisfied;
	   /* try {
			zipcodes = getZipcodes2miles(rad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		requestSatisfied=isSedanavailable();
	}


public void getSedan(){
	//check availability of sedan within 2miles 
	
	//check availability of sedan within 5 miles
}

public boolean isSedanavailable() {
	int rowCount;
	//boolean successFlag;
	String sql = "Select Count(*) from vehicles WHERE vehicle_type='sedan' and vehicle_state in ('FINISH','START') and vehicle_avalible_2miles='Y'";
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
			successFlag = true;
		}
		else
		{
			successFlag = false;

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return successFlag;
	
	}



}
/*	 public String getZipcodes2miles(int radius) throws ClientProtocolException, IOException{
		 HttpClient client = new DefaultHttpClient();

		  HttpGet request = new HttpGet("https://www.zipcodeapi.com/rest/dy9H7sCTPlfj1VZgaPqBMIIzgQChQeH4NQLVioO8K3rLYq29gsL3atCrjfIauqeh/radius.csv/95131/2/mile");

		  HttpResponse response = client.execute(request);

		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		 // String zipcodes;
		  String line = " ";
		  int ctr = 0;
		  while ((line = rd.readLine()) != null) {

			if (ctr != 0) {
		    System.out.println(line.split(",")[0]);
				//zipcodes = (line.split(",")[0]);
				
			}
			ctr++;
		  
		}
		  
		  return rd.toString();
	 }
	
	
}
*/