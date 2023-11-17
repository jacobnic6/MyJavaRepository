import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketHandlerTest {

	@Test
	void testBuyTickets() {
		//create ticket handler and pass in our value to set the number of tickets for sale
		TicketHandler testHandler = new TicketHandler(28);
		
		//ensure our method updates our variables correctly when using numbers within our bounds
		testHandler.buyTickets(4);
		assertEquals(24, testHandler.getTotalTickets());
		assertEquals(1, testHandler.getNumberOfBuyers());
		
		//ensure our method updates our variables correctly when using numbers within our bounds
		testHandler.buyTickets(1);
		assertEquals(23, testHandler.getTotalTickets());
		assertEquals(2, testHandler.getNumberOfBuyers());
		
		//ensure our method doesn't update our variables if we pass in 0
		testHandler.buyTickets(0);
		assertEquals(23, testHandler.getTotalTickets());
		assertEquals(2, testHandler.getNumberOfBuyers());
		
		//ensure our method doesn't update our variables if we pass in values outside of our bounds
		testHandler.buyTickets(23);
		assertEquals(23, testHandler.getTotalTickets());
		assertEquals(2, testHandler.getNumberOfBuyers());
		
		//ensure our method doesn't update our variables if we pass in values outside of our bounds
		testHandler.buyTickets(-1);
		assertEquals(23, testHandler.getTotalTickets());
		assertEquals(2, testHandler.getNumberOfBuyers());
		
		//ensure our method doesn't allow us to buy tickets if we try to buy more than is left
		TicketHandler testHandler1 = new TicketHandler(1);
		testHandler1.buyTickets(4);
		assertEquals(1, testHandler1.getTotalTickets());
		assertEquals(0, testHandler1.getNumberOfBuyers());
	}

	@Test
	void testGetTotalsMessage() {
		TicketHandler testHandler = new TicketHandler(28);
		
		//ensure our method returns the message that we expect, even if we exit without buying tickets
		assertEquals("Number of buyers: 0\nTickets remaining: 28", testHandler.getTotalsMessage());
		
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		testHandler.buyTickets(4);
		
		//ensure our method returns the message that we expect after buying all of the tickets
		assertEquals("Number of buyers: 7\nTickets remaining: 0", testHandler.getTotalsMessage());
		
		//ensure our variables aren't null even if we dont pass in a number of tickets we are selling, and that our method returns the expected message
		TicketHandler testHandler1 = new TicketHandler();
		assertNotNull(testHandler1.getTotalsMessage());
		assertEquals("Number of buyers: 0\nTickets remaining: 0", testHandler1.getTotalsMessage());
		
		//ensure our method returns the correct number of buyers after requesting to buy more tickets than are available
		TicketHandler testHandler2 = new TicketHandler(2);
		testHandler2.buyTickets(4);
		testHandler2.buyTickets(4);
		testHandler2.buyTickets(4);
		testHandler2.buyTickets(2);
		assertEquals("Number of buyers: 1\nTickets remaining: 0", testHandler2.getTotalsMessage());
	}

}
