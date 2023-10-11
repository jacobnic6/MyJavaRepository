import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 7, 2023
 */
public class TextFoundJacobs {
	

	/*
	 * In the main method, read a line of input from the user (as a string) and call
	 * the method you created to find out if the string contains double e or double
	 * o.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean patternFound = false;
		final String SENTINEL = "exit";
		Scanner in = new Scanner(System.in);
		String userInput = "";
		

		// loop calling method till exit typed or match found
		while (!userInput.toLowerCase().contains(SENTINEL) && !patternFound) {
			System.out.println(
					"Please enter a word you would like to check for double e or double o. \nType 'exit' to exit. ");
			userInput = in.next();
			patternFound = processString(userInput);
			if (!userInput.toLowerCase().contains(SENTINEL) && !patternFound) {
				patternFound = processString(userInput);
				if (patternFound == true) {
					break;
				}
			} else {
				break;
			}
		}
		//prints to user if exiting or if pattern found
		if (patternFound == true) {
			System.out.println("Pattern found: " + patternFound);
		} else {
			System.out.println("Exit typed, now exiting program.");
		}

	}

	/*
	 * If there is no match, prompt for another string and search again. If the
	 * string contains a double e or double o, end the program. If the user enters
	 * the word 'exit' into the program, end the program. Do not process the word
	 * 'exit'.
	 */

	// create a method that accepts a String variable as a parameter and returns a
	// boolean.
	
	public static boolean processString(String userInput) {

		boolean matchTrue = false;
		//see if it contains values ignoring case
		if (userInput.toLowerCase().contains("ee") || userInput.toLowerCase().contains("oo")) {
			matchTrue = true;
		}
		//returns true or false to where method was called
		return matchTrue;

	}

}
