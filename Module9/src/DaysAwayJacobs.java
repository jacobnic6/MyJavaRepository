
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 21, 2023
 */
	public class DaysAwayJacobs {
		public static LocalDate today = LocalDate.now();

	public static void main(String[] args) throws InputMismatchException, DateTimeException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		//try with resources on scanner because it is auto closeable
		try (Scanner in = new Scanner(System.in);) {
			
			//init our year value
			int yearValue = today.getYear();
			
			//prompt user for birth month
			System.out.println("Please enter the month of your birthday: \n(Enter the month as a positive, "
					+ "whole number between 1 and 12)");

			//assign input to in variable
			int birthMonth = in.nextInt();

			//if input variable is less than one or greater than 12 throw exception so we don't run the problem any longer
			if (birthMonth < 1 || birthMonth > 12) {
				throw new IndexOutOfBoundsException(birthMonth);
			}

			//prompt user for date of birthday
			System.out.println("Please enter the date of you birthday: \n(Enter the date as a positive, whole number.)");

			//assign input to int variable
			int birthDate = in.nextInt();

			//if input is less than 1 or greater than 31 throw exception
			if (birthDate < 1 || birthDate > 31) {
				throw new IndexOutOfBoundsException(birthDate);
			}

			// init local date of birthday with our input and current year value
			LocalDate birthday = LocalDate.of(yearValue, birthMonth, birthDate);

			//check if birthday for this year already happend. if so we increase the year value of the birthday by 1
			if (birthday.isBefore(today)) {
				yearValue = yearValue + 1;
				birthday = LocalDate.of(yearValue, birthMonth, birthDate);
			}

			//Display output to the user, calling our method
			System.out.println("Days until birthday: " + DaysTillBirthday(birthday));
		}

		//handling our out of bounds exception on the month and date input
		catch (IndexOutOfBoundsException e) {
			System.out.println("Error, input out of bounds.");
		}

		//handling input mismatch exception (if user inputs a string instead of int)
		catch (InputMismatchException e) {
			System.out.println("Error, wrong input format.");
		}

		//handling our date time exception, thrown when our LocalDate object is constructed.
		//We checked the bounds of the input for all months but this still can be thrown
		//if the value is within our bounds but still out of the specific month's bounds
		catch (DateTimeException e) {
			System.out.println("Error, input out of bounds for corresponding month.");
		}
	}

	//our method for calculating days till birthday. Takes LocalDate as param
	public static int DaysTillBirthday(LocalDate birthday) {

		//init our counter
		int dayCount = 0;

		//create a list of all of the dates from today until our birthday
		List<LocalDate> listOfDates = today.datesUntil(birthday).toList();

		//enhanced for loop to iterate through our list of dates and increment our counter.
		for (LocalDate localDate : listOfDates) {
			dayCount = dayCount + 1;
		}

		//return our value
		return dayCount;
	}
	/*
	 * In main, prompt the user for the month of their birthday and the date of
	 * their birthday. Plan for user input: are you expecting "March" or "mar" or
	 * "3" or what? Do you want 3/22 or March 22 or what? Be descriptive in your
	 * prompt and figure out how to handle it.
	 */
// Create a LocalDate object to hold their birthday for the current year.
	/*
	 * Pass the birthday to a method you create to calculate the days until their
	 * next birthday. Your parameter for your method should be LocalDate and your
	 * return type should be int that represents the days until their next birthday.
	 * Inside the method, determine the days until their next birthday based on the
	 * date you passed in. You may likely need to use LocalDate & Period classes. If
	 * their birthday has already passed in the current year, determine how many
	 * days until their birthday next year
	 */
	/*
	 * Remember to always use good programming techniques including naming
	 * conventions, spacing, indentation and user friendly interactions. Be sure to
	 * label output and ask for input in a descriptive manner so the user always
	 * knows exactly what is expected.
	 */
}
