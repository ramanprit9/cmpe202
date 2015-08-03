package payment;

import request.Request;

public class PayByMinuteStrategy implements PaymentStrategy {
	
	public double calculatePayment(Request req) {
		double mins = req.getTotalRideMinutes();
		double vehicleRate = req.getVehicle().getCostPerMinute();
		return mins*vehicleRate;
	}

}
