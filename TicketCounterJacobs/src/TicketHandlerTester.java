
import javax.swing.JOptionPane;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 16, 2023  
*/
public class TicketHandlerTester {

	public static void main(String[] args) {
		
		//create an instance of our ticketHandler class, and pass in the total num of tickets for sale
		TicketHandler ticketHandler = new TicketHandler(28);

		//loop to continue prompting user till tickets left == 0
		while (ticketHandler.getTotalTickets() > 0) {
			
			//prompt user for input
			String input = JOptionPane.showInputDialog(null,
					"How many tickets would you like to buy? (Limit 4 per)\nThere are "
							+ ticketHandler.getTotalTickets() + " tickets left",
					"Ticket Sales", JOptionPane.QUESTION_MESSAGE);
			
			//if not null, because our cancel button returns a null value
			if (input != null) {
				
				//try to parse the input 
				try {
					int ticketNum = Integer.parseInt(input);
					
					//call our buyTickets method passing in our parsed input
					ticketHandler.buyTickets(ticketNum);
					
					//display message to user for confirmation that they bought the tickets
					JOptionPane.showMessageDialog(null, "Tickets bought: " + ticketHandler.getTicketsBuying());
					
					/*
					 * catches NumberFormatException which is thrown by our parse of the input
					 * catching it allows us to continue looping until the total tickets ==0 or they
					 * click the exit or cancel button
					 */
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive, whole number.");
					continue;
				}
				
			} else {
				break;
			}
		}
		//display our total message after we have exited the loop
		JOptionPane.showMessageDialog(null, ticketHandler.getTotalsMessage());

	}

}
