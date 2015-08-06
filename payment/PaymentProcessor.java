package payment;

import member.Member;
import member.PlatinumMember;
import request.Request;

public class PaymentProcessor {

	private PaymentStrategy ps;
		
	public PaymentProcessor() {
		
	}
	
	//Wrapper function for cash payment where card number and cvs number are not applicable
	public boolean handleRequestPayment(Request req, String payMethod) {
		return handleRequestPayment(req, payMethod, "", "");
	}
	
	//Wrapper function for debit card payment where cvs number is not applicable
	public boolean handleRequestPayment(Request req, String payMethod, String cardNum) {
		return handleRequestPayment(req, payMethod, cardNum, "");
	}
	
	public boolean handleRequestPayment(Request req, String payMethod, String cardNum, String cvsNum) {
		double originalPayment;
		double finalPayment; 
		double discount;
		boolean paymentSuccessfull;
		Payment payment;
		originalPayment = calculateRequestPayment(req); //calculate the original payment of the ride
		finalPayment = originalPayment; //initially, the finalPayment is same as originalPayment
		
		//If member field is null, then the customer is not registered
		//If customer is member, apply discounts
		if (req.getMember() != null) { 
			discount = req.getMember().calculatDiscount(originalPayment); //apply the discount
			finalPayment = originalPayment - discount; //payment to be due after the discount
		}
		
		req.setRidePayment(finalPayment);
		
		if (payMethod.equals(Payment.PAY_METHOD_CREDIT_CARD)) {
			payment = new CreditCardPayment(req.getRequestID(), cardNum, cvsNum, finalPayment);
		}
		else if (payMethod.equals(Payment.PAY_METHOD_DEBIT_CARD)) {
			payment = new DebitCardPayment(req.getRequestID(), cardNum, finalPayment);
		}
		else {
			payment = new CashPayment(req.getRequestID(), finalPayment);
		}
		
		paymentSuccessfull = payment.processPayment();
		if (paymentSuccessfull == false) {
			req.getMember().debitMemberBalance(finalPayment);
		}
		
		return paymentSuccessfull;
	}
	
	public double calculateRequestPayment(Request req) {
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
		
}
