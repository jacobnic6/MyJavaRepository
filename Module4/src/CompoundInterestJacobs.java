import java.lang.Math;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 12, 2023  
*/
//Write a method called computeBalance(given initial deposit, annual interest rate, given number of years) Assume interest is compounded yearly.
// formula: A = P(1 + r)^t
//A = the future value of the investment/loan, including interest
//P = the principal investment amount (the initial deposit or loan amount)
//r = the annual interest rate (decimal)
//t = the time the money is invested or borrowed for
//Your method should return a double value of the future value including interest.

	public class CompoundInterestJacobs {
		
		static double computeBalance(double principal, double interestRate, double yrs) {
			
			double ratePlusOne = interestRate + 1;
			
			double expRate = Math.pow(ratePlusOne, yrs);
			
			double futureValue = principal * expRate;
			
			return futureValue;
		}
	
	public static void main(String[] args) {
		//In your main method, run the following tests to verify your method is working correctly.
		//
		System.out.printf("Your total is $%.2f", computeBalance(10000, .045, 13));
		//
		//// should return $17721.96
		//
		System.out.printf("\nYour total is $%.2f", computeBalance(20000, .03, 15));
		//
		//// should return $31159.35
		//
		System.out.printf("\nYour total is $%.2f", computeBalance(30000, .01, 20));

		// should return $36605.70
	}
	
}
