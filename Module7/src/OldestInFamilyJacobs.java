import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 8, 2023
 */
public class OldestInFamilyJacobs {
	// static variables for our method.
	static String oldestMemberName = "";
	static double oldestMemberAge = 0;

	public static void main(String[] args) {
		// initialize local variables.
		final int SENTINEL = -1;
		int familyMembers = 0;
		String familyMemberName = "";
		int familyMemberAge = 0;
		int familyTotalMemberAge = 0;

		// create a format
		DecimalFormat decimalFormat = new DecimalFormat("##0.#");
		Scanner in = new Scanner(System.in);

		// Prompt the user for the name and age for each person.
		System.out.println("Please enter the amount of family members you have. Please use positive, whole numbers.");
		familyMembers = in.nextInt();
		// loop that prompts user for names and ages of family.
		for (int i = 0; familyMembers > i; i++) {

			System.out.println("Please enter a family member's name: ");
			familyMemberName = in.next();
			System.out.println("Please enter " + familyMemberName + "'s age: \nPlease use positive whole numbers.");
			familyMemberAge = in.nextInt();
			familyTotalMemberAge += familyMemberAge;
			// passes in current member to method to see if they are the oldest.
			findOldestMember(familyMemberAge, familyMemberName);
		}
		System.out.println("The average age in the family is: "
				+ decimalFormat.format(findFamilyAverage(familyMembers, familyTotalMemberAge)));
		System.out.println(oldestMemberName + " is the oldest member of the family at the age of : " + oldestMemberAge);
	}

	// method for avg. parses to double so we get a decimal point on the return
	// value
	
	public static double findFamilyAverage(int familyMembers, int familyTotalMemberAge) {
		double familyAvg = (double) familyTotalMemberAge / (double) familyMembers;
		return familyAvg;
	}

	// method to check if oldest. if they are, set current member as oldest;
	public static void findOldestMember(int familyMemberAge, String familyMemberName) {

		if (familyMemberAge > oldestMemberAge) {
			oldestMemberAge = familyMemberAge;
			oldestMemberName = familyMemberName;
		}

	}

}