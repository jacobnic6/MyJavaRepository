import java.text.DecimalFormat;
import java.util.Scanner;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 24, 2023  
*/
public class MileageRatingJacobs 
{
	public static final double EXCELLENT_MIN = 40; //over 40
	public static final double GOOD_MIN = 30;		//30-39
	public static final double FAIR_MIN = 20;		//20-29		//under 20=poor
	public static final String EXCELLENT_RATING = "Excellent";
	public static final String GOOD_RATING = "Good";
	public static final String FAIR_RATING = "Fair";
	public static final String POOR_RATING = "Poor";
	public static String invalidInputMessage ="\nError: Invalid input. Please enter a positive number.";
	public static String mileageRating = "Rating not found.";
	public static double userMileageValue = 0;
	public static DecimalFormat twoDecimals = new DecimalFormat("###,###,##0.0#");
	
	public static void main(String[] args) 
	{	//get user input
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the MPG of your vehicle.");
		//checks that input is double
		if(in.hasNextDouble()) 
		{
			userMileageValue = in.nextDouble();
			//sets user mileage to input value and checks that it isn't negative
			checkInput(userMileageValue);
			if(userMileageValue >= 0) 
			{
				System.out.println("User Mileage: " + twoDecimals.format(userMileageValue) + "\nMileage rating: " + getMileage(userMileageValue));
			}
			else 
			{
				System.out.println(invalidInputMessage);
			}
		}
		else 
		{
			System.out.println(invalidInputMessage);
		}
		in.close();
	}
	
	public static double checkInput(double userMileageValue) 
	{
			if(userMileageValue >= 0) 
			{
				return userMileageValue;
				//System.out.println("User Mileage: " + twoDecimals.format(userMileageValue) + "\nMileage rating: " + getMileage(userMileageValue));
			}
			else 
			{
				userMileageValue = -1;
				//System.out.println(invalidInputMessage);
			}
			return userMileageValue;
	}
	//returns error if value is a string
	public static String checkInput(String userMileageValue) 
	{
		return invalidInputMessage;	
	}
			
	public static String getMileage(double userMileageValue) 
	{	 //compares input value to rating cutoffs and assigns a rating
			if(userMileageValue >= EXCELLENT_MIN ) 
			{
				mileageRating = EXCELLENT_RATING;
			}
			else if (userMileageValue >= GOOD_MIN && userMileageValue < EXCELLENT_MIN) 
			{
				mileageRating = GOOD_RATING;
			}
			else if(userMileageValue >= FAIR_MIN && userMileageValue < GOOD_MIN) 
			{
				mileageRating = FAIR_RATING;
			}
			else 
			{
				if (userMileageValue < FAIR_MIN && userMileageValue >= 0) 
				{
					mileageRating = POOR_RATING;
				}
				else //returns error message if value is less than 0
				{
					mileageRating = invalidInputMessage;
				}
			}
		return mileageRating;
	}
	//Create a method to return the rating.  It should accept a mileage and return a String, which represents the values above.
//	Add input validation to your program.  The following inputs would be errors for our program:
//
//		Any negative numbers
//		Any input that is not a sequence of numbers 
//		If your user enters any of these items, we want to provide and error and exit the program.
//
}
