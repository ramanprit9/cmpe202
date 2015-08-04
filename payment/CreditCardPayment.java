package payment;

public class CreditCardPayment extends Payment {

	public CreditCardPayment (String reason, String cardNum, String cvs, String amount, int reqID) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setCardNumber(cardNum);
		setRequestID(reqID);
	}
	
	public CreditCardPayment (String reason, String cardNum, String cvs, String amount) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setCardNumber(cardNum);
	}


	public boolean processPayment() {
		return true;
	}

}
