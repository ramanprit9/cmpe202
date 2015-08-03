package payment;

import request.Request;

public class PayByMileStrategy implements PaymentStrategy {

	public double calculatePayment(Request req) {
		double miles = req.getTotalRideMiles();
		double vehicleRate = req.getVehicle().getCostPerMile();
		return miles*vehicleRate;
	}

}
