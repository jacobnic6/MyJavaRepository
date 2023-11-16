package tests;
import java.time.LocalTime;

import model.Classroom;
import model.Course;
import model.Instructor;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 27, 2023  
*/
public class RegistrationTesterJacobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom compSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 20);
		Classroom bioLab = new Classroom("3", "28a", "Carroll", "Science Lab", 22);
		Classroom litRoom = new Classroom("Betts", "12", "Urban", "Classroom", 18);
		
		Instructor wsmith = new Instructor("Wanda", "Smith");
		Instructor wfitz = new Instructor("Wilma", "Fitz");
		Instructor etheo = new Instructor("Emily", "Theo");
		
		Course bio101 = new Course("24680", "BIO101", LocalTime.of(11, 15), LocalTime.of(12, 55), wsmith, bioLab);
		Course cis171 = new Course("23456", "CIS171", LocalTime.of(10, 10), LocalTime.of(12, 20), wfitz, compSciLab);
		Course lit105 = new Course("29876", "LIT105", LocalTime.of(15, 15), LocalTime.of(16, 30), etheo, litRoom);
		
		System.out.println(bio101.toString());
		System.out.println(cis171.toString());
		System.out.println(lit105.toString());


	}

}
