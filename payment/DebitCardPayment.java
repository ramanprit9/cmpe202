package payment;

public class DebitCardPayment extends Payment {

	public DebitCardPayment(String method, String reason) {
		super(method, reason);
	}

	public boolean processPayment() {
		return true;
	}

}
