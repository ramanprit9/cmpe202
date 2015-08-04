package trasnportation;

import java.util.LinkedList;

import main.Address;
import main.ServiceManager;
import member.Member;

public class Shuttle extends VehicleDecorator {

	LinkedList<Member> shuttleMembers = new LinkedList();
	LinkedList<Address> shuttleStops = new LinkedList();
	
	public Shuttle(Vehicle vehicle) {
		super(vehicle);
	}
	
	public void addMember(Member m) {
		shuttleMembers.add(m);
	}
	
	public void removeMember(Member m) {
		shuttleMembers.remove(m);
	}
	
	public void addStop(Address addr) {
		shuttleStops.add(addr);
		String memberName; 
		for (Member mem : shuttleMembers) {
			memberName =mem.getFirstName() + " " + mem.getLastName();
			broadCastNotification(memberName, "A stop added to shuttle: " + addr + "\n");
		}
	}
	
	public void removeStop(Address addr) {
		shuttleStops.remove(addr);
		String memberName; 
		for (Member mem : shuttleMembers) {
			memberName =mem.getFirstName() + " " + mem.getLastName();
			broadCastNotification(memberName, "A stop removed from shuttle: " + addr + "\n");
		}

	}
	
	public void broadCastNotification(String member, String msg) {
		ServiceManager sm = new ServiceManager();
		sm.sendShuttleNotification(member, msg);
	}
}
