package payment;

import request.Request;

public class PayByMileStrategy implements PaymentStrategy {

	public double calculatePayment(Request req) {
		double miles = req.getTotalRideMiles();
		double vehicleRate = req.getVehicle().getCostPerMile();
		double totalCost = miles*vehicleRate;
		
		req.setRidePayStrategy("Cost Per Mile: "+vehicleRate + 
				"  Total miles = "+ miles + "  Total Cost = " + totalCost);

		return totalCost;
	}

}
