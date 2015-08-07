package trasnportation;

import java.util.LinkedList;

import main.Address;
import main.ServiceManager;
import member.Member;

public abstract class Shuttle extends VehicleDecorator {

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
	
	public void notifyMembers(Member member, String msg) {
		ServiceManager sm = new ServiceManager();
		String memberName =member.getFirstName() + " " + member.getLastName();
		sm.sendShuttleNotification(memberName, msg);
		member.shuttleUpdate();
	}
	
	public abstract void addStop(Address addr);
	
	public abstract void removeStop(Address addr);
	
}
