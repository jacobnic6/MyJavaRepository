/*
kellikleindorfer

*/
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Classroom;
import model.Course;
import model.Instructor;


public class CourseFileHelper implements FileHelper {

	String nameOfFile = "courses.txt";
	File courseList = new File(nameOfFile);
	
	@Override
	public boolean doesAFileExist() {
		// TODO Auto-generated method stub
		if (courseList.exists()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<?> readFile() {
		// TODO Auto-generated method stub
		ArrayList<Course> allCourses = new ArrayList<Course>();

		Scanner fileIn;
		try {
			fileIn = new Scanner(courseList);

			while (fileIn.hasNextLine()){
				String value = fileIn.nextLine();
				String[] parts = value.split("\\|");
				
				Instructor tempInstr = getInstructor(parts[4]);
				Classroom tempClass = getClassroom(parts[5]);
				
				Course currentCourse = new Course(parts[0], parts[1], parseTime(parts[2]), parseTime(parts[3]), tempInstr, tempClass);
				allCourses.add(currentCourse);
			}
			fileIn.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		}

		return allCourses;
	}

	@Override
	public boolean writeFile(ArrayList<?> list) {
		// TODO Auto-generated method stub
ArrayList<Course> coursesToWrite = (ArrayList<Course>)(list);
		
		try {
			PrintWriter courseFile = new PrintWriter(nameOfFile);
			for(Course c: coursesToWrite){
				StringBuilder sb = new StringBuilder();
				sb.append(c.getCourseIdentifier() + "|" +c.getCourseName() + "|" + c.getStartTime() + "|" + c.getEndTime() + "|" + c.getTeacher() +"|"+ c.getLocation());
				courseFile.println(sb.toString());
			}
			
			courseFile.close();
		} catch (FileNotFoundException e) {
			return false;
		} 
		return true;
	}
private Classroom getClassroom(String string) {
		
		String[] parts = string.split("[\\[=,\\]]");
		
		Classroom returnedClassroom = new Classroom(parts[2], parts[4], parts[6], parts[8], Integer.parseInt(parts[10]));
		//System.out.println(returnedClassroom.toString());
		return returnedClassroom;
		
	
	
	}

	private Instructor getInstructor(String string) {
	
		String[] parts = string.split("[\\[=,\\]]");
		
		Instructor returnedInstructor = new Instructor(parts[2], parts[4], parts[6]);
		//System.out.println(returnedInstructor.toString());
		return returnedInstructor;
	}
	
	
	private LocalTime parseTime(String toSplit){
		
		String[] sTime = toSplit.split(":");
		LocalTime parsedTime = LocalTime.of(Integer.parseInt(sTime[0]), Integer.parseInt(sTime[1]));
		return parsedTime;
	}

}
