package trasnportation;

public abstract class VehicleDecorator extends Vehicle {
	protected Vehicle vehicle;
	
	public VehicleDecorator (Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
