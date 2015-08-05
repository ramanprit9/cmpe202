package payment;

import request.Request;

public class PayByMinuteStrategy implements PaymentStrategy {
	
	public double calculatePayment(Request req) {
		double mins = req.getTotalRideMinutes();
		double vehicleRate = req.getVehicle().getCostPerMinute();
		double totalCost = mins*vehicleRate;
		
		req.setRidePayStrategy("Cost Per Minute: "+vehicleRate + 
				"  Totale minutes = "+ mins + "  Total Cost = " + totalCost);
		
		return totalCost;
	}

}
