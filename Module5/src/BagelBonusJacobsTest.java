import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 23, 2023  
*/
class BagelBonusJacobsTest {

	/**
	 * Test method for {@link BagelBonusJacobs#calculateDiscountValue(double, double)}.
	 */
	double monthlyAmountOne = 20.00;//0%
	double monthlyAmountTwo = 27.2111111;//5%
	double monthlyAmountThree = 38.577777;//7%
	double monthlyAmountFour = 89.88898;//9%
	double monthlyAmountFive = 150.444456;//12%
	double discountPercZero = 0;
	double discountPercFive = .05;
	double discountPercSeven = .07;
	double discountPercNine = .09;
	double discountPercTwelve = .12;
	@Test
	void testCalculateDiscountValue() {		//tests the calculations on the discount amount. discount percentage * monthly spending
		assertEquals(0, BagelBonusJacobs.calculateDiscountValue(discountPercZero, monthlyAmountOne), .01);
		assertEquals(1.36, BagelBonusJacobs.calculateDiscountValue(discountPercFive, monthlyAmountTwo), .01);
		assertEquals(2.70, BagelBonusJacobs.calculateDiscountValue(discountPercSeven, monthlyAmountThree), .01);
		assertEquals(8.09, BagelBonusJacobs.calculateDiscountValue(discountPercNine, monthlyAmountFour), .01);
		assertEquals(18.05, BagelBonusJacobs.calculateDiscountValue(discountPercTwelve, monthlyAmountFive), .01);
		assertNotNull(BagelBonusJacobs.calculateDiscountValue(0, 0));
	}

	/**
	 * Test method for {@link BagelBonusJacobs#discountCoupon(double)}.
	 */
	@Test
	void testDiscountCoupon() {		//tests that different monthly spending amounts return the correct discounts
		assertEquals(0, BagelBonusJacobs.discountCoupon(monthlyAmountOne), .01);
		assertEquals(0.05, BagelBonusJacobs.discountCoupon(monthlyAmountTwo), .01);
		assertEquals(0.07, BagelBonusJacobs.discountCoupon(monthlyAmountThree), .01);
		assertEquals(0.09, BagelBonusJacobs.discountCoupon(monthlyAmountFour), .01);
		assertEquals(0.12, BagelBonusJacobs.discountCoupon(monthlyAmountFive), .01);
		assertNotNull(BagelBonusJacobs.discountCoupon(0));
	}

	/**
	 * Test method for {@link BagelBonusJacobs#getCupsEarned(double)}.
	 */
	@Test
	void testGetCupsEarned() {		//tests that different monthly spending amounts return the correct amount of free cups.
		assertEquals(0, BagelBonusJacobs.getCupsEarned(monthlyAmountOne), .01);
		assertEquals(1, BagelBonusJacobs.getCupsEarned(monthlyAmountTwo), .01);
		assertEquals(2, BagelBonusJacobs.getCupsEarned(monthlyAmountFour), .01);
		assertEquals(3, BagelBonusJacobs.getCupsEarned(monthlyAmountFive), .01);
		assertNotNull(BagelBonusJacobs.getCupsEarned(0));
	}

}
