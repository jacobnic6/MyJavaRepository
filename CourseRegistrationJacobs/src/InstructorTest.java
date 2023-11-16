import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Instructor;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
class InstructorTest {

	
	/**
	 * Test method for {@link Instructor#makeEmailAddress(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testMakeEmailAddress() {
		Instructor test = new Instructor();
		assertEquals("kcat@dmacc.edu", test.makeEmailAddress("kit", "cat"));
		assertEquals("kcat@dmacc.edu", test.makeEmailAddress("KIT", "CAT"));
	}

}
