package payment;

public class CashPayment extends Payment {

	public CashPayment (int reqID, Double amount) {
		setPaymentReason(PAY_REASON_REQUEST);
		setPaymentMethod(PAY_METHOD_CREDIT_CARD);
		setRequestID(reqID);
		setPaymentAmount(amount);
	}

	public CashPayment (String reason, String amount) {
		setPaymentReason(reason);
		setPaymentMethod(PAY_METHOD_CASH);
	}

	public boolean processPayment() {
		return true;
	}
}
