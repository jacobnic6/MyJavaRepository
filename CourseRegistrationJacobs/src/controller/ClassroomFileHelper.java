package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Classroom;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 16, 2023  
*/
public class ClassroomFileHelper implements FileHelper{
	String nameOfFile = "classrooms.txt";
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
		ArrayList<Classroom> classroomsToWrite = (ArrayList<Classroom>) (list);
		try {
			PrintWriter listOfObjects = new PrintWriter(nameOfFile);
			
			for (Classroom c : classroomsToWrite) {
				StringBuilder sb = new StringBuilder();
				sb.append(c.getBuilding() + "," + c.getRoomNumber() + "," + c.getCampus() 
				+ "," + c.getType() + "," + c.getCapacity());
				
				listOfObjects.println(sb.toString());
			}
			listOfObjects.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("No file called " + nameOfFile + " found when writing classrooms.");
			return false;
		}
		return true;
		
	}

	@Override
	public ArrayList<?> readFile() {
		// TODO Auto-generated method stub
		ArrayList<Classroom> allClassrooms = new ArrayList<Classroom>();
		Scanner fileIn;
		try {
			fileIn = new Scanner(listOfObjects);
			
			while(fileIn.hasNextLine()) {
				String value = fileIn.nextLine();
				String[] parts = value.split(",");
				Classroom currentRoom = new Classroom(parts[0], parts[1], 
						parts[2], parts[3], Integer.parseInt(parts[4]));
				allClassrooms.add(currentRoom);
			}
			fileIn.close();
			
		}catch(FileNotFoundException e){
			System.out.println("No file called " + nameOfFile + " found when reading classrooms.");
		}
		
		return allClassrooms;
	}

}
