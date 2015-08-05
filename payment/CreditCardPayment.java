package payment;

public class CreditCardPayment extends Payment {

	//Payment for a request
	public CreditCardPayment (int reqID, String cardNum, String cvs, Double amount) {
		setPaymentReason(PAY_REASON_REQUEST);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setCardNumber(cardNum);
		setCardCVSNumber(cvs);
		setRequestID(reqID);
		setPaymentAmount(amount);
	}
	
	//Other payment
	public CreditCardPayment (String reason, String cardNum, String cvs, Double amount) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setCardNumber(cardNum);
	}


	public boolean processPayment() {
		return true;
	}

}
