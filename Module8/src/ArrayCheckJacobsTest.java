import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayCheckJacobsTest {
	
	private final int arraySize = 5;
	int[] testArray = {15, 17, 53, 99, 42};
	
	@Test
	void testFindHighestElement() {
		assertEquals(99, ArrayCheckJacobs.findHighestElement(testArray));
	}

	@Test
	void testFindLowestElement() {
		assertEquals(15, ArrayCheckJacobs.findLowestElement(testArray));
	}

}
