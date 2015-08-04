package trasnportation;

public class Luxury extends VehicleDecorator {

	private double chargePerDrink = 4.50;
	
	public Luxury(Vehicle vehicle) {
		super(vehicle);
	}
	
	public void chargeForDrinks(int numOfDrinks) {
		if (numOfDrinks > 0) {
			this.setAdditionalCost(this.getAdditionalCost() + (numOfDrinks * chargePerDrink));
		}
	}

	public void chargeForDiscoLights(double amount) {
		if (amount > 0) {
			this.setAdditionalCost(this.getAdditionalCost() + amount);
		}
	}
	
	public void rideWithParisHilton (double amount) {
		if (amount > 0) {
			this.setAdditionalCost(this.getAdditionalCost() + amount);
		}
	}
	
}
