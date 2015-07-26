package main;

public class Address {
	String streetAddr;
	String city;
	String state;
	String zipcode;
	
	public Address(String addr, String c, String st, String zip) {
		streetAddr = addr;
		city = c;
		state = st;
		zipcode = zip;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString() {
		return (streetAddr + ", " + city + " " + state + ", " + zipcode);
	}
}
