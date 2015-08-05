package request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import trasnportation.Vehicle;
import main.Address;
import main.DBHandler;
import member.GoldMember;
import member.Member;
import member.PlatinumMember;
import member.SilverMember;
import notification.*;

public class Request implements RequestInterface {
	State state;
	int requestID;
	String  memberID; /*memberID is "guest" if not member */
	Address pickupLocation;
	Date pickupTime;
	Address destination;
	boolean shareable;
	String vehicleType;
	int numOfPassengers;
	int numOfLuggages;
	String commType;
	Vehicle vehicle;
	Member member;
	Date startRideTime;
	Date endRideTime;
	double totalRideMinutes; 
	double totalRideMiles;
	int rideSpeed;
	double milesTravelled;
	double durationOfRide; /* in minutes */
	String ridePayStrategy;
	double ridePayment; /* final ride payment calculated by PaymentProcessor */
	
	public Request (String memID, Address pick, Address dest, int passengers, int luggages, 
			boolean share, Date reqtime, String vtype, int speed) {
		memberID = memID;
		pickupLocation = pick;
		destination = dest;
		numOfPassengers = passengers;
		numOfLuggages = luggages;
		shareable = share;
		requestID = 2;
		pickupTime = reqtime;
		vehicleType = vtype;
		rideSpeed = speed;
		
		this.member = createMemberfromDB();
		state = new ReceiveState(this);
	}
	
	public Member createMemberfromDB() {
		System.out.println("*************** Request: creating member from DB, memberID = "+memberID.toLowerCase());
		//If member is not a guest, then create a Member object by 
		//retrieving the relevant data from DB
		if (memberID.toLowerCase().equals("guest")) { 
			return null; 
		}
		Member mem = null;
		String sql = "Select member_fname, member_lname, member_type, member_card_type, member_card_number, " + 
					"member_card_cvs_number, member_payment_balance, member_username from member_registration " + 
					"where member_id = " + memberID;
		System.out.println("*************** Request, sql = \n"+sql);
		ResultSet rs = DBHandler.queryDB(sql);
		try {
			rs.next();
			System.out.println("*************** Request: "+rs);
			if (rs.getString("member_type").equals("SILVER")) {
				mem = new SilverMember();
			}
			else if (rs.getString("member_type").equals("GOLD")) {
				mem = new GoldMember();
			}
			else {
				mem = new PlatinumMember();
			}
			mem.setFirstName(rs.getString("member_fname"));
			mem.setLastName(rs.getString("member_lname"));
			mem.setPaymentMethod(rs.getString("member_card_type"));
			mem.setPaymentCardNumber(rs.getString("member_card_number"));
			mem.setPaymentCVSNumber(rs.getString("member_card_cvs_number"));
			mem.setBalance(rs.getDouble("member_payment_balance"));
			mem.setUserName(rs.getString("member_username"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}
	
	public void receiveRequest(){
		state.receiveRequest();
	}
	
	public void evaluateRequest(){
		state.evaluateRequest();
	}
	
	public void fullfillRequest(){
		state.fulfillRequest();
	}
	
	
	public void setState(State s){
		state = s;
	}
	
	public State getState(){
		return state;
	}
	
	public Address getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Address pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public boolean isShareable() {
		return shareable;
	}

	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}

	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}
	
	
	public int getNumOfLuggages() {
		return numOfLuggages;
	}

	public void setNumOfLuggages(int numOfLuggages) {
		this.numOfLuggages = numOfLuggages;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	
	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	
	public Date getStartRideTime() {
		return startRideTime;
	}

	public void setStartRideTime(Date startRideTime) {
		this.startRideTime = startRideTime;
	}

	public Date getEndRideTime() {
		return endRideTime;
	}

	public void setEndRideTime(Date endRideTime) {
		this.endRideTime = endRideTime;
	}

	public double getTotalRideTime() {
		return totalRideMinutes;
	}

	public void setTotalRideTime(double totalRideMinutes) {
		this.totalRideMinutes = totalRideMinutes;
	}

	public double getTotalRideMiles() {
		return totalRideMiles;
	}

	public void setTotalRideMiles(double totalRideMiles) {
		this.totalRideMiles = totalRideMiles;
	}

	public int getRideSpeed() {
		return rideSpeed;
	}

	public void setRideSpeed(int rideSpeed) {
		this.rideSpeed = rideSpeed;
	}

	
	public double getMilesTravelled() {
		return milesTravelled;
	}

	public void setMilesTravelled(double milesTravelled) {
		this.milesTravelled = milesTravelled;
	}

	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getTotalRideMinutes() {
		return totalRideMinutes;
	}

	public void setTotalRideMinutes(double totalRideMinutes) {
		this.totalRideMinutes = totalRideMinutes;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public double getDurationOfRide() {
		return durationOfRide;
	}

	public void setDurationOfRide(double durationOfRide) {
		this.durationOfRide = durationOfRide;
	}

	public String toString() {
		String comm; 
		if (commType.equals(Text.class)) { comm = "Text";}
		else if (commType.equals(Phone.class)) { comm = "Phone"; }
		else { comm = "Email"; }
		
		return "Pickup Address: " + pickupLocation + " \nDestination Address: " + destination
				+ "\nPassengers: " + numOfPassengers + "   Luggauges: " + numOfLuggages + 
				"   Shareable: " + shareable + "   Communication Method: " + comm;
	}
	
	public String getBasicRequestString() {
		return "Request ID: " + requestID + "\nPickup Location: " + pickupLocation + 
				"\n Destination: " + destination;
	}

	public double getRidePayment() {
		return ridePayment;
	}

	public void setRidePayment(double ridePayment) {
		this.ridePayment = ridePayment;
	}

	public String getRidePayStrategy() {
		return ridePayStrategy;
	}

	public void setRidePayStrategy(String ridePayStrategy) {
		this.ridePayStrategy = ridePayStrategy;
	}
	
}
