package payment;

public class CashPayment extends Payment {

	public CashPayment (String reason, String amount, int reqID) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setRequestID(reqID);
	}

	public CashPayment (String reason, String amount) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CASH);
	}


	public boolean processPayment() {
		return true;
	}
}
