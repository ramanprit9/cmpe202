package member;

public class SilverMember extends Member {

	private double fixedDiscountAmount;
	private double fixedDiscountBalance;
	private double percentageDiscount;
	public double getFixedDiscountAmount() {
		return fixedDiscountAmount;
	}
	public void setFixedDiscountAmount(double fixedDiscountAmount) {
		this.fixedDiscountAmount = fixedDiscountAmount;
	}
	public double getFixedDiscountBalance() {
		return fixedDiscountBalance;
	}
	public void setFixedDiscountBalance(double fixedDiscountBalance) {
		this.fixedDiscountBalance = fixedDiscountBalance;
	}
	public double getPercentageDiscount() {
		return percentageDiscount;
	}
	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	
	@Override
	public double calculatePercentageDiscount(double amount) {
		return amount * this.percentageDiscount;
	}
	
	@Override
	public double calculateFixedDiscount(double amount) {
		/* E.g. for every $40, give $2 off. 
		 * For example, if amount is $85, then discount will be $4.25
		 */
		double n = amount / this.fixedDiscountBalance;
		return n*this.fixedDiscountAmount;
	}

}
