/*
kellikleindorfer

*/
package tests;

import java.time.LocalTime;
import java.util.ArrayList;

import controller.CourseFileHelper;
import model.Classroom;
import model.Course;
import model.Instructor;

/**
 * Kelli Kleindorfer - kjkleindorfer
 * 202101 CIS171 12928
 * Nov 9, 2020
 */
public class CourseFileHelperTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//First classrooms
		Classroom CompSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 25);
		Classroom BioLab = new Classroom("3", "17a", "Ankeny", "Science Lab", 22);
		Classroom LitRoom = new Classroom("2", "12", "Urban", "Classroom", 18);
		
		//Then instructors
		Instructor wsmith = new Instructor("Wanda Jean", "Smith");
		Instructor wfitz = new Instructor("Wilma", "Fitz");
		Instructor etheo = new Instructor("Emily", "Theo");
		
		//Now courses
		Course bio101 = new Course("12345", "BIO101", LocalTime.of(11, 15), LocalTime.of(12, 55), wsmith, BioLab);
		Course cis171 = new Course("23456", "CIS171", LocalTime.of(10, 10), LocalTime.of(12, 20), wfitz, CompSciLab);
		Course lit105 = new Course("29876", "LIT105", LocalTime.of(15, 15), LocalTime.of(16, 30), etheo, LitRoom);
		
		ArrayList<Course> allCourses = new ArrayList<Course>();
		allCourses.add(bio101);
		allCourses.add(cis171);
		allCourses.add(lit105);
		
		CourseFileHelper cofh = new CourseFileHelper();
		System.out.println("Does a Courses file exist? " + cofh.doesAFileExist());
		System.out.println("Writing course to file is successful: " + cofh.writeFile(allCourses));
		System.out.println("Does a Courses file exist after writing to it? " + cofh.doesAFileExist());
		
		ArrayList<Course> readCoursesFromFile = (ArrayList<Course>) cofh.readFile();
		System.out.println("\nPrinting all items in the Course file");
		for(Course a: readCoursesFromFile){
			System.out.println(a.toString());
		}
		

	}

}
