import java.text.DecimalFormat;
import java.util.Scanner;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 29, 2023  
*/
public class AverageExpensesJacobs {
	//initialize variables
	static int dayCounter = 1;
	static int numOfDays = 0;
	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		//prompt user to enter an amount of days of expenses they want to enter
		System.out.println("Please enter the amount of days of expenses you would like to enter. (Please use a whole positive number): ");
		//ensure input is type int for days
		if(in.hasNextInt() == true) 
			{
				numOfDays = in.nextInt();
			}
		else
			{
				System.out.println("Please use a positive whole number: ");
			}
		//create our variable to store our daily expense values.
			//set array to have the same amount of number of elements as the user entered for days
		double[] dayValues = new double[numOfDays];
		//Verify that the computed value returned back to them displays a decimal point (double) and a dollar sign.
				//create format: ("$#,##0.00");
		DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");

			//start loop and ask user to enter expenses for the number days they provided. ex: day 1: 50 day 2: 100
		System.out.println("Please enter your expenses correspondind with the day listed. (Please use positive numbers in the format 0.00): ");

			//create our loop that goes until our counter is equal to our number of days
		while (dayCounter <= numOfDays) 
			{	
					//create index point one less than day counter because we started that on 1 and we want this variable to reset itself every time the loop runs
				int indexPoint = dayCounter-1;
					//prompt for daily expenses
				System.out.println("Day " + dayCounter + ": ");
					//assign our user input to the corresponding index in our array()
				dayValues[indexPoint] = in.nextDouble();
					//increment our counter
				dayCounter++;
			}
		//display our daily avg amountmessage to the user by calling our findAverage() method and pass our array as a parameter
		System.out.println("Your average daily expense amount is: " + currencyFormat.format(findAverage(dayValues)));
		in.close();
	}
	//create our method to find the sum of our array
	public static double findSum(double[] array) 
		{
			double sum = 0;
		    for (double value : array) 
			    {
			    	sum += value;
			    }
		    return sum;
		}
	//create our method to find avg
	public static double findAverage(double[] array) 
	{
		//call our sum method and set it to a variable so we can use it to find our average
	    double sum = findSum(array);
	    double avg = (sum / array.length);
	    return avg;
	}
	
	


}
