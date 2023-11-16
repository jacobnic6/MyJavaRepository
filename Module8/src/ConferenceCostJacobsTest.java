import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConferenceCostJacobsTest {

	@Test
	void testFindCost() {
		//tests that all inputs return expected costs
		assertEquals(100, ConferenceCostJacobs.findCost(1, 1)); // (tier, days)
		assertEquals(190, ConferenceCostJacobs.findCost(1, 2));
		assertEquals(270, ConferenceCostJacobs.findCost(1, 3));
		assertEquals(340, ConferenceCostJacobs.findCost(1, 4));
		assertEquals(400, ConferenceCostJacobs.findCost(1, 5));
		assertEquals(90, ConferenceCostJacobs.findCost(2, 1));
		assertEquals(170, ConferenceCostJacobs.findCost(2, 2));
		assertEquals(250, ConferenceCostJacobs.findCost(2, 3));
		assertEquals(320, ConferenceCostJacobs.findCost(2, 4));
		assertEquals(380, ConferenceCostJacobs.findCost(2, 5));
		assertEquals(85, ConferenceCostJacobs.findCost(3, 1));
		assertEquals(160, ConferenceCostJacobs.findCost(3, 2));
		assertEquals(240, ConferenceCostJacobs.findCost(3, 3));
		assertEquals(310, ConferenceCostJacobs.findCost(3, 4));
		assertEquals(370, ConferenceCostJacobs.findCost(3, 5));
		assertEquals(75, ConferenceCostJacobs.findCost(4, 1));
		assertEquals(150, ConferenceCostJacobs.findCost(4, 2));
		assertEquals(230, ConferenceCostJacobs.findCost(4, 3));
		assertEquals(300, ConferenceCostJacobs.findCost(4, 4));
		assertEquals(360, ConferenceCostJacobs.findCost(4, 5));
		}
	
		@Test
	void testFindCostOutOfBounds() {
		//testing that my exception handler works
		assertEquals(0,ConferenceCostJacobs.findCost(5, 1));
		assertEquals(0,ConferenceCostJacobs.findCost(1, 6));

	}

}
