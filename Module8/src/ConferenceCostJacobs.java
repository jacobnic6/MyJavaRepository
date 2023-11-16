
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 15, 2023
 */
public class ConferenceCostJacobs {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	//sent value for user to exit
			final int SENTINEL = 999;
			Scanner in = new Scanner(System.in);
			
			//new format for output to be formatted as currency
			DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
	
			//prompt user and store input
			System.out.println("Please enter how many days per week the attendee will attend the conference: "
					+ "\n(Please use positive whole numbers between 1 and 5. Type 999 to exit)");
			
			int daysAttending = in.nextInt();
			int tierLevel = 0;
	
			// if statement checking that sent value wasn't entered
			if (daysAttending != SENTINEL) {
				System.out.println("Please the attendee's desired conference tier level: "
						+ "\n(Please use positive whole numbers between 1 and 4.)");
				tierLevel = in.nextInt();
			}
	
			//exit if sent value was entered
			else {
				System.out.println("Now exiting program");
			}
	
			//while loop going till sent value is entered
			while (daysAttending != SENTINEL) {
				System.out.println();
	
				//if cost == 0 then our exception was thrown and we don't need to display cost. 
					//if it isn't 0 then display formatted cost and continue loop
				if (findCost(tierLevel, daysAttending) != 0) {
					System.out.println("The cost of " + daysAttending + " days at tier level " + tierLevel + " will be: "
							+ currencyFormat.format(findCost(tierLevel, daysAttending)) + ".");
					System.out.println();
				}
	
				//prompt for days
				System.out.println("Please enter how many days per week the attendee will attend the conference: "
						+ "\n(Please use positive whole numbers. Type 999 to exit.)");
				daysAttending = in.nextInt();
	
				//check that days != to sent value
				if (daysAttending != SENTINEL) {
					System.out.println("Please the attendee's desired conference tier level: "
							+ "\n(Please use positive whole numbers.)");
					tierLevel = in.nextInt();
				} else {
					System.out.println("Now exiting program.");
				}
			}
			/*
			 * Create a program that accepts the number of days per week the attendee will
			 * attend and a tier level. Pass those to a method called
			 * determineConferenceCost that returns the cost to charge the attendee. Return
			 * the cost to the console. Continue to prompt for days and tier levels until a
			 * sentinel value of 999 is entered for number of days.
			 */
			/*
			 * To save time, you can use my array declaration and initialization:
			 * 
			 * int rates[][] = { {100, 190, 270, 340, 400}, {90, 170, 250, 320, 380}, {85,
			 * 160, 240, 310, 370}, {75, 150, 230, 300, 360} };
			 * 
			 * Create a test file to test your method to verify it is receive the correct
			 * value back. For example:
			 * 
			 * My method should return 100 if tier 1 and 1 days of attendance is passed into
			 * the determineConferenceCost method.
			 */
		}
	
	//method to find cost. takes tier and days as input
		public static int findCost(int tier, int days) {
			int rates[][] = { { 100, 190, 270, 340, 400 }, // tier 1
					{ 90, 170, 250, 320, 380 }, // tier 2
					{ 85, 160, 240, 310, 370 }, // tier 3
					{ 75, 150, 230, 300, 360 } }; // tier 4
	//try catch for exception handling
			try {
	//set cost to the value returned by user tier - 1 and days - 1 because the array starts at 0 
				int conferencCost = rates[tier - 1][days - 1];
				return conferencCost;
			}
	//throw exception so program doesn't crash it input is out of bounds of the array 
			catch (IndexOutOfBoundsException e) {
				System.out.println("Please enter a number between 1-5 for days, and 1-4 for tier.");
				System.out.println();
	//return 0 since that isn't a cost on our table
				return 0;
			}
		}
}
