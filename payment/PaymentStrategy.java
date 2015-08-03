package payment;
import request.Request;

public interface PaymentStrategy {
	public double calculatePayment (Request req);
}
