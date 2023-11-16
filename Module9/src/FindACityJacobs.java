
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 21, 2023
 */
public class FindACityJacobs {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//init sentinel value to exit loop
		final int SENTINEL = -1;

		//init index so we can enter loop before we get input
		int cityIndex = 0;

		//init our array of 10 cities
		String[] cities = new String[] { "Albany", "Des Moines", "Denver", "Topeka", "Tallahassee", "Helena", "Lincoln",
				"Springfield", "Columbus", "Nashville" };

		//try with resources so we close our scanner even when an error is thrown
		try (Scanner in = new Scanner(System.in)) {

			//while loop to prompt user until they enter the sentinel value or an error is thrown
			while (cityIndex != SENTINEL) {
				System.out.println("Please enter a positive, whole number between 1 and 10 to display the city at that position.\nEnter -1 to exit");
				int userInput = in.nextInt();

				//since we prompt user for a number between 1 and 10 we -1 to get the desired index value
				cityIndex = userInput - 1;

				//if input == -1 we exit program
				if (userInput == -1) {
					System.out.println();
					System.out.println("Now exiting");
					break;
				}

				//else we display the returned city and continue loop
				else {
					System.out.println("City number " + userInput + " in the array is: " + cities[cityIndex]);
					System.out.println();
					continue;
				}
			}
			//System.out.println(cities[cityIndex]);
		}
		//catch input exception and write message to user
		catch (InputMismatchException e) {
			System.out.println("Error, invalid input. Input must be a positive, whole number between 1 and 10.");
		}
		//catch out of bounds exception and write to user
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(
					"Error, input out of index bounds. User input must be a positive, whole number between 1 and 10.");
		}
	}
}
