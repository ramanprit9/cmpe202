package member;

import request.Request;

public abstract class Member {

	String firstName;
	String lastName;
	String status;
	double balance;
		
	public double calculatDiscount(double amount) {
		return calculatePercentageDiscount(amount) + calculateFixedDiscount(amount);
	}
	
	public abstract double calculatePercentageDiscount(double amount);
	
	public abstract double calculateFixedDiscount(double amount);
}
