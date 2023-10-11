import java.util.Scanner;
import java.text.DecimalFormat;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 11, 2023  
*/
public class CompareNumbersJacobs {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		DecimalFormat fourDecimals = new DecimalFormat("###,###,###.0000");
		
		//get input and declare and initialize variables
		System.out.print("Please enter a number with up to 4 decimal points: ");
		double userNumOne = in.nextDouble();
		System.out.print("Please enter another number with up to 4 decimal points: ");
		double userNumTwo = in.nextDouble();
		
		//set up comparisons 
		boolean greaterThan = userNumOne > userNumTwo;
		boolean lessThan = userNumOne < userNumTwo;
		boolean equalTo = userNumOne == userNumTwo;
		
		//print to user
		System.out.println(fourDecimals.format(userNumOne) + " is equal to " + fourDecimals.format(userNumTwo) + ": " + equalTo);
		System.out.println(fourDecimals.format(userNumOne) + " is greater than " + fourDecimals.format(userNumTwo) + ": " + greaterThan);
		System.out.println(fourDecimals.format(userNumOne) +  " is less than " + fourDecimals.format(userNumTwo) + ": " + lessThan);
		in.close();
	}

}
