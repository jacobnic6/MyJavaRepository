package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Classroom;

/*
 Confirm your instance variables are set up correctly prior to submitting
 Do not modify this file.  If the tests do not pass, fix the Classroom instance variables
 and subsequent getters/setters from the changes.
*/

class ClassroomTest {

	@Test
	void test() {
		Classroom compSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 20);
		assertEquals("8", compSciLab.getBuilding());
		assertEquals("17", compSciLab.getRoomNumber());
		assertEquals("Ankeny", compSciLab.getCampus());
		assertEquals("Computer Lab", compSciLab.getType());
		assertEquals(20, compSciLab.getCapacity());
		
	}

}
