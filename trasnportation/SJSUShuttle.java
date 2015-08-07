package trasnportation;

import main.Address;
import member.Member;

public class SJSUShuttle extends Shuttle {
	
	
	public SJSUShuttle(Vehicle vehicle) {
		super(vehicle);
	}

	public void addStop(Address addr) {
		shuttleStops.add(addr);
		for (Member mem : shuttleMembers) {
			notifyMembers(mem, "A stop added to shuttle: " + addr + "\n");
		}
	}
	
	public void removeStop(Address addr) {
		shuttleStops.remove(addr);
		for (Member mem : shuttleMembers) {
			notifyMembers(mem, "A stop removed from shuttle: " + addr + "\n");
		}

	}
	
}
