package payment;

import request.Request;

public abstract class Payment {
	public static final String PAY_METHOD_CREDIT_CARD = "CREDITCARD";
	public static final String PAY_METHOD_DEBIT_CARD = "DEBITCARD";
	public static final String PAY_METHOD_CASH = "CASH";
	public static final String PAY_REASON_REQUEST = "request";
	
	private String paymentID;
	private String paymentMethod = "";
	private String paymentReason = "";
	private String cardNumber = "";
	private double paymentAmount = 0.0;
	private int requestID = 0;
	
	//Customer is a member. Payment info on file
//	public Payment (Request req) {
//		this.paymentMethod = req.getMember().getPaymentMethod();
//		this.paymentReason = PAY_REASON_REQUEST;
//		this.requestID = req.getRequestID();
//	}
//
//	public Payment (Request req, String method) {
//		this.paymentMethod = method;
//		this.paymentReason = PAY_REASON_REQUEST;
//		this.requestID = req.getRequestID();
//	}
//
//	public Payment (String method, String reason) {
//		this.paymentMethod = method;
//		this.paymentReason = reason;
//	}
	
	public abstract boolean processPayment();

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentReason() {
		return paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	
}
