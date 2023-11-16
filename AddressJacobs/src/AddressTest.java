import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
Do not modify this file.  Use it to confirm that your class is set up correctly.
Only submit the Address.java class.
*/


class AddressTest {
	
	Address home = new Address("123 Main Street","Des Moines", "IA","50321");
	Address condo = new Address("5643 Hideaway Mountain", "Apt 3C","Nashville", "TN", "37115");
	
	@Test
	void testInstanceVariables() {
		assertNull(home.getAddress2());
		assertNotNull(condo.getAddress2());
		assertEquals("IA", home.getState());
		assertEquals("37115", condo.getPostalCode());
	}
	
	@Test
	void testPrint() {
		assertEquals("123 Main Street Des Moines, IA 50321", home.print());
		assertEquals("5643 Hideaway Mountain Apt 3C Nashville, TN 37115", condo.print());
		
	}

}
