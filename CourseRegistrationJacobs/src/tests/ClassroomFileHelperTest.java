package tests;

import java.util.ArrayList;

import controller.ClassroomFileHelper;
import model.Classroom;

/**
 * Your ClassroomFileHelper should work without modifying this file.
 */
public class ClassroomFileHelperTest {

	public static void main(String[] args) {
		//Create an instance of ClassroomFileHelper to use and access the methods
		ClassroomFileHelper cfh = new ClassroomFileHelper();

		// Create classrooms first
		Classroom compSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 20);
		Classroom bioLab = new Classroom("3", "28a", "Carroll", "Science lab", 22);
		Classroom litRoom = new Classroom("Betts", "12", "Urban", "Classroom", 18);

		// Add all the classrooms into an array
		ArrayList<Classroom> allClassrooms = new ArrayList<Classroom>();
		allClassrooms.add(bioLab);
		allClassrooms.add(litRoom);
		allClassrooms.add(compSciLab);

		//First time through, it should be false.  Second time through, it should be true.
		System.out.println("Does a Classroom file exist? " + cfh.doesAFileExist());
		System.out.println("Writing classrooms to file is successful: " + cfh.writeFile(allClassrooms));
		System.out.println("Does a Classroom file exist after writing to it? " + cfh.doesAFileExist());

		ArrayList<Classroom> all = (ArrayList<Classroom>) cfh.readFile();
		System.out.println("\nPrinting all items in the Classroom file");
		for (Classroom a : all) {
			System.out.println(a.toString());
		}
		
		System.out.println();
	}

}
