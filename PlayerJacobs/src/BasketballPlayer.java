
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class BasketballPlayer extends Player{
	private double freeThrowPercentage;

	public BasketballPlayer() {
		super();
	}
	
	
	/**
	 * @param playerNumber
	 * @param firstName
	 * @param lastName
	 * @param position
	 * @param homeTown
	 * @param homeState
	 */
	public BasketballPlayer(int playerNumber, String firstName, String lastName, String position, String homeTown,
			String homeState, double freeThrowPercentage) 
	{
		super(playerNumber, firstName, lastName, position, homeTown, homeState);
		if(playerNumber>0 && !firstName.isEmpty() && !lastName.isEmpty()) {
			setFreeThrowPercentage(freeThrowPercentage);
			// TODO Auto-generated constructor stub
		}
		
	}


	@Override
	public String formatPlayerInformation() {
		// TODO Auto-generated method stub
		String playerInfo = super.formatPlayerInformation() + ", Free Throw Percentage: " + freeThrowPercentage + "%";
		return playerInfo;
	}

	/**
	 * @return the freeThrowPercentage
	 */
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	/**
	 * @param freeThrowPercentage the freeThrowPercentage to set
	 */
	public void setFreeThrowPercentage(double freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}
	
	
}
