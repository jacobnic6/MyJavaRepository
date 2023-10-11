
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 24, 2023  
*/
class MileageRatingJacobsTest {
	
	
	@Test//ensures that input isn't negative
	void testCheckInputDouble() 
	{
		assertEquals(22,MileageRatingJacobs.checkInput(22));
		assertEquals(-1,MileageRatingJacobs.checkInput(-22));
	}
	
	@Test//checks that input isn't string
	void testCheckInputString() 
	{
		assertEquals("\nError: Invalid input. Please enter a positive number.",MileageRatingJacobs.checkInput("dfsdfs"));
		assertEquals("\nError: Invalid input. Please enter a positive number.",MileageRatingJacobs.checkInput("adsd"));
	}
	
	@Test//ensure our method doesn't fail without input
	void testGetMileageNotNull() 
	{
		assertNotNull(MileageRatingJacobs.getMileage(0));
	}
	
	@Test//ensures that doubles return their correct rating, and returns error message if negative
	void testGetMileage() 
	{
		assertEquals("Excellent",MileageRatingJacobs.getMileage(41.55));
		assertEquals("Good",MileageRatingJacobs.getMileage(35.2221));
		assertEquals("Fair",MileageRatingJacobs.getMileage(23.9999));
		assertEquals("Poor",MileageRatingJacobs.getMileage(17));

		assertEquals("\nError: Invalid input. Please enter a positive number.",MileageRatingJacobs.getMileage(-22));
		
	}

}
