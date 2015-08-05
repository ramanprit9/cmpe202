package member;

import main.DBHandler;
import request.Request;

public abstract class Member {

	String memberID = "";
	String firstName = "";
	String lastName = "";
	String status = "";
	double balance = 0.0;
	String paymentMethod = "";
	String paymentCardNumber = "";
	String paymentCVSNumber = "";
	String memberType = "";
	String userName = "";
		
	public double calculatDiscount(double amount) {
		return calculatePercentageDiscount(amount) + calculateFixedDiscount(amount);
	}
	
	public abstract double calculatePercentageDiscount(double amount);
	
	public abstract double calculateFixedDiscount(double amount);

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentCardNumber() {
		return paymentCardNumber;
	}

	public void setPaymentCardNumber(String paymentCardNumber) {
		this.paymentCardNumber = paymentCardNumber;
	}

	public String getPaymentCVSNumber() {
		return paymentCVSNumber;
	}

	public void setPaymentCVSNumber(String paymentCVSNumber) {
		this.paymentCVSNumber = paymentCVSNumber;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void debitMemberBalance(Double amount) {
		Double newAmount = balance + amount;
		String sql = "Update member_registration SET member_payment_balance = "
				+ newAmount + " where member_id = " + memberID;
		DBHandler.updateDB(sql);
	}
}
