
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 12, 2023
 */

public class CalendarOrderJacobs {
	//Create three overloaded computeOrderTotal() methods.
	
	// When computeOrderTotal() receives a single double parameter, it represents
	// the price of one calendar ordered.
	// Add 7% tax and return the total due as a double.
	public static double computeOrderTotal(double calendar) {
		
		final double TAX_RATE = 0.07;
		double amountDue = (calendar * TAX_RATE) + calendar;
		return amountDue;
	}

	// When computeOrderTotal() received two parameters, they represent the price of
	// a calendar and the quantity ordered (int).
	// Multiply the two values, add 7% tax and return the total due.
	public static double computeOrderTotal(double calendar, int quanity) {
		
		final double TAX_RATE = 0.07;
		double subTotal = (calendar * quanity);
		double amountDue = (subTotal * TAX_RATE) + subTotal;
		return amountDue;
	}
	
	// Finally, when computeOrderTotal() receives three parameters, they represents
	// the price of a calendar, the quantity ordered, and a coupon value represented
	// in decimal.
	// Multiple the quantity and price for a new subtotal. Compute the coupon
	// discount amount by multiplying the coupon value by subtotal.
	// Reduce the subtotal by the calculated coupon value. Finally, add 7% tax
	// (based on the new subtotal with the discount) and return the total due.
	public static double computeOrderTotal(double calendar, int quanity, double coupon) {
		
		final double TAX_RATE = 0.07;
		double subTotal = (calendar * quanity);
		double totalAfterDiscount = subTotal - (coupon * subTotal);
		double amountDue = (totalAfterDiscount * TAX_RATE) + totalAfterDiscount;

		return amountDue;
	}
	
	public static void main(String[] args) {
		/*
		 * In the main method, call each method testing to make sure you receive the
		 * correct values and back. For example, with these calls (using printf to two
		 * decimals), I would receive the following:
		 * computeOrderTotal(11.99); //12.83
		 * 
		 * computeOrderTotal(11.99, 3); // 38.49
		 * 
		 * computeOrderTotal(11.99, 3, .1); // 34.64
		 */
		System.out.printf("%.2f", computeOrderTotal(11.99));
		
		System.out.printf("\n%.2f", computeOrderTotal(11.99, 3));
		
		System.out.printf("\n%.2f", computeOrderTotal(11.99, 3, .1));
	}

}
