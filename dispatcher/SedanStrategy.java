package dispatcher;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


import org.apache.http.client.ClientProtocolException;

import java.util.ArrayList;
import request.Request;

public class SedanStrategy implements DispatchStrategy {
	
	public void findTransportation(Request r1)
	{
		int rad = 2 ;
		String zipcodes;
	  //  zipcodes = getZipcodes2miles(rad);
	};

	 public String getZipcodes2miles(int radius) throws ClientProtocolException, IOException{
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
