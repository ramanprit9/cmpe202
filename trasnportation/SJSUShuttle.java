package trasnportation;

import main.Address;
import member.Member;

public class SJSUShuttle extends Shuttle {
	
	
	public SJSUShuttle(Vehicle vehicle) {
		super(vehicle);
	}

	public void addStop(Address addr) {
		shuttleStops.add(addr);
		String memberName; 
		for (Member mem : shuttleMembers) {
			memberName =mem.getFirstName() + " " + mem.getLastName();
			notifyMembers(memberName, "A stop added to shuttle: " + addr + "\n");
		}
	}
	
	public void removeStop(Address addr) {
		shuttleStops.remove(addr);
		String memberName; 
		for (Member mem : shuttleMembers) {
			notifyMembers(mem, "A stop removed from shuttle: " + addr + "\n");
		}

	}
	


}
