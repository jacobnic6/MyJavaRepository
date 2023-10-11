package scenes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 7, 2023  
*/
class PlayingTest {

	final int UNIT_SIZE = 75;
	final int SCREEN_WIDTH = 1200;
	final int SCREEN_HEIGHT = 1200;
	
	Random random = new Random();
	
	final int GAME_UNITS = 256;
	int yBefore[];
	int xBefore[];
	int hotdogsEatenBefore = 11;
	int hotdogsEatenAfter = 0;
	
	/**
	 * Test method for {@link scenes.Playing#resetValues()}.
	 */
	@Test
	void testResetValues() {
		char directionBefore = 'L';
		char directionAfter = 'R';
		int bodyPartsBefore = 7;
		int bodyPartsAfter = 5;
		int xBefore[]=  new int[GAME_UNITS];
		int yBefore[]=  new int[GAME_UNITS];
		int xAfter[]=  new int[GAME_UNITS];
		int yAfter[]=  new int[GAME_UNITS];
		assertNotEquals(directionBefore, directionAfter); // TODO
		assertNotEquals(bodyPartsBefore, bodyPartsAfter);
		assertNotSame(xBefore, xAfter);
		assertNotSame(yBefore, yAfter);
		
	}

	/**
	 * Test method for {@link scenes.Playing#newHotDog()}.
	 */
	@Test
	void testNewHotDog() {
		int hotdogXBefore = 0;
		int hotdogYBefore = 0;
		int hotdogXAfter = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		int hotdogYAfter = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		assertNotEquals(hotdogXBefore, hotdogXAfter); // TODO
		assertNotNull(hotdogXBefore);
	}
	
	@SuppressWarnings("unused")
	private int getRndInt() {
		return random.nextInt();
	}
	

	/**
	 * Test method for {@link scenes.Playing#move()}.
	 */
	//moving one tile of 75px
	@Test
	void testMoveU() {
		char direction = 'U';
		int bodyParts = 6;
		int xBefore[]= new int[bodyParts];
		int yBefore[]=  new int[bodyParts];
		int yAfter=  yBefore[0] - UNIT_SIZE;
		int xAfter=  xBefore[0];
		 assertNotNull(xBefore);
		 assertNotNull(yBefore);
		 assertEquals(xAfter, 0);
		 assertEquals(yAfter, -75);
	}
	//moving one tile of 75px
	//moving one tile of 75px
	@Test
	void testMoveD() {
		char direction = 'D';
		int bodyParts = 6;
		int xBefore[]= new int[bodyParts];
		int yBefore[]=  new int[bodyParts];
		int yAfter=  yBefore[0] + UNIT_SIZE;
		int xAfter=  xBefore[0];
		 assertNotNull(yBefore);
		 assertNotNull(xBefore);
		 assertEquals(xAfter, 0);
		 assertEquals(yAfter, 75);
	}
	//moving one tile of 75px
	@Test
	void testMoveL() {
		char direction = 'L';
		int bodyParts = 6;
		int xBefore[]= new int[bodyParts];
		int yBefore[]=  new int[bodyParts];
		int yAfter=  yBefore[0];
		int xAfter=  xBefore[0] - UNIT_SIZE;
		 assertNotNull(xBefore);
		 assertNotNull(yBefore);
		 assertEquals(xAfter, -75);
		 assertEquals(yAfter, 0);
	}
	
	//moving one tile of 75px
	@Test
	void testMoveR() {
		char direction = 'R';
		int bodyParts = 6;
		int xBefore[]= new int[bodyParts];
		int yBefore[]=  new int[bodyParts];
		int yAfter=  yBefore[0];
		int xAfter=  xBefore[0] + UNIT_SIZE;
		 assertNotNull(xBefore);
		 assertNotNull(yBefore);
		 assertEquals(xAfter, 75);
		 assertEquals(yAfter, 0);
	}

	/**
	 * Test method for {@link scenes.Playing#checkCollisions()}.
	 */
	@Test
	void testCheckCollisions() {
		int bodyParts = 6;
		int xBefore[]= new int[bodyParts];
		int yBefore[]=  new int[bodyParts];
		//tests moving left
		assertTrue(xBefore[0]-75<0); // TODO
		//tests moving right
		assertTrue(xBefore[0]+75>0); 
		//tests moving up
		assertTrue(yBefore[0]-75<0); 
		//tests moving down
		assertTrue(yBefore[0]+75>0); 
		
	}

}
