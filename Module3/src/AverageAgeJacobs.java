
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 6, 2023  
*/
public class AverageAgeJacobs {
	public static int assignPriority(int priority)
	{
	   return priority + 2;
	}
	public static void main(String[] args) {
		int ageOfNick = 26;
		int ageOfMaddie = 26;
		int ageOfDan = 24;
		int ageOfNatalie = 25;
		int ageOfElizabeth = 29;
		int ageOfTerri = 55;
		int numOfFamilyMembers = 6;
		int sumOfFamilyAge = ageOfNick + ageOfMaddie + ageOfDan + ageOfNatalie + ageOfElizabeth + ageOfTerri;
		double avgAge = (double)sumOfFamilyAge/ numOfFamilyMembers;
		System.out.println("Nick's age is " + ageOfNick + ".");
		System.out.println("Maddie's age is " + ageOfMaddie + ".");
		System.out.println("Natalie's age is " + ageOfNatalie + ".");
		System.out.println("Dan's age is " + ageOfDan + ".");
		System.out.println("Elizabeth's age is " + ageOfElizabeth + ".");
		System.out.println("Terri's age is " + ageOfTerri + ".");
		System.out.println("The average age of my family is " + avgAge + " years old.");
		int priority = assignPriority(3);
		   System.out.println("Priority: " + priority);  
	}

}
