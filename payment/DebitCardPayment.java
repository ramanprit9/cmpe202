package payment;

public class DebitCardPayment extends Payment {

	//Payment for a request
	public DebitCardPayment (int reqID, String cardNum, Double amount) {
		setPaymentReason(PAY_REASON_REQUEST);
		setPaymentMethod(PAY_METHOD_DEBIT_CARD);
		setCardNumber(cardNum);
		setRequestID(reqID);
		setPaymentAmount(amount);
	}
	
	//Other payment
	public DebitCardPayment (String reason, String cardNum, String cvs, Double amount) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setCardNumber(cardNum);
	}

	public boolean processPayment() {
		return true;
	}
}
