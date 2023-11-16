import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 21, 2023
 */
public class SortShirtSizesJacobs {

	// tells constructor our expected possible exceptions
	public static void main(String[] args) throws IOException, MalformedURLException {

		// init the address of the file
		String fileAddress = "https://bbmedia.dmacc.edu/CIS/CIS171/shirtsizes.txt";
		// nested try catch so that the inner try is only executed if the outer is
		// successful
		// outer is for our URL object. If the URL is malphormed then it throws
		// MalformedURLException error
		try {
			URL pageLocation = new URL(fileAddress);

			// try with resources for our scanner and print writers
			try (Scanner in = new Scanner(pageLocation.openStream());
					PrintWriter outSmall = new PrintWriter("smallshirts.txt");
					PrintWriter outMed = new PrintWriter("mediumshirts.txt");
					PrintWriter outLarge = new PrintWriter("largeshirts.txt");
					PrintWriter outExtraLarge = new PrintWriter("extralargeshirts.txt");) {
				// init empty customerName variable so that we can store the value from inside
				// our loop;
				String customerName = "";

				// while our scanner has more lines to read from the file it continues loop
				while (in.hasNextLine()) {
					customerName = in.nextLine();

					// if the first letter of the line is S then that means the size is Small and we
					// should write to our smallshirts file
					if (customerName.charAt(0) == 'S') {
						// calls our format name and prints the returned name to our smallshirts file
						outSmall.println(formatName(customerName));
						outSmall.println("*********");
					}
					// if the first letter of the line is M then that means the size is Medium and
					// we should write to our mediumshirts file
					else if (customerName.charAt(0) == 'M') {
						// calls our format name and prints the returned name to our mediumshirts file
						outMed.println(formatName(customerName));
						outMed.println("*********");
					}
					// if the first letter of the line is L then that means the size is Large and we
					// should write to our largeshirts file
					else if (customerName.charAt(0) == 'L') {
						// calls our format name and prints the returned name to our largeshirts file
						outLarge.println(formatName(customerName));
						outLarge.println("*********");
					}
					// if the first letter of the line is X then that means the size is Extra Large
					// and we should
					// write to our extralargeshirts file
					else if (customerName.charAt(0) == 'X') {
						// calls our format name and prints the returned name to our extralargeshirts
						// file
						outExtraLarge.println(formatName(customerName));
						outExtraLarge.println("*********");
					}
				}
			}

			// catch our inner exceptions, which are the IOExceptions in the case that the
			// URL is not malphormed,

			// but the reader cannot access it

			catch (IOException e)

			{
				// display our custom error message to the user
				System.out.println(fileAddress + " is not available.");
			}
		}
		// catch our outer exceptions, in the case that the URL is malphormed
		catch (MalformedURLException e) {
			// display our custom error message to the user
			System.out.println("Error, invalid URL!");
		}
	}
	// method for formatting the names. Take the unformatted name as a param
	// and returns the name without the commas or shirt size.

	public static String formatName(String unformattedName) {
		// beginning of everyones name is the index after the first comma
		int firstNameStart = unformattedName.indexOf(',') + 1;
		// first name ends at the index of the second (which is the last) comma since
		// .substring()
		// won't include the ending index as a part of our output
		int firstNameEnd = unformattedName.lastIndexOf(',');
		// beginning of the last name is the index of the second (last) comma plus one
		int lastNameStart = unformattedName.lastIndexOf(',') + 1;
		// concatenate our substrings of our first and last names, adding a space
		// between
		String formattedName = unformattedName.substring(firstNameStart, firstNameEnd) + " "
				+ unformattedName.substring(lastNameStart);
		// returns our original name without the Size or commas
		return formattedName;
	}
	/*
	 * Create a Java program called SortShirtSizesYourLastName. Your program should
	 * read each line of the shirt size file available here:
	 * https://bbmedia.dmacc.edu/CIS/CIS171/shirtsizes.txt and write all the people
	 * who have order small shirts into a file called "smallshirts.txt", medium
	 * orders into a "mediumshirts.txt" file, large orders into a "largeshirts.txt"
	 * file and finally extra large shirts into "extralargeshirts.txt" file.
	 * 
	 * Use a try and a catch block to catch the IOException. If the file isn't
	 * found, provide the following error using the URL address. For example:
	 * 
	 * https://bbmedia.dmacc.edu/CIS/CIS171/shirtorders2022.txt is not available.
	 * 
	 * >> Extra credit - for one point extra credit, modify the names going into the
	 * text files to not contain the shirt size.
	 * 
	 * >> Extra credit - for one point extra credit, modify the names going into the
	 * text files to not contain the comma.
	 */
}