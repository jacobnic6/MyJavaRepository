
public class TicketHandler {
	private int totalTickets;  //28
	private int ticketsBuying; //max of 4 per
	private int numberOfBuyers; //++ for each seperate purchase, starting at 0
	private final int TICKET_BUYING_MAX = 4;
	private final int TICKET_BUYING_MIN = 1;
	
	//no arg const
	public TicketHandler() {}
	
	//non default const if we just want to pass in the totalTickets for sale
	public TicketHandler(int totalTickets) {
		super();
		setTotalTickets(totalTickets);
	}
	
	//method to buy tickets, passing in num of tickets to buy
	public void buyTickets(int ticketsBuying) {
		
		//ensure the num of tickets requested is within our bounds and that there are enough tickets left
		if(ticketsBuying>= TICKET_BUYING_MIN && ticketsBuying <= TICKET_BUYING_MAX && ticketsBuying<= totalTickets) {
			//if our input is within our bounds we update our values
			setTicketsBuying(ticketsBuying);
			numberOfBuyers = numberOfBuyers + 1;
			totalTickets = totalTickets - ticketsBuying;	
		}
		//if our input isn't within our bounds we set the num of tickets buying == 0 
		else {
			setTicketsBuying(0);
		}
		
	}
	
	//method to display our total num of buyers and how many tickets are left
	public String getTotalsMessage() {
		String totalMessage = "Number of buyers: " + this.getNumberOfBuyers() + 
				"\nTickets remaining: " + this.getTotalTickets();
		return totalMessage;
		
	}


	public int getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}
	public int getTicketsBuying() {
		return ticketsBuying;
	}
	public void setTicketsBuying(int ticketsBuying) {
		this.ticketsBuying = ticketsBuying;
	}
	public int getNumberOfBuyers() {
		return numberOfBuyers;
	}
	public void setNumberOfBuyers(int numberOfBuyers) {
		this.numberOfBuyers = numberOfBuyers;
	}
	@Override
	public String toString() {
		return "TicketHandler [totalTickets=" + totalTickets + ", ticketsBuying=" + ticketsBuying + ", numberOfBuyers="
				+ numberOfBuyers + "]";
	}



	public int getTICKET_BUYING_MAX() {
		return TICKET_BUYING_MAX;
	}



	public int getTICKET_BUYING_MIN() {
		return TICKET_BUYING_MIN;
	}
	
}
