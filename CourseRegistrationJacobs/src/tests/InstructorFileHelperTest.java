package tests;

import java.util.ArrayList;

import controller.InstructorFileHelper;
import model.Instructor;

public class InstructorFileHelperTest {

	
	public static void main(String[] args) {
		
		Instructor wsmith = new Instructor("Wanda Jean", "Smith");
		Instructor wfitz = new Instructor("Wilma", "Fitz");
		Instructor etheo = new Instructor("Emily", "Theo");
		
		ArrayList<Instructor> allInstructors = new ArrayList<Instructor>();
		allInstructors.add(wsmith);
		allInstructors.add(wfitz);
		allInstructors.add(etheo);
		
		InstructorFileHelper ifh = new InstructorFileHelper();
		System.out.println("Does an Instructor file exist? " + ifh.doesAFileExist());
		System.out.println("Writing instructors to file is successful: " + ifh.writeFile(allInstructors));
		System.out.println("Does an Instructor file exist after writing to it? " + ifh.doesAFileExist());
		
		ArrayList<Instructor> addedInstr = (ArrayList<Instructor>)ifh.readFile();
		System.out.println("\nPrinting all items in the Instructor file");
		for(Instructor a: addedInstr){
			System.out.println(a.toString());
		}
		System.out.println("---------------");
		System.out.println();

	}

}
