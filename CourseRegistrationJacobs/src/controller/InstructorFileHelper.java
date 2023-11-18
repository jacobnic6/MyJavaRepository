/**
 * 
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Instructor;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 16, 2023  
*/
public class InstructorFileHelper implements FileHelper{

	String nameOfFile = "instructors.txt";
	File listOfObjects = new File(nameOfFile);
	
	@Override
	public boolean doesAFileExist() {
		// TODO Auto-generated method stub
		if(listOfObjects.exists()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean writeFile(ArrayList<?> list) {
		// TODO Auto-generated method stub
		ArrayList<Instructor> instructorsToWrite = (ArrayList<Instructor>) (list);
		try {
			PrintWriter listOfObjects = new PrintWriter(nameOfFile);
			
			for (Instructor i : instructorsToWrite) {
				StringBuilder sb = new StringBuilder();
				sb.append(i.getFirstName() + "," + i.getLastName() + "," + i.getEmail());
				listOfObjects.println(sb.toString());
			}
			listOfObjects.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("No file called " + nameOfFile + " found when writing instructors.");
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<?> readFile() {
		// TODO Auto-generated method stub
		ArrayList<Instructor> allInstructors = new ArrayList<Instructor>();
		Scanner fileIn;
		try {
			fileIn = new Scanner(listOfObjects);
			
			while(fileIn.hasNextLine()) {
				String value = fileIn.nextLine();
				String[] parts = value.split(",");
				Instructor currentInstructor = new Instructor(parts[0], parts[1], 
						parts[2]);
				allInstructors.add(currentInstructor);
			}
			fileIn.close();
			
		}catch(FileNotFoundException e){
			System.out.println("No file called " + nameOfFile + " found when reading instructors.");
		}
		
		return allInstructors;
	}

}
