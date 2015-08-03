package payment;

import member.Member;
import member.PlatinumMember;
import request.Request;

public class PaymentProcessor {

	private Request req;
	
	private PaymentStrategy ps;
	
	public PaymentProcessor(Request r){
		req = r;
	}
	
	public void processPayment() {
		double originalPayment;
		double finalPayment; 
		double discount;
		calculateDurationOfRide(); /* calculate minutes of ride */
		originalPayment = calculatePayment(); //calculate the original payment of the ride
		discount = req.getMember().calculatDiscount(originalPayment); //apply the discount
		finalPayment = originalPayment - discount; //payment to be due after the discount
	}
	
	public double calculatePayment() {
		ps = setPaymentStrategy(req.getRideSpeed());
		return ps.calculatePayment(req);
	}
	
	public PaymentStrategy setPaymentStrategy(int rideSpeed) {
		if (rideSpeed < 15) {
			ps = new PayByMinuteStrategy();
		}
		if (rideSpeed >= 15) {
			ps = new PayByMileStrategy();
		}
		return ps;
	}
	
	public void calculateDurationOfRide() {
		double durationMS; /* in milliseconds */
		double durationMinutes; /* in minutes */
		durationMS= req.getEndRideTime().getTime() - req.getStartRideTime().getTime();
		durationMinutes = durationMS/60000; 
		
		System.out.println("************* Payment Processor: duration of ride = "+durationMinutes);
	}
}
