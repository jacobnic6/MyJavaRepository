import java.text.DecimalFormat;
import java.util.Scanner;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 1, 2023  
*/
public class AverageCaloriesJacobs {

	public static void main(String[] args) 
	{
		//initialize variables
		final int ARRAY_START = 0;
		final int DAY_START = 1;
		final int NUM_OF_DAYS = 7;
		//create format for output
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		Scanner in = new Scanner(System.in);
		//prompt user with instructions
		System.out.println("Please enter your calorie intake with the corresponding day. (Please use positive  whole numbers): ");
		//initialize our array for storing our user calories with their index+1 being their day. (dailyCalories[0] is day 1)
		int[] dailyCalories = new int[NUM_OF_DAYS]; 
		
		//set our counters, one for the array and one for the day and set them equal to our constant starting values. increment each iteration
		for (int arrayCount = ARRAY_START, dayCount= DAY_START; arrayCount < NUM_OF_DAYS; arrayCount++, dayCount++) 
		{
			//try catch for input validation
			try 
				{
				//local variable to set equal to user input that we use to pass into our check if positive method
				int userInput = 0;
				System.out.println("Day " + dayCount + ": ");
				userInput = in.nextInt();
				dailyCalories[arrayCount] = userInput;
				checkIfPositive(userInput);	
				}
			//throw error when user enters a string or negative number
			catch(Exception e)
				{
				System.out.println("Input error for day " + dayCount + ". Please use positive  whole numbers");
				break;
				}
			//display average to user after final number is entered.
			if(dayCount == NUM_OF_DAYS) 
			{
				System.out.println("Your average daily calorie intake over " + NUM_OF_DAYS + " days is: " + decimalFormat.format(findAverage(dailyCalories)) + " calories.");
			}
		}
		
		
		// TODO Auto-generated method stub
		//Using a for loop, prompt the user for 7 days worth of calorie intake as a whole number. 
		//Remember: no magic numbers.  Good, descriptive variable names.  Brief comments that describe what the code is doing. 

	}
	//get sum of our array values
	public static double findSum(int[] array) 
	{
		double sum = 0;
	    for (double value : array) 
		    {
		    	sum += value;
		    }
	    return sum;
	}
	//get avg of our array values. call findSum()/length of our array
	public static double findAverage(int[] array) 
	{
		//call our sum method and set it to a variable so we can use it to find our average
	    double sum = findSum(array);
	    double avg = (sum / array.length);
	    return avg;
	}
	//method that checks user input and throws exception if > 0
	static void checkIfPositive(int userInput) throws NegativeException{
		{
			
			if (userInput < 0) 
			{
				throw new NegativeException("\n Please enter positive numbers");
			}
		}
	}

}
