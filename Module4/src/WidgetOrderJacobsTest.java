import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 13, 2023
 */
class WidgetOrderJacobsTest {

	/**
	 * Test method for {@link WidgetOrderJacobs#computeSubtotal(int)}.
	 */
	@Test
	void testComputeSubtotalForFive() {
		assertEquals(44.95, WidgetOrderJacobs.computeSubtotal(5), 0.01);
	}
	
	/**
	 * Test method for {@link WidgetOrderJacobs#computeSubtotal(int)}.
	 */
	@Test
	void testComputeSubtotalForEight() {
		assertEquals(71.92, WidgetOrderJacobs.computeSubtotal(8), 0.01);
	}
	/**
	 * Test method for {@link WidgetOrderJacobs#computeSubtotal(int)}.
	 */
	@Test
	void testComputeSubtotalAssertNotNull() {
		assertNotNull(WidgetOrderJacobs.computeSubtotal(0));
	}

	/**
	 * Test method for {@link WidgetOrderJacobs#taxPaid(double)}.
	 */
	@Test
	void testTaxPaidForFive() {
		assertEquals(2.92, WidgetOrderJacobs.taxPaid(44.95), 0.01);
	}
	/**
	 * Test method for {@link WidgetOrderJacobs#taxPaid(double)}.
	 */
	@Test
	void testTaxPaidForEight() {
		assertEquals(4.67, WidgetOrderJacobs.taxPaid(71.92), 0.01);
	}
	/**
	 * Test method for {@link WidgetOrderJacobs#taxPaid(double)}.
	 */
	@Test
	void testTaxPaidAssertNotNull() {
		assertNotNull(WidgetOrderJacobs.taxPaid(0));
	}

	/**
	 * Test method for {@link WidgetOrderJacobs#shippingCost(int)}.
	 */
	@Test
	void testShippingCostForFive() {
		assertEquals(1.0, WidgetOrderJacobs.shippingCost(5));
	}
	/**
	 * Test method for {@link WidgetOrderJacobs#shippingCost(int)}.
	 */
	@Test
	void testShippingCostForEight() {
		assertEquals(1.6, WidgetOrderJacobs.shippingCost(8));
	}
	/**
	 * Test method for {@link WidgetOrderJacobs#shippingCost(int)}.
	 */
	@Test
	void testShippingCostAssertNotNull() {
		assertNotNull(WidgetOrderJacobs.shippingCost(0));
	}

	/**
	 * Test method for
	 * {@link WidgetOrderJacobs#computeTotal(double, double, double)}.
	 */
	@Test
	void testComputeTotalForFive() {
		assertEquals(48.87, WidgetOrderJacobs.computeTotal(44.95, 1.0, 2.92), 0.01);
	}
	/**
	 * Test method for
	 * {@link WidgetOrderJacobs#computeTotal(double, double, double)}.
	 */
	@Test
	void testComputeTotalForEight() {
		assertEquals(78.19, WidgetOrderJacobs.computeTotal(71.92, 1.6, 4.67), 0.01);
	}
	/**
	 * Test method for
	 * {@link WidgetOrderJacobs#computeTotal(double, double, double)}.
	 */
	@Test
	void testComputeTotalAssertNotNull() {
		assertNotNull(WidgetOrderJacobs.computeTotal(0, 0, 0));
	}

}
