package request;

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

	 Dispatcher dispatcher = new Dispatcher();
	 dispatcher.submitRequest(req);
	 return "Need to qualify the request";
 }
 
 public String fulfillRequest(){
	 return "Request Needs to be evaluated first";
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

