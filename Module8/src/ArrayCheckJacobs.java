import java.util.Arrays;
import java.util.Iterator;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 12, 2023
 */
public class ArrayCheckJacobs {
	// int[] randomArray;
	public static void main(String[] args) {
		/*
		 * Using a for loop and Math.random, initialize an array with five random
		 * integers between 1 and 100. Then, print these eight lines of output:
		 * 
		 * Every element in the array All elements in reverse order First element Last
		 * element Every element at an odd index Every odd element Highest element
		 * Lowest element
		 */

		// init variables
		int arraySize = 5;
		int rangeMin = 1;
		int rangeMax = 100;
		int range = rangeMax - rangeMin + 1;
		int[] randomArray = new int[arraySize];
		int randomArrayValue = 0;
		int elementIndex = 0;
		int lastArrayIndex = randomArray.length - 1;
		int firstArrayIndex = 0;

		// print random Array
		System.out.println(" Random array: ");

		for (int i = 0; i < randomArray.length; i++) {
			// get random int between 1 and 100
			randomArrayValue = rangeMin + (int) (Math.random() * rangeMax);
			elementIndex += i;
			randomArray[i] = randomArrayValue;
		}

		// enhanced loop to print random array
		for (int i : randomArray) {
			System.out.print(" || " + i + " || ");
		}
		System.out.println();
		System.out.println();

		// print reverse of randomArray by making a copy so we don't overwrite the
		// values in our array
		System.out.println(" Reverse of random array: ");
		int[] revArray = Arrays.copyOf(randomArray, randomArray.length);
		int revIndex = arraySize;

		// start from end of array so it prints in reverse
		for (int i = revArray.length - 1; i >= 0; i--) {
			System.out.print(" || " + revArray[i] + " || ");
		}

		System.out.println();
		System.out.println();

		// print first element (index of 0)
		System.out.println(" First element of random array: ");
		System.out.println(" || " + randomArray[firstArrayIndex] + " || ");
		System.out.println();

		// print last element(length -1 because start is index 0
		System.out.println(" Last element of random array: ");
		System.out.println(" || " + randomArray[lastArrayIndex] + " || ");
		System.out.println();

		// for loop so we can print only odd index values
		System.out.println(" Elements of an odd index: ");
		for (int i = 0; i < randomArray.length; i++) {
			if (i % 2 != 0) {
				System.out.print(" || " + randomArray[i] + " || ");
			}
		}

		System.out.println();
		System.out.println();
		System.out.println(" Every odd element: ");

		// enhanced loop to print odd element values so we check every index value
		for (int i : randomArray) {
			if (i % 2 != 0) {
				System.out.print(" || " + i + " || ");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(" Highest element: ");
		System.out.println(" || " + findHighestElement(randomArray) + " || ");
		System.out.println();
		System.out.println(" Lowest element: ");
		System.out.println(" || " + findLowestElement(randomArray) + " || ");
	}

	// method to check for highest element. take array as a param
	public static int findHighestElement(int array[]) {
		int highestElement = 0;
		int indexPosition = 0;

		// loop to go through all indexes
		for (int i = 0; i < array.length - 1; i++) {
			// if value of our current index is less than the next index, then the highest
			// value is the next index
			if (array[indexPosition] < array[i + 1]) {
				// set new index to next index
				indexPosition = i + 1;
				highestElement = array[i + 1];
			} else {
				// keep same index
				highestElement = array[indexPosition];
			}
		}
		return highestElement;
	}

	// method to check for lowest element. take array as a param
	public static int findLowestElement(int array[]) {
		int lowestElement = 0;
		int indexPosition = 0;
		// loop to go through all indexes
		for (int i = 0; i < array.length - 1; i++) {
			// if value of our current index is higher than the next index then the lowest
			// value is the next index
			if (array[indexPosition] > array[i + 1]) {
				// set new index to next index
				indexPosition = i + 1;
				lowestElement = array[i + 1];
			} else {
				// keep same index
				lowestElement = array[indexPosition];
			}
		}
		return lowestElement;
	}
	/*
	 * Your program should not use magic numbers in your for loops. This means that
	 * you should use your arrayName.length to find out what the last element is. In
	 * your code, the only '5' that should be present is on the first array
	 * declaration. I should easily be able to modify your array declaration to be
	 * 11 or 12 or 32 and your program should still function. Create and use
	 * variables in your Math.random statement. It should not be: int randNum = 1 +
	 * (int) (Math.random() * 100); As a reminder: If the remainder when you divide
	 * by 2 is 0, it's even. % is the operator to get a remainder. Use an enhanced
	 * for loop to print every element in the array (Item #1 above). Create two
	 * methods - one for determine the highest element and one for determining the
	 * lowest element. Pass the array as the parameter - do not create a global
	 * array. Just remember to print in the main method only! Create a tester file
	 * to test the two methods you have created.
	 */
}