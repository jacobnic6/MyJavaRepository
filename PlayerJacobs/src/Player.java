
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class Player {
	private int playerNumber;
	private String firstName;
	private String lastName;
	private String position;
	private String homeTown;
	private String homeState;
	
	public Player() {}

	public Player(int playerNumber,String firstName,String lastName, String position, String homeTown, String homeState) 
	{
		if(playerNumber>0 && !firstName.isEmpty() && !lastName.isEmpty()) 
		{
			setPlayerNumber(playerNumber);
			setFirstName(firstName);
			setLastName(lastName);
			setPosition(position);
			setHomeTown(homeTown);
			setHomeState(homeState);	
		}	
	}
	
	public String formatPlayerInformation() {
		String playerInfo = "#" + playerNumber + ": " + lastName + ", " + firstName 
				+ ", " + position + " - " + homeTown + ", " + homeState ;
		return playerInfo;
		
	}
	

	public int getPlayerNumber() {
		return playerNumber;
	}
	/**
	 * @param playerNumber the playerNumber to set
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName.isEmpty()) {this.lastName = null;}
		else if(!lastName.isEmpty()) {this.lastName = lastName;}
		
	}

	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName.isEmpty()) {this.firstName = null;}
		else if(!firstName.isEmpty()) {this.firstName = firstName;}
	}

	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	public String getHomeTown() {
		return homeTown;
	}
	/**
	 * @param homeTown the homeTown to set
	 */
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getHomeState() {
		return homeState;
	}
	/**
	 * @param homeState the homeState to set
	 */
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	@Override
	public String toString() {
		return "Player [playerNumber=" + playerNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", position=" + position + ", homeTown=" + homeTown + ", homeState=" + homeState + "]";
	}
	
	
}
