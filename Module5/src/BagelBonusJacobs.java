import java.text.DecimalFormat;
import java.util.Scanner;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 18, 2023  
*/
public class BagelBonusJacobs {
	
	//declare/initialize variables
	public final static double NO_DISCOUNT = 0;			//Up to $20
	public final static double TWENTY_DISCOUNT = .05;		//From $20.01 to $35.00
	public final static double THIRTYFIVE_DISCOUNT = .07;	//$35.01 to $75
	public final static double SEVENTYFIVE_DISCOUNT = .09;	//$75.01 to $150
	public final static double ONEFIFTY_DISCOUNT = .12;
	public final double DISCOUNT_CUTOFF = 20.00;	//max amount customer can spend	before next discount bracket	
	public final static double FIVE_PERC_MIN = 20.01;		
	public final static double SEVEN_PERC_MIN = 35.01;	
	public final static double NINE_PERC_MIN = 75.01;	
	public final static double TWELVE_PERC_MIN = 150.01;
	public final double NO_CUPS_EARNED_MAX = 24.99;		//max amount customer can spend	before they earn another free cup
	public final static double ONE_CUP_EARNED_MIN = 25.00;
	public final static double TWO_CUPS_EARNED_MIN = 50.01;
	public final static double THREE_CUPS_EARNED_MIN = 100.01;
	public static double monthlyAmountSpent = 0;
	public static double discountEarned = 0;
	public static int freeCupsEarned = 0;
	public static double discountValue = 0;
	
	public static void main(String[] args) 
	{	
		Scanner in =  new Scanner(System.in);
		System.out.println("Please enter your monthly amount spent. ");
		monthlyAmountSpent = in.nextDouble();
		
		DecimalFormat twoDecimals = new DecimalFormat("$#,##0.00");
		DecimalFormat percentFormat = new DecimalFormat("#.0%");
		
		discountCoupon(monthlyAmountSpent);
		calculateDiscountValue(discountEarned, monthlyAmountSpent);
		getCupsEarned(monthlyAmountSpent);
		
		System.out.println("Monthly amount spent at the Bagel Shop: " + twoDecimals.format(monthlyAmountSpent));
		System.out.println("You receive a discount coupon of " + twoDecimals.format(calculateDiscountValue(discountEarned, monthlyAmountSpent)) 
			+ ". (" + percentFormat.format(discountEarned) + " of your previous month's purchase)");
		System.out.println("You have earned " + freeCupsEarned + " cup(s) of coffee.");
		
		in.close();	
		//main method: accept monthly amount spent and complete all printing here
	}
		public static double calculateDiscountValue(double discountEarned, double monthlyAmountSpent) 
		{
			discountValue = (discountEarned * monthlyAmountSpent);
			return discountValue;
		}
		
		public static double discountCoupon(double monthlyAmountSpent) 
		{
			if (monthlyAmountSpent >= TWELVE_PERC_MIN) 
			{
				discountEarned = ONEFIFTY_DISCOUNT;
			}
			else if (monthlyAmountSpent >= NINE_PERC_MIN) 
			{
				discountEarned = SEVENTYFIVE_DISCOUNT;
			}
			else if (monthlyAmountSpent >= SEVEN_PERC_MIN)
			{
				discountEarned = THIRTYFIVE_DISCOUNT;
			}
			else if (monthlyAmountSpent >= FIVE_PERC_MIN) {
				discountEarned = TWENTY_DISCOUNT;
			}
			else 
			{
				discountEarned = NO_DISCOUNT;
			}
			
			return discountEarned;	
		}
		//Discount coupon method: Create a method that accepts the monthly amount as a parameter.
				//The method should return double that represents the percentage discount. 
				//Use the returned value to compute the discount (percent * monthly amount spent) and to print the percentage of the user.
		public static int getCupsEarned(double monthlyAmountSpent) 
		{
			if(monthlyAmountSpent >= THREE_CUPS_EARNED_MIN) 
			{
				freeCupsEarned = 3;
			}
			else if(monthlyAmountSpent >= TWO_CUPS_EARNED_MIN) 
			{
				freeCupsEarned = 2;
			}
			else if (monthlyAmountSpent >= ONE_CUP_EARNED_MIN) 
			{
				freeCupsEarned = 1;
			}
			else
			{
				freeCupsEarned = 0;
			}
			
			return freeCupsEarned;
		}
		//Coffee Rewards Method: Based on their prior months total purchases, also provide them with free cups of coffee.
				//25 to 50 1 cup, 50.01 to 100 2 cups, 100.01 or more 3 cups
		
		//Tests: Create two tests to test your methods.  Test all possible outputs for both methods.
				//Minimally, you'll have at least 5 tests to test the coupon if statements - 
				//possibly more because you want to test the endpoint of the ranges.
				//To test the coffee rewards method, you'll have at least three tests.
}
